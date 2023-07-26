package com.wetech.ryutsuweb.controller;

import com.wetech.core.service.MicAComA017Service;
import com.wetech.ryutsumodel.model.dto.MicAComA017InputDto;
import com.wetech.ryutsumodel.model.dto.MicAComA017TenshoOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/mst")
public class MicAComA017Controller {

    @Autowired
    private MicAComA017Service micAComA017Service;

    /*
    *店所情報取得API
    * */
    @PostMapping("/tensho-joho")
    public ResponseEntity<MicAComA017TenshoOutputDto> getTenshoInfo(@RequestBody MicAComA017InputDto micAComA017InputDto){
        String tenshoCode = micAComA017InputDto.getTenshoCode();

        MicAComA017TenshoOutputDto micAComA017TenshoOutputDto = micAComA017Service.getTenshoInfo(tenshoCode);
        return ResponseEntity.ok(micAComA017TenshoOutputDto);
    }
}
