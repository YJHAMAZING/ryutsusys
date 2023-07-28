package com.wetech.core.repository.micamst91;

import com.wetech.ryutsumodel.model.dto.TmmJininDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MicAMstA912ExtRepository {
    List<TmmJininDto> MicAMst91Sql002(@Param("tenshoCode") String tenshoCode);
}
