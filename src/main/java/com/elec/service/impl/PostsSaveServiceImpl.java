package com.elec.service.impl;

import com.elec.component.GenerateId;
import com.elec.dal.pojo.PostInfo;
import com.elec.dto.PostSaveDTO;
import com.elec.repository.PostRepository;
import com.elec.service.PostsSaveService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class PostsSaveServiceImpl implements PostsSaveService {
    @Resource
    private PostRepository postRepository;
    @Override
    public Boolean savePostInfo(PostSaveDTO postSaveDTO) {
        String postId = GenerateId.getGeneratID().toString();
        postSaveDTO.setPostId(postId);
        this.postRepository.save(postSaveDTO);
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
}
