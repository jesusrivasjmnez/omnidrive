package com.aiss.omnidrive.server.resources;

import org.restlet.data.ChallengeResponse;
import org.restlet.data.ChallengeScheme;
import org.restlet.resource.ClientResource;

import com.aiss.omnidrive.shared.dropbox.user.DropboxUserInfo;

public class DropboxResource {
	
	private static final String BASE_URL = "https://api.dropboxapi.com/1";
	private static final String TYPE_TOKEN = "Bearer";
	
	public static DropboxUserInfo getUserInfo(String token){
		DropboxUserInfo userInfo;
		ClientResource connection;
		ChallengeResponse authorization;
		
		connection = new ClientResource(BASE_URL + "/account/info");
		authorization = new ChallengeResponse(new ChallengeScheme("OAuth2", TYPE_TOKEN));
		authorization.setRawValue(token);
		connection.setChallengeResponse(authorization);
		
		userInfo = connection.get(DropboxUserInfo.class);
		
		return userInfo;
	}
}