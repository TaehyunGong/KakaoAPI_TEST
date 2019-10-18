package com.test.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.test.common.httpConnection;
import com.test.test.vo.buttons;
import com.test.test.vo.commerce;
import com.test.test.vo.content;
import com.test.test.vo.link;
import com.test.test.vo.template_object;

@Controller
public class TalkController {

	@Value("#{props['kakako.Admin_key']}")
	private String Admin_key;
	
	httpConnection conn = httpConnection.getInstance();
	
	@RequestMapping(value="/profile")
	public String getProfile(HttpSession session) throws IOException {
		
		String access_token = (String)session.getAttribute("access_token");
		Map<String, String> map = new HashMap<String, String>();
		map.put("Authorization", "Bearer "+ access_token);
		
		String result = conn.HttpGetConnection("https://kapi.kakao.com/v1/api/talk/profile", map).toString();
		System.out.println(result);
		
		return "redirect:/";
	}
	
	@RequestMapping(value="/search")
	public String search(HttpSession session) throws IOException {
		String access_token = (String)session.getAttribute("access_token");
		Map<String, String> map = new HashMap<String, String>();
		map.put("Authorization", "KakaoAK "+ Admin_key);
		
		String result = conn.HttpGetConnection("https://dapi.kakao.com/v2/search/web?query=test", map).toString();
		System.out.println(result);
		
		return "redirect:/";
	}
	
	@RequestMapping(value="/sendMessageMe")
	public String sendMessageMe(HttpSession session) throws IOException {
		
		template_object template = new template_object();
		template.setObject_type("commerce");
		
		//content
		content content = new content();
		content.setTitle("컨텐츠 제목");
		content.setImage_url("http://mud-kage.kakao.co.kr/dn/RY8ZN/btqgOGzITp3/uCM1x2xu7GNfr7NS9QvEs0/kakaolink40_original.png");
		content.setImage_width(640);
		content.setImage_height(640);
		link contentLink = new link();
		contentLink.setWeb_url("https://style.kakao.com/main/women/contentId=100");
		contentLink.setMobile_web_url("https://style.kakao.com/main/women/contentId=100");
		contentLink.setAndroid_execution_params("contentId=100");
		contentLink.setIos_execution_params("contentId=100");
		template.setContent(content);
		
		//commerce
		commerce commerce = new commerce();
		commerce.setRegular_price(208800);
		commerce.setDiscount_price(146160);
		commerce.setDiscount_rate(30);
		template.setCommerce(commerce);
		
		//buttons
		List<buttons> btnList = new ArrayList<buttons>();
		buttons buyBtn = new buttons();
		buyBtn.setTitle("구매하기");
		link buyLink = new link();
		buyLink.setWeb_url("https://style.kakao.com/main/women/contentId=100/buy");
		buyLink.setMobile_web_url("https://style.kakao.com/main/women/contentId=100/buy");
		buyLink.setAndroid_execution_params("contentId=100&buy=true");
		buyLink.setIos_execution_params("contentId=100&buy=true");
		template.setButtons(btnList);
		
		//-----------------------------------------------
		
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(template);
		
		String access_token = (String)session.getAttribute("access_token");
		Map<String, String> map = new HashMap<String, String>();
		map.put("Authorization", "Bearer "+ access_token);
		map.put("template_object=", json);
		
		String result = conn.HttpPostConnection("https://kapi.kakao.com/v2/api/talk/memo/default/send", map).toString();
		System.out.println(result);
		
		return "redirect:/";
	}
}
