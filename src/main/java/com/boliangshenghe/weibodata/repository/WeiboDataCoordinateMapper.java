package com.boliangshenghe.weibodata.repository;

import java.util.List;

import com.boliangshenghe.weibodata.entity.WeiboDataCoordinate;

public interface WeiboDataCoordinateMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WeiboDataCoordinate record);

    int insertSelective(WeiboDataCoordinate record);

    WeiboDataCoordinate selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WeiboDataCoordinate record);

    int updateByPrimaryKeyWithBLOBs(WeiboDataCoordinate record);

    int updateByPrimaryKey(WeiboDataCoordinate record);
    
    public List<WeiboDataCoordinate> selectWeiboDataCoordinateList(WeiboDataCoordinate record);
}