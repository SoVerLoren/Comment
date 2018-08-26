package com.dingli.comment.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dingli.comment.bean.Dictype;
import com.dingli.comment.dao.DictypeMapper;
import com.dingli.comment.service.DicService;

@Service
public class DictypeServiceImpl implements DicService {
	
	@Autowired
	private DictypeMapper dicMapper;
	
	@Override
	public List<Dictype> getDictype(Dictype dic) {
		
		
		return dicMapper.selectDictype(dic.getType());
	}

}
