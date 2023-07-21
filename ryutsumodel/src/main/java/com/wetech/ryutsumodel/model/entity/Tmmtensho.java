package com.wetech.ryutsumodel.model.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tmmtensho implements Serializable {
    /**
    * 店所名称１－カナ
    */
    private String comtennm1Kna;

    /**
    * 適用開始年月日
    */
    private Date comtekiyostrYmd;

    /**
    * 店所コード
    */
    private String comtenCod;

    /**
    * 社内外区分
    */
    private Short comnaigaiKbn;

    /**
    * 主要業種区分
    */
    private String comshugyoshuKbn;

    /**
    * 業種区分１
    */
    private String comgyoshu1Kbn;

    /**
    * 業種区分２
    */
    private String comgyoshu2Kbn;

    /**
    * 業種区分３
    */
    private String comgyoshu3Kbn;

    /**
    * 店格区分
    */
    private Short comtenkakuKbn;

    /**
    * 導入店区分
    */
    private String comdonyutenKbn;

    /**
    * 店所名称１－漢字
    */
    private String comtennm1Knj;

    /**
    * 店所名称２－漢字
    */
    private String comtennm2Knj;

    /**
    * 店所名称２－カナ
    */
    private String comtennm2Kna;

    /**
    * 店所名称１－英字
    */
    private String comtennm1Eng;

    /**
    * 店所名称２－英字
    */
    private String comtennm2Eng;

    /**
    * 店所漢字略称
    */
    private String comtenrnmKnj;

    /**
    * 店所住所（都道府県コード）
    */
    private String comtenkenJis;

    /**
    * 店所住所（市区町村コード）
    */
    private String comtenshikuJis;

    /**
    * 店所住所（補助住所コード）
    */
    private String comtenhojoJis;

    /**
    * 店所住所（丁目コード）
    */
    private String comtenchomeJis;

    /**
    * 店所住所（番）
    */
    private Integer comtenadrbanNum;

    /**
    * 店所住所（号）
    */
    private Integer comtenadrgoNum;

    /**
    * 店所住所-英字
    */
    private String comtenadrEng;

    /**
    * 店所住所（ビル名－カナ）
    */
    private String comtenbldgnmKna;

    /**
    * 店所住所（ビル名－漢字）
    */
    private String comtenbldgnmKnj;

    /**
    * 店所住所（ビル名-英字）
    */
    private String comtenbldgnmEng;

    /**
    * 郵便番号
    */
    private String comZip;

    /**
    * 外部向電話番号
    */
    private String comgaisenTel;

    /**
    * 社内連絡用電話番号
    */
    private String comrenrakuTel;

    /**
    * ＦＡＸ番号
    */
    private String comgaisenFax;

    /**
    * 内線電話番号
    */
    private String comnaisenTel;

    /**
    * 内線ＦＡＸ番号
    */
    private String comnaisenFax;

    /**
    * 部門用メールアドレス
    */
    private String combumonMal;

    /**
    * 関連業者コード
    */
    private String comgyoshaCod;

    /**
    * 検索用カナ文字
    */
    private String comknsmojiKna;

    /**
    * 検索用電話番号
    */
    private String comkensakuTel;

    /**
    * 予備区分
    */
    private String comyobiKbn;

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