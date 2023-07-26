package com.wetech.core.service.impl;

import com.wetech.core.common.CommonConst;
import com.wetech.core.common.MessageUtil;
import com.wetech.core.repository.micacoma01.MicAComA017ExtRepository;
import com.wetech.core.service.MicAComA017Service;
import com.wetech.ryutsumodel.model.dto.MessageDto;
import com.wetech.ryutsumodel.model.dto.MicAComA017TenshoOutputDto;
import com.wetech.ryutsumodel.model.dto.TenshoInfoDto;
import com.wetech.ryutsumodel.model.mapper.TmmbumonnayosemiMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MicAComA017ServiceImpl implements MicAComA017Service {

    @Autowired
    private MicAComA017ExtRepository micAComA017ExtRepository;

    @Autowired
    private MessageUtil messageUtil;

    @Override
    public MicAComA017TenshoOutputDto getTenshoInfo(String tenshoCode) {
        TenshoInfoDto tenshoInfoDto = new TenshoInfoDto();
        List<MessageDto> messageDtoList = new ArrayList<MessageDto>();
        Short GYOMU_KBN = 21;
        MessageDto messageDto = new MessageDto();
        MicAComA017TenshoOutputDto micAComA017TenshoOutputDto = new MicAComA017TenshoOutputDto();

        try {
            tenshoInfoDto = micAComA017ExtRepository.MicAComA017Sql001(tenshoCode,GYOMU_KBN);

            if (tenshoInfoDto == null){
                String[] args = {"組織", tenshoCode};
                messageDto.setErrorID(CommonConst.MESSAGE_ID_MICACOME00003);
                messageDto.setErrorMessage(messageUtil.getMessage(CommonConst.MESSAGE_ID_MICACOME00003, args));
                messageDtoList.add(messageDto);
            }
        }catch (Exception e) {
            messageDto.setErrorID(CommonConst.MESSAGE_ID_MICACOME00050);
            messageDto.setErrorMessage(messageUtil.getMessage(CommonConst.MESSAGE_ID_MICACOME00050, "店所情報"));
            messageDtoList.add(messageDto);
        }

        micAComA017TenshoOutputDto.setTenshoInfoDto(tenshoInfoDto);
        micAComA017TenshoOutputDto.setMessageDtoList(messageDtoList);

        return micAComA017TenshoOutputDto;
    }
}
