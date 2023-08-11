package com.wetech.core.service;

import com.wetech.ryutsumodel.model.dto.MicAMstA912InputDto;
import com.wetech.ryutsumodel.model.dto.MicAMstA912OutputDto;

public interface MicAMstA912Service {
    /**
     * @param 担当者リスト取得入力Dto
     * @return 担当者情報JSON
     */
    public MicAMstA912OutputDto getTantosha(MicAMstA912InputDto inputDto);
}
