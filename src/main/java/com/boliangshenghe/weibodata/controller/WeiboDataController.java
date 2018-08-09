package com.boliangshenghe.weibodata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.boliangshenghe.weibodata.common.PageBean;
import com.boliangshenghe.weibodata.entity.WeiboDataCoordinate;
import com.boliangshenghe.weibodata.service.WeiboDataCoordinateService;

/**
 *微博数据
 * @author xuzj
 *
 */
@Controller
@RequestMapping("/weibo")
public class WeiboDataController {
	
	@Autowired
	public WeiboDataCoordinateService weiboDataCoordinateService;
	
	@RequestMapping("alldata")
	public String index(WeiboDataCoordinate weiboDataCoordinate,Model model,
			@RequestParam(defaultValue = "1", value = "pageNo") Integer pageNo){
		PageBean<WeiboDataCoordinate> page =  weiboDataCoordinateService.getWeiboDataCoordinateByPage(weiboDataCoordinate,pageNo,10);
		System.out.println(page.getTotal());
		model.addAttribute("page", page);
		return "weibo/alldata";
	}
	
	@RequestMapping("reladata")
	public String info(){
		return "weibo/reladata";
	}
}
