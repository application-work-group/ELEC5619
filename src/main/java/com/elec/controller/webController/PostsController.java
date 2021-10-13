package com.elec.controller.webController;

import com.alibaba.fastjson.JSONObject;
import com.elec.dto.PostSaveDTO;
import com.elec.service.PostsSaveService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Controller
@RequestMapping("/save/post")
public class PostsController {
    @Resource
    private PostsSaveService postsSaveService;
    //发帖帖子入库
    @PostMapping("/savePost")
    public JSONObject savePost(@RequestBody PostSaveDTO postSaveDTO){
        JSONObject object = new JSONObject();
        object.fluentPut("result",this.postsSaveService.savePostInfo(postSaveDTO));
        return object;
    }
    //获取帖子详情
    @GetMapping("/getPostDetail")
    public JSONObject getPostDetail(@RequestParam(value = "postId") String postId){
        JSONObject object = new JSONObject();
        PostSaveDTO postSaveDTO= this.postsSaveService.queryPostInfoById(postId);
        object.fluentPut("postDetail",postSaveDTO);
        return object;
    }
    //更新帖子信息
    @PostMapping("/updatePostInfo")
    public Boolean updatePostInfo(){
        return true;
    }
    //获取帖子列表
    @PostMapping("/getPostList")
    public JSONObject getPostList(){
        JSONObject object = new JSONObject();
        object.fluentPut("postInfos",this.postsSaveService.getPostList());
        return object;
    }
}
