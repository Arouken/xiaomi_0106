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
 * ���ﳵģ��
 * @author admin
 *
 */
@WebServlet("/trolley")
public class TrolleyServlet extends BaseServlet{
	//����service
	
	private TrolleyService trolleyService=new TrolleyServiceImpl();
	/**
	 * ���빺�ﳵ
	 */
	public void insertTrolley(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//����session����
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("frontUser");
		//��ȡ�û���id
		Integer uid = user.getUid();
		//��ȡ��������Ʒ��id
		Integer cid = Integer.valueOf(request.getParameter("cid"));
		//���ú�̨���ӷ���
		int row=trolleyService.insertTrolley(uid,cid);
		
		if (row>0) {
			//��ת�����ﳵչʾҳ��
			//request.getRequestDispatcher("front/trolley.jsp").forward(request, response);
			response.sendRedirect("front/trolley.jsp");
		}
		
	}

}
