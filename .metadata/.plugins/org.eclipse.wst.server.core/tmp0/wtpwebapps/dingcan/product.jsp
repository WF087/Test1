<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>详细信息</title>
		<%
		response.addHeader("Cache-Control", "no-store, must-revalidate"); 
		response.addHeader("Expires", new java.util.Date().getTime()+"");
		%>
		<style type="text/css">
#regdiv {
	position: absolute;
	width: 700px;
	height: 700px;
	background-image: url(img/b2c_04.jpg);
}
</style>

		<script language="javascript" type="text/javascript">

function windowclose(){
window.close();
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
</script>

	</head>


	<body>



		<div id="regdiv">
			<table align="center">
				<tr align="center">
					<td>
						详细信息
					</td>
				</tr>
				<tr align="center">
					<td>
						<img src="uploadfile/${product.imgpath }" width="300" height="300" />
					</td>
				</tr>
				<tr align="center">
					<td>
					<a href="####" onclick="cartaddshow(${product.id })">
						<img src="img/gwc.jpg"  border="0"/>
					</a>
					</td>
				</tr>
			</table>


			<table align="center" border="1" cellpadding="5" cellspacing="3">
				<tr>
					<td>
						菜名
					</td>
					<td>
						${product.name }
					</td>
				</tr>
				<tr>
					<td>
						原价
					</td>
					<td>
						${product.price1 }￥
					</td>
				</tr>
				<tr>
					<td>
						热销价
					</td>
					<td>
						${product.price2 }￥
					</td>
				</tr>
				<tr>
					<td>
						销量
					</td>
					<td>
						${product.xiaoliang }
					</td>
				</tr>
				<tr>
					<td>
						简介
					</td>
					<td>
						<textarea rows="7" cols="50" readonly="readonly">${product.info5 }</textarea>
					</td>
				</tr>
				
			

			<table align="center">
				<tr align="center">
					<td>
						<input type="button" value="关闭该窗口" onclick="windowclose()"/>
					</td>
				</tr>
			</table>
		</div>

	</body>

</html>
