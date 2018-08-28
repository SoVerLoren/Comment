package com.dingli.comment.service;

import java.util.List;

import com.dingli.comment.bean.Business;
import com.dingli.comment.bean.BusinessDto;

public interface BusinessService {

	public List<Business> getBusinessList();
	
	public boolean saveBu(Business business);

	public List<BusinessDto> getBusListForApi(BusinessDto dto);

	public BusinessDto getBusinessById(BusinessDto dto);

	public List<Business> selectBu(Business bu);
}
