package com.test.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.test.common.httpConnection;

@Controller
public class HomeController {
	
	@Value("#{props['kakako.Admin_key']}")
	private String Admin_key;
	
	@Value("#{props['kakako.Rest_key']}")
	private String Rest_key;
	
	httpConnection conn = httpConnection.getInstance();
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "home";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String kakao() {
		StringBuffer loginUrl = new StringBuffer();
		loginUrl.append("https://kauth.kakao.com/oauth/authorize?client_id=");
		loginUrl.append(Rest_key); //카카오 앱에 있는 REST KEY
		loginUrl.append("&redirect_uri=");
		loginUrl.append("http://localhost:8080/kakaoLogin"); //카카오 앱에 등록한 redirect URL
		loginUrl.append("&response_type=code");
		
		return "redirect:"+loginUrl.toString();
	}
	
	@RequestMapping(value = "/kakaoLogin", method = RequestMethod.GET)
	public String redirect(@RequestParam String code, HttpSession session) throws IOException {
		
		//code
		//사용자가 취소 누르면 error 파라메터를 받음 
		// 그때 여기서 구분해야할듯
		Map<String, String> map = new HashMap<String, String>();
		map.put("grant_type", "=authorization_code");
		map.put("client_id=", Rest_key); //카카오 앱에 있는 REST KEY
		map.put("redirect_uri", "=http://localhost:8080/kakaoLogin"); //카카오 앱에 등록한 redirect URL
		map.put("code", "="+code);
		
		String out = conn.HttpPostConnection("https://kauth.kakao.com/oauth/token", map).toString();
		
		ObjectMapper mapper = new ObjectMapper();
		KakaoLoginOutput output = mapper.readValue(out, KakaoLoginOutput.class);
		
		System.out.println(output);
		session.setAttribute("access_token", output.getAccess_token());
		
		return "redirect:/";
	}
	
	@RequestMapping(value="/logout")
	public String access(HttpSession session) throws IOException {
		
		String access_token = (String)session.getAttribute("access_token");
		Map<String, String> map = new HashMap<String, String>();
		map.put("Authorization", "Bearer "+ access_token);
		
		String result = conn.HttpPostConnection("https://kapi.kakao.com/v1/user/logout", map).toString();
		System.out.println(result);
		
		return "redirect:/";
	}
	
	@RequestMapping(value="/secession")
	public String secession(HttpSession session) throws IOException {
		
		String access_token = (String)session.getAttribute("access_token");
		Map<String, String> map = new HashMap<String, String>();
		map.put("Authorization", "Bearer "+ access_token);
		
		String result = conn.HttpPostConnection("https://kapi.kakao.com/v1/user/unlink", map).toString();
		System.out.println(result);
		
		return "redirect:/";
	}	
	
	@RequestMapping(value="/secession2")
	public String secession2(HttpSession session) throws IOException {
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("Authorization", "KakaoAK "+ Admin_key);
		map.put("target_id_type", "user_id");
		map.put("target_id", "1192936782");
		
		String result = conn.HttpPostConnection("https://kapi.kakao.com/v1/user/unlink", map).toString();
		System.out.println(result);
		
		return "redirect:/";
	}
	
	@RequestMapping(value="/accessInfo")
	public String accessInfo(HttpSession session) throws IOException {
		
		String access_token = (String)session.getAttribute("access_token");
		Map<String, String> map = new HashMap<String, String>();
		map.put("Authorization", "Bearer "+ access_token);
		
		String result = conn.HttpGetConnection("https://kapi.kakao.com/v1/user/access_token_info", map).toString();
		System.out.println(result);
		
		return "redirect:/";
	}
	
	@RequestMapping(value="/info")
	public String info() throws IOException {
		Map<String, String> map = new HashMap<String, String>();
		map.put("Authorization", "KakaoAK "+ Admin_key);
		
		String result = conn.HttpPostConnection("https://kapi.kakao.com/v1/user/ids", map).toString();
		System.out.println(result);
		
		return "redirect:/";
	}
}
