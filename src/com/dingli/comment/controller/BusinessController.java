package com.dingli.comment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dingli.comment.bean.Business;
import com.dingli.comment.bean.Dictype;
import com.dingli.comment.service.BusinessService;
import com.dingli.comment.service.DicService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
public class BusinessController {
	
	@Autowired
	private BusinessService businessSer;
	@Autowired
	private DicService dicSer;
	
	//获得商户列表
	@RequestMapping("/getBusinessList")
	public String getBusinessList(@RequestParam(value="pageIndex",defaultValue="1") Integer i,Model m){
		PageHelper.startPage(i, 3);
		List<Business> business=businessSer.getBusinessList();
		PageInfo pageInfo=new PageInfo(business);
		m.addAttribute("BusiPageList", pageInfo);
		return "content/businessList";
	}
	
	//跳转到增加页面
	@RequestMapping("/Addbusiness")
	public String addBusiness(Model m){
		Dictype dic=new Dictype();
		dic.setType("category");
		List<Dictype> category=dicSer.getDictype(dic);
		dic.setType("city");
		List<Dictype> city=dicSer.getDictype(dic);
		m.addAttribute("category", category);
		m.addAttribute("city", city);
		return "content/businessAdd";
	}
	
	//实现增加页面的保存操作
	@RequestMapping("/saveBu")
	public String saveBu(Business business){
		businessSer.saveBu(business);
		return "redirect:getBusinessList";
	}
	
	//跳转到修改页面
	@RequestMapping("/modifyBu")
	public String modifyBusiness(){
		return "content/businessModify";
	}
	
	@RequestMapping("/backBu")
	public String backBu(){
		return "redirect:getBusinessList";
	}
}
