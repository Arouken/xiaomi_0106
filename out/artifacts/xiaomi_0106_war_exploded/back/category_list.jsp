<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 引入jstl标签库 -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>商品分类</title>
<link href="${pageContext.request.contextPath }/back/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath }/back/js/jquery-3.3.1.js"></script>

<script type="text/javascript">

// old write 
$(document).ready(function(){
  $(".click").click(function(){
  $(".tip").fadeIn(200);
  });
  
  $(".tiptop a").click(function(){
  $(".tip").fadeOut(200);
});

  $(".sure").click(function(){
  $(".tip").fadeOut(100);
});

  $(".cancel").click(function(){
  $(".tip").fadeOut(100);
});

});

</script>
</head>
<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">分类管理</a></li>
    </ul>
    </div>
    
    <div class="rightinfo">
    
    <div class="tools">
    
    	<ul class="toolbar">
        
        
        <li style="cursor: pointer;" onclick="add_category()"><span>
        <img src="${pageContext.request.contextPath }/back/images/t01.png"  />
        </span>添加类别</li>
        <li style="cursor: pointer;" onclick="batchDelete()"><span>
        <img src="${pageContext.request.contextPath }/back/images/t03.png" />
        </span>批量删除</li>
        </ul>

    </div>
    <!-- 错误提示 -->
    <span id="errorMsg" style="color:red;">${msg }</span>
    <!-- 设置删除的表单 -->
	<form action="${pageContext.request.contextPath }/category?key=batchDelete"  
			method="post" id="deleteForm">
    <table class="tablelist">
    	<thead>
    	<tr>
	        <th><input name="" type="checkbox" value="" checked="checked"/></th>
	        <th>序号<i class="sort"><img src="${pageContext.request.contextPath }/back/images/px.gif" /></i></th>
	        <th>类别名称</th>
	        <th>启用状态</th>
	        <th>排序序号</th>
	        <th>创建时间</th>
	        <th>描述</th>
	        <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <!-- 分类信息动态展示 -->
        <c:forEach items="${pageTool.list }" var="category" varStatus="vs">
        	<tr>
        	    <td><input name="ids" type="checkbox" 
        	         value="${category.cid }" class="one"/></td>
        	    <td>${vs.count }</td>
        	    <td>${category.cname }</td>
        	    <td>
        	      <c:if test="${category.state==1 }">启用</c:if>
        	      <c:if test="${category.state==0 }">未启用</c:if>
        	    </td>
        	    <td>${category.order_num }</td>
        	    <td>${category.create_date }</td>
        	    <td>${category.description }</td>
        	    <td>
        	    <a href="${pageContext.request.contextPath }/category?key=queryCategoryById&cid=${category.cid}">修改分类信息</a>
        	    </td>
        	</tr>	
        </c:forEach>
        </tbody>
    </table>
    </form>
   <!-- 分页按钮 -->
    <div class="pagin">
    	<div class="message">共<i class="blue">${pageTool.totalCount }</i>条记录，当前显示第&nbsp;
    	<i class="blue">&nbsp;${pageTool.currentPage }/${pageTool.totalPage }</i>页</div>
        <ul class="paginList">

	         <li class="paginItem">
	         <a href="${pageContext.request.contextPath }/category?key=queryCategoryByPage&currentPage=1">首页</a>
	         </li>
	         <li class="paginItem">
	         <a href="${pageContext.request.contextPath }/category?key=queryCategoryByPage&currentPage=${pageTool.lastPage}">上一页</a>
	         </li>
	         <li class="paginItem">
	         <a href="${pageContext.request.contextPath }/category?key=queryCategoryByPage&currentPage=${pageTool.nextPage}">下一页</a>
	         </li>
	         <li class="paginItem">
	         <a href="${pageContext.request.contextPath }/category?key=queryCategoryByPage&currentPage=${pageTool.totalPage}">尾页</a>
	         </li>
	    
        </ul>
    </div>
    
    
    <div class="tip">
    	<div class="tiptop"><span>提示信息</span><a></a></div>
        
      <div class="tipinfo">
        <span><img src="images/ticon.png" /></span>
        <div class="tipright">
        <p>是否确认对信息的修改 ？</p>
        <cite>如果是请点击确定按钮 ，否则请点取消。</cite>
        </div>
        </div>
        
        <div class="tipbtn">
        <input name="" type="button"  class="sure" value="确定" />&nbsp;
        <input name="" type="button"  class="cancel" value="取消" />
        </div>
    
    </div>
    
    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	//跳转到增加页面
	function add_category(){
		window.location="${pageContext.request.contextPath }/back/category_add.jsp";
	}
	//批量删除
	function batchDelete(){
		//清除错误提示
		$("#errorMsg").html("");
		//判断页面中是否勾选了数据
		if($(".one:checked").length==0){
			//给出提示
			$("#errorMsg").html("请勾选需要删除的数据！").css("color","red");
			return;
		}
		//确认删除
		if(confirm("确定要删除选中的数据吗？")){
			//提交删除的表单
			$("#deleteForm").submit();
		}
		
	}
	
	</script>
</body>
</html>
