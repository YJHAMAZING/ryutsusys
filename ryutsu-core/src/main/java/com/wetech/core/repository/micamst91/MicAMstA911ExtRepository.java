package com.wetech.core.repository.micamst91;

import com.wetech.ryutsumodel.model.entity.Tmmsoshiki;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MicAMstA911ExtRepository {
    /**
     * 組織コード取得SQL
     * @param 組織区分
     * @param 店所コード
     * @param 業務区分
     * @return 組織区分に紐づいた組織コード
     */
    String MicAMst91Sql001(
            @Param("soshikiKbn") String soshikiKbn,
            @Param("tenshoCode") String tenshoCode,
            @Param("gyomuKbn") Short gyomuKbn);
    /**
     * リスト取得
     * @param 組織コード
     * @param 組織区分
     * @param 業務区分
     * @return 組織コードで紐づいたリスト
     */
    List<Tmmsoshiki> MicAMst91Sql002(
            @Param("soshikiKbn") String soshikiKbn,
            @Param("tenshoCode") String tenshoCode,
            @Param("gyomuKbn") Short gyomuKbn);

    /**
     * リスト取得
     * @param 組織コード
     * @param 組織区分
     * @param 業務区分
     * @return 組織コードで紐づいたリスト
     */
    Tmmsoshiki MicAMst91Sql003(
            @Param("soshikiKbn") String soshikiKbn,
            @Param("soshikiCode") String soshikiCode,
            @Param("tenshoCode") String tenshoCode,
            @Param("gyomuKbn") Short gyomuKbn);
}
