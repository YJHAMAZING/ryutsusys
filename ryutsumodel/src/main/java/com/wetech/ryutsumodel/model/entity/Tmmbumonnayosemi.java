package com.wetech.ryutsumodel.model.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tmmbumonnayosemi implements Serializable {
    /**
    * 債務手形区分
    */
    private String jcmsaimutegataKbn;

    /**
    * 名寄管理コード
    */
    private String jcmnayosekanriCod;

    /**
    * 部門コード
    */
    private String jcmbumonCod;

    /**
    * 適用開始年月日
    */
    private Date jcmtekiyostrYmd;

    /**
    * 債務計上部門区分
    */
    private String jcmsaimukejoKbn;

    /**
    * 適用終了年月日
    */
    private Date jcmtekiyoendYmd;

    /**
    * 登録年月日
    */
    private Date jcmcrtYmd;

    /**
    * 登録社員コード
    */
    private String jcmcrtshainCod;

    /**
    * 最新更新年月日
    */
    private Date jcmupdYmd;

    /**
    * 更新社員コード
    */
    private String jcmupdshainCod;

    private static final long serialVersionUID = 1L;
}