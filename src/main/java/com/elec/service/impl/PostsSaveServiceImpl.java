package com.elec.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.elec.component.GenerateId;
import com.elec.dal.pojo.PostInfo;
import com.elec.dal.pojo.UserInfo;
import com.elec.dto.PostSaveDTO;
import com.elec.dto.UserSaveDTO;
import com.elec.repository.PostRepository;
import com.elec.service.PostsSaveService;
import com.elec.service.UserSaveService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class PostsSaveServiceImpl implements PostsSaveService {
    @Resource
    private PostRepository postRepository;
    @Resource
    private UserSaveService userSaveService;
    @Override
    public Boolean savePostInfo(PostSaveDTO postSaveDTO) {
        String postId = GenerateId.getGeneratID().toString();
        postSaveDTO.setPostId(postId);
        final Boolean save = this.postRepository.save(postSaveDTO);
        if (save){
            final UserInfo userInfo = this.userSaveService.queryUserInfo(postSaveDTO.getUserName());
            if (StringUtils.isNotBlank(userInfo.getPostList())){
                JSONArray array = JSONArray.parseArray(userInfo.getPostList());
                List<String> list = array.toJavaList(String.class);
                list.add(postId);
                userInfo.setPostList(JSONObject.toJSONString(list));
                final UserSaveDTO userSaveDTO = this.UserInfo2userSaveDTO(userInfo);
                this.userSaveService.saveUserInfo(userSaveDTO);
            }else {
                List<String> list = new ArrayList<>();
                list.add(postId);
                userInfo.setPostList(JSONObject.toJSONString(list));
                final UserSaveDTO userSaveDTO = this.UserInfo2userSaveDTO(userInfo);
                this.userSaveService.saveUserInfo(userSaveDTO);
            }
        }
        return true;
    }

    @Override
    public PostSaveDTO queryPostInfoById(String postId) {
        return this.postRepository.queryDetailById(postId);
    }

    @Override
    public List<PostInfo> getPostList() {

        List<PostInfo> list =  this.postRepository.getPostList();//这个list就是数据源
        int listNum = 20;
        int returnNum = list.size();
        //如果listNum大于数据源list，直接返回list数据源全部数据
        if(listNum < list.size()) {
            returnNum = listNum;
        }
        int randomIndex =  (int) (Math.random() * (list.size()-returnNum));
        List<PostInfo> resultList= new ArrayList<>();
        for (int i = randomIndex; i < randomIndex+returnNum; i++) {
            resultList.add(list.get(i));
        }
        return resultList;
    }

    public UserSaveDTO UserInfo2userSaveDTO(UserInfo userInfo){
        UserSaveDTO userSaveDTO = new UserSaveDTO();
        BeanUtils.copyProperties(userInfo,userSaveDTO);
        return userSaveDTO;
    }
}
