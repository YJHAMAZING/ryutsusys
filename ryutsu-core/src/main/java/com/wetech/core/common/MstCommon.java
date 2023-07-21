/*
 * システム名 :新請求システム
 * サブシステム名 :共通部品
 *
 * 注意事項 :
 *
 * Copyright:
 * All Rights Reserved Copyright (C) NIPPON EXPRESS  2022
 *
 */
package com.wetech.core.common;

import com.wetech.ryutsumodel.model.entity.Tmhanyo;
import com.wetech.ryutsumodel.model.entity.TmhanyoExample;
import com.wetech.ryutsumodel.model.mapper.TmhanyoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 共通UTIL
 * <pre>
 * [変更履歴]
 * 1.0 2022/12/08   新規作成
 * </pre>
 * @version version 1.0 2022/12/08
 * @author  富士通）李
 */
@Component
public class MstCommon {

    /**
     * バケットタイプ
     */
    public enum Buckets {
        /** 請求書ファイル用バケット */
        SEI,
        /** 領収証ファイル用バケット */
        RYO,
        /** 一時データ用バケット */
        TMP
    }

    /**
     * バケット名取得
     */
    public String getS3BucketName(Buckets bucket) {

        String bucketName = "";

        switch (bucket) {
        case SEI:
        case RYO:
            bucketName = "mic-arc-0006";
            break;
        case TMP:
            bucketName = "mic-arc-0008";
            break;
        }

        return bucketName;
    }

}
