package com.offcn.dao.impl;

import java.util.List;

import com.offcn.dao.BaseDao;
import com.offcn.dao.CommodityDao;
import com.offcn.pojo.Commodity;
import com.offcn.utils.PageTool;

public class CommodityDaoImpl extends BaseDao<Commodity> implements CommodityDao{

	/**
	 * ������Ʒ
	 */
	@Override
	public int insertCommodity(Commodity commodity) {
		String sql="INSERT INTO`commodity` (\r\n" + 
				"  `cate_id`,`cname`,`color`,\r\n" + 
				"  `size`,`price`,`short_desc`,\r\n" + 
				"  `full_desc`,`photo`,\r\n" + 
				"  `ctype`,`model`, `create_date`\r\n" + 
				") VALUES(?,?,?,?,?,?,?,?,?,?,?)";
		return update(sql, commodity.getCate_id(),commodity.getCname(),commodity.getColor(),
				commodity.getSize(),commodity.getPrice(),commodity.getShort_desc(),
				commodity.getFull_desc(),commodity.getPhoto(),commodity.getCtype(),
				commodity.getModel(),commodity.getCreate_date());
	}

	/**
	 * ��ѯ������
	 */
	@Override
	public Integer queryCount() {
		String sql="SELECT COUNT(*) FROM commodity";
		Object singelValue = getSingelValue(sql);
		return Integer.valueOf(singelValue.toString());
	}

	/**
	 * ��ҳ��ѯ
	 */
	@Override
	public List<Commodity> queryCommodityByPage(PageTool<Commodity> pageTool) {
		String sql="SELECT *FROM commodity  LIMIT ?,?";
		return getBeanList(sql, pageTool.getStartIndex(),pageTool.getPageSize());
	}

	/**
	 * ����id��ѯ
	 */
	@Override
	public Commodity queryCommodityById(Integer cid) {
		String sql="SELECT * FROM commodity WHERE cid=?";
		return getBean(sql, cid);
	}

	/**
	 * �����޸�
	 */
	@Override
	public int updateCommodity(Commodity commodity) {
		String sql="UPDATE `commodity` SET\r\n" + 
				"  `cate_id` = ?,\r\n" + 
				"  `cname` = ?,\r\n" + 
				"  `color` = ?,\r\n" + 
				"  `size` = ?,\r\n" + 
				"  `price` = ?,\r\n" + 
				"  `short_desc` = ?,\r\n" + 
				"  `full_desc` = ?,\r\n" + 
				"  `photo` = ?,\r\n" + 
				"  `ctype` = ?,\r\n" + 
				"  `model` = ?,\r\n" + 
				"  `create_date` = ? \r\n" + 
				"WHERE `cid` = ? ";
		return update(sql, commodity.getCate_id(),commodity.getCname(),commodity.getColor(),
				commodity.getSize(),commodity.getPrice(),commodity.getShort_desc(),
				commodity.getFull_desc(),commodity.getPhoto(),commodity.getCtype(),
				commodity.getModel(),commodity.getCreate_date(),commodity.getCid());
	}

	/**
	 * �������id��ѯ
	 */
	@Override
	public List<Commodity> queryCommodityByCid(Integer cid) {
		String sql="SELECT * FROM commodity WHERE cate_id=?";
		return getBeanList(sql, cid);
	}

	/**
	 * С�����ǵ�Ʒ��ѯ
	 */
	@Override
	public List<Commodity> queryIndexCommodity() {
		String sql="SELECT * FROM commodity WHERE ctype=4 ORDER BY cid DESC LIMIT 5";
		return getBeanList(sql);
	}

	@Override
	public List<Commodity> queryIndexHomeCommodity() {
		String sql="SELECT * FROM commodity WHERE cate_id=3 ORDER BY cid DESC LIMIT 8";
		return getBeanList(sql);
	}

}
