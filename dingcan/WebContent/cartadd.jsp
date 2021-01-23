<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>添加到购物车</title>
		<%
		response.addHeader("Cache-Control", "no-store, must-revalidate"); 
		response.addHeader("Expires", new java.util.Date().getTime()+"");
		%>
		<style type="text/css">
#regdiv {
	position: absolute;
	width: 300px;
	height: 100px;
	background-image: url(img/b2c_04.jpg);
}
</style>

		<script language="javascript" type="text/javascript">

function windowclose(){
window.close();
}
</script>


	</head>


	<body>



		<div id="regdiv">
			<table align="center">
				<tr align="center">
					<td>
						成功添加到购物车
					</td>
				</tr>
			</table>
			<table align="center">
				<tr align="center">
					<td>
						<input type="button" value="继续购物" onclick="windowclose()"/>
					</td>
				</tr>
			</table>
		</div>

	</body>

</html>
