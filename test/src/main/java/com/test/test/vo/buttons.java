package com.test.test.vo;

public class buttons {

	private String title;
	private link link;
	public buttons() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public link getLink() {
		return link;
	}
	public void setLink(link link) {
		this.link = link;
	}
	@Override
	public String toString() {
		return "buttons [title=" + title + ", link=" + link + "]";
	}
	
	
	
}
