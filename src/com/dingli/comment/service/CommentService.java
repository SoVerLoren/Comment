package com.dingli.comment.service;

import java.util.List;

import com.dingli.comment.bean.Comment;

public interface CommentService {

	public List<Comment> getComment();

	public List<Comment> selectCom(Comment com);
}
