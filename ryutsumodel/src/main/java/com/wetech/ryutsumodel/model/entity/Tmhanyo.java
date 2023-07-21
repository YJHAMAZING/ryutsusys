package com.wetech.ryutsumodel.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tmhanyo implements Serializable {
    /**
    * 分類コード
    */
    private String bunruiCod;

    /**
    * 区分1
    */
    private String kbn1;

    /**
    * 区分2
    */
    private String kbn2;

    /**
    * 適用開始年月日
    */
    private Date tekiyostrYmd;

    /**
    * 区分名称1
    */
    private String kbnKnj1;

    /**
    * 区分名称2
    */
    private String kbnKnj2;

    /**
    * 文字1
    */
    private String str1;

    /**
    * 文字2
    */
    private String str2;

    /**
    * 文字3
    */
    private String str3;

    /**
    * 数値1
    */
    private Integer num1;

    /**
    * 数値2
    */
    private Integer num2;

    /**
    * 数値3
    */
    private Integer num3;

    /**
    * 数値（小数あり）1
    */
    private BigDecimal numShosuari1;

    /**
    * 数値（小数あり）2
    */
    private BigDecimal numShosuari2;

    /**
    * 数値（小数あり）3
    */
    private BigDecimal numShosuari3;

    /**
    * 表示順１
    */
    private Integer hyojijun1;

    /**
    * 表示順2
    */
    private Integer hyojijun2;

    /**
    * 表示順3
    */
    private Integer hyojijun3;

    /**
    * 汎用備考
    */
    private String hanyoBiko;

    /**
    * 適用終了年月日
    */
    private Date tekiyoendYmd;

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