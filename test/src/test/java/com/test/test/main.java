package com.test.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.test.test.common.httpConnection;

public class main {

	public static void main(String[] args) throws IOException {

		httpConnection conn = httpConnection.getInstance();
		Map<String, String> map = new HashMap<String, String>();
		map.put("grant_type", "=authorization_code");
//		map.put("client_id", "=2fc5518763fcca5c3f1b3df1e3455035");
//		map.put("redirect_uri", "=http://localhost:8000/redirect");
//		map.put("code", "=1123456879");
		
		conn.HttpPostConnection("https://kauth.kakao.com/oauth/token", map);
	}

}
