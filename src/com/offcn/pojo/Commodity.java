package com.offcn.pojo;
/**
 * 商品实体类
 *
 */

import java.util.Date;

public class Commodity {
	
	private Integer cid;
	private Integer cate_id;
	private Integer ctype;
	private Double price;
	private String cname;
	private String color;
	private String size;
	private String short_desc;
	private String full_desc;
	private String photo;
	private String model;
	private Date create_date;
	
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public Integer getCate_id() {
		return cate_id;
	}
	public void setCate_id(Integer cate_id) {
		this.cate_id = cate_id;
	}
	public Integer getCtype() {
		return ctype;
	}
	public void setCtype(Integer ctype) {
		this.ctype = ctype;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getShort_desc() {
		return short_desc;
	}
	public void setShort_desc(String short_desc) {
		this.short_desc = short_desc;
	}
	public String getFull_desc() {
		return full_desc;
	}
	public void setFull_desc(String full_desc) {
		this.full_desc = full_desc;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	public Commodity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Commodity(Integer cate_id, Integer ctype, Double price, String cname, String color, String size,
			String short_desc, String full_desc, String photo, String model, Date create_date) {
		super();
		this.cate_id = cate_id;
		this.ctype = ctype;
		this.price = price;
		this.cname = cname;
		this.color = color;
		this.size = size;
		this.short_desc = short_desc;
		this.full_desc = full_desc;
		this.photo = photo;
		this.model = model;
		this.create_date = create_date;
	}
	
	

}
