package com.offcn.dao;

import java.util.List;

import com.offcn.pojo.User;
import com.offcn.utils.PageTool;

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

	//查询用户总条数
	Integer queryUserCount();

	//分页查询
	List<User> queryUserByPage(PageTool<User> pageTool);

	//修改权限
	int updateManager(Integer manager, Integer uid);

	//根据id删除
	int deleteById(Integer uid);

}
