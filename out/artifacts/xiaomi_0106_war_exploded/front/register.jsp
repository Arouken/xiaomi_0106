<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>注册页面</title>
    <link rel="stylesheet" href="css/index.css">
	  <!--js文件引入  -->
    <script type="text/javascript" src="js/jquery-3.3.1.js"></script>
    <script type="text/javascript" src="js/jquery.validate.js"></script>
    <script type="text/javascript" src="js/messages_zh.js"></script>
</head>
<body>
<body>

<div class="sign_background">
    <div class="sign_background_in">
        <div class="sign_background_no1">
            <a href="index.jsp"><img src="img/logo.jpg" alt=""></a>
        </div>
        <div class="sign_background_no2">注册小米帐号</div>
        <div class="sign_background_no3">
               
            <div class="sign_background_no5">
             	
             	<form  id="registForm" 
             	action="${pageContext.request.contextPath }/user?key=insertUser"
             	 method="post" enctype="multipart/form-data">
             	<!--错误提示  -->
             	<span id="mess" ></span>
             		<table style="width: 500px;" border="0" cellspacing="0">
             			<tr>
             				<td width="25%" class="_left">姓名：</td>
             				<td><input type="text" name="uname" id="uname" ></td>
             			</tr>
             			<tr>
             				<td width="25%" class="_left">性别：</td>
             				<td>
             					男<input type="radio" name="gender" value="1" checked="checked">
             				 	女<input type="radio" name="gender" value="0">
							</td>
             			</tr>
             			<tr>
             				<td width="25%" class="_left">电话号码：</td>
             				<td><input type="text" name="phone" 
             				   onblur="checkPhone()" id="phone">
             				   <!--错误提示  -->
             				 <span id="phone_mess"></span>  
             				   </td>
             			</tr>
             			<tr>
             				<td width="25%" class="_left">所在地区：</td>
             				<td><input type="text" name="address" id="address"></td>
             			</tr>
             			<tr>
             				<td width="25%" class="_left">账号：</td>
             				<td><input type="text" name="username" 
             				   id="username">
             				    <!--错误提示  -->
             				 <span id="username_mess"></span>  
             				   </td>
             			</tr>
             			<tr>
             				<td width="25%" class="_left">密码：</td>
             				<td><input type="text" name="userpwd" id="userpwd"></td>
             			</tr>
             			<tr>
             				<td width="25%" class="_left">上传头像：</td>
             				<td><input type="file" name="photo" id="photo"></td>
             			</tr>
             		</table>
             		<div class="sign_background_no6" id="btn" 
             		      onclick="sub()" >立即注册</div>
             	</form>
             	 
            </div>
        </div>
        <div class="sign_background_no7">注册帐号即表示您同意并愿意遵守小米 <span>用户协议</span>和<span>隐私政策</span> </div>
    </div>
    <div class="sign_background_no8"><img src="img/sign01.jpg" alt=""></div>

</div>
	<!-- js验证 -->
	<script type="text/javascript">
		//3.账号验证
		//输入框绑定一个失去焦点事件
		$("#username").blur(function(){
			//验证账号非空
			var username=$("#username").val();//账号
		    if($.trim(username).length==0){
				$("#username_mess").html("输入的账号不能为空！");
				return;
			}
			//使用ajax验证是否已经注册
			$.ajax({
				url:"${pageContext.request.contextPath }/user?key=checkUsername",
				type:"post",
				dataType:"text",
				data:"username="+username,
				success:function(obj){
					if(obj=="ok"){
						//提示可以注册
						$("#username_mess").html("账号可以注册！").css("color","green");
					}else{
						//提示已经注册
						$("#username_mess").html("账号已经注册！");
					}
				}
			})
			
		})
		//2.手机号码验证
		function checkPhone(){
			//清空错误提示
			$("#phone_mess").html("");
			//手机号码非空
			var phone=$("#phone").val();//电话
		    if($.trim(phone).length==0){
				$("#phone_mess").html("电话号码不能为空！");
				return;
			}
			//验证手机格式：正则表达式验证
			var reg=/^1[0-9]{10}$/;
			//判断手机格式是否正确:test()
			if(!reg.test(phone)){
				//错误提示
				$("#phone_mess").html("手机格式不正确！");
				return;
			}
			//验证手机号码是否被注册过
			//超链接  表单  提交数据最终都需要刷新整个页面。
			//但是我们验证手机号的时候需要的是局部刷新技术:ajax
			$.ajax({
				url:"${pageContext.request.contextPath }/user?key=checkPhone",  //请求的目标地址路径：目标servlet的映射路径以及对应的增删改查的方法
				type:"post",  //请求后台的方式：get/post
				dataType:"text",//服务器响应给客户端的数据类型：html  xml  json  text
				data:"phone="+phone,//请求中携带的参数：手机号
				success:function(obj){//根据服务器响应的参数进行处理：成功的回调函数
					//obj是ok或者是no
					console.log(obj);
					if(obj=="ok"){
						//提示可以注册
						$("#phone_mess").html("手机号码可以注册！").css("color","green");
					}else{
						//提示已经注册
						$("#phone_mess").html("手机号码已经注册！");
					}
				}
			})
		
			
			
		}
	
	
	
		//1.输入的内容不能为空：姓名  电话  地区  账号  密码 头像
		function sub(){//点击注册触发的函数
			//清空错误提示
			$("#mess").html("");
			var uname=$("#uname").val();//姓名
			if($.trim(uname).length==0){//去掉字符串的前后空格之后的长度是否为0
				//提示不能为空:html()改变html页面元素标签里面的内容
				$("#mess").html("输入的姓名不能为空！");
				//跳出方法
				return;
			}
		    var phone=$("#phone").val();//电话
		    if($.trim(phone).length==0){
				$("#mess").html("电话号码不能为空！");
				return;
			}
		    var address=$("#address").val();//地区
		    if($.trim(address).length==0){
				$("#mess").html("输入的地区不能为空！");
				return;
			}
			var username=$("#username").val();//账号
			 if($.trim(username).length==0){
					$("#mess").html("输入的账号不能为空！");
					return;
				}
			var userpwd=$("#userpwd").val();//密码
			 if($.trim(userpwd).length==0){
					$("#mess").html("密码不能为空！");
					return;
				}
			var photo=$("#photo").val();//头像
			if($.trim(photo).length==0){
				$("#mess").html("请选择一张头像图片上传！");
				return;
			}
			//上传的文件必须是图片格式：获取文件的后缀名
			//思路：截取字符串
			//获取字符串中最后.的索引
			photo=photo.substring(photo.lastIndexOf(".")+1,photo.length);
			//判断是否是图片:jpg png  gif  jpeg 
			/* 常用的图片格式
			bmp,jpg,png,tif,gif,pcx,tga,exif,fpx,
			svg,psd,cdr,pcd,dxf,ufo,eps,ai,raw,WMF,webp
			*/
			if(photo!="jpg"&&photo!="png"&&photo!="gif"){
				$("#mess").html("请上传正确的图片格式！");
				return;
			}
			//非空验证完毕，提交表单
			$("#registForm").submit();
		
		}
		
	
	</script>
</body>
</html>