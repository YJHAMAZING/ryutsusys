package com.wetech.ryutsumodel.model.mapper;

import com.wetech.ryutsumodel.model.entity.Ttmicshorijokyo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TtmicshorijokyoMapper {
    int deleteByPrimaryKey(Integer seq);

    int insert(Ttmicshorijokyo record);

    int insertSelective(Ttmicshorijokyo record);

    Ttmicshorijokyo selectByPrimaryKey(Integer seq);

    int updateByPrimaryKeySelective(Ttmicshorijokyo record);

    int updateByPrimaryKey(Ttmicshorijokyo record);
}