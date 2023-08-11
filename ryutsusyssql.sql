/*
SQLyog Ultimate v8.32 
MySQL - 5.7.24 : Database - ryutsusys
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`ryutsusys` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `ryutsusys`;

/*Table structure for table `tmhanyo` */

DROP TABLE IF EXISTS `tmhanyo`;

CREATE TABLE `tmhanyo` (
  `bunrui_cod` varchar(30) NOT NULL COMMENT '分類コード',
  `kbn1` char(2) NOT NULL COMMENT '区分1',
  `kbn_knj1` varchar(60) DEFAULT NULL COMMENT '区分名称1',
  `kbn2` char(2) NOT NULL DEFAULT '00' COMMENT '区分2',
  `kbn_knj2` varchar(60) DEFAULT NULL COMMENT '区分名称2',
  `str1` varchar(1000) DEFAULT NULL COMMENT '文字1',
  `str2` varchar(1000) DEFAULT NULL COMMENT '文字2',
  `str3` varchar(1000) DEFAULT NULL COMMENT '文字3',
  `num1` int(11) DEFAULT NULL COMMENT '数値1',
  `num2` int(11) DEFAULT NULL COMMENT '数値2',
  `num3` int(11) DEFAULT NULL COMMENT '数値3',
  `num_shosuari1` decimal(20,10) DEFAULT NULL COMMENT '数値（小数あり）1',
  `num_shosuari2` decimal(20,10) DEFAULT NULL COMMENT '数値（小数あり）2',
  `num_shosuari3` decimal(20,10) DEFAULT NULL COMMENT '数値（小数あり）3',
  `hyojijun1` int(11) DEFAULT NULL COMMENT '表示順１',
  `hyojijun2` int(11) DEFAULT NULL COMMENT '表示順2',
  `hyojijun3` int(11) DEFAULT NULL COMMENT '表示順3',
  `hanyo_biko` varchar(100) DEFAULT NULL COMMENT '汎用備考',
  `tekiyostr_ymd` date NOT NULL COMMENT '適用開始年月日',
  `tekiyoend_ymd` date NOT NULL COMMENT '適用終了年月日',
  `version` int(11) NOT NULL DEFAULT '1' COMMENT 'バージョン',
  `crt_ymdhms` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '登録日時',
  `crtshain_cod` char(10) NOT NULL COMMENT '登録社員コード',
  `crt_func_id` varchar(9) NOT NULL COMMENT '登録機能ID',
  `upd_ymdhms` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新日時',
  `updshain_cod` char(10) NOT NULL COMMENT '更新社員コード',
  `upd_func_id` varchar(9) NOT NULL COMMENT '更新機能ID',
  PRIMARY KEY (`bunrui_cod`,`kbn1`,`kbn2`,`tekiyostr_ymd`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tmhanyo` */

/*Table structure for table `tmmbumonnayosemi` */

DROP TABLE IF EXISTS `tmmbumonnayosemi`;

CREATE TABLE `tmmbumonnayosemi` (
  `jcmsaimutegata_kbn` char(1) NOT NULL COMMENT '債務手形区分',
  `jcmnayosekanri_cod` char(6) NOT NULL COMMENT '名寄管理コード',
  `jcmbumon_cod` char(6) NOT NULL COMMENT '部門コード',
  `jcmsaimukejo_kbn` char(1) DEFAULT NULL COMMENT '債務計上部門区分',
  `jcmtekiyostr_ymd` date NOT NULL COMMENT '適用開始年月日',
  `jcmtekiyoend_ymd` date DEFAULT NULL COMMENT '適用終了年月日',
  `jcmcrt_ymd` date DEFAULT NULL COMMENT '登録年月日',
  `jcmcrtshain_cod` char(10) DEFAULT NULL COMMENT '登録社員コード',
  `jcmupd_ymd` date DEFAULT NULL COMMENT '最新更新年月日',
  `jcmupdshain_cod` char(10) DEFAULT NULL COMMENT '更新社員コード',
  PRIMARY KEY (`jcmsaimutegata_kbn`,`jcmnayosekanri_cod`,`jcmbumon_cod`,`jcmtekiyostr_ymd`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tmmbumonnayosemi` */

/*Table structure for table `tmmjinin` */

DROP TABLE IF EXISTS `tmmjinin`;

CREATE TABLE `tmmjinin` (
  `comjugyoin_cod` char(10) NOT NULL COMMENT '従業員コード',
  `comjuko_kbn` smallint(6) DEFAULT NULL COMMENT '従雇区分',
  `comsozten_cod` char(6) DEFAULT NULL COMMENT '店所コード(所属支店)',
  `comshimeisei_knj` varchar(10) DEFAULT NULL COMMENT '社員名称（姓）ー漢字',
  `comshimeimei_knj` varchar(10) DEFAULT NULL COMMENT '社員名称（名）－漢字',
  `comshimeisei_kna` varchar(20) DEFAULT NULL COMMENT '社員名称（姓）－カナ',
  `comshimeimei_kna` varchar(20) DEFAULT NULL COMMENT '社員名称（名）－カナ',
  `comshimeisei_eng` varchar(35) DEFAULT NULL COMMENT '社員名称（姓）－英字',
  `comshimeimdl_eng` varchar(35) DEFAULT NULL COMMENT '社員名称（ミドルネーム）－英字',
  `comshimeimei_eng` varchar(35) DEFAULT NULL COMMENT '社員名称（名）－英字',
  `comyakushoku_kbn` smallint(6) DEFAULT NULL COMMENT '役職区分',
  `comshokuno_kbn` char(1) DEFAULT NULL COMMENT '職能資格区分',
  `comjujigyomu1_kbn` char(3) DEFAULT NULL COMMENT '従事業務区分１',
  `comjujigyomu2_kbn` char(3) DEFAULT NULL COMMENT '従事業務区分２',
  `comjujigyomu3_kbn` char(3) DEFAULT NULL COMMENT '従事業務区分３',
  `comjujigyomu4_kbn` char(3) DEFAULT NULL COMMENT '従事業務区分４',
  `comjujigyomu5_kbn` char(3) DEFAULT NULL COMMENT '従事業務区分５',
  `compassword_cod` varchar(256) DEFAULT NULL COMMENT 'パスワード',
  `comjtk_zip` varchar(8) DEFAULT NULL COMMENT '郵便番号',
  `comjtkken_jis` char(2) DEFAULT NULL COMMENT '自宅住所（都道府県コード）',
  `comjtkshiku_jis` char(3) DEFAULT NULL COMMENT '自宅住所（市区町村コード）',
  `comjtkhojo_jis` char(3) DEFAULT NULL COMMENT '自宅住所（補助住所コード）',
  `comjtkchome_jis` char(3) DEFAULT NULL COMMENT '自宅住所（丁目コード）',
  `comjtkadrban_num` int(11) DEFAULT NULL COMMENT '自宅住所（番）',
  `comjtkadrgo_num` int(11) DEFAULT NULL COMMENT '自宅住所（号）',
  `comjtkbldgnm_kna` varchar(140) DEFAULT NULL COMMENT '自宅住所（ビル名－カナ）',
  `comjtkbldgnm_knj` varchar(70) DEFAULT NULL COMMENT '自宅住所（ビル名－漢字）',
  `comfurbnk_cod` char(4) DEFAULT NULL COMMENT '振込人銀行コード',
  `comfurbnktnp_cod` char(3) DEFAULT NULL COMMENT '振込人店舗銀行コード',
  `comfurkozanm_kna` varchar(30) DEFAULT NULL COMMENT '振込人口座人名（カナ）',
  `comfurkozano_num` char(7) DEFAULT NULL COMMENT '振込人口座ＮＯ',
  `comfuryknsbt_kbn` smallint(6) DEFAULT NULL COMMENT '預金種別区分',
  `comfurdsn_kbn` smallint(6) DEFAULT NULL COMMENT '電信区分',
  `comfurtesuryo_kbn` smallint(6) DEFAULT NULL COMMENT '手数料区分',
  `comnaisen_tel` varchar(15) DEFAULT NULL COMMENT '内線電話番号',
  `comnaisen_fax` varchar(15) DEFAULT NULL COMMENT '内線FAX番号',
  `comkenmuten_cod` char(6) DEFAULT NULL COMMENT '兼務店所コード１',
  `comkenmuten2_cod` char(6) DEFAULT NULL COMMENT '兼務店所コード２',
  `comkenmuten3_cod` char(6) DEFAULT NULL COMMENT '兼務店所コード３',
  `comkenmuten4_cod` char(6) DEFAULT NULL COMMENT '兼務店所コード４',
  `comkenmuten5_cod` char(6) DEFAULT NULL COMMENT '兼務店所コード５',
  `comkenmuten6_cod` char(6) DEFAULT NULL COMMENT '兼務店所コード６',
  `comkenmuten7_cod` char(6) DEFAULT NULL COMMENT '兼務店所コード7',
  `comkenmuten8_cod` char(6) DEFAULT NULL COMMENT '兼務店所コード8',
  `comkenmuten9_cod` char(6) DEFAULT NULL COMMENT '兼務店所コード9',
  `comkenmuten10_cod` char(6) DEFAULT NULL COMMENT '兼務店所コード10',
  `comgyosha_cod` char(10) DEFAULT NULL COMMENT '業者コード',
  `comjugyoin_mal` varchar(100) DEFAULT NULL COMMENT 'メールアドレス',
  `comknsmoji_kna` varchar(40) DEFAULT NULL COMMENT '検索用カナ文字',
  `comyobi_kbn` char(1) DEFAULT NULL COMMENT '予備区分',
  `comtekiyostr_ymd` date NOT NULL COMMENT '適用開始年月日',
  `comtekiyoend_ymd` date DEFAULT NULL COMMENT '適用終了年月日',
  `comcrt_ymd` date DEFAULT NULL COMMENT '登録年月日',
  `comcrtshain_cod` char(10) DEFAULT NULL COMMENT '登録社員コード',
  `comupd_ymd` date DEFAULT NULL COMMENT '最新更新年月日',
  `comupdshain_cod` char(10) DEFAULT NULL COMMENT '更新社員コード',
  PRIMARY KEY (`comjugyoin_cod`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tmmjinin` */

/*Table structure for table `tmmsoshiki` */

DROP TABLE IF EXISTS `tmmsoshiki`;

CREATE TABLE `tmmsoshiki` (
  `comgyomu_kbn` smallint(6) NOT NULL COMMENT '業務区分',
  `comten_cod` char(6) NOT NULL COMMENT '店所コード',
  `comsosk1_cod` char(6) DEFAULT NULL COMMENT '組織コード１',
  `comsosknm11_knj` varchar(30) NOT NULL COMMENT '組織名称１１－漢字',
  `comsosknm21_knj` varchar(30) DEFAULT NULL COMMENT '組織名称２１－漢字',
  `comsosknm11_kna` varchar(60) DEFAULT NULL COMMENT '組織名称１１－カナ',
  `comsosknm21_kna` varchar(60) DEFAULT NULL COMMENT '組織名称２１－カナ',
  `comhyojijun1_num` int(11) DEFAULT NULL COMMENT '表示順１',
  `comsosk2_cod` char(6) DEFAULT NULL COMMENT '組織コード２',
  `comsosknm12_knj` varchar(30) DEFAULT NULL COMMENT '組織名称１２－漢字',
  `comsosknm22_knj` varchar(30) DEFAULT NULL COMMENT '組織名称２２－漢字',
  `comsosknm12_kna` varchar(60) DEFAULT NULL COMMENT '組織名称１２－カナ',
  `comsosknm22_kna` varchar(60) DEFAULT NULL COMMENT '組織名称２２－カナ',
  `comhyojijun2_num` int(11) DEFAULT NULL COMMENT '表示順２',
  `comsosk3_cod` char(6) DEFAULT NULL COMMENT '組織コード３',
  `comsosknm13_knj` varchar(30) DEFAULT NULL COMMENT '組織名称１３－漢字',
  `comsosknm23_knj` varchar(30) DEFAULT NULL COMMENT '組織名称２３－漢字',
  `comsosknm13_kna` varchar(60) DEFAULT NULL COMMENT '組織名称１３－カナ',
  `comsosknm23_kna` varchar(60) DEFAULT NULL COMMENT '組織名称２３－カナ',
  `comhyojijun3_num` int(11) DEFAULT NULL COMMENT '表示順３',
  `comsosk4_cod` char(6) DEFAULT NULL COMMENT '組織コード４',
  `comsosknm14_knj` varchar(30) DEFAULT NULL COMMENT '組織名称１４－漢字',
  `comsosknm24_knj` varchar(30) DEFAULT NULL COMMENT '組織名称２４－漢字',
  `comsosknm14_kna` varchar(60) DEFAULT NULL COMMENT '組織名称１４－カナ',
  `comsosknm24_kna` varchar(60) DEFAULT NULL COMMENT '組織名称２４－カナ',
  `comhyojijun4_num` int(11) DEFAULT NULL COMMENT '表示順４',
  `comsosk5_cod` char(6) DEFAULT NULL COMMENT '組織コード５',
  `comsosknm15_knj` varchar(30) DEFAULT NULL COMMENT '組織名称１５－漢字',
  `comsosknm25_knj` varchar(30) DEFAULT NULL COMMENT '組織名称２５－漢字',
  `comsosknm15_kna` varchar(60) DEFAULT NULL COMMENT '組織名称１５－カナ',
  `comsosknm25_kna` varchar(60) DEFAULT NULL COMMENT '組織名称２５－カナ',
  `comhyojijun5_num` int(11) DEFAULT NULL COMMENT '表示順５',
  `comsosk6_cod` char(6) DEFAULT NULL COMMENT '組織コード６',
  `comsosknm16_knj` varchar(30) DEFAULT NULL COMMENT '組織名称１６－漢字',
  `comsosknm26_knj` varchar(30) DEFAULT NULL COMMENT '組織名称２６－漢字',
  `comsosknm16_kna` varchar(60) DEFAULT NULL COMMENT '組織名称１６－カナ',
  `comsosknm26_kna` varchar(60) DEFAULT NULL COMMENT '組織名称２６－カナ',
  `comhyojijun6_num` int(11) DEFAULT NULL COMMENT '表示順６',
  `comsosk7_cod` char(6) DEFAULT NULL COMMENT '組織コード７',
  `comsosknm17_knj` varchar(30) DEFAULT NULL COMMENT '組織名称１７－漢字',
  `comsosknm27_knj` varchar(30) DEFAULT NULL COMMENT '組織名称２７－漢字',
  `comsosknm17_kna` varchar(60) DEFAULT NULL COMMENT '組織名称１７－カナ',
  `comsosknm27_kna` varchar(60) DEFAULT NULL COMMENT '組織名称２７－カナ',
  `comhyojijun7_num` int(11) DEFAULT NULL COMMENT '表示順７',
  `comsosk8_cod` char(6) DEFAULT NULL COMMENT '組織コード８',
  `comsosknm18_knj` varchar(30) DEFAULT NULL COMMENT '組織名称１８－漢字',
  `comsosknm28_knj` varchar(30) DEFAULT NULL COMMENT '組織名称２８－漢字',
  `comsosknm18_kna` varchar(60) DEFAULT NULL COMMENT '組織名称１８－カナ',
  `comsosknm28_kna` varchar(60) DEFAULT NULL COMMENT '組織名称２８－カナ',
  `comhyojijun8_num` int(11) DEFAULT NULL COMMENT '表示順８',
  `comsosk9_cod` char(6) DEFAULT NULL COMMENT '組織コード９',
  `comsosknm19_knj` varchar(30) DEFAULT NULL COMMENT '組織名称１９－漢字',
  `comsosknm29_knj` varchar(30) DEFAULT NULL COMMENT '組織名称２９－漢字',
  `comsosknm19_kna` varchar(60) DEFAULT NULL COMMENT '組織名称１９－カナ',
  `comsosknm29_kna` varchar(60) DEFAULT NULL COMMENT '組織名称２９－カナ',
  `comhyojijun9_num` int(11) DEFAULT NULL COMMENT '表示順９',
  `comsosk10_cod` char(6) DEFAULT NULL COMMENT '組織コード１０',
  `comsosknm110_knj` varchar(30) DEFAULT NULL COMMENT '組織名称１１０－漢字',
  `comsosknm210_knj` varchar(30) DEFAULT NULL COMMENT '組織名称２１０－漢字',
  `comsosknm110_kna` varchar(60) DEFAULT NULL COMMENT '組織名称１１０－カナ',
  `comsosknm210_kna` varchar(60) DEFAULT NULL COMMENT '組織名称２１０－カナ',
  `comhyojijun10_num` int(11) DEFAULT NULL COMMENT '表示順１０',
  `comyobi_kbn` char(1) DEFAULT NULL COMMENT '予備区分',
  `comtekiyostr_ymd` date NOT NULL COMMENT '適用開始年月日',
  `comtekiyoend_ymd` date DEFAULT NULL COMMENT '適用終了年月日',
  `comcrt_ymd` date DEFAULT NULL COMMENT '登録年月日',
  `comcrtshain_cod` char(10) DEFAULT NULL COMMENT '登録社員コード',
  `comupd_ymd` date DEFAULT NULL COMMENT '最新更新年月日',
  `comupdshain_cod` char(10) DEFAULT NULL COMMENT '更新社員コード',
  PRIMARY KEY (`comgyomu_kbn`,`comten_cod`,`comsosknm11_knj`,`comtekiyostr_ymd`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tmmsoshiki` */

/*Table structure for table `tmmtensho` */

DROP TABLE IF EXISTS `tmmtensho`;

CREATE TABLE `tmmtensho` (
  `comten_cod` char(6) DEFAULT NULL COMMENT '店所コード',
  `comnaigai_kbn` smallint(6) DEFAULT NULL COMMENT '社内外区分',
  `comshugyoshu_kbn` char(2) DEFAULT NULL COMMENT '主要業種区分',
  `comgyoshu1_kbn` char(2) DEFAULT NULL COMMENT '業種区分１',
  `comgyoshu2_kbn` char(2) DEFAULT NULL COMMENT '業種区分２',
  `comgyoshu3_kbn` char(2) DEFAULT NULL COMMENT '業種区分３',
  `comtenkaku_kbn` smallint(6) DEFAULT NULL COMMENT '店格区分',
  `comdonyuten_kbn` char(1) DEFAULT NULL COMMENT '導入店区分',
  `comtennm1_knj` varchar(30) DEFAULT NULL COMMENT '店所名称１－漢字',
  `comtennm2_knj` varchar(30) DEFAULT NULL COMMENT '店所名称２－漢字',
  `comtennm1_kna` varchar(60) NOT NULL COMMENT '店所名称１－カナ',
  `comtennm2_kna` varchar(60) DEFAULT NULL COMMENT '店所名称２－カナ',
  `comtennm1_eng` varchar(140) DEFAULT NULL COMMENT '店所名称１－英字',
  `comtennm2_eng` varchar(140) DEFAULT NULL COMMENT '店所名称２－英字',
  `comtenrnm_knj` varchar(16) DEFAULT NULL COMMENT '店所漢字略称',
  `comtenken_jis` char(2) DEFAULT NULL COMMENT '店所住所（都道府県コード）',
  `comtenshiku_jis` char(3) DEFAULT NULL COMMENT '店所住所（市区町村コード）',
  `comtenhojo_jis` char(3) DEFAULT NULL COMMENT '店所住所（補助住所コード）',
  `comtenchome_jis` char(3) DEFAULT NULL COMMENT '店所住所（丁目コード）',
  `comtenadrban_num` int(11) DEFAULT NULL COMMENT '店所住所（番）',
  `comtenadrgo_num` int(11) DEFAULT NULL COMMENT '店所住所（号）',
  `comtenadr_eng` varchar(240) DEFAULT NULL COMMENT '店所住所-英字',
  `comtenbldgnm_kna` varchar(140) DEFAULT NULL COMMENT '店所住所（ビル名－カナ）',
  `comtenbldgnm_knj` varchar(70) DEFAULT NULL COMMENT '店所住所（ビル名－漢字）',
  `comtenbldgnm_eng` varchar(120) DEFAULT NULL COMMENT '店所住所（ビル名-英字）',
  `com_zip` varchar(8) DEFAULT NULL COMMENT '郵便番号',
  `comgaisen_tel` varchar(15) DEFAULT NULL COMMENT '外部向電話番号',
  `comrenraku_tel` varchar(15) DEFAULT NULL COMMENT '社内連絡用電話番号',
  `comgaisen_fax` varchar(15) DEFAULT NULL COMMENT 'ＦＡＸ番号',
  `comnaisen_tel` varchar(15) DEFAULT NULL COMMENT '内線電話番号',
  `comnaisen_fax` varchar(15) DEFAULT NULL COMMENT '内線ＦＡＸ番号',
  `combumon_mal` varchar(100) DEFAULT NULL COMMENT '部門用メールアドレス',
  `comgyosha_cod` char(10) DEFAULT NULL COMMENT '関連業者コード',
  `comknsmoji_kna` varchar(120) DEFAULT NULL COMMENT '検索用カナ文字',
  `comkensaku_tel` varchar(13) DEFAULT NULL COMMENT '検索用電話番号',
  `comyobi_kbn` char(1) DEFAULT NULL COMMENT '予備区分',
  `comtekiyostr_ymd` date NOT NULL COMMENT '適用開始年月日',
  `comtekiyoend_ymd` date DEFAULT NULL COMMENT '適用終了年月日',
  `comcrt_ymd` date DEFAULT NULL COMMENT '登録年月日',
  `comcrtshain_cod` char(10) DEFAULT NULL COMMENT '登録社員コード',
  `comupd_ymd` date DEFAULT NULL COMMENT '最新更新年月日',
  `comupdshain_cod` char(10) DEFAULT NULL COMMENT '更新社員コード',
  PRIMARY KEY (`comtennm1_kna`,`comtekiyostr_ymd`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tmmtensho` */

/*Table structure for table `ttmicshorijokyo` */

DROP TABLE IF EXISTS `ttmicshorijokyo`;

CREATE TABLE `ttmicshorijokyo` (
  `seq` int(11) NOT NULL COMMENT 'SEQ',
  `shori_id` varchar(11) NOT NULL COMMENT '処理ID',
  `shori_start_ymdhms` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '処理開始日時',
  `shori_end_ymdhms` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '処理終了日時',
  `upl_file_knj` varchar(60) DEFAULT NULL COMMENT '入力ファイル名',
  `upl_file_path` varchar(1024) DEFAULT NULL COMMENT '入力ファイルバス',
  `dwl_file_knj` varchar(60) DEFAULT NULL COMMENT '出力ファイル名',
  `dwl_file_path` varchar(256) DEFAULT NULL COMMENT '出力ファイルバス',
  `shori_kbn` char(1) NOT NULL COMMENT '処理区分',
  `shori_status` char(1) NOT NULL COMMENT '処理ステータス',
  `jikko_shain_cod` char(10) NOT NULL COMMENT '実行ユーザID',
  `msg` varchar(60) DEFAULT NULL COMMENT 'メッセージ',
  `version` int(11) NOT NULL COMMENT 'バージョン',
  `crt-ymdhms` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '登録日時',
  `crtshain_cod` char(10) NOT NULL COMMENT '登録社員コード',
  `crt_func_id` varchar(9) NOT NULL COMMENT '登録機能ID',
  `upd_ymdhms` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新日時',
  `updshain_cod` char(10) NOT NULL COMMENT '更新社員コード',
  `upd_func_id` varchar(9) NOT NULL COMMENT '更新機能ID',
  PRIMARY KEY (`seq`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `ttmicshorijokyo` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
