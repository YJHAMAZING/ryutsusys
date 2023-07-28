package com.wetech.core.repository.micacoma01;

import com.wetech.ryutsumodel.model.dto.MicAComa014AffiliateSoskDto;
import com.wetech.ryutsumodel.model.entity.Tmtmsoshiki;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface MicAComa014ExtRepository {

    /**
     * 会社情報取得
     * @param companyCode
     * @param role
     * @param date 運用日付
     * @return
     */
    public List<Tmtmsoshiki> micACom05Sql001(@Param("companyCode") String companyCode, @Param("role") String role, @Param("date") Date date);

    /**
     * ブロック情報取得
     * @param companyCode
     * @param role
     * @param date 運用日付
     * @return
     */
    public List<Tmtmsoshiki> micACom05Sql002(@Param("companyCode") String companyCode, @Param("date") Date date);

    /**
     * 特定支店情報取得
     * @param companyCode
     * @param blockCode
     * @param role
     * @param date 運用日付
     * @return
     */
    public List<Tmtmsoshiki> micACom05Sql003(@Param("companyCode") String companyCode, @Param("blockCode") String blockCode, @Param("date") Date date);

    /**
     * 支店情報取得
     * @param companyCode
     * @param blockCode
     * @param tokuteiShitenCode
     * @param role
     * @param date 運用日付
     * @return
     */
    public List<Tmtmsoshiki> micACom05Sql004(@Param("companyCode") String companyCode, @Param("blockCode") String blockCode, @Param("tokuteiShitenCode") String tokuteiShitenCode, @Param("date") Date date);

    /**
     * 店所情報取得
     * @param companyCode
     * @param blockCode
     * @param tokuteiShitenCode
     * @param shitenCode
     * @param role
     * @param date 運用日付
     * @param tenkakuKbn 店格区分
     * @return
     */
    public List<Tmtmsoshiki> micACom05Sql005(@Param("companyCode") String companyCode, @Param("blockCode") String blockCode, @Param("tokuteiShitenCode") String tokuteiShitenCode, @Param("shitenCode") String shitenCode, @Param("tenshoCode") String tenshoCode, @Param("date") Date date, @Param("tenkakuKbn") int tenkakuKbn);

    /**
     * 所属組織階層取得
     * @param companyCode
     * @param tenshoCode
     * @return
     */
    public MicAComa014AffiliateSoskDto micACom05Sql006(@Param("companyCode") String companyCode, @Param("tenshoCode") String tenshoCode, @Param("date") Date date);

}
