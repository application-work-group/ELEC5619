package com.elec.service;

import com.elec.dal.pojo.UserInfo;
import com.elec.dto.UserSaveDTO;

public interface UserSaveService {
    /**
     * 保存用户信息
     * @param userSaveDTO
     * @return
     */
    Boolean saveUserInfo(UserSaveDTO userSaveDTO);

    /**
     * 用户登录
     * @param userSaveDTO
     * @return
     */
    Boolean userLogin(UserSaveDTO userSaveDTO);

    /**
     * 获取用户详情信息
     * @param userName
     * @return
     */
    UserInfo queryUserInfo(String userName);
}
