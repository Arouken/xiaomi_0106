<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 引入jstl标签库 -->
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<div class="box">
      <div class="inner whiteGL">
          <div class="left">
              <a class="mix" href="">小米商城-学习专用</a>
          </div>
          <div class="right">
          <!--没有登录显示注册和登录 -->
          <c:if test="${frontUser ==null}">
          		<a class="mix" href="${pageContext.request.contextPath}/front/login.jsp">登录</a>
                <a href="${pageContext.request.contextPath}/front/register.jsp">注册</a>
          
          </c:if>
          
          <!-- 登录成功显示当前登录账号和退出登录按钮 -->
          <c:if test="${frontUser !=null}">
              <span style="color:red;"> 欢迎  ${frontUser.uname }  登录小米商城</span>  
           <a href="${pageContext.request.contextPath}/user?key=frontLoginOut">退出登录</a>
          
          </c:if>
              
              <a class="max"  href="">消息通知</a>
              <a href="${pageContext.request.contextPath}/front/trolley.jsp"><img src="${pageContext.request.contextPath}/front/img/cart.jpg" alt=""></a>
          </div>
      </div>
  </div>
  <div class="logo">
      <div class="logo_left">
          <div>
              <a href="${pageContext.request.contextPath }/index?key=queryIndexInfo" 
              title="小米官网">
              <img class="xiaomi" src="${pageContext.request.contextPath}/front/img/logo.jpg"></a>
          </div>
      </div>
      <ul class="logo_center orangeGL">
          <a href="">小米手机</a>
          <a href="">红米</a>
          <a href="">笔记本</a>
          <a href="">电视</a>
          <a href="">盒子</a>
          <a href="">新品</a>
          <a href="">路由器</a>
          <a href="">智能硬件</a>
          <a href="">服务</a>
          <a href="">社区</a>
      </ul>
      <formv class="logo_right">
         <div class="logo_input"><input type="text">
             <div class="logo_input_div">
                 <a class="logo_input_a" href="">小米5 新品</a>
                 <a class="logo_input_a" href="">小米Note 3</a>
             </div>


         </div>
          <a class="logo_right_a"><img src="${pageContext.request.contextPath}/front/img/find.jpg"></a>
          <!--<a href="">红米5新品</a>-->
          <!--<a href="">小米Noto 3</a>-->
      </formv>
  </div>
</body>
</html>