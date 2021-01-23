package action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Category;
import model.Order;
import model.OrderItem;
import model.Product;
import model.User;

import org.apache.struts2.ServletActionContext;

import util.CartItem;
import util.CartService;
import util.Pager;
import util.Util;

import com.opensymphony.xwork2.ActionSupport;

import dao.CategoryDao;
import dao.OrderDao;
import dao.OrderItemDao;
import dao.ProductDao;
import dao.UserDao;

public class QiantaiAction extends ActionSupport{

	private static final long serialVersionUID = 1L;

	private UserDao userDao;
	
	private CategoryDao categoryDao;
	
	private ProductDao productDao;
	
	private OrderDao orderDao;
	
	private OrderItemDao orderItemDao;
	
	
	
	private String url = "./";


	public UserDao getUserDao() {
		return userDao;
	}


	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}


	public CategoryDao getCategoryDao() {
		return categoryDao;
	}


	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}


	public ProductDao getProductDao() {
		return productDao;
	}


	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}


	public OrderDao getOrderDao() {
		return orderDao;
	}


	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}


	public OrderItemDao getOrderItemDao() {
		return orderItemDao;
	}


	public void setOrderItemDao(OrderItemDao orderItemDao) {
		this.orderItemDao = orderItemDao;
	}

	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}
	//首页入口
	public String index() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		Util.init(request);
		List<Category> catelist = categoryDao.selectBeanList(0, 9999, " where catelock=0 ");
		request.setAttribute("topcatelist",catelist );
		request.setAttribute("xiaoliangprolist",productDao.selectBeanList(0, 15, " where productlock=0 order by xiaoliang desc "));//销量排行商品列表
		
		int currentpage = 1;
		int pagesize = 5;
		if(request.getParameter("pagenum")!=null){
			currentpage= Integer.parseInt(request.getParameter("pagenum"));
		}
		String cid = request.getParameter("cid");
		String keyword = request.getParameter("keyword");
		if (cid!=null){
			int total = productDao.selectBeanCount(" where productlock=0 and cate.id = "+cid);//分类商品数量
			request.setAttribute("hotprolist",
					productDao.selectBeanList((currentpage-1)*pagesize, pagesize, " where cate.id = "+cid +" and productlock=0 order by id desc "));//分类商品列表
			request.setAttribute("pagerinfo", Pager.getPagerNormal(total, pagesize, currentpage, "index?cid="+cid,"共有"+total+"条记录"));
		}
		else if(keyword!=null&&!"".equals(keyword)){			
			int total = productDao.selectBeanCount(" where productlock=0 and name like '%"+keyword+"%' ");//搜索商品数量
			request.setAttribute("hotprolist",productDao.selectBeanList((currentpage-1)*pagesize, pagesize, 
					" where name like '%"+keyword+"%' and productlock=0 order by id desc "));//搜索商品列表
			request.setAttribute("pagerinfo", Pager.getPagerNormal(total, pagesize, currentpage, "index","共有"+total+"条记录" ));	
		}
		else{
			int total = productDao.selectBeanCount(" where productlock=0 ");
			request.setAttribute("hotprolist",productDao.selectBeanList((currentpage-1)*pagesize, pagesize, " where productlock=0 order by id desc "));
			request.setAttribute("pagerinfo", Pager.getPagerNormal(total, pagesize, currentpage, ".","共有"+total+"条记录"));
		}
		return "success";
	}
	
	//用户注册操作
	public void register() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		
		HttpServletResponse response = ServletActionContext.getResponse();
		
		User user = new User();
		
		user.setUsername(java.net.URLDecoder.decode(request.getParameter("username"), "utf-8"));
		
		user.setPassword(request.getParameter("password"));
		
		user.setTruename(java.net.URLDecoder.decode(request.getParameter("truename"), "utf-8"));
		
		user.setAddress(java.net.URLDecoder.decode(request.getParameter("address"), "utf-8"));
		
		user.setPhone(java.net.URLDecoder.decode(request.getParameter("phone"), "utf-8"));
		
		user.setEmail(java.net.URLDecoder.decode(request.getParameter("email"), "utf-8"));
		
		user.setQq(java.net.URLDecoder.decode(request.getParameter("qq"), "utf-8"));
		
		user.setCreatetime(new Date());
		
		User u = userDao.selectBean(" where username='"+user.getUsername()+"'");
		
		if(u==null){
			userDao.insertBean(user);
			response.setCharacterEncoding("utf-8");
			response.getWriter().write("注册新用户成功！您的用户名"+user.getUsername()+",请妥善保管！");
			}else{
				response.setCharacterEncoding("utf-8");
				response.getWriter().write("该用户名已经存在，请重新注册！");
		}
	}
	
	
	//跳转到用户登录页面
	public String login(){
		HttpServletRequest request = ServletActionContext.getRequest();
		List<Category> catelist = categoryDao.selectBeanList(0, 9999, " where catelock=0 ");
		request.setAttribute("topcatelist",catelist );
		request.setAttribute("xiaoliangprolist",productDao.selectBeanList(0, 15, " where productlock=0 order by xiaoliang desc "));//销量排行商品列表
		this.setUrl("login.jsp");
		return SUCCESS;
	}

	
	//用户登录操作
	public void login2() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User u = userDao.selectBean(" where username='"+username+"' and password='"+password+"' and userlock=0");
		if(u==null){
			response.setCharacterEncoding("gbk");response.setContentType("text/html; charset=gbk");
			response
					.getWriter()
					.print(
							"<script language=javascript>alert('用户名或者密码错误！');window.location.href='qiantaimethod!login';</script>");
		}else{
			HttpSession session = request.getSession();
			session.setAttribute("user", u);
			response.setCharacterEncoding("gbk");response.setContentType("text/html; charset=gbk");
			response
					.getWriter()
					.print(
							"<script language=javascript>alert('登录成功！');window.location.href='./';</script>");
		}
		
		
	}
	
	
	//用户退出操作
	public void loginout() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		session.removeAttribute("user");
		CartService.clear();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("gbk");response.setContentType("text/html; charset=gbk");
		response
				.getWriter()
				.print(
						"<script language=javascript>alert('用户退出成功！');window.location.href='./';</script>");
	}
	
	
	//查看商品信息操作
	public String product(){
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("product", productDao.selectBean(" where id = "+request.getParameter("pid")));
		this.setUrl("product.jsp");
		return SUCCESS;
	}
	
	
	//添加商品到购物车操作
	public String cartadd() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		if(user==null){
			this.setUrl("loginfirst.jsp");
			return SUCCESS;
		}
		Product product = productDao.selectBean(" where id= "+ request.getParameter("pid"));
		if(CartService.addItem(product)){
			this.setUrl("cartadd.jsp");
			return SUCCESS;
		}else{
			this.setUrl("cartaddfail.jsp");
			return SUCCESS;
		}
	}
	
	
	//购物车列表
	public String cart() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		if(user==null){
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setCharacterEncoding("gbk");response.setContentType("text/html; charset=gbk");
			response
					.getWriter()
					.print(
							"<script language=javascript>alert('请先登录');window.location.href='qiantaimethod!login';</script>");
			return null;
		}
		request.setAttribute("cartItems", CartService.getItems());
		request.setAttribute("dropcartItems", CartService.getDropItems());
		request.setAttribute("price1", CartService.getPrice1());
		request.setAttribute("price2", CartService.getPrice2());
		request.setAttribute("price1-price2", CartService.getPrice1()-CartService.getPrice2());
		this.setUrl("cart.jsp");
		return SUCCESS;

	}
	
	//修改购物车的商品数量
	public void cartchangenum() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		CartService.updateNum(Integer.parseInt(request.getParameter("pid")), 
				Integer.parseInt(request.getParameter("num")));
		response.setCharacterEncoding("gbk");response.setContentType("text/html; charset=gbk");
		response.getWriter()
		.print("<script language=javascript>alert('变更成功');window.location.href='qiantaimethod!cart';</script>");
	}
	//删除购物车的商品
	public void delproduct() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		CartService.drop(Integer.parseInt(request.getParameter("pid")));
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("gbk");response.setContentType("text/html; charset=gbk");
		response.getWriter()
		.print("<script language=javascript>alert('删除成功');window.location.href='qiantaimethod!cart';</script>");
	}
	//回复购物车的商品
	public void recoveryCart() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		CartService.recovery(Integer.parseInt(request.getParameter("pid")));
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("gbk");response.setContentType("text/html; charset=gbk");
		response.getWriter()
		.print("<script language=javascript>alert('恢复成功');window.location.href='qiantaimethod!cart';</script>");
	}
	
	//跳转到结算页面
	public String address() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		if(CartService.isEmpty()){
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setCharacterEncoding("gbk");response.setContentType("text/html; charset=gbk");
			response.getWriter()
			.print("<script language=javascript>alert('您的购物车没有商品，结算失败');window.location.href='qiantaimethod!cart';</script>");
			return null;
		}
		HttpSession session = request.getSession();
		if(session.getAttribute("user")==null){
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setCharacterEncoding("gbk");response.setContentType("text/html; charset=gbk");
			response.getWriter()
			.print("<script language=javascript>alert('结算失败，请先登录');window.location.href='qiantaimethod!login';</script>");
			return null;
		}
		this.setUrl("address.jsp");
		return SUCCESS;
	}
	
	
	
	//生成订单页面
	public void createorder() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = request.getSession();
		if(session.getAttribute("user")!=null&&!CartService.isEmpty()){
			List<OrderItem> orderItems = new ArrayList<OrderItem>();
			List<CartItem> cartItems = CartService.getItems();
			for(CartItem ci:cartItems){
				OrderItem oi = new OrderItem();
				oi.setProductid((int)ci.getProduct().getId());
				oi.setProductname(ci.getProduct().getName());
				oi.setProductnum(ci.getNumber());
				oi.setPrice(ci.getProduct().getPrice2()*ci.getNumber());
				orderItems.add(oi);
				Product product = productDao.selectBean(" where id= "+ci.getProduct().getId());
				product.setXiaoliang(product.getXiaoliang()+ci.getNumber());
				productDao.updateBean(product);
			}
			Order order = new Order();
			order.setUser((User)session.getAttribute("user"));
			order.setAddress(request.getParameter("address"));
			order.setCreatetime(new Date());
			order.setPhone(request.getParameter("phone"));
			order.setUsername(request.getParameter("username"));
			order.setTotalprice(CartService.getPrice2());
			order.setOrderItems(orderItems);
			order.setOrderid(new java.util.Date().getTime()+"");
			for(OrderItem oi:orderItems ){
				orderItemDao.insertBean(oi);
			}
			orderDao.insertBean(order);
			CartService.clear();
			response.setCharacterEncoding("gbk");response.setContentType("text/html; charset=gbk");
			response
					.getWriter()
					.print(
							"<script language=javascript>alert('订单生成成功！');window.location.href='qiantaimethod!order';</script>");
		}else{
			response.setCharacterEncoding("gbk");response.setContentType("text/html; charset=gbk");
			response
					.getWriter()
					.print(
							"<script language=javascript>alert('订单生成失败！');window.location.href='./';</script>");
		}
	}
	
	
	//查看订单操作
	public String order () throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		List<Category> catelist = categoryDao.selectBeanList(0, 9999, " where catelock=0 ");
		request.setAttribute("topcatelist",catelist );
		request.setAttribute("xiaoliangprolist",productDao.selectBeanList(0, 15, " where productlock=0 order by xiaoliang desc "));//销量排行商品列表
		HttpSession session = request.getSession();
		if(session.getAttribute("user")!=null){
			int currentpage = 1;
			int pagesize = 10;
			if(request.getParameter("pagenum")!=null){
				currentpage= Integer.parseInt(request.getParameter("pagenum"));
			}
			User user = (User)session.getAttribute("user");
			int total = orderDao.selectBeanCount(" where user.id= "+user.getId());
			request.setAttribute("orderlist",orderDao.selectBeanList((currentpage-1)*pagesize, pagesize, " where user.id= "+user.getId()));
			request.setAttribute("pagerinfo", Pager.getPagerNormal(total, pagesize, currentpage, "order","共有"+total+"条记录"));
			this.setUrl("order.jsp");
			return SUCCESS;
		}else{
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setCharacterEncoding("gbk");response.setContentType("text/html; charset=gbk");
			response
					.getWriter()
					.print(
							"<script language=javascript>alert('请先登录');window.location.href='qiantaimethod!login';</script>");
			return null;
		}
	}
	
	
	//查看订单信息操作
	public String orderinfo(){
		HttpServletRequest request = ServletActionContext.getRequest();
		Order order = orderDao.selectBean(" where id= "+request.getParameter("oid"));
		request.setAttribute("order", order);
		this.setUrl("orderinfo.jsp");
		return SUCCESS;
	}
	
	
	
}
