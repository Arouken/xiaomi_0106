package com.offcn.service;
/**
 * 购物车业务逻辑接口
 * @author admin
 *
 */
public interface TrolleyService {

	//加入购物车
	int insertTrolley(Integer uid, Integer cid);

}
