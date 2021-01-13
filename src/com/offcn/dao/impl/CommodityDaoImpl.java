package com.offcn.dao.impl;

import com.offcn.dao.BaseDao;
import com.offcn.dao.CommodityDao;
import com.offcn.pojo.Commodity;

public class CommodityDaoImpl extends BaseDao<Commodity> implements CommodityDao{

	/**
	 * 增加商品
	 */
	@Override
	public int insertCommodity(Commodity commodity) {
		String sql="INSERT INTO`commodity` (\r\n" + 
				"  `cate_id`,`cname`,`color`,\r\n" + 
				"  `size`,`price`,`short_desc`,\r\n" + 
				"  `full_desc`,`photo`,\r\n" + 
				"  `ctype`,`model`, `create_date`\r\n" + 
				") VALUES(?,?,?,?,?,?,?,?,?,?,?)";
		int num=update(sql, commodity.getCate_id(),commodity.getCname(),commodity.getColor(),
				commodity.getSize(),commodity.getPrice(),commodity.getShort_desc(),
				commodity.getFull_desc(),commodity.getPhoto(),commodity.getCtype(),
				commodity.getModel(),commodity.getCreate_date());
		return num;
	}

}
