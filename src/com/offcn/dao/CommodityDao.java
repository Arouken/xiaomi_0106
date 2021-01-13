package com.offcn.dao;

import com.offcn.pojo.Commodity;
import com.offcn.utils.PageTool;

import java.util.List;

/**
 * 商品的持久化接口
 * @author admin
 *
 */
public interface CommodityDao {

	//增加商品
	int insertCommodity(Commodity commodity);

    Integer queryCount();

	List<Commodity> queryCommodityByPage(PageTool<Commodity> pageTool);

	//根据id查询
	Commodity queryCommodityById(Integer cid);
	//保存修改
	int updateCommodity(Commodity commodity);
	//根据分类id查询商品信息
	List<Commodity> queryCommodityByCid(Integer cid);


}
