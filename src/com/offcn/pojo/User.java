package com.offcn.pojo;
/**
 * �û�ʵ����
 *
 */

import java.util.Date;

public class User {

	private Integer uid;
	private String uname;//����
	private String phone;//�绰
	private String address;//����
	private String username;//�˺�
	private String userpwd;//����
	private String photo;//ͷ������
	private Integer gender;//�Ա�1��0Ů
	private Integer manager;//Ȩ�ޣ�1����Ա  0��ͨ�û�
	private Date create_date;//ע������ ��ϵͳ��ǰʱ��
	
	
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
