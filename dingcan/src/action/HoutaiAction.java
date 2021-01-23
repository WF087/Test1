package action;



import java.io.File;
import java.io.IOException;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Category;
import model.Order;
import model.Product;
import model.User;

import org.apache.struts2.ServletActionContext;

import util.Pager;
import util.Util;

import com.opensymphony.xwork2.ActionSupport;

import dao.CategoryDao;
import dao.OrderDao;
import dao.OrderItemDao;
import dao.ProductDao;
import dao.UserDao;



public class HoutaiAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private UserDao userDao;
	
	private CategoryDao categoryDao;
	
	private ProductDao productDao;
	
	private OrderDao orderDao;
	
	private OrderItemDao orderItemDao;
	
	
	private String url = "./";

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
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
	
	
	

	
	//用户登录操作
	public String login() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = userDao.selectBean(" where username = '"+username +"' and password= '"+password +"' and userlock=0 and role=1");
		if (user!=null) {
			HttpSession session = request.getSession();
			session.setAttribute("manage", user);
			this.setUrl("index.jsp");
			return SUCCESS;
		} else {
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setCharacterEncoding("gbk");response.setContentType("text/html; charset=gbk");
			response
					.getWriter()
					.print(
							"<script language=javascript>alert('用户名或者密码错误');window.location.href='login.jsp';</script>");
		}
		return null;
	}
//用户退出操作
	public String loginout() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		session.removeAttribute("manage");
		this.setUrl("login.jsp");
		return SUCCESS;
	}
	
	
	//跳转到修改密码页面
	public String changepwd() {
		this.setUrl("user/password.jsp");
		return SUCCESS;
	}
	
	//修改密码操作
	public void changepwd2() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		
		HttpSession session = request.getSession();
		User u = (User)session.getAttribute("manage");
		String password1 = request.getParameter("password1");
		String password2 = request.getParameter("password2");
		User bean = userDao.selectBean(" where username= '"+u.getUsername()+"' and password= '"+password1+"'");
		if(bean!=null){
			bean.setPassword(password2);
			userDao.updateBean(bean);
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setCharacterEncoding("gbk");response.setContentType("text/html; charset=gbk");
			response
					.getWriter()
					.print(
							"<script language=javascript>alert('修改成功');</script>");
		}else{
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setCharacterEncoding("gbk");response.setContentType("text/html; charset=gbk");
			response
					.getWriter()
					.print(
							"<script language=javascript>alert('用户名或者密码错误');</script>");
		}
	}
	//商品分类列表
	public String catelist() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int currentpage = 1;
		int pagesize = 10;
		if(request.getParameter("pagenum")!=null){
			currentpage = Integer.parseInt(request.getParameter("pagenum"));
		}
		String where = " where catelock=0";
		int total = categoryDao.selectBeanCount(where);
		request.setAttribute("list", categoryDao.selectBeanList((currentpage - 1) * pagesize, pagesize, where));
		request.setAttribute("pagerinfo", Pager.getPagerNormal(total, pagesize,
				currentpage, "houtaimethod!catelist", "共有" + total + "条记录"));
		this.setUrl("product/catelist.jsp");
		return SUCCESS;
	}
	
	//跳转到添加商品分类页面
	public String cateadd() {
		this.setUrl("product/cateadd.jsp");
		return SUCCESS;
	}
	//添加商品分类操作
	public void cateadd2() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		String catename = request.getParameter("catename");
		Category cate = new Category();
		cate.setCatename(catename);
		categoryDao.insertBean(cate);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("gbk");response.setContentType("text/html; charset=gbk");
		response
				.getWriter()
				.print(
						"<script language=javascript>alert('操作成功');window.location.href='houtaimethod!catelist';</script>");
	}
	
	//跳转到更新商品分类页面
	public String cateupdate() {
		HttpServletRequest request = ServletActionContext.getRequest();
		Category bean = categoryDao.selectBean(" where id= "+request.getParameter("id"));
		request.setAttribute("bean", bean);
		this.setUrl("product/cateupdate.jsp");
		return SUCCESS;
	}
	
	
	//商品分类更新操作
	public void cateupdate2() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		Category bean = categoryDao.selectBean(" where id= "+request.getParameter("id"));
		String catename = request.getParameter("catename");
		bean.setCatename(catename);
		categoryDao.updateBean(bean);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("gbk");response.setContentType("text/html; charset=gbk");
		response
				.getWriter()
				.print(
						"<script language=javascript>alert('操作成功');window.location.href='houtaimethod!catelist';</script>");
	}
	//删除商品分类操作
	public void catedelete() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		Category bean = categoryDao.selectBean(" where id= "+request.getParameter("id"));
		bean.setCatelock(1);
		categoryDao.updateBean(bean);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("gbk");response.setContentType("text/html; charset=gbk");
		response
				.getWriter()
				.print(
						"<script language=javascript>alert('操作成功');window.location.href='houtaimethod!catelist';</script>");
	}
	
	//商品列表
	public String productlist() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int currentpage = 1;
		int pagesize =10;
		if(request.getParameter("pagenum")!=null){
			currentpage = Integer.parseInt(request.getParameter("pagenum"));
		}
		
		String where = " where productlock=0 order by id desc"; 



		int total = productDao.selectBeanCount(where.replaceAll("order by id desc", ""));
		request.setAttribute("list", productDao.selectBeanList((currentpage - 1) * pagesize, pagesize, where));
		request.setAttribute("pagerinfo", Pager.getPagerNormal(total, pagesize,
				currentpage, "houtaimethod!productlist", "共有" + total + "条记录"));
		this.setUrl("product/productlist.jsp");
		return SUCCESS;
	}

	//跳转到添加商品页面
	public String productadd() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String where = " where catelock=0  ";
		request.setAttribute("list", categoryDao.selectBeanList(0, 9999, where));
		this.setUrl("product/productadd.jsp");
		return SUCCESS;
	}
	
	

	private File uploadfile;

	public File getUploadfile() {
		return uploadfile;
	}

	public void setUploadfile(File uploadfile) {
		this.uploadfile = uploadfile;
	}
//添加商品操作
	public void productadd2() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		String name = request.getParameter("name");
		String cid = request.getParameter("cid");
		String price1 = request.getParameter("price1");
		String price2 = request.getParameter("price2");
		String info5 = request.getParameter("info5");
		
		if(cid==null||"0".equals(cid)){
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setCharacterEncoding("gbk");response.setContentType("text/html; charset=gbk");
			response
					.getWriter()
					.print(
							"<script language=javascript>alert('操作失败，请先在菜单分类列表中添加菜单分类');window.location.href='houtaimethod!productlist';</script>");
			return;
		}
		
		String imgpath = this.uploadImg(uploadfile);
		Product product = new Product();
		product.setName(name);
		product.setCate(categoryDao.selectBean( " where catelock=0 and id= " +cid));
		product.setPrice1(Double.parseDouble(price1));
		product.setPrice2(Double.parseDouble(price2));
		product.setInfo5(info5);
		product.setImgpath(imgpath);
		product.setCreatetime(new Date());
		productDao.insertBean(product);		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("gbk");response.setContentType("text/html; charset=gbk");
		response
				.getWriter()
				.print(
						"<script language=javascript>alert('操作成功');window.location.href='houtaimethod!productlist';</script>");
	}

	//图片上传操作
	public  String  uploadImg(File uploadImg) throws IOException {
		String savaPath = ServletActionContext.getServletContext().getRealPath(
				"/")+ "/uploadfile/";

		String time = new java.text.SimpleDateFormat("yyyyMMddHHmmssSSS")
				.format(new Date()).toString();
		String imageFileName = time+".jpg";
		File imageFile = new File(savaPath + imageFileName);
		Util.copyFile(uploadImg, imageFile);
		return imageFileName;
	}
	
	//跳转到更新商品信息页面
	public String productupdate() {
		HttpServletRequest request = ServletActionContext.getRequest();
		Product product = productDao.selectBean(" where id = "+request.getParameter("id"));
		request.setAttribute("bean", product);
		String where = " where catelock=0  ";
		request.setAttribute("list", categoryDao.selectBeanList(0, 9999, where));
		this.setUrl("product/productupdate.jsp");
		return SUCCESS;
	}
	
	
	//更新商品信息操作
	public void productupdate2() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		Product product = productDao.selectBean(" where id = "+request.getParameter("id"));
		String name = request.getParameter("name");
		String cid = request.getParameter("cid");
		String price1 = request.getParameter("price1");
		String price2 = request.getParameter("price2");
		String info5 = request.getParameter("info5");

		product.setName(name);
		product.setCate(categoryDao.selectBean(" where id="+cid));
		product.setPrice1(Double.parseDouble(price1));
		product.setPrice2(Double.parseDouble(price2));
		product.setInfo5(info5);
		productDao.updateBean(product);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("gbk");response.setContentType("text/html; charset=gbk");
		response
				.getWriter()
				.print(
						"<script language=javascript>alert('操作成功');window.location.href='houtaimethod!productlist';</script>");

	}
	
	
	//删除商品信息操作
	public void productdelete() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		Product bean = productDao.selectBean(" where id= "+request.getParameter("id"));
		bean.setProductlock(1);
		productDao.updateBean(bean);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("gbk");response.setContentType("text/html; charset=gbk");
		response
				.getWriter()
				.print(
						"<script language=javascript>alert('操作成功');window.location.href='houtaimethod!productlist';</script>");
	}
	
	//新品推荐操作
	public void productupdate3() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		Product product = productDao.selectBean(" where id = "+request.getParameter("id"));
		if(product.getNewstuijian()==0){
			product.setNewstuijian(1);
		}else{
			product.setNewstuijian(0);
		}
		productDao.updateBean(product);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("gbk");response.setContentType("text/html; charset=gbk");
		response
				.getWriter()
				.print(
						"<script language=javascript>alert('操作成功');window.location.href='houtaimethod!productlist';</script>");
	}

	
	
	
	
	//订单列表
	public String orderlist() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String orderid = request.getParameter("orderid");
		String  username = request.getParameter("username");
		String status = request.getParameter("status");
		String time1 = request.getParameter("time1");
		String time2 = request.getParameter("time2");
		
		
		StringBuffer sb = new StringBuffer();
		sb.append(" where ");
	
		if(orderid!=null&&!"".equals(orderid)){
			sb.append("orderid like '%"+orderid.trim()+"%'");
			sb.append(" and ");
			
			request.setAttribute("orderid", orderid);
		}
		
		if(username!=null&&!"".equals(username)){
			sb.append("username like '%"+username.trim()+"%'");
			sb.append(" and ");
			
			request.setAttribute("username", username);
		}
		
		if(status!=null&&!"".equals(status)){
			if("未受理订单".equals(status)){
				sb.append("status =0");
				sb.append(" and ");
			
			}else{
				sb.append("status =1");
				sb.append(" and ");
		
			}
			request.setAttribute("status", status);
		}
		if(time1!=null&&!"".equals(time1)){
			sb.append("createtime >=  '"+time1+"'");
			sb.append(" and ");
		
			request.setAttribute("time1", time1);
		}
		
		if(time2!=null&&!"".equals(time2)){
			sb.append("createtime <  '"+time2+"'");
			sb.append(" and ");
		
			request.setAttribute("time2", time2);
		}
		
		sb.append(" 1=1  order by id desc ");
		String where = sb.toString();

		
		int currentpage = 1;
		int pagesize =10;
		if(request.getParameter("pagenum")!=null){
			currentpage = Integer.parseInt(request.getParameter("pagenum"));
		}
		
		int total = orderDao.selectBeanCount(where.replaceAll("order by id desc", ""));
		request.setAttribute("list", orderDao.selectBeanList((currentpage - 1) * pagesize, pagesize, where));
		request.setAttribute("pagerinfo", Pager.getPagerNormal(total, pagesize,
				currentpage, "houtaimethod!orderlist", "共有" + total + "条记录"));
		this.setUrl("order/orderlist.jsp");
		return SUCCESS;
	}
	//查看订单信息
	public String orderupdate() {
		HttpServletRequest request = ServletActionContext.getRequest();
		Order bean = orderDao.selectBean(" where id = "+request.getParameter("id"));
		request.setAttribute("order", bean);

		this.setUrl("order/orderupdate.jsp");
		return SUCCESS;
	}
	
	//处理订单信息
	public void orderupdate3() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		Order bean = orderDao.selectBean(" where id = "+request.getParameter("id"));
		if(bean.getStatus()==0){
			bean.setStatus(1);
		}
		orderDao.updateBean(bean);	
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("gbk");response.setContentType("text/html; charset=gbk");
		response
				.getWriter()
				.print(
						"<script language=javascript>alert('操作成功');window.location.href='houtaimethod!orderlist';</script>");
	}

	
	
	
	
	
	
	
	//用户列表
	public String userlist() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int currentpage = 1;
		int pagesize =20;
		if(request.getParameter("pageNum")!=null){
			currentpage = Integer.parseInt(request.getParameter("pageNum"));
			pagesize = Integer.parseInt(request.getParameter("numPerPage"));
		}
		
		String where = " where role=0 and userlock=0  order by id desc "; 


		int total = userDao.selectBeanCount(where.replaceAll("order by id desc", ""));
		request.setAttribute("list", userDao.selectBeanList((currentpage - 1) * pagesize, pagesize, where));
		request.setAttribute("totalCount", total);
		request.setAttribute("ps", pagesize);
		request.setAttribute("pn", currentpage);
		this.setUrl("user/userlist.jsp");
		return SUCCESS;
	}
	//删除用户操作
	public void userdelete() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		User bean = userDao.selectBean(" where id= "+request.getParameter("id"));
		bean.setUserlock(1);
		bean.setUsername(bean.getUsername()+"_delete");
		userDao.updateBean(bean);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("gbk");response.setContentType("text/html; charset=gbk");
		response
				.getWriter()
				.print(
						"<script language=javascript>alert('操作成功');window.location.href='houtaimethod!userlist';</script>");
	}

	
	
}
