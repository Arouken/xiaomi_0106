package com.offcn.dao;

import com.offcn.pojo.Trolley;

/**
 * 购物车持久化接口
 * @author admin
 *
 */
public interface TrolleyDao {

	//查询当前商品是否已经存在购物车表中
	Trolley queryTrolleyByUid(Integer uid, Integer cid);
	//增加购物车记录
	int insertTrolley(Integer uid, Integer cid);
	//修改商品的数量
	int updateNumber(Integer tid);

}
