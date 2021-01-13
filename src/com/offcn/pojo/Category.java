package com.offcn.pojo;
/**
 * 商品分类实体类
 *
 */

import java.util.Date;

public class Category {

	private Integer cid;
	private Integer state;
	private Integer order_num;
	private String cname;
	private String description;
	private Date create_date;

	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public Integer getOrder_num() {
		return order_num;
	}
	public void setOrder_num(Integer order_num) {
		this.order_num = order_num;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Category(Integer state, Integer order_num, String cname, String description, Date create_date) {
		super();
		this.state = state;
		this.order_num = order_num;
		this.cname = cname;
		this.description = description;
		this.create_date = create_date;
	}
	public Category(Integer cid, Integer state, Integer order_num, String cname, String description, Date create_date) {
		super();
		this.cid = cid;
		this.state = state;
		this.order_num = order_num;
		this.cname = cname;
		this.description = description;
		this.create_date = create_date;
	}


}
