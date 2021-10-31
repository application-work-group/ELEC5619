package com.elec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ok接口
 *
 * @author tengsimin
 * @version 2020/6/28 下午5:33
 */
@Controller
public class RootController {

    @GetMapping("/")
    public String root() {
        return "index";
    }

    @GetMapping("/ok")
    public String ok() {
        return "ok";
    }
}