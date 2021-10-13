package com.elec.convertor;

import com.elec.component.GenerateId;
import com.elec.dal.pojo.PostInfo;
import com.elec.dal.pojo.User;
import com.elec.dal.pojo.UserInfo;
import com.elec.dto.PostSaveDTO;
import com.elec.dto.UserSaveDTO;

import java.util.Date;

public class UserConvertor {
    public static User convert2User(UserSaveDTO userSaveDTO){
        User user = new User();
        user.setId(1);
        user.setUserId(GenerateId.getGeneratID());
        user.setUserName(userSaveDTO.getUserName());
        user.setPassword(userSaveDTO.getPassword());
        user.setEmail(userSaveDTO.getEmail());
        user.setPhoneNumber(userSaveDTO.getPhoneNumber());
        user.setGmtCreate(new Date());
        user.setGmtModified(new Date());
        return user;
    }
    public static UserInfo convert2UserInfo(User user){
        UserInfo userInfo = new UserInfo();
//        userInfo.setId(1);
        userInfo.setUserId(user.getUserId());
        userInfo.setUserName(user.getUserName());
        userInfo.setCurrScores(1000L);
        userInfo.setGmtCreate(new Date());
        userInfo.setGmtModified(new Date());
        return userInfo;
    }
    public static PostInfo convert2PostInfo(PostSaveDTO postSaveDTO){
        PostInfo postInfo = new PostInfo();
        postInfo.setUserName(postSaveDTO.getUserName());
        postInfo.setTitle(postSaveDTO.getTitle());
        postInfo.setContent(postSaveDTO.getContent());
        postInfo.setGameType(postSaveDTO.getGameType());
        postInfo.setComment(postSaveDTO.getComment());
        postInfo.setGmtCreate(new Date());
        postInfo.setGmtModified(new Date());
        return postInfo;
    }
}
