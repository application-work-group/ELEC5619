package com.elec.repository;

import com.elec.dal.pojo.User;

public interface UserRepository {
    /**
     * 保存
     * @param user@return
     */
    boolean saveUser(User user);
    /**
     * 保存用户账户信息
     * @param user
     * @return
     */
    boolean saveUserInfo(User user);
}
