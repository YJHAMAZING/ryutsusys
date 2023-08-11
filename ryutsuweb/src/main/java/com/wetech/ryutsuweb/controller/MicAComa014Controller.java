package com.wetech.ryutsuweb.controller;

import com.wetech.core.service.MicAComa014Service;
import com.wetech.ryutsumodel.model.dto.MicAComa014InputDto;
import com.wetech.ryutsumodel.model.dto.MicAComa014OutputDto;
import com.wetech.ryutsumodel.model.mapper.TmhanyoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/mst")
public class MicAComa014Controller {

    @Autowired
    private MicAComa014Service micAComa014Service;

    @Autowired
    private TmhanyoMapper tmhanyoMapper;

    /**
     * 初期表示データ取得
     */
    @PostMapping("/get-tensho-search-list")
    public ResponseEntity<MicAComa014OutputDto> get(@RequestBody MicAComa014InputDto micAComa014InputDto) {

        MicAComa014OutputDto micAComa014OutputDto = micAComa014Service.getRecord(micAComa014InputDto);
        return ResponseEntity.ok(micAComa014OutputDto);
    }

    @GetMapping("/ok")
    public String test() {
        String a =tmhanyoMapper.test("a");
        return a;
    }
}
