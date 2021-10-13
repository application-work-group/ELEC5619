package com.elec.service;

import com.elec.dto.PostSaveDTO;

public interface PostsSaveService {
    /**
     * 保存帖子信息
     * @param postSaveDTO
     * @return
     */
    Boolean savePostInfo(PostSaveDTO postSaveDTO);

}
