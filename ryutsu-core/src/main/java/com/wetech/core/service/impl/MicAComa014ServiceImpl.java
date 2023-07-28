package com.wetech.core.service.impl;

import com.wetech.core.repository.micacoma01.MicAComa014ExtRepository;
import com.wetech.core.service.MicAComa014Service;
import com.wetech.ryutsumodel.model.dto.*;
import com.wetech.ryutsumodel.model.entity.Tmtmsoshiki;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class MicAComa014ServiceImpl implements MicAComa014Service {
    @Autowired
    private MicAComa014ExtRepository micAComa014ExtRepository;

    // 運用日付
    Date date = new Date();

    /**
     * 初期表示データ取得
     */
    public MicAComa014OutputDto getRecord(MicAComa014InputDto micAComa014InputDto) {

        // 返却Dto
        MicAComa014OutputDto micAComa014OutputDto = new MicAComa014OutputDto();
        // 会社情報
        List<MicAComa014CompanyDto> companyList = new ArrayList<>();

        List<Tmtmsoshiki> list = new ArrayList<>();
        // 会社情報詰め替え用
        MicAComa014CompanyDto company = new MicAComa014CompanyDto();

        // ロールがSSCもしくはシステム管理者の場合は会社情報全件取得
        if (micAComa014InputDto.getRole().equals("ssc") || micAComa014InputDto.getRole().equals("sys_admin")) {

            // 会社情報の取得
            list = micAComa014ExtRepository.micACom05Sql001(null, micAComa014InputDto.getRole(), date);
            // ブロック情報
            List<MicAComa014BlockDto> blockList = getBlockRecord(micAComa014InputDto.getCompanyCode());
            // ブロック情報をDtoクラスに格納
            micAComa014OutputDto.setComSosk5List(blockList);
            companyList.add(0, company);

            // そうでない場合はログインユーザに紐づく情報取得
        } else {
            // 所属組織階層情報の取得
            MicAComa014AffiliateSoskDto affiliateSosk = micAComa014ExtRepository.micACom05Sql006(micAComa014InputDto.getCompanyCode(), micAComa014InputDto.getTenshoCode(), date);

            // 会社情報
            list = micAComa014ExtRepository.micACom05Sql001(micAComa014InputDto.getCompanyCode(), micAComa014InputDto.getRole(), date);
            // ブロック情報
            List<MicAComa014BlockDto> blockList = getBlockRecord(micAComa014InputDto.getCompanyCode());
            // 特定支店情報
            // getComSosk5Cod: ブロックコード
            List<MicAComa014TokuteiShitenDto> tokuteiShitenList = getTokuteiShitenRecord(micAComa014InputDto.getCompanyCode(), affiliateSosk.getComSosk5Cod());
            // 支店情報
            // getComSosk4Cod: 特定支店コード
            List<MicAComa014ShitenDto> shitenList = getShitenRecord(micAComa014InputDto.getCompanyCode(), affiliateSosk.getComSosk5Cod(), affiliateSosk.getComSosk4Cod());
            // 店所情報
            // getComSosk3Cod: 支店コード
            List<MicAComa014TenshoDto> tenshoList = getTenshoRecord(micAComa014InputDto.getCompanyCode(), affiliateSosk.getComSosk5Cod(), affiliateSosk.getComSosk4Cod(), affiliateSosk.getComSosk3Cod(), micAComa014InputDto.getTenshoCode(), affiliateSosk.getComTenkakuKbn());

            // 各Dtoクラスに格納
            micAComa014OutputDto.setComSosk5List(blockList);
            micAComa014OutputDto.setComSosk4List(tokuteiShitenList);
            micAComa014OutputDto.setComSosk3List(shitenList);
            micAComa014OutputDto.setComSosk2List(tenshoList);
            micAComa014OutputDto.setAffiliateSosk(affiliateSosk);
        }

        // 会社Dtoクラスに詰め替え
        for (Tmtmsoshiki l: list) {
            company = new MicAComa014CompanyDto();
            company.setComSoskKaisoKbn(6);
            company.setComSosk6Cod(l.getComsosk6_cod());
            company.setComSoskNm16(l.getComsosknm16_knj());
            companyList.add(company);
        }

        micAComa014OutputDto.setComSosk6List(companyList);
        return micAComa014OutputDto;
    }

    /**
     * ブロック情報取得
     * @param companyCode 会社コード
     * @return
     */
    public List<MicAComa014BlockDto> getBlockRecord(String companyCode) {
        // 返却リスト
        List<MicAComa014BlockDto> blockList = new ArrayList<>();
        // ブロック情報
        List<Tmtmsoshiki> list = micAComa014ExtRepository.micACom05Sql002(companyCode, date);

        // BlockDtoクラスに詰め替え
        MicAComa014BlockDto block = new MicAComa014BlockDto();
        blockList.add(0, block);
        for (Tmtmsoshiki l: list) {
            block = new MicAComa014BlockDto();
            block.setComSoskKaisoKbn(5);
            block.setComSosk5Cod(l.getComsosk5_cod());
            block.setComSoskNm15(l.getComsosknm15_knj());
            blockList.add(block);
        }

        return blockList;
    }

    /**
     * 特定支店情報取得
     * @param companyCode 会社コード
     * @param blockCode ブロックコード
     * @return
     */
    public List<MicAComa014TokuteiShitenDto> getTokuteiShitenRecord(String companyCode, String blockCode) {
        // 返却リスト
        List<MicAComa014TokuteiShitenDto> tokuteiShitenList = new ArrayList<>();
        // 特定支店情報
        List<Tmtmsoshiki> list = micAComa014ExtRepository.micACom05Sql003(companyCode, blockCode, date);

        // tokuteiShitenDtoクラスに詰め替え
        MicAComa014TokuteiShitenDto tokuteiShiten = new MicAComa014TokuteiShitenDto();
        tokuteiShitenList.add(0, tokuteiShiten);
        for (Tmtmsoshiki l: list) {
            tokuteiShiten = new MicAComa014TokuteiShitenDto();
            tokuteiShiten.setComSoskKaisoKbn(4);
            tokuteiShiten.setComSosk4Cod(l.getComsosk4_cod());
            tokuteiShiten.setComSoskNm14(l.getComsosknm14_knj());
            tokuteiShitenList.add(tokuteiShiten);
        }

        return tokuteiShitenList;
    }

    /**
     * 支店情報取得
     * @param companyCode 会社コード
     * @param blockCode ブロックコード
     * @param tokuteiShitenCode 特定支店コード
     * @return
     */
    public List<MicAComa014ShitenDto> getShitenRecord(String companyCode, String blockCode, String tokuteiShiten) {
        // 返却リスト
        List<MicAComa014ShitenDto> shitenList = new ArrayList<>();
        // 支店情報
        List<Tmtmsoshiki> list = micAComa014ExtRepository.micACom05Sql004(companyCode, blockCode, tokuteiShiten, date);

        // ShitenDtoクラスに詰め替え
        MicAComa014ShitenDto shiten = new MicAComa014ShitenDto();
        shitenList.add(0, shiten);
        for (Tmtmsoshiki l: list) {
            shiten = new MicAComa014ShitenDto();
            shiten.setComSoskKaisoKbn(3);
            shiten.setComSosk3Cod(l.getComsosk3_cod());
            shiten.setComSoskNm13(l.getComsosknm13_knj());
            shitenList.add(shiten);
        }

        return shitenList;
    }

    /**
     * 店所情報取得
     * @param companyCode 会社コード
     * @param blockCode ブロックコード
     * @param tokuteiShitenCode 特定支店コード
     * @param shitenCode 支店コード
     * @param tenshoCode 店所コード
     * @param tenkakuKbn 店格区分
     * @return
     */
    public List<MicAComa014TenshoDto> getTenshoRecord(String companyCode, String blockCode, String tokuteiShitenCode, String shitenCode, String tenshoCode, int tenkakuKbn) {
        // 返却リスト
        List<MicAComa014TenshoDto> tenshoList = new ArrayList<>();
        // 店所情報
        List<Tmtmsoshiki> list = micAComa014ExtRepository.micACom05Sql005(companyCode, blockCode, tokuteiShitenCode, shitenCode, tenshoCode, date, tenkakuKbn);

        // TenshoDtoクラスに詰め替え
        MicAComa014TenshoDto tensho = new MicAComa014TenshoDto();
        // 件数0の場合はそのまま返却する
        if (list.isEmpty()) {
            return tenshoList;
        }
        tenshoList.add(0, tensho);
        for (Tmtmsoshiki l: list) {
            tensho = new MicAComa014TenshoDto();
            tensho.setComSoskKaisoKbn(2);
            tensho.setComTenCod(l.getComsosk2_cod());
            tensho.setComTenNm1(l.getComsosknm21_knj());
            tenshoList.add(tensho);
        }

        return tenshoList;
    }
}
