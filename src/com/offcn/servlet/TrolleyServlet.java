package com.offcn.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.offcn.pojo.User;
import com.offcn.service.TrolleyService;
import com.offcn.service.impl.TrolleyServiceImpl;

import java.io.IOException;

/**
 * 购物车模块
 * @author admin
 *
 */
@WebServlet("/trolley")
public class TrolleyServlet extends BaseServlet{
	//引入service
	
	private TrolleyService trolleyService=new TrolleyServiceImpl();
	/**
	 * 加入购物车
	 */
	public void insertTrolley(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//创建session对象
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("frontUser");
		//获取用户的id
		Integer uid = user.getUid();
		//获取请求中商品的id
		Integer cid = Integer.valueOf(request.getParameter("cid"));
		//调用后台增加方法
		int row=trolleyService.insertTrolley(uid,cid);
		
		if (row>0) {
			//跳转到购物车展示页面
			//request.getRequestDispatcher("front/trolley.jsp").forward(request, response);
			response.sendRedirect("front/trolley.jsp");
		}
		
	}

}
