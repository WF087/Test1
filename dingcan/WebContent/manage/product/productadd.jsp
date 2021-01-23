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


	
<script> 
 
 	function checkform(){
 	
 	
	 if (document.getElementById('nameid').value=="")
	{
		alert("菜单名不能为空");
		return false;
	}
	 if (document.getElementById('cidid').value=="0")
		{
			alert("请选择所属分类，如果无法选择请在分类管理中先添加菜单分类");
			return false;
		}
	 if (document.getElementById('uploadfileid').value=="")
		{
			alert("图片不能为空");
			return false;
		}
	 if (document.getElementById('price1id').value=="")
		{
			alert("原价不能为空");
			return false;
		}

	 if (document.getElementById('price2id').value=="")
		{
			alert("热销价不能为空");
			return false;
		}


	// 验证必须为正数

	 var reg1 =  /^[1-9]\d*\.\d*|0\.\d*[1-9]\d*$/;
	  
	  var reg2 =  /^\d+$/;
	  
	  var flag = 0;
	  if(document.getElementById('price1id').value.match(reg1) != null){
	  	flag=1
	  }
	   if(document.getElementById('price1id').value.match(reg2) != null){
	  	flag=1
	  }


		if (flag==0)
		{
			alert("原价必须为正数");
			return false;
		}


		var reg1 =  /^[1-9]\d*\.\d*|0\.\d*[1-9]\d*$/;
		  
		  var reg2 =  /^\d+$/;
		  
		  var flag = 0;
		  if(document.getElementById('price2id').value.match(reg1) != null){
		  	flag=1
		  }
		   if(document.getElementById('price2id').value.match(reg2) != null){
		  	flag=1
		  }


			if (flag==0)
			{
				alert("热销价必须为正数");
				return false;
			}

			var price1 = document.getElementById('price1id').value;
			var price2 = document.getElementById('price2id').value;

			 if(eval(price1)<=eval(price2)){
				 	alert('原价必须大于热销价');
					return false;
			}
	

return true;
	
	}

</script>

<body>
<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="17" valign="top" background="images/mail_leftbg.gif"><img src="images/left-top-right.gif" width="17" height="29" /></td>
    <td valign="top" background="images/content-bg.gif"><table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg" id="table2">
      <tr>
        <td height="31"><div class="titlebt">添加菜单</div></td>
      </tr>
    </table></td>
    <td width="16" valign="top" background="images/mail_rightbg.gif"><img src="images/nav-right-bg.gif" width="16" height="29" /></td>
  </tr>
</table>
<br/>






<form action="houtaimethod!productadd2" method="post" enctype="multipart/form-data" onsubmit="return checkform()" >
<table width="70%" border="1" cellpadding="0" cellspacing="0">

<tr>
<td style="font-weight: bold;">
菜单名:
</td>
<td style="font-weight: bold;">
<input type="text" name="name" size="30"  id="nameid" />
</td>
</tr>

<tr>
<td style="font-weight: bold;">
所属分类:
</td>
<td style="font-weight: bold;">
<select name="cid"   id="cidid" >
						<option value="0">请选择分类</option>
							<c:forEach items="${list}" var="bean">
                                <option value="${bean.id }" >
                                   	${bean.catename }
                                </option>
                                </c:forEach>
</select>     	
</td>
</tr>

<tr>
<td style="font-weight: bold;">
图片:
</td>
<td style="font-weight: bold;">
<input  name="uploadfile"  type="file" id="uploadfileid"  />
</td>
</tr>

<tr>
<td style="font-weight: bold;">
原价(元):
</td>
<td style="font-weight: bold;">
 <input type="text" name="price1" id="price1id" />
</td>
</tr>

<tr>
<td style="font-weight: bold;">
热销价(元):
</td>
<td style="font-weight: bold;">
 <input type="text" name="price2" id="price2id" />
</td>
</tr>

<tr>
<td style="font-weight: bold;">
商品简介:
</td>
<td style="font-weight: bold;">
<textarea  rows="7" cols="50" name="info5"></textarea>
</td>
</tr>


<tr>
<td style="font-weight: bold;">
操作
</td>
<td style="font-weight: bold;">
<input type="submit" value="提交" style="width: 60px">
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input  onclick="javascript:history.go(-1);" style="width: 60px" type="button" value="返回" />
</td>
</tr>

</table>
</form>

</body>
