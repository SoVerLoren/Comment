package com.dingli.comment.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dingli.comment.bean.Legend;
import com.dingli.comment.bean.Option;
import com.dingli.comment.bean.Series;
import com.dingli.comment.bean.XAxis;
import com.dingli.comment.dao.orderReportMapper;
import com.dingli.comment.service.ReportService;

@Service
public class ReportServiceImpl implements ReportService {

	@Autowired
	private orderReportMapper orm;
	
	@Override
	public Option getReport() {
	/*	Option op = new Option();
		List<Map<String,String>> report = orm.countReport();
		Legend le = new Legend();
		
		Map<String,String> reportMap = new HashMap<String,String>();
		for (Map<String, String> map : report) {
			String cateName = map.get("category");
			le.getData().add(cateName);
			
			reportMap.put(cateName+"_"+map.get("hour").toString(),map.get("num").toString());
		}
		op.setLegend(le);
		
		XAxis x = new XAxis();
		for(int i = 0;i<24;i++){
			x.getData().add(String.format("%02d", i));
		}
		op.setxAxis(x);
		
		for(Object cateName : le.getData()){
			Series si = new Series();
			si.setName(cateName.toString());
			si.setStack("总量");
			si.setType("line");
			
			for(Object hour : x.getData()){
				String key = cateName.toString()+"_"+hour.toString();
				String orderName = reportMap.get(key);
				si.getData().add(orderName==null ?0:orderName);
			}
			op.getSeries().add(si);
		}
		*/
		return null;
	}

}
