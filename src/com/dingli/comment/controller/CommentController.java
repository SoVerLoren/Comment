package com.dingli.comment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dingli.comment.bean.Comment;
import com.dingli.comment.service.CommentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
public class CommentController {
	
	@Autowired
	private CommentService comservice;
	
	@RequestMapping("/getComment")
	public String getComment(@RequestParam(value="pageIndex",defaultValue="1")Integer i,Model m){
		PageHelper.startPage(i, 4);
		List<Comment> com=comservice.getComment();
		PageInfo pageInfo=new PageInfo(com);
		m.addAttribute("PageInfo", pageInfo);
		return "content/commentList";
	}

}
