package com.elec.repository;

import com.elec.dal.pojo.User;

/**
 * @author JinglinWang
 * @date 2021.9.8 10:24:20
 */
public interface SportsBetRepository {
    Boolean saveUser(User user);
}
