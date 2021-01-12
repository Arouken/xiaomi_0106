package com.offcn.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * ���е�servlet�Ļ���
 * @author admin
 *
 */

public class BaseServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
				//������������
		request.setCharacterEncoding("utf-8");
	    response.setContentType("text/html;charset=utf-8");
	    //���������еĹؼ���key
	    String key = request.getParameter("key");
	    //�������ֽ����ļ�����
	    Class<? extends BaseServlet> clazz = this.getClass();
	    try {
	    	//��ȡ������еķ���
			Method method = clazz.getMethod(key, 
					HttpServletRequest.class,HttpServletResponse.class);
			//ִ�����еķ���
			method.invoke(this, request,response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
