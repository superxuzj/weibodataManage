package com.boliangshenghe.weibodata.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boliangshenghe.weibodata.common.PageBean;
import com.boliangshenghe.weibodata.entity.WeiboLonlat;
import com.boliangshenghe.weibodata.repository.WeiboLonlatMapper;
import com.boliangshenghe.weibodata.util.CommonUtils;
import com.github.pagehelper.PageHelper;

@Service
public class WeiboLonlatService {

	@Autowired
	WeiboLonlatMapper weiboLonlatMapper;
	public int insertSelective(WeiboLonlat record) {
        return weiboLonlatMapper.insertSelective(record);
    }
	
    /*public Integer selectUserListCount(WeiboDataCoordinate record){
    	return weiboDataCoordinateMapper.selectUserListCount(record);
    }*/
    
    public WeiboLonlat selectByPrimaryKey(Integer id){
    	return weiboLonlatMapper.selectByPrimaryKey(id);
    }
    
    public  int updateByPrimaryKeySelective(WeiboLonlat record){
    	return weiboLonlatMapper.updateByPrimaryKeySelective(record);
    }
    
    public  int deleteByUid(String uid){
    	return weiboLonlatMapper.deleteByUid(uid);
    }
    
    public List<WeiboLonlat> selectWeiboLonlatList(WeiboLonlat record){
    	return weiboLonlatMapper.selectWeiboLonlatList(record);
    }
    
    public PageBean<WeiboLonlat> getWeiboLonlatByPage(WeiboLonlat record,Integer pageNo,Integer size) {
        
        PageHelper.startPage(pageNo,CommonUtils.PAGESIZE);
        List<WeiboLonlat> list = this.weiboLonlatMapper.selectWeiboLonlatList(record);
        return new PageBean<WeiboLonlat>(list);
    }
}
