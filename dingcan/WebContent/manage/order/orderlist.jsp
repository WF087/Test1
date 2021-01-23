<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<link href="images/skin.css" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" /><style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	background-color: #EEF2FB;
}
-->
</style>
 <script src="js/Calendar.js"></script>
<body>
<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="17" valign="top" background="images/mail_leftbg.gif"><img src="images/left-top-right.gif" width="17" height="29" /></td>
    <td valign="top" background="images/content-bg.gif"><table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg" id="table2">
      <tr>
        <td height="31"><div class="titlebt">订单管理</div></td>
      </tr>
    </table></td>
    <td width="16" valign="top" background="images/mail_rightbg.gif"><img src="images/nav-right-bg.gif" width="16" height="29" /></td>
  </tr>
</table>
<br/>

<form  action="houtaimethod!orderlist" method="post">
		<table class="searchContent">
		   <input type="hidden" name="id" value="${id}" />
		   <input type="hidden" name="type" value="${type}" />
			<tr>
			
				<td>
					订单状态：<select name="status">
					<option value="">所有状态</option> 
					<option value="未受理订单" <c:if test="${status=='未受理订单' }">selected</c:if>>未受理订单</option> 
					<option value="已受理订单" <c:if test="${status=='已受理订单' }">selected</c:if>>已受理订单</option>
					</select>
				</td>
				<td>
					订单添加时间：<input type="text" name="time1" value="${time1}"  onfocus='setDayHM(this);'  />
					---<input type="text" name="time2" value="${time2}"  onfocus='setDayHM(this);'  />
				</td>
				
				<td>
					订单号：<input type="text"  name="orderid" value="${orderid}"  size="12"/>
				</td>
				<td>
					收货人名称：<input type="text"  name="username" value="${username}" size="12"/>
				</td>
				
				
				<td>
				<input type="submit" value="查询">
				</td>
				
				
			</tr>
			
			
			
		</table>
		

	</form>



<br/>
<table width="100%" border="1" cellpadding="0" cellspacing="0">
<tr>
<td style="font-weight: bold;">
订单号
</td>
<td style="font-weight: bold;">
收货人姓名
</td>
<td style="font-weight: bold;">
地址
</td>
<td style="font-weight: bold;">
联系方式
</td>
<td style="font-weight: bold;">
总价格
</td>
<td style="font-weight: bold;">
订单状态
</td>
<td style="font-weight: bold;">
订单时间
</td>
<td style="font-weight: bold;">
操作
</td>
</tr>
<c:forEach var="bean" items="${list}">
<tr>
<td>
${bean.orderid}
</td>
<td>
 ${bean.username}
</td>
<td>
${bean.address}
</td>
<td>
${bean.phone}
</td>
<td>
${bean.totalprice}
</td>
<td>
<c:if test="${bean.status==0}">未受理订单</c:if>
<c:if test="${bean.status==1}">已受理订单</c:if>
</td>
<td>
${fn:substring(bean.createtime,0, 19)}
</td>
<td>
<c:if test="${bean.status==0}">
<a href="houtaimethod!orderupdate3?id=${bean.id }"><span style="font-size: 20px;color: blue;">处理订单</span></a>
&nbsp;&nbsp;&nbsp;&nbsp;
</c:if>
<a href="houtaimethod!orderupdate?id=${bean.id }"><span style="font-size: 20px;color: blue;">订单详情</span></a>
</td>
</tr>
</c:forEach>
<tr>
<td colspan="7">
${pagerinfo }
</td>

</tr>
</table>



</body>
