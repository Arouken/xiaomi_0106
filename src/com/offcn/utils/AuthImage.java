package com.offcn.utils;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.offcn.utils.VerifyCodeUtils;

/**
 * ������֤��ͼƬ
 */
@WebServlet("/authImage")
public class AuthImage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//������Ӧͷ��Ϣ
		resp.setHeader("Pragma", "No-cache");
		resp.setHeader("Cache-Control", "no-cache");
		resp.setDateHeader("Expires",0);
		resp.setContentType("image/jpeg");//��ӦͼƬ���ͻ���
		//��������룺��֤�루����һ��4λ������ַ���֤�룩
		String verifyCode = VerifyCodeUtils.generateVerifyCode(4);
		//�洢��session��������
		HttpSession session = req.getSession();
		//ÿ�δ洢�µ�code���Ƴ�ԭ����
		session.removeAttribute("verifyCode");
		//Ϊ����֤�������֤���Ƿ���ȷ
		session.setAttribute("verifyCode", verifyCode);
		//��Ӧ��ҳ��ͼƬ
		int w=100;
		int h=30;
		VerifyCodeUtils.outputImage(w, h, resp.getOutputStream(), verifyCode);
	}

}
