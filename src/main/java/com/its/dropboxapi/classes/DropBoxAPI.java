package com.its.dropboxapi.classes;

import java.io.Serializable;

public class DropBoxAPI implements Serializable{
	private static final long serialVersionUID = 8319413711613943556L;
	private String authorizeUrl;
	private String token;
	

	public void setAuthorizeUrl(String authorizeUrl) {
		this.authorizeUrl = authorizeUrl;
	}

	public String getAuthorizeUrl() {
		return authorizeUrl;
	}

	public void setToken(String token) {
		this.token = token;
		
	}

	public String getToken() {
		return token;
	}



}
