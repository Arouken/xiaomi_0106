package com.offcn.service;

import javax.servlet.http.HttpSession;

import com.offcn.pojo.User;
import com.offcn.utils.PageTool;

/**
 * �û�ҵ���߼��ӿ��ļ�
 * @author admin
 *
 */
public interface UserService {

	//�����ֻ������ѯ
	User queryByPhone(String phone);

	//�����˺Ų�ѯ
	User queryByUsername(String username);

	//�����û�
	int insertUser(User user);

	//������֤��
	void sendCode(String phone,HttpSession session);

	//��֤��¼
	int checkCode(String phone, String code, HttpSession session);

	//��֤ͼ����֤��
	int checkImgCode(String code, HttpSession session);

	//�����˺������ѯ
	User queryByNameAndPwd(String username, String userpwd);

	//����Ա��¼
	User adminLogin(String username, String userpwd);


    PageTool<User> queryByPage(String currentPage);

	//�޸�Ȩ��
	int updateManager(Integer manager, Integer uid);

	int batchDelete(String[] values);
}
