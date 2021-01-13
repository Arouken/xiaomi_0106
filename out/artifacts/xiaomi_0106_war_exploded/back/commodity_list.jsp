<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>商品信息</title>
<link href="${pageContext.request.contextPath }/back/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath }/back/jquery-3.3.1.js"></script>

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
    <li><a href="#">商品管理</a></li>
    </ul>
    </div>
    
    <div class="rightinfo">
    
    <div class="tools">
    
    	<ul class="toolbar">
        
        <!-- 
        
        <li class="click"><span><img src="images/t02.png" /></span>修改</li>
        <li><span><img src="images/t04.png" /></span>统计</li>
         -->
        <li style="cursor: pointer;" onclick="add_commodity()"><span>
        <img src="${pageContext.request.contextPath }/back/images/t01.png"  /></span>
        		添加商品</li>
        <li style="cursor: pointer;" onclick="batchDelete()"><span><img src="${pageContext.request.contextPath }/back/images/t03.png" /></span>批量删除</li>
        </ul>

    </div>
    <table class="tablelist">
    	<thead>
    	<tr>
	        <th><input name="" type="checkbox" value="" checked="checked"/></th>
	        <th>序号<i class="sort"><img src="${pageContext.request.contextPath }/back/images/px.gif" /></i></th>
	        <th>商品类别</th>
	        <th>商品名称</th>
	        <th>商品颜色</th>
	        <th>商品价格</th>
	        <th width="10%">简介</th>
	        <th width="20%">详情</th>
	       	<th>商品展示图</th>
	       	<th>是否热推</th>
	       	<th>型号</th>
	       	<th>生产日期</th>
	       	<th>操作</th>
        </tr>
        </thead>
        <tbody>
        <!-- 商品信息动态展示 -->
        <c:forEach items="${pageTool.list }" var="commodity" varStatus="vs">
        	<tr>
        	    <td><input name="" type="checkbox" value=""/></td>
        	    <td>${vs.count }</td>
        	    <td>${commodity.category.cname }</td>
        	    <td>${commodity.cname }</td>
        	    <td>${commodity.color }</td>
        	    <td>${commodity.price }</td>
        	    <td>${commodity.short_desc }</td>
        	    <td>${commodity.full_desc }</td>
        	    <td>
        	    	<img src="img/${commodity.photo }"
        	    	 width="80px" height="80px" />
        	    </td>
       	      <td>
       	        <c:if test="${commodity.ctype==0 }">正常</c:if>
       	        <c:if test="${commodity.ctype==1 }">热门产品</c:if>
       	        <c:if test="${commodity.ctype==2 }">为你推荐</c:if>
       	        <c:if test="${commodity.ctype==3 }">新品</c:if>
       	        <c:if test="${commodity.ctype==4 }">小米明星单品</c:if>
       	      </td>
       	      <td>${commodity.model }</td>
       	      <td>${commodity.create_date }</td>
       	      <td>
       	      		<a href="${pageContext.request.contextPath }/commodity?key=queryCommodityById&cid=${commodity.cid}">修改商品信息</a>
       	      </td>
        	</tr>
        </c:forEach>
        </tbody>
    </table>
    
   <!-- 分页按钮 -->
    <div class="pagin">
    	<div class="message">共<i class="blue">${pageTool.totalCount }</i>
    	条记录，当前显示第&nbsp;<i class="blue">&nbsp;${pageTool.currentPage }/${pageTool.totalPage }</i>页</div>
        <ul class="paginList">  
	         <li class="paginItem">
	         <a href="${pageContext.request.contextPath }/commodity?key=queryCommodityByPage&currentPage=1">首页</a>
	         </li>
	         <li class="paginItem">
	         <a href="${pageContext.request.contextPath }/commodity?key=queryCommodityByPage&currentPage=${pageTool.lastPage }">上一页</a>
	         </li>
	         <li class="paginItem">
	         <a href="${pageContext.request.contextPath }/commodity?key=queryCommodityByPage&currentPage=${pageTool.nextPage }">下一页</a>
	         </li>
	         <li class="paginItem">
	         <a href="${pageContext.request.contextPath }/commodity?key=queryCommodityByPage&currentPage=${pageTool.totalPage }">尾页</a>
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
    
    
    
    
    </div>
    
    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	//跳转商品增加页面：先进行分类查询
	function add_commodity(){
		window.location="${pageContext.request.contextPath }/category?key=queryAllCategory";
	}
	</script>
</body>
</html>
