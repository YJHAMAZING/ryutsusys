package com.wetech.ryutsumodel.model.dto;

import lombok.Data;

@Data
public class MsgDto {
    /**
     * メッセージID
     */
    private String msgId;

    /**
     * メッセージ
     */
    private String msgInfo;



    public MsgDto() {
        super();
    }

    public MsgDto(String msgId, String msgInfo) {
        super();
        this.msgId = msgId;
        this.msgInfo = msgInfo;
    }

}
