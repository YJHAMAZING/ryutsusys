/*
* システム名: 新請求システム
* サブシステム名: 共通マスタ
*
* 注意事項:
*
* Copyright:
* All Rights Reserved Copyright (C) NIPPON EXPRESS  2022
*
*/
package com.wetech.core.repository.micacoma01;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.wetech.ryutsumodel.model.dto.TenshoInfoDto;

/**
* 店所情報取得Sqlマッパー
* <pre>
* [変更履歴]
* 1.0  2022/09/14   新規作成
* </pre>
* @version 1.1  2022/09/14
* @author  富士通）末永 詩歩
*/
@Mapper
public interface MicAComA017ExtRepository {
    TenshoInfoDto MicAComA017Sql001(
            @Param("tenshoCode") String tenshoCode,
            @Param("gyomuKbn") Short gyomuKbn);

}
