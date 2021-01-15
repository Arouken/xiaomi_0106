<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <!-- 引入JSTL函数标签库 -->
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>${commodity.cname }详情页面</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/front/css/index.css">
    <script src="${pageContext.request.contextPath}/front/js/jquery-3.3.1.js"></script>
	<style>
	    .plus5_no3{
		    width: 1226px;
		    height: 700px;
		    margin: 0 auto;
		    padding-top: 32px;
		    padding-bottom: 12px;
		}
	</style>
</head>
<body>
    
    <jsp:include page="header.jsp"></jsp:include>
    
    <div class="plus5_no2 ">
        <div class="plus5_no2_in">
            <a class="plus5_no2_in_a"> 为方便您购买，请提前登录 </a>
            <a class="plus5_no2_in_a orange"style="color: pink;" href="login.jsp">立即登录</a>
            <a id="plus5_no2_in" class="plus5_no2_in_a" href="javascript:;">x</a>
        </div>
    </div>
    <div class="plus5_no3">
        <div class="plus5_no3_img">
            <img width="560px" height="560px" 
                src="img/${commodity.photo }" style="display: block" alt="">
        </div>
        <div class="plus5_no3_right">
            <h3>${commodity.cname }</h3>
            <p class="plus5_no3_right_p2">
            	<span class="plus5_no3_right_span2">
            	<!-- 商品简介 -->
            			<c:if test="${commodity.short_desc.length() <=5 }">
		            				${commodity.short_desc}
            			</c:if>
            			<c:if test="${commodity.short_desc.length() > 5 }">
            				${ fn:substring(commodity.short_desc ,0,5)}...
            			</c:if>
            	</span>
            	<div style="font-size: 14px;">
            	<!-- 商品详情介绍-->
            			<c:if test="${commodity.full_desc.length() <=12 }">
		            				${commodity.full_desc}
            			</c:if>
            			<c:if test="${commodity.full_desc.length() > 12 }">
            				${ fn:substring(commodity.full_desc ,0,12)}...
            			</c:if>
            	</div>
            	
            </p>
            <p class="plus5_no3_right_p3">
			            ${commodity.price } 元<span class="plus5_no3_right_span3">
			             ${commodity.price+500 } 元</span></p>
          
           
            <div class="plus5_no3_right_div6">选择版本</div>
            <div class="plus5_no3_right_div7">
            
            	<li class="plus5_no3_right_div7_in plus5_no3_right_div7_in_hover">
                    <span class="plus5_no3_right_div7_span0 ">${commodity.model }</span>
                    <span class="plus5_no3_right_div7_span " >${commodity.price }  元</span>
                </li>
            </div>
            <div class="plus5_no3_right_div6">选择颜色</div>
            <div class="plus5_no3_right_div9">
            	<li class="plus5_no3_right_div7_in plus5_no3_right_div7_in_hover ">
            		<img src="" alt=""><span>${commodity.color }</span>
            	</li>
            </div>
            
            <a href="javascript:void(0)" >
            <div class="plus5_no3_right_div11" 
                style="cursor: pointer;" id="sub">加入购物车</div>
            </a>
           
            <a href="javascript:void (0);"></a>

        </div>
    </div>
    
    <jsp:include page="footer.jsp"></jsp:include>
    
    <script type="text/javascript">
	    //1.绑定加入购物车事件
	    $("#sub").click(function(){
	    	//判断是否已经登录
	    	var frontUser="${sessionScope.frontUser }";
	    	var cid="${commodity.cid }";
	    	
	    	if(frontUser==null){
	    		alert("请先登录在执行操作！");
	    		return;
	    	}
	    	//将商品的id传入后台，执行添加购物车操作
	    	window.location="${pageContext.request.contextPath}/trolley?key=insertTrolley&cid="+cid;
	    	
	    })
    
    
    
    </script>
    
    
    
</body>
</html>