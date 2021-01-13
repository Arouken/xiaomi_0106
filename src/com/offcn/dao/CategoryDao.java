package com.offcn.dao;

import java.util.List;

import com.offcn.pojo.Category;
import com.offcn.utils.PageTool;

/**
 * 类别的持久化接口
 * @author admin
 *
 */
public interface CategoryDao {

	//增加类别
	int insertCategory(Category category);
	//查询总条数
	Integer queryCount();
	//分页查询
	List<Category> queryByPage(PageTool<Category> pageTool);
	//查询所有分类
	List<Category> queryAllCategory();
	//根据id查询
	Category queryById(Integer cid);
	//根据id删除
	int deleteById(Integer cid);
	//保存修改
	int updateCategory(Category category);

}
