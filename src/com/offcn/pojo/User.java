package com.offcn.pojo;
/**
 * 用户实体类
 *
 */

import java.util.Date;

public class User {

	private Integer uid;
	private String uname;//姓名
	private String phone;//电话
	private String address;//地区
	private String username;//账号
	private String userpwd;//密码
	private String photo;//头像名称
	private Integer gender;//性别：1男0女
	private Integer manager;//权限：1管理员  0普通用户
	private Date create_date;//注册日期 ：系统当前时间
	
	
	public User(String uname, String phone, String address, String username, String userpwd, Integer gender,
			Date create_date) {
		super();
		this.uname = uname;
		this.phone = phone;
		this.address = address;
		this.username = username;
		this.userpwd = userpwd;
		this.gender = gender;
		this.create_date = create_date;
	}
	public User(String uname, String phone, String address, String username, String userpwd, String photo,
			Integer gender, Date create_date) {
		super();
		this.uname = uname;
		this.phone = phone;
		this.address = address;
		this.username = username;
		this.userpwd = userpwd;
		this.photo = photo;
		this.gender = gender;
		this.create_date = create_date;
	}
	public User(Integer uid, String uname, String phone, String address, String username, String userpwd, String photo,
			Integer gender, Integer manager, Date create_date) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.phone = phone;
		this.address = address;
		this.username = username;
		this.userpwd = userpwd;
		this.photo = photo;
		this.gender = gender;
		this.manager = manager;
		this.create_date = create_date;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserpwd() {
		return userpwd;
	}
	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public Integer getManager() {
		return manager;
	}
	public void setManager(Integer manager) {
		this.manager = manager;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	
	
}
