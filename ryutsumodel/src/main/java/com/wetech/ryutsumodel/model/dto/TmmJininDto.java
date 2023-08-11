package com.wetech.ryutsumodel.model.dto;

import lombok.Data;

@Data
public class TmmJininDto {
    /**
     * 担当者コード
     */
    private String tantoshaCode;
    /**
     * 担当者名(姓)
     */
    private String tantoshaNameSei;
    /**
     * 担当者名(名)
     */
    private String tantoshaNameMei;
}
