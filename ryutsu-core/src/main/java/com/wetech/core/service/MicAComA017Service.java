package com.wetech.core.service;

import com.wetech.ryutsumodel.model.dto.MicAComA017TenshoOutputDto;

public interface MicAComA017Service {
    /**
     * @param 店所情報取得入力Dto
     * @return 店所情報JSON
     * @exception APIException
     */
    MicAComA017TenshoOutputDto getTenshoInfo(String tenshoCode);
}
