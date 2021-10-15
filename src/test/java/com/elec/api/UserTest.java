package com.elec.api;

import com.elec.devTest.BaseTest;
import com.elec.service.UserSaveService;
import org.junit.Test;

import javax.annotation.Resource;

public class UserTest extends BaseTest {
    @Resource
    private UserSaveService userSaveService;
    @Test
    public void test1(){
        String userName = "nanmenamenmandsa";
        String password = "wobushimimamamaa";
        this.userSaveService.modifyPassword(userName,password);
    }
}
