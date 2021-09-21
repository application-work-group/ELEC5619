package com.elec.api;

import com.elec.dal.pojo.User;
import com.elec.devTest.BaseTest;
import com.elec.repository.SportsBetRepository;
import org.junit.Test;

import javax.annotation.Resource;

public class SportsTest extends BaseTest {
    @Resource
    private SportsBetRepository sportsBetRepository;
    @Test
    public void testSave(){
        User user = new User();
        user.setUserId(77777222L);
        user.setEmail("iamemail@xxx.xxx.com");
        user.setUserName("iamuserName");
        user.setPhoneNumber("12345677677");
        user.setPassword("password");
        this.sportsBetRepository.saveUser(user);
    }
}
