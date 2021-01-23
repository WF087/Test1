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
        <td height="31"><div class="titlebt">用户管理</div></td>
      </tr>
    </table></td>
    <td width="16" valign="top" background="images/mail_rightbg.gif"><img src="images/nav-right-bg.gif" width="16" height="29" /></td>
  </tr>
</table>
<br/>


<br/>
<table width="100%" border="1" cellpadding="0" cellspacing="0">
<tr>
<td style="font-weight: bold;">
用户名
</td>
<td style="font-weight: bold;">
密码
</td>
<td style="font-weight: bold;">
真实姓名
</td>
<td style="font-weight: bold;">
联系地址
</td>
<td style="font-weight: bold;">
联系电话
</td>
<td style="font-weight: bold;">
email
</td>
<td style="font-weight: bold;">
qq
</td>
<td style="font-weight: bold;">
注册时间
</td>
<td style="font-weight: bold;">
操作
</td>
</tr>
<c:forEach var="bean" items="${list}">
<tr>
<td>
${bean.username}
</td>
<td>
 ${bean.password}
</td>
<td>
${bean.truename}
</td>
<td>
${bean.address}
</td>
<td>
${bean.phone}
</td>
<td>
${bean.email}
</td>
<td>
${bean.qq}
</td>
<td>
${fn:substring(bean.createtime,0, 19)}
</td>
<td>

<a href="houtaimethod!userdelete?id=${bean.id }"><span style="font-size: 20px;color: blue;">删除用户</span></a>

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
