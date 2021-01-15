package com.offcn.service.impl;

import com.offcn.dao.TrolleyDao;
import com.offcn.dao.impl.TrolleyDaoImpl;
import com.offcn.pojo.Trolley;
import com.offcn.service.TrolleyService;

public class TrolleyServiceImpl implements TrolleyService{
	//引入dao
	private TrolleyDao trolleyDao=new TrolleyDaoImpl();

	/**
	 * 加入购物车
	 */
	@Override
	public int insertTrolley(Integer uid, Integer cid) {
		//1.判断当前添加的商品是否已经存在购物车表中：
		 Trolley trolley=  trolleyDao.queryTrolleyByUid(uid,cid);
		int row=0;
		 if(trolley==null) {
			//2.如果没有存在，直接执行添加；
			 row= trolleyDao.insertTrolley(uid,cid);
		 }else {
			//3.如果已经存在，执行修改数量的操作
			Integer tid = trolley.getTid();
			 row=trolleyDao.updateNumber(tid);
		 }
		return row;
		
	}

}
