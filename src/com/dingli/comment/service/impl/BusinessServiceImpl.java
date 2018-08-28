package com.dingli.comment.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.dingli.comment.bean.Business;
import com.dingli.comment.bean.BusinessDto;
import com.dingli.comment.dao.BusinessMapper;
import com.dingli.comment.service.BusinessService;
@Service
public class BusinessServiceImpl implements BusinessService {

	@Value("${bus_img_url}")
	public String busImagePath;
	@Value("${bus_img_url}")
	public String imgPath;
	
	@Autowired
	private BusinessMapper bsmapper;
	
	@Override
	public List<Business> getBusinessList() {
		
		return bsmapper.selectAllbusiness();
	}

	@Override
	public boolean saveBu(Business business) {
		bsmapper.insertBu(business);
		return true;
	}

	@Override
	public List<BusinessDto> getBusListForApi(BusinessDto dto) {
		List<BusinessDto> busDto=bsmapper.selectLoveBus(dto);
		//System.out.println(busDto.size()+"aaa");
		for (BusinessDto businessDto : busDto) {
			String loveImagePath=busImagePath+businessDto.getImgFileName();
			
			businessDto.setImg(loveImagePath);
		}
		return busDto;
	}

	@Override
	public BusinessDto getBusinessById(BusinessDto dto) {
		Business business = bsmapper.selectByPrimaryKey(dto.getId());
		BusinessDto budto = new BusinessDto();
		BeanUtils.copyProperties(business, budto);
		budto.setImg(imgPath+business.getImgFileName());
		Integer star = business.getStarTotalNum();
		budto.setStar(star);
		return budto;
	}

	@Override
	public List<Business> selectBu(Business bu) {
		
		return bsmapper.selectByTitle(bu.getTitle());
	}

}
