package com.dingli.comment.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dingli.comment.bean.Comment;
import com.dingli.comment.dao.CommentMapper;
import com.dingli.comment.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	private CommentMapper commentMap;

	@Override
	public List<Comment> getComment() {
		
		return commentMap.selectAllCom();
	}

	@Override
	public List<Comment> selectCom(Comment com) {
		
		return  commentMap.selectByComment(com.getComment());
	}

}
