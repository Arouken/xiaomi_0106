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
	//����dao
	private UserDao userDao=new UserDaoImpl();

	@Override
	public User queryByPhone(String phone) {
		//����dao�в�ѯ����
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
	 * ʹ�ù����෢����֤�뵽�ֻ���
	 * ���ֻ��ź���֤�뱣�浽session��
	 */
	@Override
	public void sendCode(String phone,HttpSession session) {
		//���ù����෢����֤�뵽�ֻ���
		int code = SendSms.sendCode(phone);
		//Ϊ�˱����˷���Ѷ��ţ����Ե�ʱ�����ʹ�ù̶�ֵ
		//int code = 123456;
		if(code>0) {
			//�����ַ���
			String oldCode=phone+"#"+code;
			//����֤�뱣��session:�ֻ�+��֤��
			session.setAttribute("oldCode", oldCode);
		}
		
	}

	/**
	 * ��֤��¼
	 */
	@Override
	public int checkCode(String phone, String code, HttpSession session) {
		//��ȡsession����֤��
		String oldCode = (String) session.getAttribute("oldCode");
		//�����µ��ֻ���֤��
		String newCode=phone+"#"+code;
		//�Ƚ�������֤���ֵ
		if (oldCode.equals(newCode)) {
			//��¼�ɹ�
			return 1;
		}
		return 0;
	}

	/**
	 * У��ͼ����֤��
	 */
	@Override
	public int checkImgCode(String code, HttpSession session) {
		// ��ȡϵͳ���ɵ���֤��
		String verifyCode=(String) session.getAttribute("verifyCode");
		//�Ƚ�ϵͳ���ɵ���֤��ͱ��������֤���Ƿ�һ��(���Դ�С����)
		if (verifyCode.equalsIgnoreCase(code)) {
			//��֤����ȷ
			return 1;
		}
		//��֤�����
		return 0;
	}

	/**
	 * �����˺������ѯ
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
	 * ʹ�÷�ҳ�������ѯ�û���Ϣ
	 */
	@Override
	public PageTool<User> queryByPage(String currentPage) {
		//2.��ѯ������
		Integer totalCount = userDao.queryUserCount();
		//1.������ҳ����
		PageTool<User> pageTool=new PageTool<User>(currentPage, totalCount);
		//3.��ҳ��ѯ
		List<User> list = userDao.queryUserByPage(pageTool);

		//4.���û��������õ���ҳ������
		pageTool.setList(list);
		return pageTool;
	}


	//�޸�Ȩ��
	@Override
	public int updateManager(Integer manager, Integer uid) {
		int num=userDao.updateManager(manager,uid);
		return num;
	}

	/**
	 * ����ɾ��
	 */
	@Override
	public int batchDelete(String[] ids) {
		//����һ������ֵ
		int sum=0;
		//����ids����
		for (String id : ids) {
			//�ַ���ת��������
			Integer uid = Integer.valueOf(id);
			//ִ��ɾ��
			int row=userDao.deleteById(uid);
			//�ۼӲ���
			sum+=row;
		}
		return sum;
	}
}
