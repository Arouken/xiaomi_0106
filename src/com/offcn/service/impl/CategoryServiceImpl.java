package com.offcn.service.impl;

import java.util.List;

import com.offcn.dao.CategoryDao;
import com.offcn.dao.impl.CategoryDaoImpl;
import com.offcn.pojo.Category;
import com.offcn.service.CategoryService;
import com.offcn.utils.PageTool;

public class CategoryServiceImpl implements CategoryService{
	//����dao
	private CategoryDao categoryDao=new CategoryDaoImpl();
	@Override
	public int insertCategory(Category category) {
		int num=categoryDao.insertCategory(category);
		return num;
	}
	/**
	 * ��ҳ��ѯ
	 */
	@Override
	public PageTool<Category> queryCategoryByPage(String currentPage) {
		//2.��ѯ�����������
		Integer totalCount=categoryDao.queryCount();
		//1.������ҳ����
		PageTool<Category> pageTool=new PageTool<Category>(currentPage, totalCount);
		//3.��ҳ��ѯ
	   List<Category> categoryList=	categoryDao.queryByPage(pageTool);
	   //4.���������õ���ҳ������
	   pageTool.setList(categoryList);
		return pageTool;
	}
	
	@Override
	public List<Category> queryAllCategory() {
		List<Category> categoryList=categoryDao.queryAllCategory();
		return categoryList;
	}

}
