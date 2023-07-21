package com.wetech.ryutsumodel.model.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ttmicshorijokyo implements Serializable {
    /**
    * SEQ
    */
    private Integer seq;

    /**
    * 処理ID
    */
    private String shoriId;

    /**
    * 処理開始日時
    */
    private Date shoriStartYmdhms;

    /**
    * 処理終了日時
    */
    private Date shoriEndYmdhms;

    /**
    * 入力ファイル名
    */
    private String uplFileKnj;

    /**
    * 入力ファイルバス
    */
    private String uplFilePath;

    /**
    * 出力ファイル名
    */
    private String dwlFileKnj;

    /**
    * 出力ファイルバス
    */
    private String dwlFilePath;

    /**
    * 処理区分
    */
    private String shoriKbn;

    /**
    * 処理ステータス
    */
    private String shoriStatus;

    /**
    * 実行ユーザID
    */
    private String jikkoShainCod;

    /**
    * メッセージ
    */
    private String msg;

    /**
    * バージョン
    */
    private Integer version;

    /**
    * 登録日時
    */
    private Date crtYmdhms;

    /**
    * 登録社員コード
    */
    private String crtshainCod;

    /**
    * 登録機能ID
    */
    private String crtFuncId;

    /**
    * 更新日時
    */
    private Date updYmdhms;

    /**
    * 更新社員コード
    */
    private String updshainCod;

    /**
    * 更新機能ID
    */
    private String updFuncId;

    private static final long serialVersionUID = 1L;
}