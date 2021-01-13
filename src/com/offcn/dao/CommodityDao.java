package com.offcn.dao;

import com.offcn.pojo.Commodity;
import com.offcn.utils.PageTool;

import java.util.List;

/**
 * ��Ʒ�ĳ־û��ӿ�
 * @author admin
 *
 */
public interface CommodityDao {

	//������Ʒ
	int insertCommodity(Commodity commodity);

    Integer queryCount();

	List<Commodity> queryCommodityByPage(PageTool<Commodity> pageTool);

	//����id��ѯ
	Commodity queryCommodityById(Integer cid);
	//�����޸�
	int updateCommodity(Commodity commodity);
	//���ݷ���id��ѯ��Ʒ��Ϣ
	List<Commodity> queryCommodityByCid(Integer cid);


}
