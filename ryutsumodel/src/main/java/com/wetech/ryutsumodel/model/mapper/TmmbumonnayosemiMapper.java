package com.wetech.ryutsumodel.model.mapper;

import com.wetech.ryutsumodel.model.entity.Tmmbumonnayosemi;
import java.util.Date;
import java.util.List;

import com.wetech.ryutsumodel.model.entity.TmmbumonnayosemiExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TmmbumonnayosemiMapper {
    int deleteByPrimaryKey(@Param("jcmsaimutegataKbn") String jcmsaimutegataKbn, @Param("jcmnayosekanriCod") String jcmnayosekanriCod, @Param("jcmbumonCod") String jcmbumonCod, @Param("jcmtekiyostrYmd") Date jcmtekiyostrYmd);

    int insert(Tmmbumonnayosemi record);

    int insertSelective(Tmmbumonnayosemi record);

    Tmmbumonnayosemi selectByPrimaryKey(@Param("jcmsaimutegataKbn") String jcmsaimutegataKbn, @Param("jcmnayosekanriCod") String jcmnayosekanriCod, @Param("jcmbumonCod") String jcmbumonCod, @Param("jcmtekiyostrYmd") Date jcmtekiyostrYmd);

    int updateByPrimaryKeySelective(Tmmbumonnayosemi record);

    int updateByPrimaryKey(Tmmbumonnayosemi record);

    List<Tmmbumonnayosemi> selectByExample(TmmbumonnayosemiExample tmmbumonnayosemiExample);
}