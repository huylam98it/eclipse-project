package com.huylam98it.loginfacebook;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component("mycom")
public class MyComponent {

	@Autowired
	Environment env;

	public String getAsscesToken(String code) throws ClientProtocolException, IOException {
		String url = "https://graph.facebook.com/oauth/access_token?client_id=?id&client_secret=?sr&redirect_uri=?re&code=?cd";
		url = url.replace("?id", "550755415431559");
		url = url.replace("?sr", "a7905c084fb3f010c80541c1d5f0cda8");
		url = url.replace("?re", "https://localhost:8080/login-facebook");
		url = url.replace("?cd", code);

		System.out.println("url: " + url);
		String response = Request.Get(url).execute().returnContent().toString();
		System.out.println("token= " + response);
		ObjectMapper mapper = new ObjectMapper();
		JsonNode node = mapper.readTree(response).get("access_token");

		return node.textValue();
	}

	public String getUser(String token) throws ClientProtocolException, IOException {
		String url = "https://graph.facebook.com/me?access_token=tk";
		url = url.replace("tk", token);
		String response = Request.Get(url).execute().returnContent().toString();
		ObjectMapper mapper = new ObjectMapper();
		JsonNode name = mapper.readTree(response).get("name");
		JsonNode id = mapper.readTree(response).get("id");
		System.out.println(name.textValue());
		System.out.println(id.textValue());

		return name.textValue();
	}
}
