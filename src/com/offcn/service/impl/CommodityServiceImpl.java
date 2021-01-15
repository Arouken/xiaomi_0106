package com.offcn.service.impl;

import java.util.List;

import com.offcn.dao.CategoryDao;
import com.offcn.dao.CommodityDao;
import com.offcn.dao.impl.CategoryDaoImpl;
import com.offcn.dao.impl.CommodityDaoImpl;
import com.offcn.pojo.Category;
import com.offcn.pojo.Commodity;
import com.offcn.service.CommodityService;
import com.offcn.utils.PageTool;

public class CommodityServiceImpl implements CommodityService{
	
	//引入dao
   private CommodityDao commodityDao=new CommodityDaoImpl();
   //引入分类的dao
   private CategoryDao categoryDao=new CategoryDaoImpl();
   
	@Override
	public int insertCommodity(Commodity commodity) {
		return commodityDao.insertCommodity(commodity);
	}
	/**
	 * 分页查询
	 */
	@Override
	public PageTool<Commodity> queryCommodityByPage(String currentPage) {
		//查询商品总条数
		Integer totalCount=commodityDao.queryCount();
		//创建分页对象
		PageTool<Commodity> pageTool=new PageTool<Commodity>(currentPage, totalCount);
		//分页查询商品
		List<Commodity> list= commodityDao.queryCommodityByPage(pageTool);
		/**
		 * 每个商品实体类对象中都有分类对象的属性，只需要给每个分类对象赋值就可以了
		 * 1、遍历商品集合
		 * 2.通过商品信息获取到外键cate_id
		 * 3.根据cate_id查询分类信息
		 * 4.将分类属性设置商品对象中
		 */
		for (Commodity commodity : list) {
			Integer cid = commodity.getCate_id();
			Category category=categoryDao.queryById(cid);
			commodity.setCategory(category);
		}
		
		//集合设置到分页对象中
		pageTool.setList(list);
		return pageTool;
	}
	@Override
	public Commodity queryCommodityById(Integer cid) {
		return commodityDao.queryCommodityById(cid);
	}
	@Override
	public int updateCommodity(Commodity commodity) {
		return commodityDao.updateCommodity(commodity);
	}
	@Override
	public List<Commodity> queryIndexCommodity() {
		return commodityDao.queryIndexCommodity();
	}
	@Override
	public List<Commodity> queryIndexHomeCommodity() {
		return commodityDao.queryIndexHomeCommodity();
	}

}
