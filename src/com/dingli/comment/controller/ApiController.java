package com.dingli.comment.controller;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dingli.comment.bean.AdvanceDto;
import com.dingli.comment.bean.BusinessDto;
import com.dingli.comment.bean.BusinessDtoForApi;
import com.dingli.comment.bean.BuyCom;
import com.dingli.comment.bean.OrdersDto;
import com.dingli.comment.cacha.Common;
import com.dingli.comment.cacha.LoginCode;
import com.dingli.comment.service.AdService;
import com.dingli.comment.service.BusinessService;
import com.dingli.comment.service.MemberService;
import com.dingli.comment.service.OrderService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@RestController
public class ApiController {

	@Autowired
	private AdService adService;
	
	@Autowired
	private BusinessService bService;
	
	@Autowired
	private OrderService os;
	
	@Autowired
	private MemberService ms;
	
	//首页广告数据接口
	@RequestMapping("/api/homead")
	public List<AdvanceDto> getAllAdForApi(){
		PageHelper.startPage(1, 6);
		List<AdvanceDto> dtos=adService.getAdListForApi();
		PageInfo pageInfo=new PageInfo(dtos);
		return pageInfo.getList() ;
	}
	
	//猜你喜欢（首页商户列表推荐）       @PathVariable(value="city") String city
	@RequestMapping("/api/homelist/{city}/{page}")
	public BusinessDtoForApi getBusDto(BusinessDto dto){
		dto.setPage(dto.getPage()+1);
		PageHelper.startPage(dto.getPage(), 2);
		List<BusinessDto> busList=bService.getBusListForApi(dto);
		PageInfo pg=new PageInfo(busList);
		BusinessDtoForApi dtoforapi=new BusinessDtoForApi();
		dtoforapi.setHasMore(!pg.isIsLastPage());
		dtoforapi.setData(pg.getList());
		return dtoforapi;
	}
	
	
	
	@RequestMapping("/api/detail/info/{id}")
	public BusinessDto getBusDetail(BusinessDto dto){
		BusinessDto businessDto=bService.getBusinessById(dto);
		return businessDto;
	}
	
	//查询手机号是否存在，获取验证码，并将手机号和验证码以key value的形式存在map集合，用于登录验证
	@RequestMapping("/api/sms")
	public LoginCode sendCode(@RequestParam("username") String username){
		LoginCode lcode=new LoginCode();
		if(!ms.checkUsername(username)){
			lcode.setErrno(1);
			lcode.setMsg("手机号码输入错误！");
			return lcode;
		}
		lcode.setErrno(0);
		double codeDouble=Math.random()*100000;
		String code = String.valueOf(Math.round(codeDouble));
		lcode.setCode(code);
		lcode.setUsername(username);
		lcode.setMsg("ok");
		Common.codeMap.put(username,code);
		return lcode;
	}
	
	//登录操作
	@RequestMapping("/api/login")
	public LoginCode loginForApi(@RequestParam("code") String code,
			@RequestParam("username") String username ) throws Exception{
		LoginCode lcode = new LoginCode();
		if(!Common.codeMap.containsKey(username)){
			lcode.setErrno(1);
			lcode.setMsg("用户不存在！");
			return lcode;
		}
		if(!Common.codeMap.get(username).equals(code)){
			lcode.setErrno(1);
			lcode.setMsg("验证码不正确");
			return lcode;
		}
		lcode.setErrno(0);
		lcode.setMsg("登录成功！");
		String uuid=UUID.randomUUID().toString().replace("_", "");
		lcode.setToken(uuid);
		Common.tokenMap.put(username, uuid);
		return lcode;
	}
	
	@RequestMapping("/api/order")
	public LoginCode buyForApi(BuyCom bc){
		LoginCode lcode=new LoginCode();
		if(!Common.tokenMap.get(bc.getUsername()).equals(bc.getToken())){
			lcode.setErrno(1);
			lcode.setMsg("用户未登录");
			return lcode;
		}
		OrdersDto oDto = new OrdersDto();
		oDto.setBusinessId(bc.getId());
		oDto.setPrice(BigDecimal.valueOf(bc.getPrice()));
		oDto.setCommentState(0);
		oDto.setUsername(bc.getUsername());
		oDto.setNum(bc.getNum());
		
		if(os.addOrder(oDto)<1){
			lcode.setErrno(1);
			lcode.setMsg("购买失败");
			return lcode;
		}
		return null;
		
	}
}
