<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>购物车</title>
		<%
		response.addHeader("Cache-Control", "no-store, must-revalidate"); 
		response.addHeader("Expires", new java.util.Date().getTime()+"");
		%>
		
		<link href="css/list.css" rel="stylesheet" type="text/css" />
		<link href="css/login.css" rel="stylesheet" type="text/css" />
		<link href="css/book.css" rel="stylesheet" type="text/css" />
		<link href="css/second.css" rel="stylesheet" type="text/css" />
		<link href="css/secBook_Show.css" rel="stylesheet" type="text/css" />
		<link href="css/shopping_vehicle.css" rel="stylesheet" type="text/css" />
		<link href="css/page_bottom.css" rel="stylesheet" type="text/css" />
		
<script  language="javascript" type="text/javascript"> 
function productshow(pid){
		var now = new Date(); 
		var t = now.getTime()+''; 
		//window.showModalDialog("qiantaimethod!product?pid="+pid+"&t="+t, null,'dialogWidth:700px;dialogHeight:700px;help:no;unadorned:no;resizable:no;status:no;scroll:no');

		if(window.showModalDialog == undefined){  //谷歌,火狐等浏览器
		     window.myNewWindow = window.open("qiantaimethod!product?pid="+pid+"&t="+t,'newwindow', 'height=700, width=700, top=100, left=250, toolbar=no, menubar=no, scrollbars=no, resizable=no, location=no, status=no'); 
		}else{  //IE
			window.showModalDialog("qiantaimethod!product?pid="+pid+"&t="+t, null, 
			'dialogWidth:700px;dialogHeight:700px;help:no;unadorned:no;resizable:no;status:no;scroll:no');
		}

		
	}
	
function changenum(pid){
	window.location = "qiantaimethod!cartchangenum?pid="+pid+'&num='+document.getElementById('it_'+pid).value;
	
}
function delproduct(pid){
	window.location = "qiantaimethod!delproduct?pid="+pid;
}

</script>
	</head>
	<body>
		<br />


		<div class="my_shopping">
			<img class="pic_shop"
				src="img/pic_myshopping.gif" />
		</div>
		<div id="div_choice" class="choice_merch">
			<h2 id="cart_tips">
				您已选购以下商品
			</h2>
			<div class="choice_bord">
				<table class="tabl_buy" id="tbCartItemsNormal">
					<tr class="tabl_buy_title">
						<td class="buy_td_6">
							<span>序号</span>
						</td>
						<td>
							<span class="span_w1">菜名</span>
						</td>
						
						<td class="buy_td_5">
							<span class="span_w2">原价</span>
						</td>
						<td class="buy_td_4">
							<span class="span_w3">热销价</span>
						</td>
						<td class="buy_td_1">
							<span class="span_w2">数量</span>
						</td>
						<td class="buy_td_2">
							<span>变更数量</span>
						</td>
						<td class="buy_td_1">
							<span>删除</span>
						</td>

					</tr>
					<tr class='objhide' over="no">
						<td colspan="8">
							&nbsp;
						</td>
					</tr>


					<c:forEach items="${cartItems}" var="it" varStatus="v">
						<tr class='td_no_bord'>
							<td >
								${v.index+1 }
							</td>
							<td>
								<a href="####" onclick="productshow(${it.product.id })"><span class="span_w1">${it.product.name }</span></a>
							</td>
							<td class="buy_td_5">
								<span class="c_gray">￥${it.product.price1}</span>
							</td>
							<td class="buy_td_4">
								&nbsp;&nbsp;
								<span>￥${it.product.price2}</span>
							</td>
							<td class="buy_td_1">
								&nbsp;&nbsp;${it.number}
							</td>

							<td class="buy_td_1">
								
								<input class="del_num" type="text" size="5" maxlength="4"
									id="it_${it.product.id}" value='${it.number}' />
									<br/>
								<a href="####" onclick="changenum(${it.product.id})">变更</a>
							</td>
							<td class="buy_td_1">
								<a href="####" onclick="delproduct(${it.product.id})">删除</a>
							</td>
						</tr>

					</c:forEach>
				</table>
				<div id="div_no_choice" class="objhide">
					<div class="choice_title"></div>
					<div class="no_select">
						您还没有挑选商品
					</div>
				</div>
				<div class="choice_balance">
					<div class="select_merch">

						<a href='.'>继续挑选商品...</a>

					</div>
					<div class="total_balance">
						<div class="save_total">
							原价：
							<span class="c_red"> ￥<span id="total_economy">${price1}</span>
							
							</span>
							<span class="t_add">优惠价：</span>
							<span class="c_red_b"> ￥<span id='total_account'>${price2}</span>
							</span>
						</div>
						<div id="balance" class="balance">
							<a name='checkout' href="qiantaimethod!address" > <img
									src="${pageContext.request.contextPath}/img/butt_balance.gif"
									alt="结算" border="0" title="结算" /> </a>
						</div>
					</div>
				</div>
			</div>
		</div>

		<!-- 用户删除恢复区 -->


			<div id="divCartItemsRemoved" class="del_merch">
				<div class="del_title">
					您已删除以下商品，如果想重新购买，请点击“恢复”
				</div>
				<table class=tabl_del id=del_table>
					<tbody>

						<c:forEach items="${dropcartItems}" var="it"
							varStatus="status">
							<tr>
								<td width="58" class=buy_td_6>
									&nbsp;
								</td>
								<td width="365" class=t2>
									<a href="####" onclick="productshow(${it.product.id })">${it.product.name}</a>
								</td>
								<td width="106" class=buy_td_5>
									￥${it.product.price1}
								</td>
								<td width="134" class=buy_td_4>
									<span>￥${it.product.price2}</span>
								</td>
								<td width="56" class=buy_td_1>
									<a href="javascript:;"
										onclick="location='qiantaimethod!recoveryCart?pid=${it.product.id}'">
										恢复 </a>
								</td>
								<td width="16" class=objhide>
									&nbsp;
								</td>
							</tr>

							<c:if test="${!status.last}">

								<tr class=td_add_bord>
									<td colspan=8>
										&nbsp;
									</td>
								</tr>
							</c:if>
						</c:forEach>

					</tbody>
				</table>
			</div>
		
	</body>
</html>



