package com.wetech.ryutsuweb.controller;

import com.wetech.core.service.MicAMstA912Service;
import com.wetech.ryutsumodel.model.dto.MicAMstA912InputDto;
import com.wetech.ryutsumodel.model.dto.MicAMstA912OutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/mst")
public class MicAMstA912Controller {

    @Autowired
    private MicAMstA912Service micAMstA912Service;

    /**
     * @param MicMstA912InputDto inputDto 入力パラメータ
     * @return 担当者リスト取得JSON
     */
    @PostMapping("/tantosha-list")
    public ResponseEntity<MicAMstA912OutputDto> getTantosha(@RequestBody MicAMstA912InputDto inputDto) {

        MicAMstA912OutputDto micAMstA912OutputDto = micAMstA912Service.getTantosha(inputDto);
        return ResponseEntity.ok(micAMstA912OutputDto);
    }

}
