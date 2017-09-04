package com.bob.model;

import java.util.List;

public class PageModel<T> {
	private int nResult = -1;
	private List<T> data;
	private Long recordTotal;
	private int totalPage;
	private int pageSize;
	private int pageNo;
	
	public PageModel() {
	
	}
	public PageModel(List<T> datas, Long recordTotal, int pageSize, int pageNo) {
		this.data = datas;
		this.recordTotal = recordTotal;
		this.pageSize = pageSize;
		this.pageNo = pageNo;
	}
	
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	public Long getRecordTotal() {
		return recordTotal;
	}
	public void setRecordTotal(Long recordTotal) {
		this.recordTotal = recordTotal;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getnResult() {
		return nResult;
	}
	public void setnResult(int nResult) {
		this.nResult = nResult;
	}


	
	public int getTotalPage() {
	    totalPage = (new Long(recordTotal).intValue()+  this.pageSize  - 1) / this.pageSize;  
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}


	
}
