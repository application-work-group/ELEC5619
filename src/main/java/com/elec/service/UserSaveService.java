package com.elec.service;

import com.elec.dto.UserSaveDTO;

public interface UserSaveService {
    /**
     * 保存用户信息
     * @param userSaveDTO
     * @return
     */
    Boolean saveUserInfo(UserSaveDTO userSaveDTO);
}
