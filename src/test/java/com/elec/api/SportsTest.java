package com.elec.api;

import com.elec.component.GenerateId;
import com.elec.dal.pojo.User;
import com.elec.devTest.BaseTest;
import com.elec.dto.UserSaveDTO;
import com.elec.repository.SportsBetRepository;
import com.elec.service.UserSaveService;
import org.junit.Test;

import javax.annotation.Resource;

public class SportsTest extends BaseTest {
    @Resource
    private SportsBetRepository sportsBetRepository;
    @Resource
    private UserSaveService userSaveService;
    @Test
    public void testSave(){
        User user = new User();
//        user.setId(1);
        user.setUserId(GenerateId.getGeneratID());
        user.setEmail("iamemail@xxx.xxx.com");
        user.setUserName("lulallalalala");
        user.setPhoneNumber("12345677677");
        user.setPassword("password");
//        user.setGmtCreate(new Date());
//        user.setGmtModified(new Date());
        this.sportsBetRepository.saveUser(user);
    }
    @Test
    public void test2(){
        UserSaveDTO userSaveDTO = new UserSaveDTO();
        userSaveDTO.setPassword("ceshiyixia");
        userSaveDTO.setEmail("wowoyoulaileabb@email.com");
        userSaveDTO.setUserName("username*1wo");
        userSaveDTO.setPhoneNumber("181321wqeqw22");
        this.userSaveService.saveUserInfo(userSaveDTO);
    }
}
