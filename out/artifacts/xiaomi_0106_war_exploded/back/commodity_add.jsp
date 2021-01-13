<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>添加商品</title>
<link href="${pageContext.request.contextPath }/back/css/style.css" rel="stylesheet" type="text/css" />
<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath }/back/js/My97DatePicker/WdatePicker.js"></script>
</head>

<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">添加商品</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>商品信息</span></div>
    
    <form action="${pageContext.request.contextPath }/commodity?key=insertCommodity" 
          method="post" enctype="multipart/form-data">
    	
	    <ul class="forminfo"> 
	    	 <!-- 商品分类信息 -->
	    	 <li>
	    	 	<label>商品分类</label>
	    	 	<select name="cate_id" class="dfinput">
	    	 		<option value="0">===请选择===</option>
					<!-- 动态获取分类信息 -->
					<c:forEach items="${categoryList }" var="cate">
					  <option value="${cate.cid }">${cate.cname }</option>
					</c:forEach>
	    	 	</select>
	    	 </li>	 
	    	 
		    <li><label>商品名称</label>
		    <input name="cname" type="text" class="dfinput" /><i>商品名称不能超过30个字符</i></li>
		    <li><label>颜色</label>
		    <input name="color" type="text" class="dfinput" /></li>
		    <li><label>规格尺寸</label>
		    <input name="size" type="text" class="dfinput" /></li>
		    <li><label>单价</label>
		    <input name="price" type="text" class="dfinput" /></li>
		    <li><label>简介</label>
		    	<textarea name="short_desc" cols="10" rows="10" class="textinput" style="height: 80px"></textarea>
		    </li>
		    <li><label>完整介绍</label>
		    	<textarea name="full_desc" cols="10" rows="10" class="textinput" style="height: 80px"></textarea>
		    </li>
		    <li><label>商品展示图</label>
		    	<input name="photo" type="file"/>
		    </li>
		    <li><label>商品小类别</label>
			    <cite>
				    <input name="ctype" type="radio" value="0" checked="checked" />正常&nbsp;&nbsp;&nbsp;&nbsp;
				    <input name="ctype" type="radio" value="1" />热门产品
				    <input name="ctype" type="radio" value="2" />为你推荐
				    <input name="ctype" type="radio" value="3" />新品
				    <input name="ctype" type="radio" value="4" />小米明星单品
			    </cite>
		    </li>
		    <li><label>型号</label>
		    <input name="model" type="text" class="dfinput" /></li>
		    
		    <li><label>生产日期</label>
		    	<input class="Wdate" style="width: 345px;height: 32px;line-height: 32px;"
		    	 onClick="WdatePicker({el:this,dateFmt:'yyyy-MM-dd HH:mm:ss'})" 
		    	 name="create_date" type="text" class="dfinput" value="" />
		    </li>
		    
		    <li><label>&nbsp;</label><input type="submit" class="btn" value="确认保存"/></li>
	    </ul>
    </form>
    </div>
</body>
</html>
