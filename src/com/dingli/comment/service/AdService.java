package com.dingli.comment.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dingli.comment.bean.Advance;
import com.dingli.comment.bean.AdvanceDto;

public interface AdService {

	public List<Advance> getAdList();
	
	public boolean saveAd(AdvanceDto adDto);
	
	public List<Advance> selectAd(Advance ad);

	public AdvanceDto getAdById(Advance ad);

	public boolean deAdById(Advance ad);

	public List<AdvanceDto> getAdListForApi();

	public boolean changeAd(Advance ad);
}
