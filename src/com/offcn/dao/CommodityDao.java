package com.offcn.dao;

import java.util.List;

import com.offcn.pojo.Commodity;
import com.offcn.utils.PageTool;

/**
 * 商品的持久化接口
 * @author admin
 *
 */
public interface CommodityDao {

	//增加商品
	int insertCommodity(Commodity commodity);
	//查询总条数
	Integer queryCount();
	//分页查询商品
	List<Commodity> queryCommodityByPage(PageTool<Commodity> pageTool);
	//根据id查询
	Commodity queryCommodityById(Integer cid);
	//保存修改
	int updateCommodity(Commodity commodity);
	//根据分类id查询商品信息
	List<Commodity> queryCommodityByCid(Integer cid);
	//小米明星单品
	List<Commodity> queryIndexCommodity();
	//查询家电
	List<Commodity> queryIndexHomeCommodity();

}
