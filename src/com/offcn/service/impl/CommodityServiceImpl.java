package com.offcn.service.impl;

import java.util.List;

import com.offcn.dao.CategoryDao;
import com.offcn.dao.CommodityDao;
import com.offcn.dao.impl.CategoryDaoImpl;
import com.offcn.dao.impl.CommodityDaoImpl;
import com.offcn.pojo.Category;
import com.offcn.pojo.Commodity;
import com.offcn.service.CommodityService;
import com.offcn.utils.PageTool;

public class CommodityServiceImpl implements CommodityService{
	
	//����dao
   private CommodityDao commodityDao=new CommodityDaoImpl();
   //��������dao
   private CategoryDao categoryDao=new CategoryDaoImpl();
   
	@Override
	public int insertCommodity(Commodity commodity) {
		return commodityDao.insertCommodity(commodity);
	}
	/**
	 * ��ҳ��ѯ
	 */
	@Override
	public PageTool<Commodity> queryCommodityByPage(String currentPage) {
		//��ѯ��Ʒ������
		Integer totalCount=commodityDao.queryCount();
		//������ҳ����
		PageTool<Commodity> pageTool=new PageTool<Commodity>(currentPage, totalCount);
		//��ҳ��ѯ��Ʒ
		List<Commodity> list= commodityDao.queryCommodityByPage(pageTool);
		/**
		 * ÿ����Ʒʵ��������ж��з����������ԣ�ֻ��Ҫ��ÿ���������ֵ�Ϳ�����
		 * 1��������Ʒ����
		 * 2.ͨ����Ʒ��Ϣ��ȡ�����cate_id
		 * 3.����cate_id��ѯ������Ϣ
		 * 4.����������������Ʒ������
		 */
		for (Commodity commodity : list) {
			Integer cid = commodity.getCate_id();
			Category category=categoryDao.queryById(cid);
			commodity.setCategory(category);
		}
		
		//�������õ���ҳ������
		pageTool.setList(list);
		return pageTool;
	}
	@Override
	public Commodity queryCommodityById(Integer cid) {
		return commodityDao.queryCommodityById(cid);
	}
	@Override
	public int updateCommodity(Commodity commodity) {
		return commodityDao.updateCommodity(commodity);
	}
	@Override
	public List<Commodity> queryIndexCommodity() {
		return commodityDao.queryIndexCommodity();
	}
	@Override
	public List<Commodity> queryIndexHomeCommodity() {
		return commodityDao.queryIndexHomeCommodity();
	}

}
