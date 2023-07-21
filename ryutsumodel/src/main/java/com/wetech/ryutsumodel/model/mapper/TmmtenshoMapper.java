package com.wetech.ryutsumodel.model.mapper;

import com.wetech.ryutsumodel.model.entity.Tmmtensho;
import java.util.Date;
import java.util.List;

import com.wetech.ryutsumodel.model.entity.TmmtenshoExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TmmtenshoMapper {
    int deleteByPrimaryKey(@Param("comtennm1Kna") String comtennm1Kna, @Param("comtekiyostrYmd") Date comtekiyostrYmd);

    int insert(Tmmtensho record);

    int insertSelective(Tmmtensho record);

    Tmmtensho selectByPrimaryKey(@Param("comtennm1Kna") String comtennm1Kna, @Param("comtekiyostrYmd") Date comtekiyostrYmd);

    int updateByPrimaryKeySelective(Tmmtensho record);

    int updateByPrimaryKey(Tmmtensho record);

    List<Tmmtensho> selectByExample(TmmtenshoExample tenshoExample);
}