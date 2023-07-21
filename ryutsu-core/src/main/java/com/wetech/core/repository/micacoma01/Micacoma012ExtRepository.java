package com.wetech.core.repository.micacoma01;

import com.wetech.ryutsumodel.model.dto.ShorijokyoDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
@Mapper
public interface Micacoma012ExtRepository {
    /**
     * 処理状況情報一覧取得
     * @return
     */
    List<ShorijokyoDto> findShorijyokyo(@Param("parameter") Map<String, Object> parameter);

    /**
     * 処理状況情報件数取得
     * @return
     */
    int findShorijyokyoCount(@Param("parameterCount") Map<String, Object> parameterCount);

}
