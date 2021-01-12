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
 * 用户模块
 * @author admin
 *
 */
@WebServlet("/user")
//支持上传的注解:servlet3.0版本提供的
@MultipartConfig
public class UserServlet extends BaseServlet{
	//引入service
	private UserService userService=new UserServiceImpl();

	/**
	 * 根据手机号码查询用户
	 * SELECT * FROM users WHERE phone=
	 */
	
	public void checkPhone(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		//获取请求中的手机号码
		String phone = request.getParameter("phone");
		//调用service的查询方法
	    User user=userService.queryByPhone(phone);
		if (user==null) {
			//手机号码没有注册过
			response.getWriter().write("ok");
		} else {
			//手机号码已经注册过
			response.getWriter().write("no");
		}
	}
	/**
	 * 根据账号查询用户
	 */
	
	public void checkUsername(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		//获取请求中的账号
		String username = request.getParameter("username");
		//调用service查询方法
	     User user=	userService.queryByUsername(username);
	     if (user==null) {
			//账号没有注册过
			response.getWriter().write("ok");
		} else {
			//账号已经注册过
			response.getWriter().write("no");
		}
	     
		
	}
	/**
	 * 用户增加
	 */
	
	public void insertUser(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		//获取表单中的参数
		String uname = request.getParameter("uname");
		String genderStr = request.getParameter("gender");
		//将字符串转换成整形
		Integer gender = Integer.valueOf(genderStr);
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String username = request.getParameter("username");
		String userpwd = request.getParameter("userpwd");
		//注册日期:系统当前时间
		Date create_date=new Date();
		//获取part对象
		Part part = request.getPart("photo");
		System.out.println(part.getSize());
		//使用工具类获取文件名称
		String photo = UploadTool.uploadImg(part);
		//将获取的参数封装到一个用户实体类对象中
		User user=new User(uname, phone, address, username, userpwd,
				           photo,  gender, create_date);
		//调用service增加方法
		int row=userService.insertUser(user);
		//注册成功，跳转登录
		if (row>0) {
			//转发或重定向
			response.sendRedirect("front/login.jsp");
		}
		
		
	}
	
	/**
	 * 调用工具类发送验证码到手机上
	 */
	public void sendCode(HttpServletRequest request,
			HttpServletResponse response) {
		//获取手机号
		String phone = request.getParameter("phone");
		//获取session对象
		HttpSession session = request.getSession();
		//调用后台方法发送验证码
		userService.sendCode(phone,session);
	}
	
	/**
	 * 根据手机号码验证码登录
	 */
	public void checkCode(HttpServletRequest request,
			HttpServletResponse response)throws Exception {
		//获取请求中的手机号和验证码
		String phone = request.getParameter("phone");
		String code = request.getParameter("code");
		//获取session对象
		HttpSession session = request.getSession();
		//调用后台验证的方法
	   int num=	userService.checkCode(phone,code,session);
		//登录成功跳转到首页
	   if (num>0) {
		  //重定向
		   response.sendRedirect("front/index.jsp");
	   }
		
	}
	
	/**
	 * 校验输入的图形验证码是否正确
	 */
	public void checkImgCode(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		//获取请求中的图形验证码
		String code = request.getParameter("code");
		//创建session对象
		HttpSession session = request.getSession();
		//调用service的验证方法
		int num= userService.checkImgCode(code,session);
		if (num>0) {
			//验证码正确
			response.getWriter().write("ok");
		}else {
			//验证码错误
			response.getWriter().write("no");
		}
	}
	
	/**
	 * 根据账号密码登录：前端系统登录
	 */
	public void checkLogin(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		//获取请求中的账号和密码
		String username = request.getParameter("username");
		String userpwd = request.getParameter("userpwd");
		//调用service查询方法
		User user= userService.queryByNameAndPwd(username,userpwd);
		if (user!=null) {
			//登录成功，跳转首页
			response.sendRedirect("front/index.jsp");
		}
		
	}
	
	/**
	 * 管理员登录
	 */
	
	public void adminLogin(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		//获取请求中的账号和密码
		String username = request.getParameter("username");
		String userpwd = request.getParameter("userpwd");
		//调用service里面的查询方法
		User user=userService.adminLogin(username,userpwd);
		if (user!=null) {
			/**
			 * 登录成功。将当前登录的账号信息存储到作用域对象session中
			 */
			//获取session对象
			HttpSession session = request.getSession();
			//将当前登录的账号信息存储session中
			session.setAttribute("adminUser", user);
			
			//登录成功跳转到首页
			response.sendRedirect("back/main.jsp");
		}
	}
	
	/**
	 * 退出管理员账号
	 */
	public void loginOut(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		//创建session对象
		HttpSession session = request.getSession();
		//将登录的账号移除
		session.removeAttribute("adminUser");
		//退出登录，跳转到登录页面
		response.sendRedirect("back/login.jsp");
	}

	//分页
	public void queryUserByPage(HttpServletRequest request,
								HttpServletResponse response) throws Exception{
		//1.获取页面中的当前页码值
		String currentPage = request.getParameter("currentPage");
		//2.执行分页查询
		PageTool<User> pageTool=userService.queryByPage(currentPage);
		//6.将分页对象传输到客户端页面
		request.setAttribute("pageTool", pageTool);
		//7.跳转到用户展示页面：转发
		request.getRequestDispatcher("back/user_list.jsp").forward(request, response);
	}

	/**
	 * 修改用户的权限
	 */

	public void updateManager(HttpServletRequest request,
							  HttpServletResponse response) throws Exception{
		//获取请求中的参数
		Integer uid = Integer.valueOf(request.getParameter("uid"));
		Integer manager = Integer.valueOf(request.getParameter("manager"));
		//调用service修改的方法
		int num=userService.updateManager(manager,uid);
		if (num>0) {
			//修改成功
			queryUserByPage(request,response);
		}

	}

	/**
	 * 批量删除
	 * @throws Exception
	 */
	public void batchDelete(HttpServletRequest request,
							HttpServletResponse response) throws Exception {
		//获取需要删除的id
		String[] values = request.getParameterValues("ids");
		//将数组转换成功字符串输出
		//System.out.println(Arrays.toString(values));
		//调用后台删除方法
		int num=userService.batchDelete(values);
		//删除成功跳转查询
		if (num>0) {
			queryUserByPage(request, response);
		}

	}



}
