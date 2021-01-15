package com.offcn.dao.impl;

import java.util.List;

import com.offcn.dao.BaseDao;
import com.offcn.dao.UserDao;
import com.offcn.pojo.User;
import com.offcn.utils.PageTool;

public class UserDaoImpl extends BaseDao<User> implements UserDao{

	/**
	 * �����ֻ������ѯ�û�
	 */
	@Override
	public User findByPhone(String phone) {
		String sql="SELECT * FROM users WHERE phone=?";
	    User user=getBean(sql, phone);
		return user;
	}

	/**
	 * �����˺Ų�ѯ
	 */
	@Override
	public User findByUsername(String username) {
		String sql="SELECT * FROM users WHERE username=?";
		User user = getBean(sql, username);
		return user;
	}

	/**
	 * �����û�
	 */
	@Override
	public int insertUser(User user) {
		String sql="INSERT INTO `users` (\r\n" + 
						"  `uname`,\r\n" + 
						"  `gender`,\r\n" + 
						"  `phone`,\r\n" + 
						"  `address`,\r\n" + 
						"  `username`,\r\n" + 
						"  `userpwd`,\r\n" + 
						"  `photo`,\r\n" + 
						"  `create_date`\r\n" + 
						") VALUES(?,?,?,?,?,?,?,?)";
		int row=update(sql, user.getUname(),user.getGender(),user.getPhone(),
				user.getAddress(),user.getUsername(),user.getUserpwd(),user.getPhoto(),
				user.getCreate_date());
		return row;
	}

	/**
	 * �����˺������ѯ
	 */
	@Override
	public User findUserByNameAndPwd(String username, String userpwd) {
		String sql="SELECT * FROM users \r\n" + 
					"WHERE username=? \r\n" + 
					"AND userpwd=?\r\n" + 
					"AND manager=0";
		User user=getBean(sql, username,userpwd);
		return user;
	}

	/**
	 * �����˺�������й���Ա��¼
	 */
	@Override
	public User adminLogin(String username, String userpwd) {
		String sql="SELECT * FROM users \r\n" + 
					"WHERE username=? \r\n" + 
					"AND userpwd=?\r\n" + 
					"AND manager=1";
		User user=getBean(sql, username,userpwd);
		return user;
	}

	/**
	 * ��ѯ������
	 */
	@Override
	public Integer queryUserCount() {
		String sql="SELECT COUNT(*) FROM users";
		Object singelValue = getSingelValue(sql);
		//ת��������
		String string = singelValue.toString();
		Integer value = Integer.valueOf(string);
		return value;
	}
	/**
	 * ��ҳ��ѯ
	 */

	@Override
	public List<User> queryUserByPage(PageTool<User> pageTool) {
		String sql="SELECT * FROM users LIMIT ?,?";
		List<User> list = getBeanList(sql,
				pageTool.getStartIndex(),pageTool.getPageSize());
		return list;
	}

	/**
	 * �޸��˺ŵ�Ȩ��
	 */
	@Override
	public int updateManager(Integer manager, Integer uid) {
		String sql="UPDATE users SET manager =? WHERE uid=?";
		int num=update(sql, manager,uid);
		return num;
	}

	/**
	 * ����idɾ��
	 */
	@Override
	public int deleteById(Integer uid) {
		String sql="DELETE FROM users WHERE uid=?";
		int num = update(sql, uid);
		return num;
	}

}
