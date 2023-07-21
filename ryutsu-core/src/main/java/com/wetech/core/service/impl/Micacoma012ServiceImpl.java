package com.wetech.core.service.impl;

import com.wetech.core.common.*;
import com.wetech.core.repository.micacoma01.Micacoma012ExtRepository;
import com.wetech.core.repository.micamst91.MicAMstA911ExtRepository;
import com.wetech.core.service.Micacoma012Servie;
import com.wetech.ryutsumodel.model.dto.*;
import com.wetech.ryutsumodel.model.entity.*;
import com.wetech.ryutsumodel.model.mapper.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

import static java.util.stream.Collectors.toList;

@Service
public class Micacoma012ServiceImpl implements Micacoma012Servie {

    @Autowired
    private TmhanyoMapper tmhanyoMapper;

    @Autowired
    private TmmjininMapper tmmjininMapper;

    @Autowired
    private TmmtenshoMapper tmmtenshoMapper;

    @Autowired
    private TmmsoshikiMapper tmmsoshikiMapper;

    @Autowired
    private TmmbumonnayosemiMapper tmmbumonnayosemiMapper;

    @Autowired
    private Micacoma012ExtRepository micacoma012ExtRepository;

    @Autowired
    private MicAMstA911ExtRepository micAMstA911Mapper;

    @Autowired
    private MessageUtil messageUtil;
    /**
     * 共通UTIL
     */
    @Autowired
    private MstCommon mstCommon;

    // 処理区分取得
    private Map<String,String> shoriKbnList = new HashMap<>();

    // 処理ステータス
    private Map<String,String> statusList = new LinkedHashMap<>();

    // 共通定数
    private static final String NUMBERZERO = "0";
    private static final String NUMBERONE = "1";
    private static final String NUMBERTWO = "2";
    private static final String NUMBERTHREE = "3";
    private static final String NUMBERFOUR = "4";
    private static final String NUMBERFIVE = "5";
    private static final String NUMBERSIX = "6";
    private static final String SHORIID = "SHORI_ID";
    private static final String SHORIKBN1 = "UPLOAD";
    private static final String SHORI_KBN = "SHORI_KBN";
    private static final String SHORI_STATUS = "SHORI_STATUS";
    private static final String STATUS1 = "正常終了";
    private static final String STATUS2 = "エラー";
    private static final String TENSHO_CODE = "tenshoCode";
    private static final String SHORIBI_TO = "shoribiTo";

    // 業務区分
    private static final Short GYOMU_KBN = 21;

    // ページサイズ
    private static final int PAGE_SIZE = 100;

    // システム日付取得
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(CommonConst.DATE_FORMAT_YYYYMMDD);
    String format = simpleDateFormat.format(new Date());
    Date systemDate;

    /**
     * 処理状況検索
     * @param micacoma012InputDto
     * @param role
     * @return
     * @throws ParseException
     */
    @Override
    public Micacoma012OutputDto syoriJyokyoSearch(Micacoma012InputDto micacoma012InputDto, List<String> role) throws ParseException, ApiException {

        // 変数の初期化
        Micacoma012OutputDto micacoma012OutputDto = new Micacoma012OutputDto();
        List<ShorijokyoDto> syorijyokyoListOut = new ArrayList<>();

        // 処理情報Dtoリスト
        List<ShoriInfoDto> syoriInfoListOut = new ArrayList<>();
        List<MsgDto> msgListOut = new ArrayList<>();
        PagingDto pagingDtoOut = new PagingDto();

        // 画面フォーカス項目
        String focus = "";

        // 検索フラグ
        String kensakuFlg = micacoma012InputDto.getKensakuFlg();
        systemDate = currentTime();
        // チェックボックスのオプション取得
        // SHORI_KBN:処理区分
        shoriKbnList = findTmhanyo(SHORI_KBN, systemDate);
        // SHORI_STATUS:処理ステータス
        statusList = findTmhanyo(SHORI_STATUS, systemDate);

        // 出力設定
        // ステータス
        micacoma012OutputDto.setStatusList(new ArrayList<>(statusList.values()));
        // 処理区分
        micacoma012OutputDto.setShoriKbnList(new ArrayList<>(shoriKbnList.values()));

        // 入力パラメータ.検索フラグは「0：初期表示」の場合
        if (StringUtils.equals(NUMBERZERO, kensakuFlg)) {
            syoriInfoListOut = getSyoriInfoList();
        }

        // 入力パラメータ.検索フラグは「1」の場合(検索イベント)
        if (StringUtils.equals(NUMBERONE, kensakuFlg)) {
            // 処理区分リスト
            List<String> shoriList = micacoma012InputDto.getShoriKbnList();
            List<String> shoriKbnConv = getShoriKbnConv(shoriList);

            // ステータスリスト
            List<String> shoriStatusList =  micacoma012InputDto.getStatusList();
            List<String> shoriStatusConv = getShoriStatusConv(shoriStatusList);

            // 担当者コード
            String tantoCod = micacoma012InputDto.getJikkoShainId();

            // 処理ID
            String shoriId = micacoma012InputDto.getShoriId();

            // 関連チェック
            LocalDate shoribiFrom = CommonConvertUtil.stringToLocalDate(micacoma012InputDto.getShoribiFrom(),
                    CommonConst.DATE_FORMAT_YYYY_MM_DD);
            LocalDate shoribiTo = CommonConvertUtil.stringToLocalDate(micacoma012InputDto.getShoribiTo(),
                    CommonConst.DATE_FORMAT_YYYY_MM_DD);

            // 入力チェック
            Micacoma012OutputDto checkResult = gyomuCheck(micacoma012InputDto, shoribiFrom, shoribiTo);
            if (StringUtils.isNotEmpty(checkResult.getFocusItem())) {
                return checkResult;
            }

            //店所コード情報取得
            List<String> comtenCodList = getComtenCodList(micacoma012InputDto);

            // ページ情報
            int totalPageCout = -1;
            int totalDataCout = -1;
            int currentPage  = -1;

            try {
                Map<String, Object> parameterCount = new HashMap<>();
                parameterCount.put("shoriKbnList" , shoriKbnConv);
                parameterCount.put("comTenCodList" , comtenCodList);
                parameterCount.put("jikkoShainId" , tantoCod);
                parameterCount.put("shoribiFrom" , Timestamp.valueOf(String.valueOf(shoribiFrom) + " 00:00:00"));
                parameterCount.put(SHORIBI_TO , Timestamp.valueOf(String.valueOf(shoribiTo) + " 23:59:59"));
                parameterCount.put("shoriId" , shoriId);
                parameterCount.put("statusList" , shoriStatusConv);
                parameterCount.put("comBunruiCd" , SHORIID);
                parameterCount.put("currentDate" , new Date());
                // 処理状況情報件数取得
                totalDataCout = micacoma012ExtRepository.findShorijyokyoCount(parameterCount);

                if(totalDataCout <= 0) {
                    MsgDto msgDto = new MsgDto(CommonConst.MESSAGE_ID_MICACOMW00001,
                            messageUtil.getMessage(CommonConst.MESSAGE_ID_MICACOMW00001, "処理状況照会"));
                    msgListOut.add(msgDto);
                } else {
                    //現在のページの取得
                    currentPage = getCurrentPage(micacoma012InputDto, totalDataCout);
                    int offsetCount = (currentPage-1) * PAGE_SIZE;
                    List<ShorijokyoDto> shorijyokyoList;

                    parameterCount.put("pageNo" , offsetCount);
                    parameterCount.put("pageSize" , PAGE_SIZE);

                    if (totalDataCout > CommonConst.LIMIT_TOTAL_COUNT) {
                        totalDataCout = CommonConst.LIMIT_TOTAL_COUNT;
                        MsgDto msgDto = new MsgDto(CommonConst.MESSAGE_ID_MICACOMW00016,
                                messageUtil.getMessage(CommonConst.MESSAGE_ID_MICACOMW00016, String.valueOf(CommonConst.LIMIT_TOTAL_COUNT)));
                        msgListOut.add(msgDto);
                    }
                    // 処理状況ワークリストを取得
                    shorijyokyoList = micacoma012ExtRepository.findShorijyokyo(parameterCount);
                    // 画面データ変換
                    syorijyokyoListOut = getSyorijyokyoListOut(shorijyokyoList);
                }
                totalPageCout = (totalDataCout % PAGE_SIZE) == 0 ? (totalDataCout/PAGE_SIZE) : (totalDataCout/PAGE_SIZE + 1);
                pagingDtoOut.setCurrentPage(currentPage);
                pagingDtoOut.setTotalDataCount(totalDataCout);
                pagingDtoOut.setTotalPageCount(totalPageCout);
            } catch (Exception e) {
                throw new ApiException(CommonConst.MESSAGE_ID_MICACOME00005);
            }
        }

        // 戻り値を設定。
        micacoma012OutputDto.setFocusItem(focus);
        micacoma012OutputDto.setMsgList(msgListOut);
        micacoma012OutputDto.setPagingInfo(pagingDtoOut);
        micacoma012OutputDto.setShoriInfoList(syoriInfoListOut);
        micacoma012OutputDto.setShorijyokyoList(syorijyokyoListOut);

        return micacoma012OutputDto;
    }

    /**
     * 現在のページの取得
     * @param micacoma012InputDto
     * @param totalDataCout
     * @return
     */
    private Integer getCurrentPage(Micacoma012InputDto micacoma012InputDto, Integer totalDataCout){
        int currentPageNumber = micacoma012InputDto.getCurrentPage();
        if (currentPageNumber > totalDataCout) {
            currentPageNumber = totalDataCout;
        }
        if (currentPageNumber <= 0) {
            currentPageNumber = 1;
        }
        return currentPageNumber;
    }

    /**
     * 処理区分リスト
     * @param shoriList
     * @return
     */
    private List<String> getShoriKbnConv(List<String> shoriList){

        List<String> shoriKbnConv = new ArrayList<>();
        for (String shoriKbn : shoriList) {
            if (shoriKbn.equals(SHORIKBN1)) {
                shoriKbnConv.add(NUMBERONE);
            } else {
                shoriKbnConv.add(NUMBERTWO);
            }
        }
        return shoriKbnConv;
    }

    /**
     * ステータスリスト
     * @param shoriStatusList
     * @return
     */
    private List<String> getShoriStatusConv(List<String> shoriStatusList){
        List<String> shoriStatusConv = new ArrayList<>();
        for (String shoriStatus : shoriStatusList) {
            if (shoriStatus.equals(STATUS1)) {
                shoriStatusConv.add(NUMBERONE);
            } else if (shoriStatus.equals(STATUS2)) {
                shoriStatusConv.add(NUMBERTWO);
            } else {
                shoriStatusConv.add(NUMBERZERO);
            }
        }

        return shoriStatusConv;
    }

    /**
     * 店所コード情報取得
     * @param micacoma012InputDto
     * @return
     */
    private List<String> getComtenCodList(Micacoma012InputDto micacoma012InputDto){
        // 店所コード
        String tenCod = micacoma012InputDto.getTenCod();
        // 組織階層区分
        String soshikiKbn = micacoma012InputDto.getSoshikiKbn();

        // 店所コード情報取得
        List<String> comtenCodList = new ArrayList<>();
        int soshikiKbnInt = Integer.parseInt(soshikiKbn);
        if (Integer.parseInt(NUMBERTHREE) <= soshikiKbnInt && Integer.parseInt(NUMBERSIX) >= soshikiKbnInt) {
            // 3≦ 組織階層区分 ≦6 の場合
            TmmsoshikiExample tmmsoshikiExample = new TmmsoshikiExample();
            TmmsoshikiExample.Criteria criteria = tmmsoshikiExample.createCriteria()
                    .andComgyomu_kbnEqualTo(GYOMU_KBN)
                    .andComtekiyostr_ymdLessThanOrEqualTo(systemDate)
                    .andComtekiyoend_ymdGreaterThanOrEqualTo(systemDate);
            if (Integer.parseInt(NUMBERTHREE) == soshikiKbnInt) {
                // 組織階層区分 = 3の場合
                criteria.andComsosk3_codEqualTo(tenCod);
            } else if (Integer.parseInt(NUMBERFOUR) == soshikiKbnInt) {
                // 組織階層区分 = 4の場合
                criteria.andComsosk4_codEqualTo(tenCod);
            } else if (Integer.parseInt(NUMBERFIVE) == soshikiKbnInt) {
                // 組織階層区分 = 5の場合
                criteria.andComsosk5_codEqualTo(tenCod);
            } else if (Integer.parseInt(NUMBERSIX) == soshikiKbnInt) {
                // 組織階層区分 = 6の場合
                criteria.andComsosk6_codEqualTo(tenCod);
            }
            List<Tmmsoshiki> tmmsoshikiList = tmmsoshikiMapper.selectByExample(tmmsoshikiExample);
            comtenCodList = tmmsoshikiList.stream().map(Tmmsoshiki::getComtenCod).distinct().collect(toList());
        } else if (soshikiKbnInt == Integer.parseInt(NUMBERTWO)) {
            // 組織階層区分 = 2 の場合
            TmmbumonnayosemiExample tmmbumonnayosemiExample = new TmmbumonnayosemiExample();
            tmmbumonnayosemiExample.createCriteria()
                    .andJcmsaimutegataKbnEqualTo("4")
                    .andJcmnayosekanriCodEqualTo(tenCod)
                    .andJcmtekiyostrYmdLessThanOrEqualTo(systemDate)
                    .andJcmtekiyoendYmdGreaterThanOrEqualTo(systemDate);

            // 検索実施
            List<Tmmbumonnayosemi> tmmbumonnayosemiList = tmmbumonnayosemiMapper.selectByExample(tmmbumonnayosemiExample);
            comtenCodList = tmmbumonnayosemiList.stream().map(Tmmbumonnayosemi::getJcmbumonCod).collect(toList());

            // 検索結果判定
            if (comtenCodList.isEmpty() && StringUtils.isNotBlank(tenCod)) {
                comtenCodList.add(tenCod);
            }
        } else if (StringUtils.isNotBlank(tenCod)) {
            comtenCodList.add(tenCod);
        }

        return comtenCodList;
    }

    /**
     * 処理情報取得
     * @return
     */
    private List<ShoriInfoDto> getSyoriInfoList() throws ApiException {
        List<ShoriInfoDto> syoriInfoListOut = new ArrayList<>();
        try {
            // 検索条件設定
            TmhanyoExample hanyoExample = new TmhanyoExample();

            hanyoExample.setOrderByClause("str1");
            TmhanyoExample.Criteria criteria1 = hanyoExample.createCriteria();
            criteria1.andBunrui_codEqualTo(SHORIID);
            criteria1.andTekiyoend_ymdGreaterThanOrEqualTo(systemDate);
            criteria1.andTekiyostr_ymdLessThanOrEqualTo(systemDate);
            criteria1.andNum1EqualTo(Integer.parseInt(NUMBERTWO));

            TmhanyoExample.Criteria criteria2 = hanyoExample.createCriteria();
            hanyoExample.setOrderByClause("str1");
            criteria2.andBunrui_codEqualTo(SHORIID);
            criteria2.andTekiyoend_ymdGreaterThanOrEqualTo(systemDate);
            criteria2.andTekiyostr_ymdLessThanOrEqualTo(systemDate);
            criteria2.andNum1EqualTo(Integer.parseInt(NUMBERONE));

            hanyoExample.or(criteria2);

            // 汎用マスタ検索実施
            List<Tmhanyo> hanyoList = tmhanyoMapper.selectByExample(hanyoExample);

            for (Tmhanyo tmhanyo : hanyoList) {
                ShoriInfoDto shoriInfoDto = new ShoriInfoDto();
                shoriInfoDto.setStr1(tmhanyo.getStr1());
                shoriInfoDto.setStr2(tmhanyo.getStr2());
                shoriInfoDto.setStr3(tmhanyo.getStr3());
                shoriInfoDto.setNum1(tmhanyo.getNum1());

                // 処理情報設定
                syoriInfoListOut.add(shoriInfoDto);
            }
        } catch (Exception e) {
            throw new ApiException(CommonConst.MESSAGE_ID_MICACOME00005);
        }
        return syoriInfoListOut;
    }

    /**
     * SQLデータ -> 画面データ変換
     * @param shorijyokyoList
     * @return
     */
    private List<ShorijokyoDto> getSyorijyokyoListOut(List<ShorijokyoDto> shorijyokyoList) throws ApiException {
        List<ShoriInfoDto> syoriInfoListOut = getSyoriInfoList();
        shorijyokyoList.forEach(item->{
            List<ShoriInfoDto> shoriList = syoriInfoListOut.stream().filter(syorijyokyo -> syorijyokyo.getStr1().equals(item.getShoriId())).collect(toList());

            //バケット名取得する
            item.setBucketName(getBucketName(item, shoriList));
            //処理開始日時取得する
            item.setShoriStart(getShoriStart(item));
            //処理終了日時取得する
            item.setShoriEnd(getShoriEnd(item));

            if (StringUtils.equals(NUMBERZERO, item.getShoriStatus())) {
                item.setDwlFileKnj("");
                item.setDwlFilePath("");
                item.setUplFileKnj("");
                item.setUplFilePath("");
            } else if (StringUtils.equals(NUMBERTWO, item.getShoriStatus())) {
                item.setUplFileKnj("");
                item.setUplFilePath("");
            } else if (StringUtils.equals(NUMBERONE, item.getShoriStatus())) {
                if (StringUtils.equals(NUMBERONE, item.getShoriKbn())) {
                    item.setDwlFileKnj("");
                    item.setDwlFilePath("");
                }
                if (StringUtils.equals(NUMBERTWO, item.getShoriKbn())) {
                    item.setUplFileKnj("");
                    item.setUplFilePath("");
                }
            }
            if (!item.getShoriKbn().isEmpty()) {
                item.setShoriKbn(shoriKbnList.get(item.getShoriKbn()));
            }
            if (!item.getShoriStatus().isEmpty()) {
                item.setShoriStatus(statusList.get(item.getShoriStatus()));
            }
        });

        return shorijyokyoList;
    }

    /**
     * 処理終了日時取得する
     * @param item
     * @return
     */
    private String getShoriEnd(ShorijokyoDto item) {
        if(!item.getShoriEnd().isEmpty()) {
            item.setShoriEnd(item.getShoriEnd().replace(" ", CommonConst.NEW_LINE_CODE_LF));
        }
        return item.getShoriEnd();
    }

    /**
     * 処理開始日時取得する
     * @param item
     * @return
     */
    private String getShoriStart(ShorijokyoDto item) {
        if(!item.getShoriStart().isEmpty()) {
            item.setShoriStart(item.getShoriStart().replace(" ", CommonConst.NEW_LINE_CODE_LF));
        }
        return item.getShoriStart();
    }

    /**
     * バケット名取得する
     * @param item
     * @param shoriList
     * @return
     */
    private String getBucketName(ShorijokyoDto item, List<ShoriInfoDto> shoriList) {
        String bucketName = item.getBucketName();
        if (!shoriList.isEmpty()) {
            if (shoriList.get(0).getStr3().equals(CommonConst.RYO)) {
                bucketName = mstCommon.getS3BucketName(MstCommon.Buckets.RYO);
            } else if (shoriList.get(0).getStr3().equals(CommonConst.SEI)) {
                bucketName = mstCommon.getS3BucketName(MstCommon.Buckets.SEI);
            }
        }
        return bucketName;
    }

    /**
     * 汎用マスタ取得処理
     * @param bunruiCod
     * @param nowDate
     * @return
     */
    private Map<String, String> findTmhanyo(String bunruiCod, Date nowDate) {
        // 検索引数設定
        TmhanyoExample tmhanyoExample = new TmhanyoExample();
        tmhanyoExample.createCriteria()
                .andBunrui_codEqualTo(bunruiCod)
                .andTekiyostr_ymdLessThanOrEqualTo(nowDate)
                .andTekiyoend_ymdGreaterThanOrEqualTo(nowDate);
        tmhanyoExample.setOrderByClause("str3");

        // 検索実施
        List<Tmhanyo> tmhanyoList = tmhanyoMapper.selectByExample(tmhanyoExample);
        Map<String, String> ret = new LinkedHashMap<>();
        for (Tmhanyo entity:tmhanyoList) {
            ret.put(entity.getStr1(), entity.getStr2());
        }

        return ret;
    }

    /**
     * 入力チェック
     * @param micacoma012InputDto 処理状況照会入力パラメータDto
     * @param shoribiFrom 処理日From
     * @param shoribiTo 処理日To
     * @return
     */
    private Micacoma012OutputDto gyomuCheck(Micacoma012InputDto micacoma012InputDto, LocalDate shoribiFrom, LocalDate shoribiTo) throws ApiException {
        // 店所コード
        String tenCod = micacoma012InputDto.getTenCod();
        // 担当者コード
        String tantoCod = micacoma012InputDto.getJikkoShainId();
        // 組織階層区分
        String soshikiKbn = micacoma012InputDto.getSoshikiKbn();
        //　初期化
        Micacoma012OutputDto micacoma012OutputDto = new Micacoma012OutputDto();
        List<MsgDto> messageDtoList = new ArrayList<>();

        // 処理日Toより処理日Fromは大きい
        if (shoribiTo.compareTo(shoribiFrom) < 0) {
            MsgDto messageDto = new MsgDto(CommonConst.MESSAGE_ID_MICACOME00002,
                    messageUtil.getMessage(CommonConst.MESSAGE_ID_MICACOME00002, "処理日To", "処理日From"));
            messageDtoList.add(messageDto);
            micacoma012OutputDto.setFocusItem(SHORIBI_TO);
        }

        // 店所コードが入力された場合、店所マスタに存在確認
        Micacoma012OutputDto micacoma012OutputDtoTenCod = tmmtenshoCheck(tenCod, soshikiKbn, messageDtoList, micacoma012OutputDto);
        if (micacoma012OutputDtoTenCod != null){
            return micacoma012OutputDtoTenCod;
        }

        // 店所コードが入力された場合、組織マスタに存在確認
        Micacoma012OutputDto micacoma012OutputDtoSoshiki = tmmsoshikiCheck(tenCod, soshikiKbn, messageDtoList, micacoma012OutputDto);
        if (micacoma012OutputDtoSoshiki != null){
            return micacoma012OutputDtoSoshiki;
        }

        //従業員コードの人員マスタ存在確認
        Micacoma012OutputDto micacoma012OutputDtoJinin = tmmjininCheck(tenCod, tantoCod, messageDtoList, micacoma012OutputDto);
        if (micacoma012OutputDtoJinin != null){
            return micacoma012OutputDtoJinin;
        }

        return micacoma012OutputDto;
    }

    /**
     * 店所コードが入力された場合、店所マスタに存在確認
     * @param tenCod
     * @param soshikiKbn
     * @param messageDtoList
     * @param micacoma012OutputDto
     * @return
     */
    private Micacoma012OutputDto tmmtenshoCheck(String tenCod, String soshikiKbn, List<MsgDto> messageDtoList, Micacoma012OutputDto micacoma012OutputDto) throws ApiException {
        // 店所コードが入力された場合、店所マスタに存在確認
        if (StringUtils.isNotBlank(tenCod) && StringUtils.isNotBlank(soshikiKbn) &&
                (NUMBERTWO.equals(soshikiKbn) || NUMBERONE.equals(soshikiKbn))) {
            try {
                // 店所マスタ検索
                List<Tmmtensho> tenshoList;
                TmmtenshoExample tenshoExample = new TmmtenshoExample();
                tenshoExample.createCriteria()
                        .andComten_codEqualTo(tenCod)
                        .andComtekiyostr_ymdLessThanOrEqualTo(systemDate)
                        .andComtekiyoend_ymdGreaterThanOrEqualTo(systemDate);
                tenshoList = tmmtenshoMapper.selectByExample(tenshoExample);

                // 検索結果判定
                if (tenshoList.isEmpty()) {
                    MsgDto messageDto = new MsgDto(CommonConst.MESSAGE_ID_MICACOME00003,
                            messageUtil.getMessage(CommonConst.MESSAGE_ID_MICACOME00003, "店所", "店所コード"));
                    messageDtoList.add(messageDto);

                    // フォーカス設定
                    micacoma012OutputDto.setFocusItem(getFocusItem(micacoma012OutputDto));

                    // 出力設定
                    micacoma012OutputDto.setMsgList(messageDtoList);
                    return micacoma012OutputDto;
                }
                return null;
            } catch (Exception e) {
                throw new ApiException(CommonConst.MESSAGE_ID_MICACOME00050, "店所マスタ");
            }
        }
        return null;
    }

    /**
     * 従業員コードの人員マスタ存在確認
     * @param tenCod
     * @param tantoCod
     * @param messageDtoList
     * @param micacoma012OutputDto
     * @return
     */
    private Micacoma012OutputDto tmmjininCheck (String tenCod, String tantoCod, List<MsgDto> messageDtoList, Micacoma012OutputDto micacoma012OutputDto) throws ApiException {
        // 従業員コードの人員マスタ存在確認
        try {
            if (StringUtils.isNotBlank(tantoCod)) {
                // 人員マスタ検索
                TmmjininExample jininExample = new TmmjininExample();
                jininExample.createCriteria()
                        .andComtekiyostrYmdLessThanOrEqualTo(systemDate)
                        .andComtekiyoendYmdGreaterThanOrEqualTo(systemDate)
                        .andComjugyoinCodEqualTo(tantoCod);

                List<Tmmjinin> jininList = tmmjininMapper.selectByExample(jininExample);

                // 検索結果判定
                if (jininList.isEmpty()) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("従業員コード：");
                    stringBuilder.append(tantoCod);
                    MsgDto messageDto = new MsgDto(CommonConst.MESSAGE_ID_MICACOME00003,
                            messageUtil.getMessage(CommonConst.MESSAGE_ID_MICACOME00003, "人員", stringBuilder.toString()));
                    messageDtoList.add(messageDto);
                    if (StringUtils.isEmpty(micacoma012OutputDto.getFocusItem())) {
                        micacoma012OutputDto.setFocusItem("tantoName");
                    }

                    // 出力設定
                    micacoma012OutputDto.setMsgList(messageDtoList);
                    return micacoma012OutputDto;
                }

                // 店所コードと担当者が不整合チェック
                if (!jininList.isEmpty() && StringUtils.isNotBlank(tenCod) && !tenCod.equals(jininList.get(0).getComsoztenCod())) {
                    // 店所コード一致しない場合
                    MsgDto messageDto = new MsgDto(CommonConst.MESSAGE_ID_MICACOME00004,
                            messageUtil.getMessage(CommonConst.MESSAGE_ID_MICACOME00004));
                    messageDtoList.add(messageDto);
                    // フォーカス設定
                    micacoma012OutputDto.setFocusItem(getFocusItem(micacoma012OutputDto));

                    // 出力設定
                    micacoma012OutputDto.setMsgList(messageDtoList);
                    return micacoma012OutputDto;
                }
            }
            return null;
        } catch (Exception e) {
            throw new ApiException(CommonConst.MESSAGE_ID_MICACOME00005);
        }
    }

    /**
     * 店所コードが入力された場合、組織マスタに存在確認
     * @param tenCod
     * @param soshikiKbn
     * @param messageDtoList
     * @param micacoma012OutputDto
     * @return
     */
    private Micacoma012OutputDto tmmsoshikiCheck(String tenCod, String soshikiKbn, List<MsgDto> messageDtoList, Micacoma012OutputDto micacoma012OutputDto) throws ApiException {
        // 店所コードが入力された場合、組織マスタに存在確認
        try {
            // 組織マスタ検索
            int soshiki = 6;
            String soshikiName = null;
            while (soshiki >= 1 && StringUtils.isNotBlank(tenCod)) {
                boolean isBreak = false;
                soshikiName = micAMstA911Mapper.MicAMst91Sql001(soshikiKbn, tenCod, GYOMU_KBN);
                // 検索結果判定
                if (soshikiName == null) {
                    if (soshiki == 1) {
                        MsgDto messageDto = new MsgDto(CommonConst.MESSAGE_ID_MICACOME00003,
                                messageUtil.getMessage(CommonConst.MESSAGE_ID_MICACOME00003, "組織", "店所コード"));
                        messageDtoList.add(messageDto);
                        // フォーカス設定
                        micacoma012OutputDto.setFocusItem(getFocusItem(micacoma012OutputDto));
                        // 出力設定
                        micacoma012OutputDto.setMsgList(messageDtoList);
                        isBreak = true;
                    } else {
                        // 組織区分に1減算
                        soshiki = soshiki - 1;
                    }

                } else {
                    isBreak = true;
                }
                if (isBreak) {
                    break;
                }
            }
            if (!CollectionUtils.isEmpty(micacoma012OutputDto.getMsgList())) {
                return micacoma012OutputDto;
            }
            return null;
        } catch (Exception e) {
            throw new ApiException(CommonConst.MESSAGE_ID_MICACOME00050, "組織マスタ");
        }
    }

    /**
     * フォーカス設定
     * @param micacoma012OutputDto
     * @return
     */
    private String getFocusItem(Micacoma012OutputDto micacoma012OutputDto) {
        if (StringUtils.isEmpty(micacoma012OutputDto.getFocusItem())) {
            micacoma012OutputDto.setFocusItem(TENSHO_CODE);
        }
        return micacoma012OutputDto.getFocusItem();
    }

    /**
     * システム日付取得
     * @return
     * @throws ParseException
     */
    private Date currentTime() throws ParseException {
        systemDate = simpleDateFormat.parse(format);
        return systemDate;
    }
}
