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
	//����dao
	private CategoryDao categoryDao=new CategoryDaoImpl();
	//������Ʒdao
	private CommodityDao commodityDao=new CommodityDaoImpl();
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
	/**
	 * ����ɾ��
	 */
	@Override
	public String batchDelete(String[] values) {
		//����һ�����ص��ַ���
		String names="";
		//��������
		for (String string : values) {
			//��ȡcid��ֵ
			Integer cid = Integer.valueOf(string);
			//����cid��ѯ��Ʒ��Ϣ
			List<Commodity> list=commodityDao.queryCommodityByCid(cid);
			//�жϷ���������û����Ʒ
			if (list.size()==0) {
				//��������û����Ʒ����ɾ��
				int row=categoryDao.deleteById(cid);
			}else {
				//������������Ʒ������ɾ�������������Ʒ��ظ�ҳ��
				Category category = categoryDao.queryById(cid);
				//��ȡ��������
				String cname = category.getCname();
				//������ƴ��:�ֻ��������
				names+=cname+"  ";
			}
		}
		return names;
	}
	/**
	 * �޸�֮ǰ�Ĳ�ѯ
	 */
	@Override
	public Category queryCategoryById(Integer cid) {
		//���巵��ֵ����
		Category category=null;
		// ����cid��ѯ�����������Ʒ
		List<Commodity> list = commodityDao.queryCommodityByCid(cid);
		//�жϷ��������Ƿ�����Ʒ
		if (list.size()==0) {
			//������û����Ʒ�������޸�
			 category = categoryDao.queryById(cid);
		}
	    //����������Ʒ�����޸�
		return category;
	}
	//�����޸�
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
