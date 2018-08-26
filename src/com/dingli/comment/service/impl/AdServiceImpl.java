package com.dingli.comment.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dingli.comment.bean.Advance;
import com.dingli.comment.bean.AdvanceDto;
import com.dingli.comment.dao.AdvanceMapper;
import com.dingli.comment.service.AdService;


@Service
public class AdServiceImpl implements AdService {
	@Value("${img_save_path}")
	public String filePath;
	@Value("${img_url}")
	public String imgUrl;
	
	@Autowired
	private AdvanceMapper advanceMapper;
	
	@Override
	public List<Advance> getAdList() {
		List<Advance> advance=advanceMapper.selectAllAd(null);
		return advance;
	}
	
	@Override
	public boolean saveAd(AdvanceDto adDto){
		Advance ad=new Advance();
	//	System.out.println(adDto.getTitle());
		//这是页面上传过来的文件,暂时保存在内存中
		MultipartFile imgFile=adDto.getImgFile();
		String FileName=System.currentTimeMillis()+"_"+imgFile.getOriginalFilename();
		if(null==imgFile|| imgFile.getSize()==0){
			return false;
		}
		File saveFile=new File(filePath+FileName);
		if(!saveFile.exists()){
			saveFile.mkdirs();
		}
		
		//将内存中的文件转移到硬盘
		try {
			imgFile.transferTo(saveFile);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		BeanUtils.copyProperties(adDto, ad);
	//	System.out.println(ad.getTitle());
		ad.setImgFileName(FileName);
		advanceMapper.insert(ad);
		return true;
	}
	
	@Override
	public List<Advance> selectAd(Advance ad){
		//	System.out.println(ad.getTitle());
		List<Advance> adList=advanceMapper.selectByAdtitle(ad.getTitle());
		//System.out.println("qwwwwww"+adList.size());
		return adList;
	}
	
	@Override
	public AdvanceDto getAdById(Advance ad){
		Advance adlist=advanceMapper.selectByPrimaryKey(ad.getId());
		AdvanceDto adDto=new AdvanceDto();
		BeanUtils.copyProperties(adlist, adDto);
		adDto.setImageUrl(imgUrl+adlist.getImgFileName());
		return adDto;
	}

	@Override
	public boolean deAdById(Advance ad) {
		advanceMapper.deleteByPrimaryKey(ad.getId());
		return true;
	}

	@Override
	public List<AdvanceDto> getAdListForApi() {
		
		List<Advance> ads=advanceMapper.selectAllAd(null);
		List<AdvanceDto> adDtos=new ArrayList<AdvanceDto>();
		for(int i=0;i<ads.size();i++){
			AdvanceDto dto=new AdvanceDto();
			BeanUtils.copyProperties(ads.get(i), dto);
			dto.setImg(imgUrl+ads.get(i).getImgFileName());
			adDtos.add(i,dto);
		}
		return adDtos;
	}

	@Override
	public boolean changeAd(Advance ad) {
		int resule=advanceMapper.updateAd(ad);
		if(resule==0){
			return false;
		}
		return true;
	}
}
