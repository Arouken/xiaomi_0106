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
 * 生成验证码图片
 */
@WebServlet("/authImage")
public class AuthImage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//设置响应头信息
		resp.setHeader("Pragma", "No-cache");
		resp.setHeader("Cache-Control", "no-cache");
		resp.setDateHeader("Expires",0);
		resp.setContentType("image/jpeg");//响应图片到客户端
		//生成随机码：验证码（生成一个4位的随机字符验证码）
		String verifyCode = VerifyCodeUtils.generateVerifyCode(4);
		//存储到session作用域中
		HttpSession session = req.getSession();
		//每次存储新的code先移除原来的
		session.removeAttribute("verifyCode");
		//为了验证输入的验证码是否正确
		session.setAttribute("verifyCode", verifyCode);
		//响应到页面图片
		int w=100;
		int h=30;
		VerifyCodeUtils.outputImage(w, h, resp.getOutputStream(), verifyCode);
	}

}
