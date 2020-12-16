package com.wang.freemarker.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LayUIController {

	@RequestMapping("/getUser")
	public Map<String,Object>getUser(){
		
		List<Map<String,String>>users=new ArrayList<Map<String,String>>();
		getUserList(users);
		Map<String,Object>result=new HashMap<String,Object>();
		setResult(result, users);
		return result;
	} 
	
	@RequestMapping("/timeOutTest")
	public String timeOutTest() throws InterruptedException {
		Thread.sleep(1000*7);
		System.err.println("*********\n*****打印内容*******");
		return "返回数据";
	}
	
	public void setUser(Map<String,String> user) {
		user.put("id", "1");
		user.put("username", "user-one");
		user.put("experience", "experience");
		user.put("sex", "sex");
		user.put("score", "score");
		user.put("city", "city");
		user.put("sign", "sign");
		user.put("classify", "classify");
		user.put("wealth", "wealth");
	}
	public void getUserList(List<Map<String,String>> users) {
		Map<String, String>user=new HashMap<String, String>();
		setUser(user);
		users.add(user);
	}
	
	void setResult(Map<String,Object>result,Object data){
		result.put("code", "0");
		result.put("msg", "");
		result.put("count", "100");
		result.put("data", data);
	}
	
}
