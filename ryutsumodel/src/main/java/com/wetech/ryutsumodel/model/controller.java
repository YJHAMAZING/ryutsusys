package com.wetech.ryutsumodel.model;

import com.wetech.ryutsumodel.model.mapper.TmhanyoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class controller {
    @Autowired
    private TmhanyoMapper tmhanyoMapper;

    @GetMapping("/ok")
    public String test() {
        String b = tmhanyoMapper.test("a");
        System.out.println(b);
        return b;
    }
}
