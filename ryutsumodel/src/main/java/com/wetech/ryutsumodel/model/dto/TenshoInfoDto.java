package com.wetech.ryutsumodel.model.dto;

import lombok.Data;

@Data
public class TenshoInfoDto {

    /**
     * 会社名
     */
    private String companyName;

    /**
     * ブロック
     */
    private String block;

    /**
     * 特定支店
     */
    private String tokuteiShiten;

    /**
     * 支店
     */
    private String shiten;

    /**
     * 課所
     */
    private String kasho;

    /**
     * デポ
     */
    private String depo;

    /**
     * 店所コード
     */
    private String tenshoCode;

    /**
     * 外線電話番号
     */
    private String gaisenTel;
    
}
