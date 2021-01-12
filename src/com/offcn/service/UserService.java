package com.offcn.service;

import javax.servlet.http.HttpSession;

import com.offcn.pojo.User;
import com.offcn.utils.PageTool;

/**
 * 用户业务逻辑接口文件
 * @author admin
 *
 */
public interface UserService {

	//根据手机号码查询
	User queryByPhone(String phone);

	//根据账号查询
	User queryByUsername(String username);

	//增加用户
	int insertUser(User user);

	//发送验证码
	void sendCode(String phone,HttpSession session);

	//验证登录
	int checkCode(String phone, String code, HttpSession session);

	//验证图形验证码
	int checkImgCode(String code, HttpSession session);

	//根据账号密码查询
	User queryByNameAndPwd(String username, String userpwd);

	//管理员登录
	User adminLogin(String username, String userpwd);


    PageTool<User> queryByPage(String currentPage);

	//修改权限
	int updateManager(Integer manager, Integer uid);

	int batchDelete(String[] values);
}
