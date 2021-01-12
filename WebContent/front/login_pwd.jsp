<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>登录页面</title>
    <link rel="stylesheet" href="css/index.css">
    <script src="js/jquery-3.3.1.js"></script>
    <style>
    /* 修改登录表单的默认样式：内部引入 */
		.register_boby_no2{
		    width: 410px;
		    height: 280px;
		    float: right;
		}
    </style>
</head>
<body>
<div class="register_head_on">

</div>
<div class="register_head">
    <a href="index.html"><img src="img/logo.jpg" alt=""></a>
    <div class="register_head_right">
        <p class="register_head_right_p1">小 米 商 城</p>
        <p class="register_head_right_p2">让每个人都享受科技乐趣</p>
    </div>

</div>

<div class="register">
    <div class="register_boby">
        <div class="register_boby_min">
            <div class="register_boby_no1">
                <div class="register_boby_no1_in">
                    <span style="color: #ff6700">账号密码登录 </span>
                </div>
            </div>
            <form id="f3" 
            action="${pageContext.request.contextPath}/user?key=checkLogin" 
            method="post">
            
            <!-- fs区分的方法 -->
            <input name="fs" value="checkCode" type="hidden">
            
            <div class="register_boby_no2">
            <!-- 错误提示 -->
            	<span id="msg" style="color: red;font-size: 12px;margin-left: 20px;"></span>
               <!-- 账号 -->
                <input id="username" name="username" type="text" 
                placeholder="请输入账号">
                <!-- 密码 -->
                <input id="userpwd" name="userpwd" type="text" 
                placeholder="请输入密码">
                <input id="code" name="code"  type="text" placeholder="输入验证码" 
                style="width: 200px; margin-left: 15px;float: left;">
                
                <!-- 图形验证码图片
                src属性直接访问后台的servlet映射路径即可
                 -->
                <img id="loginImg" src="${pageContext.request.contextPath }/authImage" 
                style="width: 138px;float: left;height: 53px;margin-left: 5px;margin-top:8px">
                
                <div style="clear: both;">
                
                <div class="register_boby_no2_div">
                    <span id="sub">登录</span>
                </div>
            </div>
            </div>
            </form>
            
            <div class="register_boby_no3">
                <a href="login.jsp" style="color: #ff6700">手机验证码登录</a>
                <sapn class="register_boby_no3_span">
                    <a href="register.jsp">立即注册</a>
                    <span>|</span>
                    <a href="avascript:void(0);">忘记密码?</a>
                </sapn>

            </div>
            <div class="register_boby_no4">
                <img src="img/register02.jpg" alt="">
            </div>

        </div>
    </div>
</div>
<div class="register_foot">
    <img  src="img/register03.jpg" alt="">
</div>
	<script type="text/javascript">
	//1.点击图片改变验证码
	$("#loginImg").click(function(){
		//再次访问图片的servlet映射路径即可：也就是改变图片的src属性值
		//为了让后台服务器认为每次都是一个新的请求，需要设置一个参数在请求中
		this.src="${pageContext.request.contextPath }/authImage?date="+new Date();
	})
	//2.点击登录
	$("#sub").click(function(){
		//错误提示清空
		$("#msg").html("");
		//获取输入的账号密码  验证码
		var username=$("#username").val();
		if($.trim(username).length==0){
			//错误提示
			$("#msg").html("账号不能为空！");
			return;
		}
		var userpwd=$("#userpwd").val();
		if($.trim(userpwd).length==0){
			//错误提示
			$("#msg").html("密码不能为空！");
			return;
		}
		var code=$("#code").val();
		if($.trim(code).length==0){
			//错误提示
			$("#msg").html("验证码不能为空！");
			return;
		}
		
		//验证码是否正确：ajax
		$.ajax({
			url:"${pageContext.request.contextPath }/user?key=checkImgCode",
			type:"post",
			dataType:"text",
			data:"code="+code,
			success:function(obj){
				if(obj=="ok"){
					//验证码正确，提交表单根据账号密码验证登录
					$("#f3").submit();
				}else{
					//验证码错误
					$("#msg").html("验证码输入错误！");
					return;
				}
			}
			
		})
		
		
	})
	
	</script>
</body>
</html>