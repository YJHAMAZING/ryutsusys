package com.wetech.ryutsumodel.model.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tmmjinin implements Serializable {
    /**
    * 従業員コード
    */
    private String comjugyoinCod;

    /**
    * 従雇区分
    */
    private Short comjukoKbn;

    /**
    * 店所コード(所属支店)
    */
    private String comsoztenCod;

    /**
    * 社員名称（姓）ー漢字
    */
    private String comshimeiseiKnj;

    /**
    * 社員名称（名）－漢字
    */
    private String comshimeimeiKnj;

    /**
    * 社員名称（姓）－カナ
    */
    private String comshimeiseiKna;

    /**
    * 社員名称（名）－カナ
    */
    private String comshimeimeiKna;

    /**
    * 社員名称（姓）－英字
    */
    private String comshimeiseiEng;

    /**
    * 社員名称（ミドルネーム）－英字
    */
    private String comshimeimdlEng;

    /**
    * 社員名称（名）－英字
    */
    private String comshimeimeiEng;

    /**
    * 役職区分
    */
    private Short comyakushokuKbn;

    /**
    * 職能資格区分
    */
    private String comshokunoKbn;

    /**
    * 従事業務区分１
    */
    private String comjujigyomu1Kbn;

    /**
    * 従事業務区分２
    */
    private String comjujigyomu2Kbn;

    /**
    * 従事業務区分３
    */
    private String comjujigyomu3Kbn;

    /**
    * 従事業務区分４
    */
    private String comjujigyomu4Kbn;

    /**
    * 従事業務区分５
    */
    private String comjujigyomu5Kbn;

    /**
    * パスワード
    */
    private String compasswordCod;

    /**
    * 郵便番号
    */
    private String comjtkZip;

    /**
    * 自宅住所（都道府県コード）
    */
    private String comjtkkenJis;

    /**
    * 自宅住所（市区町村コード）
    */
    private String comjtkshikuJis;

    /**
    * 自宅住所（補助住所コード）
    */
    private String comjtkhojoJis;

    /**
    * 自宅住所（丁目コード）
    */
    private String comjtkchomeJis;

    /**
    * 自宅住所（番）
    */
    private Integer comjtkadrbanNum;

    /**
    * 自宅住所（号）
    */
    private Integer comjtkadrgoNum;

    /**
    * 自宅住所（ビル名－カナ）
    */
    private String comjtkbldgnmKna;

    /**
    * 自宅住所（ビル名－漢字）
    */
    private String comjtkbldgnmKnj;

    /**
    * 振込人銀行コード
    */
    private String comfurbnkCod;

    /**
    * 振込人店舗銀行コード
    */
    private String comfurbnktnpCod;

    /**
    * 振込人口座人名（カナ）
    */
    private String comfurkozanmKna;

    /**
    * 振込人口座ＮＯ
    */
    private String comfurkozanoNum;

    /**
    * 預金種別区分
    */
    private Short comfuryknsbtKbn;

    /**
    * 電信区分
    */
    private Short comfurdsnKbn;

    /**
    * 手数料区分
    */
    private Short comfurtesuryoKbn;

    /**
    * 内線電話番号
    */
    private String comnaisenTel;

    /**
    * 内線FAX番号
    */
    private String comnaisenFax;

    /**
    * 兼務店所コード１
    */
    private String comkenmutenCod;

    /**
    * 兼務店所コード２
    */
    private String comkenmuten2Cod;

    /**
    * 兼務店所コード３
    */
    private String comkenmuten3Cod;

    /**
    * 兼務店所コード４
    */
    private String comkenmuten4Cod;

    /**
    * 兼務店所コード５
    */
    private String comkenmuten5Cod;

    /**
    * 兼務店所コード６
    */
    private String comkenmuten6Cod;

    /**
    * 兼務店所コード7
    */
    private String comkenmuten7Cod;

    /**
    * 兼務店所コード8
    */
    private String comkenmuten8Cod;

    /**
    * 兼務店所コード9
    */
    private String comkenmuten9Cod;

    /**
    * 兼務店所コード10
    */
    private String comkenmuten10Cod;

    /**
    * 業者コード
    */
    private String comgyoshaCod;

    /**
    * メールアドレス
    */
    private String comjugyoinMal;

    /**
    * 検索用カナ文字
    */
    private String comknsmojiKna;

    /**
    * 予備区分
    */
    private String comyobiKbn;

    /**
    * 適用開始年月日
    */
    private Date comtekiyostrYmd;

    /**
    * 適用終了年月日
    */
    private Date comtekiyoendYmd;

    /**
    * 登録年月日
    */
    private Date comcrtYmd;

    /**
    * 登録社員コード
    */
    private String comcrtshainCod;

    /**
    * 最新更新年月日
    */
    private Date comupdYmd;

    /**
    * 更新社員コード
    */
    private String comupdshainCod;

    private static final long serialVersionUID = 1L;
}