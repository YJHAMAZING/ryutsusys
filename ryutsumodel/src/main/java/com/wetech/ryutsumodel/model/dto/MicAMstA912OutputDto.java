package com.wetech.ryutsumodel.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class MicAMstA912OutputDto {
    /**
     * 人員Dtoリスト
     */
    private List<TmmJininDto> jininEntityList;
    /**
     * メッセージDtoリスト
     */
    private List<MessageDto> messageDtoList;
}
