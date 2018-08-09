package com.boliangshenghe.weibodata.repository;

import com.boliangshenghe.weibodata.entity.WeiboData;

public interface WeiboDataMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WeiboData record);

    int insertSelective(WeiboData record);

    WeiboData selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WeiboData record);

    int updateByPrimaryKeyWithBLOBs(WeiboData record);

    int updateByPrimaryKey(WeiboData record);
}