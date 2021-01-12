package com.offcn.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 所有的servlet的基类
 * @author admin
 *
 */

public class BaseServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
				//处理中文乱码
		request.setCharacterEncoding("utf-8");
	    response.setContentType("text/html;charset=utf-8");
	    //接受请求中的关键字key
	    String key = request.getParameter("key");
	    //创建类字节码文件对象
	    Class<? extends BaseServlet> clazz = this.getClass();
	    try {
	    	//获取类对象中的方法
			Method method = clazz.getMethod(key, 
					HttpServletRequest.class,HttpServletResponse.class);
			//执行类中的方法
			method.invoke(this, request,response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
