package com.dingli.comment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dingli.comment.bean.Advance;
import com.dingli.comment.bean.AdvanceDto;
import com.dingli.comment.service.AdService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
public class AdvanceController {
	@Autowired
	private AdService adService;
	
	//获取ad列表
	@RequestMapping("/getAdList")
	public String getAdList(@RequestParam(value="pageIndex",defaultValue="1") Integer i, Model m){
		
		PageHelper.startPage(i, 3);
		List<Advance> adlist=adService.getAdList();
		PageInfo pageInfo=new PageInfo(adlist);
		
//		pageInfo.getList();
		//是否有下一页
//		pageInfo.isHasNextPage();
//		//当前是第几页
//		pageInfo.getPageNum();
//		//总共几页
//		pageInfo.getPages();
//	System.out.println(pageInfo);
		m.addAttribute("adPageList", pageInfo);
		return "content/adList";
	}
	
	//跳转到增加界面
	@RequestMapping("/addAd")
	public String addAd(){
		return "content/adAdd";
	}
	
	//返回到ad列表
	@RequestMapping("/backAd")
	public String backAd(){
		return "redirect:getAdList";
	}
	
	//执行增加界面的保存操作
	@RequestMapping("/saveAd")
	public String saveAd(AdvanceDto adDto, Model m){
		//System.out.println(adDto.getTitle());
		adService.saveAd(adDto);
	
		//重定向，返回ad列表
		return "redirect:getAdList";
	}
	
	//查询实现(模糊查询！！！)
	@RequestMapping("/selectAd")
	public String selectAd(Advance ad,@RequestParam(value="pageIndex",defaultValue="1") Integer i, Model m){
		PageHelper.startPage(i, 3);
		List<Advance> adList=adService.selectAd(ad);
		PageInfo AdpageInfo=new PageInfo(adList);
		m.addAttribute("adPageList", AdpageInfo);
		return "content/adList";
	}
	
	//跳转到修改界面
	@RequestMapping("/modifyAd")
	public String modifyAd(Advance ad,Model m){
		AdvanceDto nead=adService.getAdById(ad);
		m.addAttribute("ad", nead);
		return "content/adModify";
	}
	
	//执行修改界面的保存操作
	@RequestMapping("/changeAd")
	public String changeAd(Advance ad){
		adService.changeAd(ad);
		
		return "redirect:getAdList";
	}
	//删除操作
	@RequestMapping("/delAd")
	public String delAd(Advance ad){
		adService.deAdById(ad);
		
		return "redirect:getAdList";
	}
	
}
