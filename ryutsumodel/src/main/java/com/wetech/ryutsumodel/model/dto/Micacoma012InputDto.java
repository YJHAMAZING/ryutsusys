package com.wetech.ryutsumodel.model.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class Micacoma012InputDto {

    /**
     * 処理区分リスト
     */
    @NotEmpty(message = "MICACOME00001,処理区分")
    private List<String> shoriKbnList;

    /**
     * 店所コード
     */
    @Size(max = 6, message = "MICACOME00008")
    @Pattern(regexp = "^[A-Za-z0-9]*$", message = "MICACOME00206")
    private String tenCod;

    /**
     * 担当者コード
     */
    private String jikkoShainId;

    /**
     * 処理日From
     */
    @NotEmpty(message = "MICACOME0063,処理日From")
    @Pattern(regexp = "^\\d{4}/\\d{2}/\\d{2}$", message = "MICACOME00063,処理日From")
    private String shoribiFrom;

    /**
     * 処理日To
     */
    @NotEmpty(message = "MICACOME0063,処理日To")
    @Pattern(regexp = "^\\d{4}/\\d{2}/\\d{2}$", message = "MICACOME00063,処理日To")
    private String shoribiTo;

    /**
     * 処理ID
     */
    private String shoriId;

    /**
     * ステータスリスト
     */
    @NotEmpty(message = "MICACOME00001,ステータス")
    private List<String> statusList;

    /**
     * 検索フラグ 0:画面初期化　1:検索イベント
     */
    private String kensakuFlg;

    /**
     * 配下組織含むフラグ
     */
    private String childSoshikiFlg;

    /**
     * 組織階層区分
     */
    private String soshikiKbn;

    /**
     * ページ位置
     */
    private int currentPage;

}
