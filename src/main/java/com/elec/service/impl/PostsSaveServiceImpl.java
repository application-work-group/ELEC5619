package com.elec.service.impl;

import com.elec.dto.PostSaveDTO;
import com.elec.repository.PostRepository;
import com.elec.service.PostsSaveService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PostsSaveServiceImpl implements PostsSaveService {
    @Resource
    private PostRepository postRepository;
    @Override
    public Boolean savePostInfo(PostSaveDTO postSaveDTO) {
        this.postRepository.save(postSaveDTO);
        return true;
    }
}
