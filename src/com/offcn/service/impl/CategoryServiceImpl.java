package com.offcn.service.impl;

import java.util.List;

import com.offcn.dao.CategoryDao;
import com.offcn.dao.CommodityDao;
import com.offcn.dao.impl.CategoryDaoImpl;
import com.offcn.dao.impl.CommodityDaoImpl;
import com.offcn.pojo.Category;
import com.offcn.pojo.Commodity;
import com.offcn.service.CategoryService;
import com.offcn.utils.PageTool;

public class CategoryServiceImpl implements CategoryService{
	//引入dao
	private CategoryDao categoryDao=new CategoryDaoImpl();
	//引入商品dao
	private CommodityDao commodityDao=new CommodityDaoImpl();
	@Override
	public int insertCategory(Category category) {
		int num=categoryDao.insertCategory(category);
		return num;
	}
	/**
	 * 分页查询
	 */
	@Override
	public PageTool<Category> queryCategoryByPage(String currentPage) {
		//2.查询分类的总条数
		Integer totalCount=categoryDao.queryCount();
		//1.创建分页对象
		PageTool<Category> pageTool=new PageTool<Category>(currentPage, totalCount);
		//3.分页查询
	   List<Category> categoryList=	categoryDao.queryByPage(pageTool);
	   //4.将集合设置到分页对象中
	   pageTool.setList(categoryList);
		return pageTool;
	}
	
	@Override
	public List<Category> queryAllCategory() {
		List<Category> categoryList=categoryDao.queryAllCategory();
		return categoryList;
	}
	/**
	 * 批量删除
	 */
	@Override
	public String batchDelete(String[] values) {
		//定义一个返回的字符串
		String names="";
		//遍历数组
		for (String string : values) {
			//获取cid的值
			Integer cid = Integer.valueOf(string);
			//根据cid查询商品信息
			List<Commodity> list=commodityDao.queryCommodityByCid(cid);
			//判断分类下面有没有商品
			if (list.size()==0) {
				//分类下面没有商品可以删除
				int row=categoryDao.deleteById(cid);
			}else {
				//分类下面有商品，不能删除。将分类名称返回给页面
				Category category = categoryDao.queryById(cid);
				//获取分类名称
				String cname = category.getCname();
				//将名称拼接:手机电脑箱包
				names+=cname+"  ";
			}
		}
		return names;
	}
	/**
	 * 修改之前的查询
	 */
	@Override
	public Category queryCategoryById(Integer cid) {
		//定义返回值变量
		Category category=null;
		// 根据cid查询分类下面的商品
		List<Commodity> list = commodityDao.queryCommodityByCid(cid);
		//判断分类下面是否有商品
		if (list.size()==0) {
			//分类下没有商品，可以修改
			 category = categoryDao.queryById(cid);
		}
	    //分类下有商品不能修改
		return category;
	}
	//保存修改
	@Override
	public int updateCategory(Category category) {
		int row=categoryDao.updateCategory(category);
		return row;
	}
	@Override
	public List<Category> queryIndexCategory() {
		List<Category> categoryLiset=categoryDao.queryIndexCategory();
		return categoryLiset;
	}

}
