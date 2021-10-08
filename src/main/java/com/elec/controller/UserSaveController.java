package com.elec.controller;

import com.elec.dto.UserSaveDTO;
import com.elec.service.UserSaveService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/save/userInfo")
public class UserSaveController {
    @Resource
    private UserSaveService userSaveService;
    @RequestMapping
    public Boolean saveUserInfo(@RequestBody UserSaveDTO userSaveDTO){
        this.userSaveService.saveUserInfo(userSaveDTO);
        return true;
    }
}
