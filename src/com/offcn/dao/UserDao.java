package com.offcn.dao;

import java.util.List;

import com.offcn.pojo.User;
import com.offcn.utils.PageTool;

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

	//��ѯ�û�������
	Integer queryUserCount();

	//��ҳ��ѯ
	List<User> queryUserByPage(PageTool<User> pageTool);

	//�޸�Ȩ��
	int updateManager(Integer manager, Integer uid);

	//����idɾ��
	int deleteById(Integer uid);

}
