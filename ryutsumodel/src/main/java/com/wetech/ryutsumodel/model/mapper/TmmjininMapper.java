package com.wetech.ryutsumodel.model.mapper;

import com.wetech.ryutsumodel.model.entity.Tmmjinin;
import com.wetech.ryutsumodel.model.entity.TmmjininExample;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TmmjininMapper {
    int deleteByPrimaryKey(String comjugyoinCod);

    int insert(Tmmjinin record);

    int insertSelective(Tmmjinin record);

    Tmmjinin selectByPrimaryKey(String comjugyoinCod);

    int updateByPrimaryKeySelective(Tmmjinin record);

    int updateByPrimaryKey(Tmmjinin record);

    List<Tmmjinin> selectByExample(TmmjininExample jininExample);
}