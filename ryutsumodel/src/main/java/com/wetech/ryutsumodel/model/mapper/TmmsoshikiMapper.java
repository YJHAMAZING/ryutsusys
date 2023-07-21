package com.wetech.ryutsumodel.model.mapper;

import com.wetech.ryutsumodel.model.entity.Tmmsoshiki;
import java.util.Date;
import java.util.List;

import com.wetech.ryutsumodel.model.entity.TmmsoshikiExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TmmsoshikiMapper {
    int deleteByPrimaryKey(@Param("comgyomuKbn") Short comgyomuKbn, @Param("comtenCod") String comtenCod, @Param("comsosknm11Knj") String comsosknm11Knj, @Param("comtekiyostrYmd") Date comtekiyostrYmd);

    int insert(Tmmsoshiki record);

    int insertSelective(Tmmsoshiki record);

    Tmmsoshiki selectByPrimaryKey(@Param("comgyomuKbn") Short comgyomuKbn, @Param("comtenCod") String comtenCod, @Param("comsosknm11Knj") String comsosknm11Knj, @Param("comtekiyostrYmd") Date comtekiyostrYmd);

    int updateByPrimaryKeySelective(Tmmsoshiki record);

    int updateByPrimaryKey(Tmmsoshiki record);

    List<Tmmsoshiki> selectByExample(TmmsoshikiExample tmmsoshikiExample);
}