package com.offcn.service;

import java.util.List;

import com.offcn.pojo.Category;
import com.offcn.utils.PageTool;

/**
 * ����ҵ���߼���ӿ�
 * @author admin
 *
 */
public interface CategoryService {
	//���ӷ���
	int insertCategory(Category category);

	//��ҳ��ѯ
	PageTool<Category> queryCategoryByPage(String currentPage);
	//��ѯ���з�����Ϣ
	List<Category> queryAllCategory();

}
