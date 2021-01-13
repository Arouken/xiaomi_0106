<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>修改类别</title>

<link href="${pageContext.request.contextPath }/back/css/style.css" rel="stylesheet" type="text/css" />
<!-- 错误提示的样式修改 -->
<style type="text/css">
.forminfo li{width:850px;margin-bottom:13px; clear:both;}
.forminfo li label{width:86px;line-height:34px; display:block; float:right;}
.forminfo li .title{width:86px;line-height:34px; display:block; float:left;}
.error{
		width:490px; 
		margin-top:5px;
		padding-top:5px;
		color:red;
		}
</style>

<!-- 引入jquery -->
<script type="text/javascript" src="${pageContext.request.contextPath }/back/js/jquery-3.3.1.js"></script>
<!-- 引入validate验证插件：验证非空  格式验证 -->
<script type="text/javascript" src="${pageContext.request.contextPath }/back/js/jquery.validate.js"></script>
<!-- validate语言插件：默认验证插件是英文  引入一个支持中文的设置 -->
<script type="text/javascript" src="${pageContext.request.contextPath }/back/js/messages_zh.js"></script>


<!-- my97日期插件 -->
<script language="javascript" type="text/javascript" 
src="${pageContext.request.contextPath }/back/js/My97DatePicker/WdatePicker.js"></script>
</head>

<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">修改类别</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>类别信息</span></div>
    <!-- 修改的表单 -->
    <form action="${pageContext.request.contextPath }/category?key=updateCategory" 
          method="post" id="cateForm">
          <!-- 使用隐藏域传入id -->
          <input name="cid" type="hidden" value="${category.cid }" />
	    <ul class="forminfo">
		    <li><label class="title">类别名称</label>
		    <input name="cname" type="text" value="${category.cname }"
		           class="dfinput" required="required"/>
		    <i>类别名称不能超过30个字符</i></li>
		    <li><label class="title">是否启用</label>
			    <cite>
				    <input name="state" type="radio" value="1"  
				    <c:if test="${category.state==1 }">checked="checked"</c:if>
				    />是&nbsp;&nbsp;&nbsp;&nbsp;
				    <input name="state" type="radio" value="0" 
				    <c:if test="${category.state==0 }">checked="checked"</c:if>
				    />否
			    </cite>
		    </li>
		    
		    <li><label class="title">排序序号</label>
		    	<input name="order_num" type="text" value="${category.order_num }"
		    	     class="dfinput" required="required"/>
		    	<i>输入数字，越大越靠后排列</i>
		    </li>
		    
		    <li><label class="title">类别描述</label>
		    	<textarea name="description" cols="" rows="" 
		    	class="textinput" required="required">${category.description }</textarea>
		    </li>
		    
		    <li><label class="title">创建时间</label>
		    	<input class="Wdate" style="width: 345px;height: 32px;line-height: 32px;" 
		    	onClick="WdatePicker({el:this,dateFmt:'yyyy-MM-dd HH:mm:ss'})" readonly="readonly"
		    	name="create_date" type="text" class="dfinput" value="${category.create_date }" required="required"/>
		    </li>
		    
		    <li><label>&nbsp;</label><input type="submit" class="btn" value="确认保存"/></li>
	    </ul>
    </form>
    </div>
    
    <script type="text/javascript">
    /* 表单提交的时候进行非空验证 */
    $("#cateForm").validate();
    </script>
</body>
</html>
