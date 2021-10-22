package com.elec.controller;


import com.elec.dal.pojo.GameSession;
import com.elec.dal.pojo.PostInfo;
import com.elec.dto.valueObj.Result;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Jinglin
 * @since 2021-10-08
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/test0shuyuan")
    public String testenhua(){
        return "index";
    }
}
