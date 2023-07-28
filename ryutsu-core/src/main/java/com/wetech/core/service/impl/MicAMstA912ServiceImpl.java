package com.wetech.core.service.impl;

import com.wetech.core.common.MessageUtil;
import com.wetech.core.repository.micamst91.MicAMstA912ExtRepository;
import com.wetech.core.service.MicAMstA912Service;
import com.wetech.ryutsumodel.model.dto.MessageDto;
import com.wetech.ryutsumodel.model.dto.MicAMstA912InputDto;
import com.wetech.ryutsumodel.model.dto.MicAMstA912OutputDto;
import com.wetech.ryutsumodel.model.dto.TmmJininDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MicAMstA912ServiceImpl implements MicAMstA912Service {
    @Autowired
    private MicAMstA912ExtRepository micAMstA912Mapper;

    @Autowired
    private MessageUtil messageUtil;

    /**
     * @param    担当者リスト取得入力Dto
     * @return    担当者情報JSON
     * @exception APIException
     */
    @Override
    public MicAMstA912OutputDto getTantosha(MicAMstA912InputDto inputDto) {
        // 変数の初期化
        List<TmmJininDto> jininEntityList = new ArrayList<TmmJininDto>();
        List<MessageDto> messageDtoList = new ArrayList<MessageDto>();

        MessageDto messageDto = new MessageDto();
        String tenshoCode = inputDto.getTenshoCode();

        // リスト情報取得
        if (inputDto.getSoshikiKbn() == 1 || (inputDto.getSoshikiKbn() == 2 && inputDto.getHaikaFlg() == 0)) {
            try {
                // sqlの実施
                jininEntityList = micAMstA912Mapper.MicAMst91Sql002(tenshoCode);

            } catch (Exception e) {
                // エラーメッセージの格納
                messageDto.setErrorID("MICACOME00050");
                messageDto.setErrorMessage(messageUtil.getMessage("MICACOME00050", "組織名称"));
                messageDtoList.add(messageDto);
            }

        }

        //出力Dtoに格納
        MicAMstA912OutputDto outputDto = new MicAMstA912OutputDto();
        outputDto.setJininEntityList(jininEntityList);
        outputDto.setMessageDtoList(messageDtoList);
        return outputDto;
    }

}
