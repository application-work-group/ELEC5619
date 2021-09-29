package com.elec.controller;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Jinglin
 * @since 2021-09-08
 */
@Controller
@RequestMapping("/game-session")
public class GameSessionController {
    @RequestMapping("/test0shuyuan")
    public String test0shuyuan(Model model){
        model.addAttribute("name","zhangsan");
        return "test";
    }
}
