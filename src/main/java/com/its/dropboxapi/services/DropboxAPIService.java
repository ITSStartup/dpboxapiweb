package com.its.dropboxapi.services;

import java.util.Locale;

import org.springframework.stereotype.Service;

import com.dropbox.core.DbxAppInfo;
import com.dropbox.core.DbxAuthFinish;
import com.dropbox.core.DbxAuthInfo;
import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.DbxWebAuthNoRedirect;
import com.its.dropboxapi.classes.DropBoxAPI;
@Service
public class DropboxAPIService {
	
	private DbxAppInfo appInfo;
	private DbxWebAuthNoRedirect webAuth;
	private DropBoxAPI dropBoxAPI;

	public DropBoxAPI getUrlAuthorization(String app_key, String app_secret) {
		appInfo = new DbxAppInfo(app_key, app_secret);
		String userLocale = Locale.getDefault().toString();
		DbxRequestConfig requestConfig = new DbxRequestConfig("examples-authorize", userLocale);
		webAuth = new DbxWebAuthNoRedirect(requestConfig, appInfo);
		String authorizeUrl = webAuth.start();
		dropBoxAPI = new DropBoxAPI();
		dropBoxAPI.setAuthorizeUrl(authorizeUrl);
		return dropBoxAPI;
	}

	public DropBoxAPI generateToken(String code) throws DbxException {
		code = code.trim();
		DbxAuthFinish authFinish = webAuth.finish(code);
		DbxAuthInfo authInfo = new DbxAuthInfo(authFinish.accessToken,appInfo.host);
		String token = authInfo.accessToken;
		dropBoxAPI.setToken(token);
		return dropBoxAPI;
	}


	public DbxAppInfo getAppInfo() {
		return appInfo;
	}

	public DbxWebAuthNoRedirect getWebAuth() {
		return webAuth;
	}


}
