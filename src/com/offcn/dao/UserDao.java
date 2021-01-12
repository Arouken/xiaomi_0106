package com.offcn.dao;

import com.offcn.pojo.User;
import com.offcn.utils.PageTool;

import java.util.List;

/**
 * �û��־û��ӿ��ļ�
 * @author admin
 *
 */
public interface UserDao {

	//�����ֻ��Ų�ѯ
	User findByPhone(String phone);

	//�����˺Ų�ѯ
	User findByUsername(String username);

	//�����û�
	int insertUser(User user);

	//�����˺������ѯ
	User findUserByNameAndPwd(String username, String userpwd);

	//����Ա��¼
	User adminLogin(String username, String userpwd);

    Integer queryUserCount();

	List<User> queryUserByPage(PageTool<User> pageTool);

	int updateManager(Integer manager, Integer uid);

	int deleteById(Integer uid);
}
