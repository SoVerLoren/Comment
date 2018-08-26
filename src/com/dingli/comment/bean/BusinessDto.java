package com.dingli.comment.bean;

public class BusinessDto extends Business {

	private String img;
	
	private Integer mumber;
	
	private Integer page;
	
	private String keyword;
	
	private Integer star;
	

	public Integer getStar() {
		return star;
	}

	public void setStar(Integer star) {
		this.star = star;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Integer getMumber() {
		return mumber;
	}

	public void setMumber(Integer mumber) {
		this.mumber = mumber;
	}
	
}
