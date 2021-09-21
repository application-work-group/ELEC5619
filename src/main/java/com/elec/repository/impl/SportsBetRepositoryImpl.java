package com.elec.repository.impl;

import com.elec.dal.pojo.User;
import com.elec.dal.service.IUserService;
import com.elec.repository.SportsBetRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class SportsBetRepositoryImpl implements SportsBetRepository {
    @Resource
    private IUserService iUserService;
    @Override
    public Boolean saveUser(User user) {
        try{
            boolean save = iUserService.save(user);
        }catch (Exception e){
            System.out.println(e);
        }

        return true;
    }
}
