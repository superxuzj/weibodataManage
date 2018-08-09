package com.boliangshenghe.weibodata.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boliangshenghe.weibodata.common.PageBean;
import com.boliangshenghe.weibodata.entity.User;
import com.boliangshenghe.weibodata.entity.WeiboDataCoordinate;
import com.boliangshenghe.weibodata.repository.WeiboDataCoordinateMapper;
import com.boliangshenghe.weibodata.util.CommonUtils;
import com.github.pagehelper.PageHelper;

@Service
public class WeiboDataCoordinateService {

	@Autowired
	WeiboDataCoordinateMapper weiboDataCoordinateMapper;
	
	public int insertSelective(WeiboDataCoordinate record) {
        return weiboDataCoordinateMapper.insertSelective(record);
    }
	
    /*public Integer selectUserListCount(WeiboDataCoordinate record){
    	return weiboDataCoordinateMapper.selectUserListCount(record);
    }*/
    
    public WeiboDataCoordinate selectByPrimaryKey(Integer id){
    	return weiboDataCoordinateMapper.selectByPrimaryKey(id);
    }
    
    public  int updateByPrimaryKeySelective(WeiboDataCoordinate record){
    	return weiboDataCoordinateMapper.updateByPrimaryKeySelective(record);
    }
    
    public List<WeiboDataCoordinate> selectWeiboDataCoordinateList(WeiboDataCoordinate record){
    	return weiboDataCoordinateMapper.selectWeiboDataCoordinateList(record);
    }
    
    public PageBean<WeiboDataCoordinate> getWeiboDataCoordinateByPage(WeiboDataCoordinate record,Integer pageNo,Integer size) {
        
        PageHelper.startPage(pageNo,CommonUtils.PAGESIZE);
        List<WeiboDataCoordinate> list = this.weiboDataCoordinateMapper.selectWeiboDataCoordinateList(record);
        return new PageBean<WeiboDataCoordinate>(list);
    }
}
