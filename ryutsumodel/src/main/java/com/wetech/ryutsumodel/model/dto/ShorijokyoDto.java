package com.wetech.ryutsumodel.model.dto;

import lombok.Data;

@Data
public class ShorijokyoDto {
    /**
     * 処理開始日時
     */
    private String shoriStart;

    /**
     * 処理終了日時
     */
    private String shoriEnd;

    /**
     * 処理ID
     */
    private String shoriId;

    /**
     * 処理名称
     */
    private String shoriName;

    /**
     *
     * 処理区分
     */
    private String shoriKbn;

    /**
     *
     * 実行ユーザ名
     */
    private String jikouUserName;

    /**
     *
     *ステータス
     */
    private String shoriStatus;

    /**
     *
     * 入力ファイル名
     */
    private String uplFileKnj;

    /**
     *
     * 入力ファイルパス
     */
    private String uplFilePath;

    /**
     *
     * 出力ファイル名
     */
    private String dwlFileKnj;

    /**
     *
     * 出力ファイルパス
     */
    private String dwlFilePath;

    /**
     *
     * メッセージ
     */
    private String msg;

    /**
     *
     * バケット名
     */
    private String bucketName;
}
