package com.elec.api;

import com.alibaba.fastjson.JSONObject;
import com.elec.dal.pojo.UserInfo;
import com.elec.devTest.BaseTest;
import com.elec.service.RankListService;
import com.elec.service.UserSaveService;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

public class UserTest extends BaseTest {
    @Resource
    private UserSaveService userSaveService;
    @Resource
    private RankListService rankListService;
    @Test
    public void test1(){
        String userName = "nanmenamenmandsa";
        String password = "wobushimimamamaa";
        this.userSaveService.modifyPassword(userName,password);
    }
    @Test
    public void test22(){
        final List<UserInfo> userInfoList = this.rankListService.getUserInfoList();
        System.out.println(JSONObject.toJSONString(userInfoList));
    }
}
