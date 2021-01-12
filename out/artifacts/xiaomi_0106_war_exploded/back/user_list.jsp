<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!-- JSTL标签:核心标签库 -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 引入函数标签库 -->
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
    //获取项目名
    String path = request.getContextPath();
    //获取tomcat 协议+地址+端口号+ 获取项目名
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>用户信息</title>
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
        <li><a href="#">用户管理</a></li>
    </ul>
</div>

<div class="rightinfo">

    <div class="tools">

        <ul class="toolbar">


            <li style="cursor: pointer;" onclick="batchDelete()">
        <span>
        <img src="${pageContext.request.contextPath }/back/images/t03.png" />
        </span>批量删除</li>
        </ul>

    </div>
    <!-- 错误提示 -->

    <span id="errorMsg"></span>
    <!-- 设置一个批量删除的表单 -->
    <form action="${pageContext.request.contextPath }/user?key=batchDelete"
          method="post" id="delForm">
        <table class="tablelist">
            <thead>
            <tr>
                <th><input name="" type="checkbox" value="" checked="checked"/></th>
                <th>序号<i class="sort"><img src="${pageContext.request.contextPath }/back/images/px.gif" /></i></th>
                <th>姓名</th>
                <th>性别</th>
                <th>电话号码</th>
                <th>所在地区</th>
                <th>权限</th>
                <th>账号</th>
                <th>头像</th>
                <th>注册时间</th>
                <th>操作</th>
            </tr>
            </thead>


            <tbody>
            <!-- 动态的展示数据库用户信息
            forEach 遍历循环类似java中的for循环
            items="" 循环遍历的集合对象，通常配合EL表达式使用
            var="" 遍历的集合对象中的元素对象
            varStatus=""表示遍历的元素的位置参数  通常使用count属性表示元素的位置值

             -->
            <!-- el表达式通过：对象.属性名    方式获取对象中的参数 -->
            <c:forEach items="${pageTool.list }" var="user" varStatus="vs">
                <tr>
                    <td>
                        <!-- 判断是否是当前登录的账号，如果是不能删除 -->
                        <c:if test="${user.username!=adminUser.username }">
                            <!-- 将当前行用户的id赋值给复选框，当获取到复选框的值的时候就获取到用户的id -->
                            <input  type="checkbox" value="${user.uid }"
                                    class="one" name="ids" />
                        </c:if>
                        <c:if test="${user.username==adminUser.username }">
                            <span style="color:deeppink;">正在使用的账号</span>
                        </c:if>
                    </td>
                    <td>${vs.count }</td>
                    <td>${user.uname }</td>
                    <td>
                        <c:if test="${user.gender==1 }">男</c:if>
                        <c:if test="${user.gender==0 }">女</c:if>
                    </td>
                    <td>
                        <!--
                        fn:substring(需要截取的目标字符串，截取的起始索引，截取的结束索引)
                        fn:replace(需要操作的目标字符串，需要替换的字符片段，替代的特殊字符)
                         -->
                            ${fn:replace(user.phone,fn:substring(user.phone,3,8),'*****') }
                    </td>
                    <td>${user.address }</td>
                    <td>
                        <c:if test="${user.manager==1 }">管理员</c:if>
                        <c:if test="${user.manager==0 }">普通账号</c:if>
                    </td>
                    <td>${user.username }</td>
                    <td>
                        <img src="img/${user.photo }"
                             width="60px" height="60px"/>
                    </td>
                    <td>${user.create_date }</td>
                    <td>
                        <!--根据账号当前的状态进行权限的修改操作
                                                      当前登录的账号不能修改
                        -->
                        <c:if test="${user.manager==1 }">
                            <!-- 判断当前账号是否是正在登录使用的账号 -->
                            <c:if test="${user.username==adminUser.username }">
                                <span style="color:deeppink;">正在使用的账号</span>
                            </c:if>
                            <c:if test="${user.username!=adminUser.username }">
                                <a href="${pageContext.request.contextPath }/user?key=updateManager&manager=0&uid=${user.uid}"
                                   style="color:red;">取消管理员</a>
                            </c:if>
                        </c:if>
                        <c:if test="${user.manager==0 }">
                            <a href="${pageContext.request.contextPath }/user?key=updateManager&manager=1&uid=${user.uid}"
                               style="color:blue;">设为管理员</a>
                        </c:if>

                    </td>

                </tr>
            </c:forEach>

            </tbody>

        </table>
    </form>
    <!-- 分页按钮 -->
    <div class="pagin">
        <div class="message">共<i class="blue">${pageTool.totalCount}</i>
            条记录，当前显示第&nbsp;<i class="blue">${pageTool.currentPage}/${pageTool.totalPage}&nbsp;</i>页</div>
        <ul class="paginList">

            <li class="paginItem">
                <a href="${pageContext.request.contextPath }/user?key=queryUserByPage&currentPage=1">首页</a></li>
            <li class="paginItem">
                <a href="${pageContext.request.contextPath }/user?key=queryUserByPage&currentPage=${pageTool.lastPage}">上一页</a></li>
            <li class="paginItem">
                <a href="${pageContext.request.contextPath }/user?key=queryUserByPage&currentPage=${pageTool.nextPage}">下一页</a></li>
            <li class="paginItem">
                <a href="${pageContext.request.contextPath }/user?key=queryUserByPage&currentPage=${pageTool.totalPage}">尾页</a></li>

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

    //1.绑定批量删除事件
    function batchDelete(){
        //2.确定页面中复选框是否被勾选，如果没有被勾选给出提示
        //获取页面中被选中的class=one的复选框
        var num=$(".one:checked").length;
        //如果没有勾选就提示
        if(num==0){
            $("#errorMsg").html("请先勾选需要删除的数据！").css("color","red");
            return;
        }
        //确认删除
        if(confirm("确定要删除选中的数据吗？")){
            //将uid传入后台执行删除
            $("#delForm").submit();
        }

    }




</script>
</body>
</html>
