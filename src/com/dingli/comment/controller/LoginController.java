package com.dingli.comment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dingli.comment.bean.Member;
import com.dingli.comment.service.LoginService;

@Controller
public class LoginController {
	@Autowired
	private LoginService loginService;
	
	@RequestMapping("/preLogin")
	public String preLogin(){
		return "system/login";
	}
	@RequestMapping("/checkLogin")
	public String login(Member m){
		//System.out.println(loginService.checkLogin(m));
		if(loginService.checkLogin(m)){
			return "system/index";
		}
		
		return "system/login";
		
	}
}
