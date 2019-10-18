package com.test.test.vo;

import java.util.List;

public class template_object {

	private String object_type;
	private content content;
	private commerce commerce;
	private List<buttons> buttons;
	
	public template_object() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getObject_type() {
		return object_type;
	}

	public void setObject_type(String object_type) {
		this.object_type = object_type;
	}

	public content getContent() {
		return content;
	}

	public void setContent(content content) {
		this.content = content;
	}

	public commerce getCommerce() {
		return commerce;
	}

	public void setCommerce(commerce commerce) {
		this.commerce = commerce;
	}

	public List<buttons> getButtons() {
		return buttons;
	}

	public void setButtons(List<buttons> buttons) {
		this.buttons = buttons;
	}

	@Override
	public String toString() {
		return "template_object [object_type=" + object_type + ", content=" + content + ", commerce=" + commerce
				+ ", buttons=" + buttons + "]";
	}
	
	
	
}
