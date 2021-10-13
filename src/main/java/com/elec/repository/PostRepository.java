package com.elec.repository;

import com.elec.dto.PostSaveDTO;

public interface PostRepository {
    Boolean save(PostSaveDTO postSaveDTO);
}
