package com.offcn.service.impl;

import com.offcn.dao.CommodityDao;
import com.offcn.dao.impl.CommodityDaoImpl;
import com.offcn.pojo.Commodity;
import com.offcn.service.CommodityService;

public class CommodityServiceImpl implements CommodityService{
	
	//ÒýÈëdao
   private CommodityDao commodityDao=new CommodityDaoImpl();
	@Override
	public int insertCommodity(Commodity commodity) {
		int num=commodityDao.insertCommodity(commodity);
		return num;
	}

}
