package com.wetech.ryutsumodel.model.dto;

import lombok.Data;

@Data
public class MicAMstA912InputDto {
    /**
     * 店所コード
     */
    private String tenshoCode;
    /**
     * 組織区分
     */
    private Short soshikiKbn;
    /**
     * 配下組織を含むフラグ
     */
    private int haikaFlg;
}
