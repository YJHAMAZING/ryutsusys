package com.wetech.ryutsumodel.model.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class MicAComa014InputDto {

    /**
     * ロール
     */
    private String role;

    /**
     * 会社コード
     */
    @NotNull()
    @NotEmpty()
    private String companyCode;

    /**
     * ブロックコード
     */
    private String blockCode;

    /**
     * 特定支店コード
     */
    private String tokuteiShitenCode;

    /**
     * 支店コード
     */
    private String shitenCode;

    /**
     * 店所コード
     */
    private String tenshoCode;

    /**
     * 店格区分
     */
    private int tenkakuKbn;
}
