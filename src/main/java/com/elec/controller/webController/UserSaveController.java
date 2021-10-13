package com.elec.controller.webController;

import com.alibaba.fastjson.JSONObject;
import com.elec.dal.pojo.UserInfo;
import com.elec.dto.UserSaveDTO;
import com.elec.service.UserSaveService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Controller
@RequestMapping("/save/userInfo")
public class UserSaveController {
    @Resource
    private UserSaveService userSaveService;

    /**
     * 保存用户信息
     * @param userSaveDTO
     * @return
     */
    @PostMapping("/saveUserInfo")
    public JSONObject saveUserInfo(@RequestBody UserSaveDTO userSaveDTO){
        JSONObject object = new JSONObject();
        object.fluentPut("result",this.userSaveService.saveUserInfo(userSaveDTO));
        return object;
    }

    /**
     * 判断登录是否成功
     * @param userSaveDTO
     * @return
     */
    @PostMapping("/userLogin")
    public JSONObject userLogin(@RequestBody UserSaveDTO userSaveDTO){
        JSONObject object = new JSONObject();
        object.fluentPut("result",this.userSaveService.userLogin(userSaveDTO));
        return object;
    }

    /**
     * 获取用户信息详情（积分、帖子等）
     * @param userName
     * @return
     */
    @GetMapping("/queryUserInfo")
    public UserInfo queryUserInfo(@RequestParam(value = "userName") String userName){
        return this.userSaveService.queryUserInfo(userName);
    }
    /**
     * 获取关注用户列表
     */
}
