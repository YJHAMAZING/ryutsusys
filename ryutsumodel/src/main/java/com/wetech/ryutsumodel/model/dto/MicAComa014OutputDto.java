package com.wetech.ryutsumodel.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class MicAComa014OutputDto {
    /**
     * 会社情報リスト
     */
    private List<MicAComa014CompanyDto> comSosk6List;

    /**
     * ブロック情報リスト
     */
    private List<MicAComa014BlockDto> comSosk5List;

    /**
     * 特定支店情報リスト
     */
    private List<MicAComa014TokuteiShitenDto> comSosk4List;

    /**
     * 支店情報リスト
     */
    private List<MicAComa014ShitenDto> comSosk3List;

    /**
     * 店所情報リスト
     */
    private List<MicAComa014TenshoDto> comSosk2List;

    /**
     * 所属組織階層情報
     */
    private MicAComa014AffiliateSoskDto affiliateSosk;

    /**
     * 経理店判別区分
     */
    private int comKeiriKbn;
}
