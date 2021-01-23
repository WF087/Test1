<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="s" uri="/struts-tags"%>



<div>

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
					<td height="25" width="100">
						订单编号
					</td>
					<td>
						${order.orderid }
					</td>
				</tr>
				<tr>
					<td height="25" width="100">
						订单时间
					</td>
					<td>
						${fn:substring(order.createtime,0, 10)}
					</td>
				</tr>
				<tr>
					<td width="100"   height="25">
						总价
					</td>
					<td>
						${order.totalprice }
					</td>
				</tr>
				<tr>
					<td width="100"   height="25">
						订单状态
					</td>
					<td >
						<c:if test="${order.status==0}">
						提交成功
						</c:if>
						<c:if test="${order.status==1}">
						发货成功
						</c:if>
					</td>
				</tr>
				<tr>
					<td width="100"   height="25">
						收货人
					</td>
					<td>
						${order.username }
					</td>
				</tr>
				<tr>
					<td width="100"   height="25">
						收货地址
					</td>
					<td>
						${order.address }
					</td>
				</tr>
				<tr>
					<td width="100"   height="25">
						联系方式
					</td>
					<td>
						${order.phone }
					</td>
				</tr>
			</table>
			<br/><br/><br/>

			<table align="center">
				<tr align="center">
					<td>
						订单商品列表
					</td>
				</tr>
			</table>
			
			<table align="center" border="1" cellpadding="5">
				<tr align="center">
					<td width="100"   height="25">
					商品名
					</td>
					<td width="100"   height="25">
					数量
					</td>
					<td width="100"   height="25">
					价格总计
					</td>
				</tr>
				<c:forEach items="${order.orderItems}" var="bean" varStatus="vstatus">
				<tr align="center">
					<td width="100"   height="25">
					${bean.productname }
					</td>
					<td width="100"   height="25">
					${bean.productnum }
					</td>
					<td width="100"   height="25">
					${bean.price }
					</td>
				</tr>
				</c:forEach>
			</table>
 	
			

			
		</div>