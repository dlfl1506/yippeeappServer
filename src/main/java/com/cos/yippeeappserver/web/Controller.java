package com.cos.yippeeappserver.web;

import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
public class Controller {


    @GetMapping("/test")
    public String test(@RequestParam Map<String, Object> param, Model model) {
        return "test입니다";
    }

}
