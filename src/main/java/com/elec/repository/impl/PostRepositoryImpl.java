package com.elec.repository.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.elec.convertor.UserConvertor;
import com.elec.dal.pojo.PostInfo;
import com.elec.dal.service.IPostInfoService;
import com.elec.dto.PostSaveDTO;
import com.elec.repository.PostRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class PostRepositoryImpl implements PostRepository {
    @Resource
    private IPostInfoService iPostInfoService;
    @Override
    public Boolean save(PostSaveDTO postSaveDTO) {
        PostInfo postInfo = UserConvertor.convert2PostInfo(postSaveDTO);
        this.iPostInfoService.save(postInfo);
        return true;
    }

    @Override
    public PostSaveDTO queryDetailById(String postId) {
        return null;
    }

    @Override
    public List<PostInfo> getPostList() {
        List<PostInfo> postInfos = iPostInfoService.list(new LambdaQueryWrapper<>());
        return postInfos;
    }
}
