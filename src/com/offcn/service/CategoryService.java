package com.offcn.service;

import java.util.List;

import com.offcn.pojo.Category;
import com.offcn.utils.PageTool;

/**
 * 类别的业务逻辑层接口
 * @author admin
 *
 */
public interface CategoryService {
	//增加分类
	int insertCategory(Category category);

	//分页查询
	PageTool<Category> queryCategoryByPage(String currentPage);
	//查询所有分类信息
	List<Category> queryAllCategory();

	//批量删除
	String batchDelete(String[] values);

	//修改之前的查询
	Category queryCategoryById(Integer cid);
	//保存修改
	int updateCategory(Category category);

}
