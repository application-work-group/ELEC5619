package com.elec.controller.webController;

import com.elec.dto.PostSaveDTO;
import com.elec.service.PostsSaveService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/save/post")
public class PostsController {
    @Resource
    private PostsSaveService postsSaveService;
    //发帖帖子入库
    @PostMapping("/savePost")
    public Boolean savePost(@RequestBody PostSaveDTO postSaveDTO){
        this.postsSaveService.savePostInfo(postSaveDTO);
        return true;
    }
    //获取帖子详情
    @PostMapping("/getPostDetail")
    public Boolean getPostDetail(){
        return true;
    }
    //更新帖子信息
    @PostMapping("/updatePostInfo")
    public Boolean updatePostInfo(){
        return true;
    }
    //获取帖子列表
    @PostMapping("/getPostList")
    public Boolean getPostList(){
        return true;
    }
}
