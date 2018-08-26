package com.dingli.comment.bean;

import org.springframework.web.multipart.MultipartFile;

public class AdvanceDto extends Advance {
	
	private MultipartFile imgFile;
	
	private String imageUrl;
	
	private String img;
	

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public MultipartFile getImgFile() {
		return imgFile;
	}

	public void setImgFile(MultipartFile imgFile) {
		this.imgFile = imgFile;
	}

}
