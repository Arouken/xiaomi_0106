<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%	
	//获取项目名
	String path = request.getContextPath();
	//获取tomcat 协议+地址+端口号+ 获取项目名
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	//获取tomcat 协议+地址+端口号
	String imgPath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+"/";
	
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>购物车</title>
    <link href="css/index.css"  rel="stylesheet"  rel="stylesheet" type="text/css" />
<script type="text/javascript">
	
</script>
</head>
<body>
    <div class="order_head">
        <div class="head_background">
            <div class="head_box">
                <a href="index.html" class="head_left_a"><img src="img/logo.jpg" alt="" class="head_left_p"></a>
                <h1 class="head_h1">历史订单</h1>
                <div class="head_right">
                    <span class="head_right_in">${sessionScope.phone_number }</span>
                    <span class="head_right_in">|</span>
                    <a href="indexServlet?fs=index" class="head_right_in">继续购物</a>
                </div>

            </div>
        </div>
    </div>
    <div class="trolley_background" >
    	<center>
    		<table border="1" cellspacing="0" style="width: 1400px;background-color: #FFF" >
	           	<tr style="height: 80px;">
	           		<th width="220px">订单号</th>
	           		<th>商品信息</th>
	           		<th>商品总数量</th>
	           		<th>总价</th>
	           		<th>订单状态</th>
	           		<th width="220px">创建时间</th>
	           		<th>操作</th>
	           	</tr>
	           	
	           	<c:forEach items="${ordersList }" var="orders">
		           	<tr  style="height: 80px;">
		           		<td style="text-align: center;">${orders.order_number }</td>
		           		<td style="text-align: center;">
		           			<c:forEach items="${orders.trolleyList }" var="tro">
		           				${tro.goods.name }<br/>
		           			</c:forEach>
		           		
		           		</td>
		           		<td style="text-align: center;">${orders.number }</td>
		           		<td style="text-align: center;">${orders.sum_price }</td>
		           		<td style="text-align: center;">
		           			<!-- 0,未支付、1,待发货、2,已发货、3,已收货 -->
		           			<c:if test="${orders.state == 0 }">未支付</c:if>
		           			<c:if test="${orders.state == 1 }">待发货</c:if>
		           			<c:if test="${orders.state == 2 }">已发货</c:if>
		           			<c:if test="${orders.state == 3 }">已收货</c:if>
		           		</td>
		           		<td style="text-align: center;">${orders.create_time }</td>
		           		<td style="text-align: center;"></td>
		           	</tr>
	           	</c:forEach>
           </table>
           </center>
    </div>

   <jsp:include page="footer.jsp"></jsp:include>

    <script>
    </script>
</body>
</html>