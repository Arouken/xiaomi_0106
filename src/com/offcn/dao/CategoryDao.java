package com.offcn.dao;

import java.util.List;

import com.offcn.pojo.Category;
import com.offcn.utils.PageTool;

/**
 * ���ĳ־û��ӿ�
 * @author admin
 *
 */
public interface CategoryDao {

	//�������
	int insertCategory(Category category);
	//��ѯ������
	Integer queryCount();
	//��ҳ��ѯ
	List<Category> queryByPage(PageTool<Category> pageTool);
	//��ѯ���з���
	List<Category> queryAllCategory();

}
