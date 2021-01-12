package com.offcn.dao;

import com.offcn.pojo.User;
import com.offcn.utils.PageTool;

import java.util.List;

/**
 * 用户持久化接口文件
 * @author admin
 *
 */
public interface UserDao {

	//根据手机号查询
	User findByPhone(String phone);

	//根据账号查询
	User findByUsername(String username);

	//增加用户
	int insertUser(User user);

	//根据账号密码查询
	User findUserByNameAndPwd(String username, String userpwd);

	//管理员登录
	User adminLogin(String username, String userpwd);

    Integer queryUserCount();

	List<User> queryUserByPage(PageTool<User> pageTool);

	int updateManager(Integer manager, Integer uid);

	int deleteById(Integer uid);
}
