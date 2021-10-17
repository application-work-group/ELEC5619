package com.elec.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Jinglin
 * @since 2021-10-08
 */
@Controller
@RequestMapping("/operation-record")
public class OperationRecordController {
    @GetMapping("/test")
    public String test(){
        return "suc";
    }
}
