package com.offcn.service;

import com.offcn.pojo.Commodity;
import com.offcn.utils.PageTool;

/**
 * ��Ʒ��ҵ���߼��ӿ�
 * @author admin
 *
 */
public interface CommodityService {

	//������Ʒ
	int insertCommodity(Commodity commodity);
	//��ҳ��ѯ
	PageTool<Commodity> queryCommodityByPage(String currentPage);
	//����id��ѯ��Ʒ
	Commodity queryCommodityById(Integer cid);
	//ȷ���޸�
	int updateCommodity(Commodity commodity);

}
