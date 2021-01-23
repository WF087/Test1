<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>订单详细信息</title>
		<%
		response.addHeader("Cache-Control", "no-store, must-revalidate"); 
		response.addHeader("Expires", new java.util.Date().getTime()+"");
		%>
		<style type="text/css">

</style>

		<script language="javascript" type="text/javascript">

function windowclose(){
window.close();
}

</script>


	</head>


	<body>



		<div >
			<table align="center">
				<tr >
					<td>
						<span
						id="sph1"
						style="font-size: 14px; font-weight: bold; color: #ff7800; ">订单详细信息</span>
					</td>
				</tr>
			</table>
			<table  border="1" cellpadding="5" cellspacing="3" align="center">
				<tr>
					<td>
						订单编号
					</td>
					<td>
						${order.orderid }
					</td>
				</tr>
				<tr>
					<td>
						订单时间
					</td>
					<td>
						${fn:substring(order.createtime,0, 10)}
					</td>
				</tr>
				<tr>
					<td>
						总价
					</td>
					<td>
						${order.totalprice }
					</td>
				</tr>
				<tr>
					<td>
						订单状态
					</td>
					<td>
						<c:if test="${order.status==0}">
						提交成功
						</c:if>
						<c:if test="${order.status==1}">
						发货成功
						</c:if>
					</td>
				</tr>
				<tr>
					<td>
						收货人
					</td>
					<td>
						${order.username }
					</td>
				</tr>
				<tr>
					<td>
						收货地址
					</td>
					<td>
						${order.address }
					</td>
				</tr>
				<tr>
					<td>
						联系方式
					</td>
					<td>
						${order.phone }
					</td>
				</tr>
			</table>
			

			<table align="center">
				<tr align="center">
					<td>
						订单菜名列表
					</td>
				</tr>
			</table>
			
			<table align="center" border="1" cellpadding="5">
				<tr align="center">
					<td>
					菜名
					</td>
					<td>
					数量
					</td>
					<td>
					价格总计
					</td>
				</tr>
				<c:forEach items="${order.orderItems}" var="bean" varStatus="vstatus">
				<tr align="center">
					<td>
					${bean.productname }
					</td>
					<td>
					${bean.productnum }
					</td>
					<td>
					${bean.price }
					</td>
				</tr>
				</c:forEach>
			</table>
 	
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
