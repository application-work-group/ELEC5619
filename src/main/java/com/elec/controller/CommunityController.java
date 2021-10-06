package com.elec.controller;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/community")
public class CommunityController {

    @RequestMapping("/post")
    public String post(Model model){
        model.addAttribute("name","zhangsan");
        return "post";
    }
}
