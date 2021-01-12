package com.offcn.utils;

import java.util.List;

/**
 * ��ҳ������
 * @author admin
 *
 */

public class PageTool<T> {
	
	//	a.��ǰҳ��ֵ���ͻ��˴��뵽��̨
	private Integer currentPage;
	//	b.ÿҳ��ʾ�������Զ���
	private Integer pageSize;
	//	c.���ݿ��������������sql��ѯ
	private Integer totalCount;
	//	d.���ݵ���ҳ�룺������/ÿҳ��ʾ����
	private Integer totalPage;
	//	e.��ѯ����ʼ����������ǰҳ��ֵ-1��*ÿҳ��ʾ����
	private Integer startIndex;
	//	f.��һҳ����ǰҳ��-1
	private Integer lastPage;
	//	g.��һҳ����ǰҳ��+1
	private Integer nextPage;
	//	h.��ҳ��ѯ�����ݼ��ϣ���ҳsql��ѯ
	private List<T> list;
	
	
	
	/**
	 * �вι���:ʵ������ҳ���󣨸����������Ը�ֵ��
	 * @param currentPage
	 * @param totalCount
	 */

	public PageTool(String currentPage, Integer totalCount) {
		//1.����ÿҳ��ʾ����
		this.pageSize=4;
		//2.��ȡ��ǰҳ��ֵ
		initCurrentPage(currentPage);
		//3.��ʼ��������
		this.totalCount=totalCount;
		//4.��ʼ����ҳ��
		initTotalPage();
		//5.��ѯ��ʼ����
		initStartIndex();
		//6.��һҳ
		initLastPage();
		//7.��һҳ
		initNextPage();
		
	}
	/**
	 * ��ʼ����һҳ
	 */
	private void initNextPage() {
		// �ж��Ƿ���βҳ
		if (this.currentPage==this.totalPage) {
			this.nextPage=this.totalPage;
		} else {
			this.nextPage=this.currentPage+1;
		}
		
	}
	/**
	 * ��ʼ����һҳ
	 */
	private void initLastPage() {
		// �жϵ�ǰ�Ƿ�����ҳ
		if (this.currentPage==1) {
			this.lastPage=1;
		} else {
			this.lastPage=this.currentPage-1;
		}	
	}
	/**
	 * ��ʼ����ѯ����ʼ����
	 */
	private void initStartIndex() {
		this.startIndex=(this.currentPage-1)*this.pageSize;
	}
	/**
	 * ��ʼ����ҳ��
	 */
	private void initTotalPage() {
		// ��Ҫ�ж��������Ƿ���Ա�ÿҳ��ʾ��������
		if (this.totalCount%this.pageSize==0) {
			this.totalPage=this.totalCount/this.pageSize;
		} else {
			this.totalPage=this.totalCount/this.pageSize+1;
		}
	}

	/**
	 * ��ʼ����ǰҳ��ֵ
	 * @param currentPage
	 */
	private void initCurrentPage(String currentPage) {
		// ������״ν��룬��Ĭ�Ϸ��ʵ�һҳ
		if (currentPage==null) {
			this.currentPage=1;
		} else {
			//���״ν��룺���ַ���ת��������
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
