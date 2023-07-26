package com.wetech.ryutsumodel.model.dto;

import lombok.Data;

@Data
public class MessageDto {
    /**
     * エラーID
     */
    private String errorID;

    /**
     * エラーメッセージ
     */
    private String errorMessage;
}
