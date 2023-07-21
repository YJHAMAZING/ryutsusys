package com.wetech.ryutsumodel.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class Micacoma012OutputDto {
    /**
     * ページングDto
     */
    private PagingDto pagingInfo;

    /**
     * 処理状況情報Dtoリスト
     */
    private List<ShorijokyoDto> shorijyokyoList;

    /**
     * メッセージDtoリスト
     */
    private List<MsgDto> msgList;

    /**
     * 処理情報Dtoリスト
     */
    private List<ShoriInfoDto> shoriInfoList;

    /**
     * 画面フォーカス項目
     */
    private String focusItem;

    /**
     * 処理区分（日本語名）リスト
     */
    private List<String> shoriKbnList;

    /**
     * 処理ステータス（日本語名）リスト
     */
    private List<String> statusList;
}
