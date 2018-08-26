package com.dingli.comment.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dingli.comment.bean.Member;
import com.dingli.comment.dao.MemberMapper;
import com.dingli.comment.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberMapper mbm;
	
	@Override
	public boolean checkUsername(String username) {
		long parseLong = Long.parseLong(username);
		Member member = mbm.selectByPhone(parseLong);
		if(member.getId()==null){
			return false;
		}
		return true;
	}

}
