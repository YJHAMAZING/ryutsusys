package com.wetech.ryutsumodel.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class MicAComA017TenshoOutputDto {

    /**
     * 店所情報取得結果Dto
     */
    private TenshoInfoDto tenshoInfoDto;

    /**
     * メッセージDtoリスト
     */
    private List<MessageDto> messageDtoList;
}
