package com.test.test.vo;

public class link {

	private String web_url;
	private String mobile_web_url;
	private String android_execution_params;
	private String ios_execution_params;
	public link() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getWeb_url() {
		return web_url;
	}
	public void setWeb_url(String web_url) {
		this.web_url = web_url;
	}
	public String getMobile_web_url() {
		return mobile_web_url;
	}
	public void setMobile_web_url(String mobile_web_url) {
		this.mobile_web_url = mobile_web_url;
	}
	public String getAndroid_execution_params() {
		return android_execution_params;
	}
	public void setAndroid_execution_params(String android_execution_params) {
		this.android_execution_params = android_execution_params;
	}
	public String getIos_execution_params() {
		return ios_execution_params;
	}
	public void setIos_execution_params(String ios_execution_params) {
		this.ios_execution_params = ios_execution_params;
	}
	@Override
	public String toString() {
		return "link [web_url=" + web_url + ", mobile_web_url=" + mobile_web_url + ", android_execution_params="
				+ android_execution_params + ", ios_execution_params=" + ios_execution_params + "]";
	}
	
	
	
}
