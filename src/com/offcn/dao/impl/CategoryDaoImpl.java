package com.offcn.dao.impl;

import java.util.List;

import com.offcn.dao.BaseDao;
import com.offcn.dao.CategoryDao;
import com.offcn.pojo.Category;
import com.offcn.utils.PageTool;

public class CategoryDaoImpl extends BaseDao<Category> implements CategoryDao{

	/**
	 * 增加分类
	 */
	@Override
	public int insertCategory(Category category) {
		String sql="INSERT INTO `category` (\r\n" + 
				"  `cname`,\r\n" + 
				"  `state`,\r\n" + 
				"  `order_num`,\r\n" + 
				"  `description`,\r\n" + 
				"  `create_date`\r\n" + 
				") VALUES(?,?,?,?,?)";
		int row = update(sql, category.getCname(),category.getState(),category.getOrder_num(),
				category.getDescription(),category.getCreate_date());
		return row;
	}
	
	/**
	 * 查询总条数
	 */
	@Override
	public Integer queryCount() {
		String sql="SELECT COUNT(*) FROM category";
		Object singelValue = getSingelValue(sql);
		Integer num = Integer.valueOf(singelValue.toString());
		return num;
	}

	/**
	 * 分页查询
	 */
	@Override
	public List<Category> queryByPage(PageTool<Category> pageTool) {
		String sql="SELECT * FROM category LIMIT ?,?";
		List<Category> categoryList = getBeanList(sql, pageTool.getStartIndex(),pageTool.getPageSize());
		return categoryList;
	}

	/**
	 * 查询所有分类
	 */
	@Override
	public List<Category> queryAllCategory() {
		String sql="SELECT * FROM category WHERE state=1";
		List<Category> list = getBeanList(sql);
		return list;
	}

}
