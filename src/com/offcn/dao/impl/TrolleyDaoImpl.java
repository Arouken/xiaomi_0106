package com.offcn.dao.impl;

import com.offcn.dao.BaseDao;
import com.offcn.dao.TrolleyDao;
import com.offcn.pojo.Trolley;

public class TrolleyDaoImpl extends BaseDao<Trolley> implements TrolleyDao{

	/**
	 * ����uid��cid��ѯ
	 */
	@Override
	public Trolley queryTrolleyByUid(Integer uid, Integer cid) {
		String sql="SELECT * FROM trolley \r\n" + 
				"WHERE user_id= ? \r\n" + 
				"AND comm_id= ?\r\n" + 
				"AND order_number IS NULL";
		 
		return getBean(sql, uid,cid);
	}

	/**
	 * ���ӹ��ﳵ��¼
	 */
	@Override
	public int insertTrolley(Integer uid, Integer cid) {
		String sql="INSERT INTO `trolley` (\r\n" + 
				"  `user_id`,\r\n" + 
				"  `comm_id`,\r\n" + 
				"  `number`\r\n" + 
				") VALUES(\r\n" + 
				"    ?,\r\n" + 
				"    ?,\r\n" + 
				"    1\r\n" + 
				"  )";
		return update(sql, uid,cid);
		
	}

	/**
	 * �޸���Ʒ����
	 */
	@Override
	public int updateNumber(Integer tid) {
		String sql="UPDATE trolley SET number=number+1 WHERE tid=?";
		return update(sql, tid);
	}

}
