/*
 * システム名 :新請求システム
 * サブシステム名 :共通
 *
 * 注意事項 :
 *
 * Copyright:
 * All Rights Reserved Copyright (C) NIPPON EXPRESS  2022
 *
 */
package com.wetech.core.common;

import org.springframework.stereotype.Component;

/**
 * 定数クラス
 * <pre>
 * [変更履歴]
 * 1.0 2022/11/01   新規作成
 * </pre>
 * @version version 1.0 2022/11/01
 * @author  富士通）李
 * @see  String*
 */
@Component
public class CommonConst {

    public final static String ROLE = "role";
    //権限種類
    public static final String ROLE_NITTSU_SSC = "81";
    public static final String ROLE_NITTSU_SYSTEM = "99";

    public final static String FUNC_ID = "func_id";
    
    //共通項目ヘッダーキー
    public static final String SHOTEN_COD = "shoten_cod";

    /** ファイル関連 */
    // 拡張子.csv
    public static final String EXTENSION_CSV = ".csv";
    
    // 文字コード.UTF-8
    public static final String CHARACTER_CODE_UTF8 = "UTF-8";
    
    // 改行コード.\r\n
    public static final String NEW_LINE_CODE_CRLF = "\r\n";
    // 改行コード.\n
    public static final String NEW_LINE_CODE_LF = "\n";
    
    
    /** フォーマット */
    // 日付フォーマット.YYYYMMDD
    public static final String DATE_FORMAT_YYYYMMDD = "yyyyMMdd";
    // 日付フォーマット.yyyy/MM/dd
    public static final String DATE_FORMAT_YYYY_MM_DD = "yyyy/MM/dd";
    
    // 日付フォーマット.YYYYMMDDHHMISSMS
    public static final String DATE_FORMAT_YYYYMMDDHHMISSMS = "yyyyMMdd_HHmmssSS";
    
    // 日付フォーマット.YYYY-MM-DD hh:mm:ss
    public static final String DATE_FORMAT_TIMESTAMP = "yyyy-MM-dd HH:mm:ss";
    
    // 時刻フォーマット.HHMI
    public static final String DATE_FORMAT_HHMM = "HHmm";
    
    // 業務区分
    public static final Short GYOMU_KBN = 21;
    
    
    /** 項目区分値 */
    // 汎用マスタ.区分1
    public static final String HANYO_KBN1 = "01";
    
    // 汎用マスタ.区分2
    public static final String HANYO_KBN2 = "00";

    // 汎用マスタ.領収証ファイル用
    public static final String RYO = "ryo";

    // 汎用マスタ.請求書ファイル用
    public static final String SEI = "sei";
    
    /** ファイルパス */
    // 取込対象外ファイル退避先パス.その他
    public static final String NOT_INCLUDE_LIST_DIR_ANOTHER = "/nhs/iko/";
    
    // エラーファイル退避先パス
    //TODO:後決め
    public static final String ERROR_LIST_DIR = "/error/";
    
    // アップロードファイル用ローカルディレクトリ
    
    // ダウンロードファイル用ローカルディレクトリ
    
    
    /** ファイル名称 */
    // エラーファイル名称
    //TODO:後決め
    public static final String ERROR_FILE_NAME = "error_";
    
    /** 機能ID */
    // 機能ID.処理状況照会
    public static final String FUNCTION_ID_MICACOMA01 = "micacoma01";
    
    
    /** チェック関連 */
    // true
    public static final String CHECK_TRUE = "true";
    
    // false
    public static final String CHECK_FALSE = "false";
    
    // チェックリスト.index
    public static final String CHECK_LIST_INDEX = "index";
    
    // チェックリスト.name
    public static final String CHECK_LIST_NAME = "name";
    
    // チェックリスト.requiredCheckFlg
    public static final String CHECK_LIST_REQUIRED_CHECK = "requiredCheckFlg";
    
    // チェックリスト.numCheckFlg
    public static final String CHECK_LIST_NUM_CHECK = "numCheckFlg";
    
    // チェックリスト.dateCheckFlg
    public static final String CHECK_LIST_DATE_CHECK = "dateCheckFlg";
    
    // チェックリスト.timeCheckFlg
    public static final String CHECK_LIST_TIME_CHECK = "timeCheckFlg";
    
    // チェックリスト.byteCheckFlg
    public static final String CHECK_LIST_BYTE_CHECK = "byteCheckFlg";
    
    // チェックリスト.length
    public static final String CHECK_LIST_LENGTH = "length";
    
    // チェックRESULT.result
    public static final String CHECK_RESULT_RESULT = "result";
    
    // チェックRESULT.itemName
    public static final String CHECK_RESULT_ITEM_NAME = "itemName";
    
    
    // チェック名称.起動パラメータ
    public static final String CHECK_NAME_STARTUP_PARAM = "起動パラメータチェック";
    
    // チェック名称.形式チェック
    public static final String CHECK_NAME_FORMAT = "形式チェック";
    
    // チェック名称.項目数チェック
    public static final String CHECK_NAME_ITEM_COUNT = "項目数チェック";
    
    // チェック名称.店所コードチェック
    public static final String CHECK_NAME_TENSHO_CD = "店所コードチェック";
    
    // チェック名称.決済顧客マスタチェック
    public static final String CHECK_NAME_KESSAI_KOKYAKU_MST = "決済顧客マスタチェック";
    
    // チェック名称.作業店顧客マスタチェック
    public static final String CHECK_NAME_SAGYOUTEN_KOKYAKU_MST = "作業店顧客マスタチェック";
    
    // チェック名称.商品マスタチェック
    public static final String CHECK_NAME_SHOHIN_MST = "商品マスタチェック";
    
    // チェック名称.コード値チェック
    public static final String CHECK_NAME_CODE = "コード値チェック";
    
    // チェック名称.主キー重複チェック
    public static final String CHECK_NAME_KEY_DUPLICATE = "主キー重複チェック";
    
    // チェック名称.属性チェック
    public static final String CHECK_NAME_REQUIRED = "必須チェック";
    
    // チェック名称.属性チェック
    public static final String CHECK_NAME_TYPE = "属性チェック";
    
    // チェック名称.バイト数チェック
    public static final String CHECK_NAME_BYTE = "バイト数チェック";
    
    // チェック名称.レコード存在チェック
    public static final String CHECK_NAME_RECORD_EXIST = "レコード存在チェック";
    
    
    /** テーブル名 */
    // テーブル名称.汎用マスタ
    public static final String TABLE_NAME_TMHANYO = "汎用マスタ";
    
    // テーブル名称.店所マスタ
    public static final String TABLE_NAME_TMMTENSHO = "店所マスタ";
    
    // テーブル名称.決済顧客マスタ
    public static final String TABLE_NAME_TMMKOKYAKUKESSAI = "決済顧客マスタ";
    
    // テーブル名称.作業店顧客マスタ
    public static final String TABLE_NAME_TMMKOKYAKUSAGYO = "作業店顧客マスタ";
    
    // テーブル名称.商品マスタ
    public static final String TABLE_NAME_TMMSHOHIN = "商品マスタ";
    
    // テーブル名称.MIC取引データ（請求明細管理情報）テーブル
    public static final String TABLE_NAME_TJTORIHKDTSKMSKRINFO = "MIC取引データ（請求明細管理情報）テーブル";
    
    // テーブル名称.移行期間用MIC取引データ（売上）テーブル
    public static final String TABLE_NAME_TIKOJTORIHIKIDATAURIAGE = "移行期間用MIC取引データ（売上）テーブル";
    
    // テーブル名称.MIC訂正データ（請求明細）テーブル
    public static final String TABLE_NAME_TJTEISEIDTSKMS = "MIC訂正データ（請求明細）テーブル";
    
    // テーブル名称.MIC取引データ（請求明細印字情報）テーブル
    public static final String TABLE_NAME_TJTORIHKDTSKMSIJINFO = "MIC取引データ（請求明細印字情報）テーブル";
    
    // テーブル名称.MIC取引データ（紐付）テーブル
    public static final String TABLE_NAME_TJTORIHIKIDTHIMOZUKE = "MIC取引データ（紐付）テーブル";
    
    // テーブル名称.業務別店格マスタ
    public static final String TABLE_NAME_TMMGYOMUTENKAKU = "業務別店格マスタ";
    
    // テーブル名称.組織マスタ
    public static final String TABLE_NAME_TMMSOSHIKI = "組織マスタ";
    
    /** 項目名称 */
    // 項目名称.起動パラメータ
    public static final String ITEM_NAME_STARTUP_PARAM = "起動パラメータ";

    /** 処理名称 */
    // 処理名称.汎用マスタ参照
    public static final String PROCESS_NAME_SELECT_HANYO_MST = "汎用マスタ参照";
    
    
    // 結果コード
    public static final String RESULT_CODE = "resultCode";
    
    // 結果コード 正常終了
    public static final String RESULT_CODE_SUCCESS = "0";
    
    // 結果コード 一部警告あり
    public static final String RESULT_CODE_WARN = "2";
    
    // 結果コード 異常終了
    public static final String RESULT_CODE_ERROR = "9";
       
    // 拡張子 json
    public static final String EXTENSION_JSON = ".json";
    
    // 拡張子 テキスト
    public static final String EXTENSION_TXT = ".txt";
    
    // 62進数
    public static final String HEXADECIMAL_62 = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    // 上限件数
    public static final int LIMIT_TOTAL_COUNT = 10000;

    
    /** テーブル名 */
    // MIC取引データ（請求明細管理情報）テーブル
    public static final String TBL_NM_T_SKM_KANRI = "MIC取引データ（請求明細管理情報）テーブル";
    
    // MIC作業店顧客マスタ
    public static final String TBL_NM_M_SAG_KOKYAKU = "MIC作業店顧客マスタ";
    
    // 決済顧客マスタ
    public static final String TBL_NM_M_KSS_KOKYAKU = "決済顧客マスタ";
    
    // MIC代表請求マスタ
    public static final String TBL_NM_M_DAIHYO_SEI = "MIC代表請求マスタ";
    
    // 汎用マスタ
    public static final String TBL_NM_M_HANYO = "汎用マスタ";
    
    // MICフロント独自マスタ
    public static final String TBL_NM_M_DOKUJI = "MICフロント独自マスタ";
    
    // MIC請求確定鑑テーブル
    public static final String TBL_NM_T_KAKUTEI_KGM = "MIC請求確定鑑テーブル";
    
    
    /** メッセージID */
    // メッセージID.MICACOMI00007
    public static final String MESSAGE_ID_MICACOMI00007 = "MICACOMI00007";
    
    // メッセージID.MICACOMI00013
    public static final String MESSAGE_ID_MICACOMI00013 = "MICACOMI00013";
    
    // メッセージID.MICACOMI00008
    public static final String MESSAGE_ID_MICACOMI00008 = "MICACOMI00008";

    // メッセージID.MICACOME00002
    public static final String MESSAGE_ID_MICACOME00002 = "MICACOME00002";

    // メッセージID.MICACOME00003
    public static final String MESSAGE_ID_MICACOME00003 = "MICACOME00003";

    // メッセージID.MICACOME00004
    public static final String MESSAGE_ID_MICACOME00004 = "MICACOME00004";

    // メッセージID.MICACOME00005
    public static final String MESSAGE_ID_MICACOME00005 = "MICACOME00005";
    
    // メッセージID.MICACOME00032
    public static final String MESSAGE_ID_MICACOME00032 = "MICACOME00032";
    
    // メッセージID.MICACOME00036
    public static final String MESSAGE_ID_MICACOME00036 = "MICACOME00036";
    
    // メッセージID.MICACOME00043
    public static final String MESSAGE_ID_MICACOME00043 = "MICACOME00043";
    
    // メッセージID.MICACOME00044
    public static final String MESSAGE_ID_MICACOME00044 = "MICACOME00044";

    // メッセージID.MICACOME00050
    public static final String MESSAGE_ID_MICACOME00050= "MICACOME00050";
    
    // メッセージID.MICACOME00052
    public static final String MESSAGE_ID_MICACOME00052 = "MICACOME00052";

    // メッセージID.MICACOME00054
    public static final String MESSAGE_ID_MICACOME00054 = "MICACOME00054";
    
    // メッセージID.MICACOME00055
    public static final String MESSAGE_ID_MICACOME00055 = "MICACOME00055";
    
    // メッセージID.MICACOME00069
    public static final String MESSAGE_ID_MICACOME00069 = "MICACOME00069";

    // メッセージID.MICACOMW00001
    public static final String MESSAGE_ID_MICACOMW00001 = "MICACOMW00001";

    // メッセージID.MICACOMW00002
    public static final String MESSAGE_ID_MICACOMW00002 = "MICACOMW00002";
    
    // メッセージID.MICACOMW00003
    public static final String MESSAGE_ID_MICACOMW00003 = "MICACOMW00003";

    // メッセージID.MICACOMW00016
    public static final String MESSAGE_ID_MICACOMW00016 = "MICACOMW00016";

    // メッセージID.MICACOMD00001
    public static final String MESSAGE_ID_MICACOMD00001 = "MICACOMD00001";
    
    
    // メッセージID.MICACOME00037
    public static final String MESSAGE_ID_MICACOME00037 = "MICACOME00037";
    
    // メッセージID.MICACOME00038
    public static final String MESSAGE_ID_MICACOME00038 = "MICACOME00038";
    
    // メッセージID.MICACOME00039
    public static final String MESSAGE_ID_MICACOME00039 = "MICACOME00039";
    
    // メッセージID.MICACOME00040
    public static final String MESSAGE_ID_MICACOME00040 = "MICACOME00040";
    
    // メッセージID.MICACOME00041
    public static final String MESSAGE_ID_MICACOME00041 = "MICACOME00041";
    
    // メッセージID.MICACOME00056
    public static final String MESSAGE_ID_MICACOME00056 = "MICACOME00056";
    
    // メッセージID.MICACOME00057
    public static final String MESSAGE_ID_MICACOME00057 = "MICACOME00057";
    
    // メッセージID.MICACOME00058
    public static final String MESSAGE_ID_MICACOME00058 = "MICACOME00058";
    
    // メッセージID.MICACOME00059
    public static final String MESSAGE_ID_MICACOME00059 = "MICACOME00059";
    
    // メッセージID.MICACOME00062
    public static final String MESSAGE_ID_MICACOME00062 = "MICACOME00062";
    
    // メッセージID.MICACOME00068
    public static final String MESSAGE_ID_MICACOME00068 = "MICACOME00068";
    
    // メッセージID.MICACOME00070
    public static final String MESSAGE_ID_MICACOME00070 = "MICACOME00070";
    
    // メッセージID.MICACOMW00005
    public static final String MESSAGE_ID_MICACOMW00005 = "MICACOMW00005";
    
    // メッセージID.MICACOMW00006
    public static final String MESSAGE_ID_MICACOMW00006 = "MICACOMW00006";
    
    // メッセージID.MICACOME00042
    public static final String MESSAGE_ID_MICACOME00042 = "MICACOME00042";
    
    // メッセージID.MICACOMW00004
    public static final String MESSAGE_ID_MICACOMW00004 = "MICACOMW00004";
    
    // メッセージID:MICACOME00227
    public static final String MESSAGE_ID_MICACOME00227 = "MICACOME00227";

    
    private CommonConst(){} 
    
}
