package com.its.dropboxapi.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.dropbox.core.DbxException;
import com.its.dropboxapi.classes.DropBoxAPI;
import com.its.dropboxapi.services.DropboxAPIService;

@Controller
@Path("/dptoken")
public class DropboxAPIController {
	@Autowired
	private DropboxAPIService dropboxAPIService;
	
	@GET
	@Path("/{key}/{secret}")
	@Produces(MediaType.APPLICATION_JSON)
	public DropBoxAPI getUrlAuthorization(@PathParam("key")String app_key,@PathParam("secret") String app_secret){
		return dropboxAPIService.getUrlAuthorization(app_key,app_secret);
		
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{code}")
	public DropBoxAPI generateToken(@PathParam("code")String code) throws DbxException{
		return dropboxAPIService.generateToken(code);
	}

	public DropboxAPIService getDropboxAPIService() {
		return dropboxAPIService;
	}

}
