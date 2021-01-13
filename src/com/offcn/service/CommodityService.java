package com.offcn.service;

import com.offcn.pojo.Commodity;
import com.offcn.utils.PageTool;

/**
 * 商品的业务逻辑接口
 * @author admin
 *
 */
public interface CommodityService {

	//增加商品
	int insertCommodity(Commodity commodity);
	//分页查询
	PageTool<Commodity> queryCommodityByPage(String currentPage);
	//根据id查询商品
	Commodity queryCommodityById(Integer cid);
	//确定修改
	int updateCommodity(Commodity commodity);

}
