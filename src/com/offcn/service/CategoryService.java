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

}
