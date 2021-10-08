package com.elec.repository.impl;

import com.elec.convertor.UserConvertor;
import com.elec.dal.pojo.User;
import com.elec.dal.pojo.UserInfo;
import com.elec.dal.service.IUserInfoService;
import com.elec.dal.service.IUserService;
import com.elec.repository.UserRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class UserRepositoryImpl implements UserRepository {
    @Resource
    private IUserService iUserService;
    @Resource
    private IUserInfoService userInfoService;
    @Override
    public boolean saveUser(User user) {
        this.iUserService.save(user);
        return true;
    }

    @Override
    public boolean saveUserInfo(User user) {
        UserInfo userInfo = UserConvertor.convert2UserInfo(user);
        this.userInfoService.save(userInfo);
        return true;
    }
}