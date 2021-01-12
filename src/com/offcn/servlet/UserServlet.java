package com.offcn.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.offcn.pojo.User;
import com.offcn.service.UserService;
import com.offcn.service.impl.UserServiceImpl;
import com.offcn.utils.UploadTool;
import com.offcn.utils.PageTool;

/**
 * �û�ģ��
 * @author admin
 *
 */
@WebServlet("/user")
//֧���ϴ���ע��:servlet3.0�汾�ṩ��
@MultipartConfig
public class UserServlet extends BaseServlet{
	//����service
	private UserService userService=new UserServiceImpl();

	/**
	 * �����ֻ������ѯ�û�
	 * SELECT * FROM users WHERE phone=
	 */
	
	public void checkPhone(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		//��ȡ�����е��ֻ�����
		String phone = request.getParameter("phone");
		//����service�Ĳ�ѯ����
	    User user=userService.queryByPhone(phone);
		if (user==null) {
			//�ֻ�����û��ע���
			response.getWriter().write("ok");
		} else {
			//�ֻ������Ѿ�ע���
			response.getWriter().write("no");
		}
	}
	/**
	 * �����˺Ų�ѯ�û�
	 */
	
	public void checkUsername(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		//��ȡ�����е��˺�
		String username = request.getParameter("username");
		//����service��ѯ����
	     User user=	userService.queryByUsername(username);
	     if (user==null) {
			//�˺�û��ע���
			response.getWriter().write("ok");
		} else {
			//�˺��Ѿ�ע���
			response.getWriter().write("no");
		}
	     
		
	}
	/**
	 * �û�����
	 */
	
	public void insertUser(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		//��ȡ���еĲ���
		String uname = request.getParameter("uname");
		String genderStr = request.getParameter("gender");
		//���ַ���ת��������
		Integer gender = Integer.valueOf(genderStr);
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String username = request.getParameter("username");
		String userpwd = request.getParameter("userpwd");
		//ע������:ϵͳ��ǰʱ��
		Date create_date=new Date();
		//��ȡpart����
		Part part = request.getPart("photo");
		System.out.println(part.getSize());
		//ʹ�ù������ȡ�ļ�����
		String photo = UploadTool.uploadImg(part);
		//����ȡ�Ĳ�����װ��һ���û�ʵ���������
		User user=new User(uname, phone, address, username, userpwd,
				           photo,  gender, create_date);
		//����service���ӷ���
		int row=userService.insertUser(user);
		//ע��ɹ�����ת��¼
		if (row>0) {
			//ת�����ض���
			response.sendRedirect("front/login.jsp");
		}
		
		
	}
	
	/**
	 * ���ù����෢����֤�뵽�ֻ���
	 */
	public void sendCode(HttpServletRequest request,
			HttpServletResponse response) {
		//��ȡ�ֻ���
		String phone = request.getParameter("phone");
		//��ȡsession����
		HttpSession session = request.getSession();
		//���ú�̨����������֤��
		userService.sendCode(phone,session);
	}
	
	/**
	 * �����ֻ�������֤���¼
	 */
	public void checkCode(HttpServletRequest request,
			HttpServletResponse response)throws Exception {
		//��ȡ�����е��ֻ��ź���֤��
		String phone = request.getParameter("phone");
		String code = request.getParameter("code");
		//��ȡsession����
		HttpSession session = request.getSession();
		//���ú�̨��֤�ķ���
	   int num=	userService.checkCode(phone,code,session);
		//��¼�ɹ���ת����ҳ
	   if (num>0) {
		  //�ض���
		   response.sendRedirect("front/index.jsp");
	   }
		
	}
	
	/**
	 * У�������ͼ����֤���Ƿ���ȷ
	 */
	public void checkImgCode(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		//��ȡ�����е�ͼ����֤��
		String code = request.getParameter("code");
		//����session����
		HttpSession session = request.getSession();
		//����service����֤����
		int num= userService.checkImgCode(code,session);
		if (num>0) {
			//��֤����ȷ
			response.getWriter().write("ok");
		}else {
			//��֤�����
			response.getWriter().write("no");
		}
	}
	
	/**
	 * �����˺������¼��ǰ��ϵͳ��¼
	 */
	public void checkLogin(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		//��ȡ�����е��˺ź�����
		String username = request.getParameter("username");
		String userpwd = request.getParameter("userpwd");
		//����service��ѯ����
		User user= userService.queryByNameAndPwd(username,userpwd);
		if (user!=null) {
			//��¼�ɹ�����ת��ҳ
			response.sendRedirect("front/index.jsp");
		}
		
	}
	
	/**
	 * ����Ա��¼
	 */
	
	public void adminLogin(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		//��ȡ�����е��˺ź�����
		String username = request.getParameter("username");
		String userpwd = request.getParameter("userpwd");
		//����service����Ĳ�ѯ����
		User user=userService.adminLogin(username,userpwd);
		if (user!=null) {
			/**
			 * ��¼�ɹ�������ǰ��¼���˺���Ϣ�洢�����������session��
			 */
			//��ȡsession����
			HttpSession session = request.getSession();
			//����ǰ��¼���˺���Ϣ�洢session��
			session.setAttribute("adminUser", user);
			
			//��¼�ɹ���ת����ҳ
			response.sendRedirect("back/main.jsp");
		}
	}
	
	/**
	 * �˳�����Ա�˺�
	 */
	public void loginOut(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		//����session����
		HttpSession session = request.getSession();
		//����¼���˺��Ƴ�
		session.removeAttribute("adminUser");
		//�˳���¼����ת����¼ҳ��
		response.sendRedirect("back/login.jsp");
	}

	//��ҳ
	public void queryUserByPage(HttpServletRequest request,
								HttpServletResponse response) throws Exception{
		//1.��ȡҳ���еĵ�ǰҳ��ֵ
		String currentPage = request.getParameter("currentPage");
		//2.ִ�з�ҳ��ѯ
		PageTool<User> pageTool=userService.queryByPage(currentPage);
		//6.����ҳ�����䵽�ͻ���ҳ��
		request.setAttribute("pageTool", pageTool);
		//7.��ת���û�չʾҳ�棺ת��
		request.getRequestDispatcher("back/user_list.jsp").forward(request, response);
	}

	/**
	 * �޸��û���Ȩ��
	 */

	public void updateManager(HttpServletRequest request,
							  HttpServletResponse response) throws Exception{
		//��ȡ�����еĲ���
		Integer uid = Integer.valueOf(request.getParameter("uid"));
		Integer manager = Integer.valueOf(request.getParameter("manager"));
		//����service�޸ĵķ���
		int num=userService.updateManager(manager,uid);
		if (num>0) {
			//�޸ĳɹ�
			queryUserByPage(request,response);
		}

	}

	/**
	 * ����ɾ��
	 * @throws Exception
	 */
	public void batchDelete(HttpServletRequest request,
							HttpServletResponse response) throws Exception {
		//��ȡ��Ҫɾ����id
		String[] values = request.getParameterValues("ids");
		//������ת���ɹ��ַ������
		//System.out.println(Arrays.toString(values));
		//���ú�̨ɾ������
		int num=userService.batchDelete(values);
		//ɾ���ɹ���ת��ѯ
		if (num>0) {
			queryUserByPage(request, response);
		}

	}



}
