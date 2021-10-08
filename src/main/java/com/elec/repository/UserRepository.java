package com.elec.repository;

import com.elec.dal.pojo.User;
import com.elec.dal.pojo.UserInfo;
import com.elec.dto.UserSaveDTO;

import java.util.List;

public interface UserRepository {
    /**
     * 保存
     * @param user
     * @return
     */
    boolean saveUser(User user);
    /**
     * 保存用户账户信息
     * @param user
     * @return
     */
    boolean saveUserInfo(User user);

    /**
     * 判断是否用户名重复
     * @param userName
     * @return
     */
    boolean whetherRepeatName(String userName);

    /**
     * 判断用户登录
     * @param userSaveDTO
     * @return
     */
    boolean userLogin(UserSaveDTO userSaveDTO);

    /**
     * 获取用户详情
     * @param userName
     * @return
     */
    UserInfo queryUserInfo(String userName);

    /**
     * 获取所有用户积分信息
     * @return
     */
    List<UserInfo> getUserInfos();
}
