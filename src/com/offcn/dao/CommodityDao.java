package com.offcn.dao;

import java.util.List;

import com.offcn.pojo.Commodity;
import com.offcn.utils.PageTool;

/**
 * ��Ʒ�ĳ־û��ӿ�
 * @author admin
 *
 */
public interface CommodityDao {

	//������Ʒ
	int insertCommodity(Commodity commodity);
	//��ѯ������
	Integer queryCount();
	//��ҳ��ѯ��Ʒ
	List<Commodity> queryCommodityByPage(PageTool<Commodity> pageTool);
	//����id��ѯ
	Commodity queryCommodityById(Integer cid);
	//�����޸�
	int updateCommodity(Commodity commodity);
	//���ݷ���id��ѯ��Ʒ��Ϣ
	List<Commodity> queryCommodityByCid(Integer cid);
	//С�����ǵ�Ʒ
	List<Commodity> queryIndexCommodity();
	//��ѯ�ҵ�
	List<Commodity> queryIndexHomeCommodity();

}
