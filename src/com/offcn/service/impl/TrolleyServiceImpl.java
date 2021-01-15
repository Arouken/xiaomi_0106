package com.offcn.service.impl;

import com.offcn.dao.TrolleyDao;
import com.offcn.dao.impl.TrolleyDaoImpl;
import com.offcn.pojo.Trolley;
import com.offcn.service.TrolleyService;

public class TrolleyServiceImpl implements TrolleyService{
	//����dao
	private TrolleyDao trolleyDao=new TrolleyDaoImpl();

	/**
	 * ���빺�ﳵ
	 */
	@Override
	public int insertTrolley(Integer uid, Integer cid) {
		//1.�жϵ�ǰ��ӵ���Ʒ�Ƿ��Ѿ����ڹ��ﳵ���У�
		 Trolley trolley=  trolleyDao.queryTrolleyByUid(uid,cid);
		int row=0;
		 if(trolley==null) {
			//2.���û�д��ڣ�ֱ��ִ����ӣ�
			 row= trolleyDao.insertTrolley(uid,cid);
		 }else {
			//3.����Ѿ����ڣ�ִ���޸������Ĳ���
			Integer tid = trolley.getTid();
			 row=trolleyDao.updateNumber(tid);
		 }
		return row;
		
	}

}
