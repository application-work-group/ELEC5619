package com.elec.api;

import com.alibaba.fastjson.JSONObject;
import com.elec.dal.pojo.UserInfo;
import com.elec.devTest.BaseTest;
import com.elec.dto.UserSaveDTO;
import com.elec.service.GameSessionHandleService;
import com.elec.service.UserSaveService;
import org.junit.Test;

import javax.annotation.Resource;

public class SportsTest extends BaseTest {
    @Resource
    private UserSaveService userSaveService;
    @Resource
    private GameSessionHandleService gameSessionHandleService;
    @Test
    public void test2(){
        UserSaveDTO userSaveDTO = new UserSaveDTO();
        userSaveDTO.setPassword("ceshiyixia");
        userSaveDTO.setEmail("wowoyoulaileabb@email.com");
        userSaveDTO.setUserName("username*1wo");
        userSaveDTO.setPhoneNumber("181321wqeqw22");
        this.userSaveService.saveUserInfo(userSaveDTO);
    }
    @Test
    public void test3(){
        String userName = "username*1wo";
        UserInfo userInfo = this.userSaveService.queryUserInfo(userName);
        System.out.println(JSONObject.toJSONString(userInfo));

    }
    @Test
    public void test4(){
        this.gameSessionHandleService.saveDetail();
    }
}
