package com.elec.service.impl;

import com.elec.component.MD5Utils;
import com.elec.component.UserFactory;
import com.elec.dal.pojo.User;
import com.elec.dto.UserSaveDTO;
import com.elec.repository.UserRepository;
import com.elec.service.UserSaveService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserSaveServiceImpl implements UserSaveService {
    @Resource
    private UserRepository userRepository;
    @Override
    public Boolean saveUserInfo(UserSaveDTO userSaveDTO) {
        //初始化
        User user = UserFactory.create(userSaveDTO);
        //处理密码加密
        String password = MD5Utils.stringToMD5(user.getPassword());
        user.setPassword(password);
        this.userRepository.saveUser(user);
        this.userRepository.saveUserInfo(user);
        return true;
    }
}
