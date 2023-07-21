package com.wetech.ryutsuweb.controller;

import com.wetech.core.common.ApiException;
import com.wetech.core.common.CommonConst;
import com.wetech.core.service.Micacoma012Servie;
import com.wetech.ryutsumodel.model.dto.Micacoma012InputDto;
import com.wetech.ryutsumodel.model.dto.Micacoma012OutputDto;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;

@RestController
@RequestMapping("/api/v1/mst")
public class Micacoma012Controller {

    @Autowired
    private Micacoma012Servie micacoma012Servie;

    @PostMapping("/get-shorijyokyo-list")
    public ResponseEntity<Micacoma012OutputDto> syoriJyokyoSearch(@RequestHeader HttpHeaders header, @Valid @RequestBody Micacoma012InputDto micacoma012InputDto) throws ApiException, ParseException {
        //処理状況検索
        Micacoma012OutputDto micacoma012OutputDto = micacoma012Servie.syoriJyokyoSearch(micacoma012InputDto,header.get(CommonConst.ROLE));
        return ResponseEntity.ok(micacoma012OutputDto);
    }

    @GetMapping("/ok")
    @ResponseBody
    public String test(){
        return "ok";
    }

}
