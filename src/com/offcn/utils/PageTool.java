package com.offcn.utils;

import java.util.List;

/**
 * 分页工具类
 * @author admin
 *
 */

public class PageTool<T> {
	
	//	a.当前页码值：客户端传入到后台
	private Integer currentPage;
	//	b.每页显示条数：自定义
	private Integer pageSize;
	//	c.数据库表数据总条数：sql查询
	private Integer totalCount;
	//	d.数据的总页码：总条数/每页显示条数
	private Integer totalPage;
	//	e.查询的起始索引：（当前页码值-1）*每页显示条数
	private Integer startIndex;
	//	f.上一页：当前页码-1
	private Integer lastPage;
	//	g.下一页：当前页码+1
	private Integer nextPage;
	//	h.分页查询的数据集合：分页sql查询
	private List<T> list;
	
	
	
	/**
	 * 有参构造:实例化分页对象（给对象中属性赋值）
	 * @param currentPage
	 * @param totalCount
	 */

	public PageTool(String currentPage, Integer totalCount) {
		//1.定义每页显示条数
		this.pageSize=4;
		//2.获取当前页码值
		initCurrentPage(currentPage);
		//3.初始化总条数
		this.totalCount=totalCount;
		//4.初始化总页码
		initTotalPage();
		//5.查询起始索引
		initStartIndex();
		//6.上一页
		initLastPage();
		//7.下一页
		initNextPage();
		
	}
	/**
	 * 初始化下一页
	 */
	private void initNextPage() {
		// 判断是否在尾页
		if (this.currentPage==this.totalPage) {
			this.nextPage=this.totalPage;
		} else {
			this.nextPage=this.currentPage+1;
		}
		
	}
	/**
	 * 初始化上一页
	 */
	private void initLastPage() {
		// 判断当前是否在首页
		if (this.currentPage==1) {
			this.lastPage=1;
		} else {
			this.lastPage=this.currentPage-1;
		}	
	}
	/**
	 * 初始化查询的起始索引
	 */
	private void initStartIndex() {
		this.startIndex=(this.currentPage-1)*this.pageSize;
	}
	/**
	 * 初始化总页码
	 */
	private void initTotalPage() {
		// 需要判断总条数是否可以被每页显示条数整除
		if (this.totalCount%this.pageSize==0) {
			this.totalPage=this.totalCount/this.pageSize;
		} else {
			this.totalPage=this.totalCount/this.pageSize+1;
		}
	}

	/**
	 * 初始化当前页码值
	 * @param currentPage
	 */
	private void initCurrentPage(String currentPage) {
		// 如果是首次进入，则默认访问第一页
		if (currentPage==null) {
			this.currentPage=1;
		} else {
			//非首次进入：将字符串转换成整形
			this.currentPage=Integer.valueOf(currentPage);
		}
	}


	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public Integer getStartIndex() {
		return startIndex;
	}
	public void setStartIndex(Integer startIndex) {
		this.startIndex = startIndex;
	}
	public Integer getLastPage() {
		return lastPage;
	}
	public void setLastPage(Integer lastPage) {
		this.lastPage = lastPage;
	}
	public Integer getNextPage() {
		return nextPage;
	}
	public void setNextPage(Integer nextPage) {
		this.nextPage = nextPage;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	
	
	

}
