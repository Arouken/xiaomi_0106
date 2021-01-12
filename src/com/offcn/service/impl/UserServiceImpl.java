package com.offcn.service.impl;

import javax.servlet.http.HttpSession;

import com.offcn.dao.UserDao;
import com.offcn.dao.impl.UserDaoImpl;
import com.offcn.pojo.User;
import com.offcn.service.UserService;
import com.offcn.utils.PageTool;
import com.offcn.utils.SendSms;

import java.util.List;

public class UserServiceImpl implements UserService{
	//引入dao
	private UserDao userDao=new UserDaoImpl();

	@Override
	public User queryByPhone(String phone) {
		//调用dao中查询方法
		User user=userDao.findByPhone(phone);
		return user;
	}

	@Override
	public User queryByUsername(String username) {
		User user=userDao.findByUsername(username);
		return user;
	}

	@Override
	public int insertUser(User user) {
		int row=userDao.insertUser(user);
		return row;
	}

	/**
	 * 使用工具类发送验证码到手机上
	 * 将手机号和验证码保存到session中
	 */
	@Override
	public void sendCode(String phone,HttpSession session) {
		//调用工具类发送验证码到手机上
		int code = SendSms.sendCode(phone);
		//为了避免浪费免费短信，测试的时候可以使用固定值
		//int code = 123456;
		if(code>0) {
			//定义字符串
			String oldCode=phone+"#"+code;
			//将验证码保存session:手机+验证码
			session.setAttribute("oldCode", oldCode);
		}
		
	}

	/**
	 * 验证登录
	 */
	@Override
	public int checkCode(String phone, String code, HttpSession session) {
		//获取session的验证码
		String oldCode = (String) session.getAttribute("oldCode");
		//定义新的手机验证码
		String newCode=phone+"#"+code;
		//比较两个验证码的值
		if (oldCode.equals(newCode)) {
			//登录成功
			return 1;
		}
		return 0;
	}

	/**
	 * 校验图形验证码
	 */
	@Override
	public int checkImgCode(String code, HttpSession session) {
		// 获取系统生成的验证码
		String verifyCode=(String) session.getAttribute("verifyCode");
		//比较系统生成的验证码和表单输入的验证码是否一致(忽略大小区别)
		if (verifyCode.equalsIgnoreCase(code)) {
			//验证码正确
			return 1;
		}
		//验证码错误
		return 0;
	}

	/**
	 * 根据账号密码查询
	 */
	@Override
	public User queryByNameAndPwd(String username, String userpwd) {
		 User user= userDao.findUserByNameAndPwd(username,userpwd);
		return user;
	}

	@Override
	public User adminLogin(String username, String userpwd) {
		User user=userDao.adminLogin(username,userpwd);
		return user;
	}



	/**
	 * 使用分页工具类查询用户信息
	 */
	@Override
	public PageTool<User> queryByPage(String currentPage) {
		//2.查询总条数
		Integer totalCount = userDao.queryUserCount();
		//1.创建分页对象
		PageTool<User> pageTool=new PageTool<User>(currentPage, totalCount);
		//3.分页查询
		List<User> list = userDao.queryUserByPage(pageTool);

		//4.将用户集合设置到分页对象中
		pageTool.setList(list);
		return pageTool;
	}


	//修改权限
	@Override
	public int updateManager(Integer manager, Integer uid) {
		int num=userDao.updateManager(manager,uid);
		return num;
	}

	/**
	 * 批量删除
	 */
	@Override
	public int batchDelete(String[] ids) {
		//定义一个返回值
		int sum=0;
		//遍历ids参数
		for (String id : ids) {
			//字符串转换成整形
			Integer uid = Integer.valueOf(id);
			//执行删除
			int row=userDao.deleteById(uid);
			//累加操作
			sum+=row;
		}
		return sum;
	}
}
