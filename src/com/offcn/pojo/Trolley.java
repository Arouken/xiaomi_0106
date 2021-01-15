package com.offcn.pojo;
/**
 * 购物车实体类
 *
 */
public class Trolley {

	private Integer tid;
	private Integer user_id;
	private Integer comm_id;
	private Integer number;
	private String order_number;
	
	public Integer getTid() {
		return tid;
	}
	public void setTid(Integer tid) {
		this.tid = tid;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public Integer getComm_id() {
		return comm_id;
	}
	public void setComm_id(Integer comm_id) {
		this.comm_id = comm_id;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public String getOrder_number() {
		return order_number;
	}
	public void setOrder_number(String order_number) {
		this.order_number = order_number;
	}
	public Trolley() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Trolley(Integer user_id, Integer comm_id, Integer number, String order_number) {
		super();
		this.user_id = user_id;
		this.comm_id = comm_id;
		this.number = number;
		this.order_number = order_number;
	}
	
	
	
}
