package com.dingli.comment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dingli.comment.bean.Option;
import com.dingli.comment.service.ReportService;

@Controller
public class ReportController {

	@Autowired
	private ReportService rs;
	
	@ResponseBody
	@RequestMapping("/report")
	public Option getReportToApi(){
		Option option = rs.getReport();
		
		return option;
	}
	
	@RequestMapping("/reportPage")
	public String pageReport(){
		return "report/orderCount";
	}
}
