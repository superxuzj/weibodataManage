package com.boliangshenghe.weibodata.repository;

import java.util.List;

import com.boliangshenghe.weibodata.entity.WeiboLonlat;

public interface WeiboLonlatMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WeiboLonlat record);

    int insertSelective(WeiboLonlat record);

    WeiboLonlat selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WeiboLonlat record);

    int updateByPrimaryKey(WeiboLonlat record);
    
    public List<WeiboLonlat> selectWeiboLonlatList(WeiboLonlat record);
    
    public  int deleteByUid(String uid);
}