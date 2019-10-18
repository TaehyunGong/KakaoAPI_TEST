package com.test.test.vo;

public class content {

	private String title;
	private String image_url;
	private int image_width;
	private int image_height;
	private link link;
	public content() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImage_url() {
		return image_url;
	}
	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}
	public link getLink() {
		return link;
	}
	public void setLink(link link) {
		this.link = link;
	}
	public int getImage_width() {
		return image_width;
	}
	public void setImage_width(int image_width) {
		this.image_width = image_width;
	}
	public int getImage_height() {
		return image_height;
	}
	public void setImage_height(int image_height) {
		this.image_height = image_height;
	}
	@Override
	public String toString() {
		return "content [title=" + title + ", image_url=" + image_url + ", image_width=" + image_width
				+ ", image_height=" + image_height + ", link=" + link + "]";
	}
	
	
	
}
