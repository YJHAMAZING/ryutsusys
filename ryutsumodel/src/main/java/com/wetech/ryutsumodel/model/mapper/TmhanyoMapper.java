package com.wetech.ryutsumodel.model.mapper;

import com.wetech.ryutsumodel.model.entity.Tmhanyo;
import java.util.Date;
import java.util.List;

import com.wetech.ryutsumodel.model.entity.TmhanyoExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TmhanyoMapper {
    int deleteByPrimaryKey(@Param("bunruiCod") String bunruiCod, @Param("kbn1") String kbn1, @Param("kbn2") String kbn2, @Param("tekiyostrYmd") Date tekiyostrYmd);

    int insert(Tmhanyo record);

    int insertSelective(Tmhanyo record);

    Tmhanyo selectByPrimaryKey(@Param("bunruiCod") String bunruiCod, @Param("kbn1") String kbn1, @Param("kbn2") String kbn2, @Param("tekiyostrYmd") Date tekiyostrYmd);

    int updateByPrimaryKeySelective(Tmhanyo record);

    int updateByPrimaryKey(Tmhanyo record);

    List<Tmhanyo> selectByExample(TmhanyoExample hanyoExample);

    String test(String a);
}