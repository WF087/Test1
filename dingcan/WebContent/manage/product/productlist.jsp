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

<body>
<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="17" valign="top" background="images/mail_leftbg.gif"><img src="images/left-top-right.gif" width="17" height="29" /></td>
    <td valign="top" background="images/content-bg.gif"><table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg" id="table2">
      <tr>
        <td height="31"><div class="titlebt">菜单管理</div></td>
      </tr>
    </table></td>
    <td width="16" valign="top" background="images/mail_rightbg.gif"><img src="images/nav-right-bg.gif" width="16" height="29" /></td>
  </tr>
</table>
<br/>




<a href="houtaimethod!productadd"><span style="font-size: 20px;color: blue;">添加菜单</span></a>
<br/>
<table width="100%" border="1" cellpadding="0" cellspacing="0">
<tr>
<td style="font-weight: bold;">
菜单名
</td>
<td style="font-weight: bold;">
所属分类
</td>
<td style="font-weight: bold;">
原价
</td>
<td style="font-weight: bold;">
热销价
</td>
<td style="font-weight: bold;">
销量
</td>
<td style="font-weight: bold;">
热点推荐
</td>
<td style="font-weight: bold;">
操作
</td>
</tr>
<c:forEach var="bean" items="${list}">
<tr>
<td>
${bean.name}
</td>
<td>
${bean.cate.catename}
</td>
<td>
${bean.price1}
</td>
<td>
${bean.price2}
</td>
<td>
${bean.xiaoliang}
</td>
<td>
<c:if test="${bean.newstuijian==1}">已推荐</c:if>
<c:if test="${bean.newstuijian==0}">未推荐</c:if>
</td>
<td>

<a href="houtaimethod!productupdate?id=${bean.id }"><span style="font-size: 20px;color: blue;">更新菜单</span></a>
&nbsp;&nbsp;&nbsp;&nbsp;
<a href="houtaimethod!productupdate3?id=${bean.id }"><span style="font-size: 20px;color: blue;">热点推荐</span></a>
&nbsp;&nbsp;&nbsp;&nbsp;
<a href="houtaimethod!productdelete?id=${bean.id }"><span style="font-size: 20px;color: blue;">删除菜单</span></a>
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
