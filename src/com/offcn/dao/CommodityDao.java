package com.offcn.dao;

import com.offcn.pojo.Commodity;

/**
 * 商品的持久化接口
 * @author admin
 *
 */
public interface CommodityDao {

	//增加商品
	int insertCommodity(Commodity commodity);

}
