<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<!-- saved from url=(0076)http://www.4008823823.com.cn/kfcios/HomeAction/giveuporder1.action -->
<HTML xmlns="http://www.w3.org/1999/xhtml"><HEAD><TITLE>美食订餐</TITLE>
<META content="text/html; charset=utf-8" http-equiv=Content-Type>
<META name=keywords content=index>
<META name=description content=>
<LINK rel=stylesheet type=text/css href="files/common.css">
<META name=GENERATOR content="MSHTML 8.00.6001.19258">
<script language="javascript" type="text/javascript">
function clearText(field)
{
    if (field.defaultValue == field.value) field.value = '';
    else if (field.value == '') field.value = field.defaultValue;
}


function registershow(){
		//window.showModalDialog("register.jsp", null,'dialogWidth:700px;dialogHeight:500px;help:no;unadorned:no;resizable:no;status:no;scroll:no');

		if(window.showModalDialog == undefined){  //谷歌,火狐等浏览器
		     window.myNewWindow = window.open("register.jsp",'newwindow', 'height=500, width=700, top=100, left=250, toolbar=no, menubar=no, scrollbars=no, resizable=no, location=no, status=no'); 
		}else{  //IE
			window.showModalDialog("register.jsp", null, 
			'dialogWidth:700px;dialogHeight:500px;help:no;unadorned:no;resizable:no;status:no;scroll:no');
		}
		
	}
	
function productshow(pid){
		var now = new Date(); 
		var t = now.getTime()+''; 
		//window.showModalDialog("qiantaimethod!product?pid="+pid+"&t="+t, null,'dialogWidth:700px;dialogHeight:700px;help:no;unadorned:no;resizable:no;status:no;scroll:yes');

		if(window.showModalDialog == undefined){  //谷歌,火狐等浏览器
		     window.myNewWindow = window.open("qiantaimethod!product?pid="+pid+"&t="+t,'newwindow', 'height=700, width=700, top=100, left=250, toolbar=no, menubar=no, scrollbars=no, resizable=no, location=no, status=no'); 
		}else{  //IE
			window.showModalDialog("qiantaimethod!product?pid="+pid+"&t="+t, null, 
			'dialogWidth:700px;dialogHeight:700px;help:no;unadorned:no;resizable:no;status:no;scroll:yes');
		}
		
	}
function cartaddshow(pid){
		var now = new Date(); 
		var t = now.getTime()+''; 
		//window.showModalDialog("qiantaimethod!cartadd?pid="+pid+"&t="+t, null,'dialogWidth:300px;dialogHeight:100px;help:no;unadorned:no;resizable:no;status:no;scroll:no');

		if(window.showModalDialog == undefined){  //谷歌,火狐等浏览器
		     window.myNewWindow = window.open("qiantaimethod!cartadd?pid="+pid+"&t="+t,'newwindow', 'height=100, width=300, top=100, left=250, toolbar=no, menubar=no, scrollbars=no, resizable=no, location=no, status=no'); 
		}else{  //IE
			window.showModalDialog("qiantaimethod!cartadd?pid="+pid+"&t="+t, null, 
			'dialogWidth:300px;dialogHeight:100px;help:no;unadorned:no;resizable:no;status:no;scroll:no');
		}
		
	}
function orderinfoshow(oid){
		var now = new Date(); 
		var t = now.getTime()+''; 
		//window.showModalDialog("qiantaimethod!orderinfo?oid="+oid+"&t="+t, null, 'dialogWidth:700px;dialogHeight:500px;help:no;unadorned:no;resizable:no;status:no;scroll:yes');

		if(window.showModalDialog == undefined){  //谷歌,火狐等浏览器
		     window.myNewWindow = window.open("qiantaimethod!orderinfo?oid="+oid+"&t="+t,'newwindow', 'height=500, width=700, top=100, left=250, toolbar=no, menubar=no, scrollbars=no, resizable=no, location=no, status=no'); 
		}else{  //IE
			window.showModalDialog("qiantaimethod!orderinfo?oid="+oid+"&t="+t, null, 
			'dialogWidth:700px;dialogHeight:500px;help:no;unadorned:no;resizable:no;status:no;scroll:yes');
		}

		
	}

</script>

</HEAD>
<BODY>
<DIV class=public_container><LINK rel=stylesheet type=text/css 
href="files/new.css"><LINK rel=stylesheet 
type=text/css href="files/jquery.loadmask.css">




<!--header_box start-->
<DIV class="header_box clearfix">
<H1 class=kfcLogo><span style="font-size: 40px;color: #f4a431;">美食订餐</span></H1>
<DIV class=headLeft>
<DIV class=tfav> </DIV>
<P><SPAN>欢迎美食订餐！ Welcome to order online!</SPAN></P>
<UL class=clearfix>
  <LI class=m1><A href="."><STRONG>首页</STRONG></A></LI>
  <LI class=m2><A href="qiantaimethod!cart"><STRONG>我的购物车</STRONG></A></LI>
  <LI class=m3><A href="qiantaimethod!order"><STRONG>我的订单</STRONG></A></LI>
  <LI class=m4><A href="#" onclick="registershow()"><STRONG>用户注册</STRONG></A></LI>
  <c:if test="${user==null}"> <LI class=m5><A href="qiantaimethod!login"><STRONG>用户登录</STRONG></A></LI></c:if>
  <c:if test="${user!=null}"> <LI class=m5><A href="qiantaimethod!loginout"><STRONG>用户退出</STRONG></A></LI></c:if>
  </UL></DIV></DIV>
<DIV id=clear_div></DIV><!--content_box start-->
<DIV class=spx5px></DIV>
<DIV id=content class=content_box><!--content_box_left start-->
<DIV class=content_box_left>
<DIV style="MARGIN-TOP: 0px !important" class=content_box_left_main><!-- 左侧菜单 -->
<DIV id=showMenu class=content_box_left_main_left>


<DIV style="WIDTH: 196px; BACKGROUND: #fff; FLOAT: left; OVERFLOW: hidden" 
id=menu_china>
<DIV style="WIDTH: 196px; BACKGROUND: #ffefcd; OVERFLOW: hidden">
<DIV style="DISPLAY: block" id=china>
<H1 class=content_box_left_main_left_h1>菜单</H1>
<SPAN class=content_box_left_main_left_c>


<UL id=menu_1 class=nav_left_ul>
<!-- 菜单 -->
<c:forEach items="${topcatelist}" var="bean">
<LI><A class=nav_left_n href=".?cid=${bean.id }"><span style="font-size: 20px;font-weight: bold;">${bean.catename }</span></A></LI>
</c:forEach>

</UL>
<SPAN 
class=content_box_left_main_left_info></SPAN></SPAN><SPAN 
class=content_box_left_main_left_b_2></SPAN></DIV></DIV>
</DIV>
</DIV>



<!--主体部分  -->
<DIV style="HEIGHT: 647px; OVERFLOW: hidden" id=eventInner class=content_box_left_main_right>

<form action="qiantaimethod!login2" method="post">
<table width="100%" border="1" cellpadding="0" cellspacing="20">
<tr>
<td colspan="2" align="center"><span style="font-size: 25px;">用户登录</span></td>
</tr>
<tr>
<td>
用户名：
</td>
<td>
<input type="text"  name="username">
</td>
</tr>
<tr>
<td>
密码：
</td>
<td>
<input type="password"  name="password">
</td>
</tr>
<tr>
<td>
操作：
</td>
<td>
<input type="submit"  value="提交">
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;
<input type="reset"  value="重置">
</td>
</tr>
</table>
</form>

</DIV>







<DIV id=clear_div></DIV></DIV></DIV>

<DIV style="FLOAT: right" class=content_box_right_1>
<form action="index" method="post">
  订餐搜索： <input type="text" value="请输入菜名" name="keyword" size="10" class="inputfield" title="email address" onfocus="clearText(this)" onblur="clearText(this)" />
           <input type="submit" name="submit" value="搜索"  />
 </form>


<DIV id=c>
</DIV>
</DIV>
<DIV id=orderArea class=content_box_right>
<DIV id=showHot class=content_box_right_2>
</DIV>
<span style="font-size: 20px;color: red;">
热度排行榜:
</span>

<table width="100%"  cellpadding="0" cellspacing="20">
<tr>

<td width="80%">菜单</td>
<td width="20%">销量</td>

</tr>

<c:forEach items="${xiaoliangprolist}" var="bean">
<tr>

<td>${bean.name}</td>
<td>${bean.xiaoliang}</td>

</tr>
</c:forEach>

</table>
<a href="manage/login.jsp">管理后台</a>
</DIV>
</BODY></HTML>

