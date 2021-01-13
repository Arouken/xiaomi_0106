package com.offcn.service.impl;

import java.util.List;

import com.offcn.dao.CategoryDao;
import com.offcn.dao.impl.CategoryDaoImpl;
import com.offcn.pojo.Category;
import com.offcn.service.CategoryService;
import com.offcn.utils.PageTool;

public class CategoryServiceImpl implements CategoryService{
	//引入dao
	private CategoryDao categoryDao=new CategoryDaoImpl();
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

}
