package com.elec.controller;

import com.alibaba.fastjson.JSONObject;
import com.elec.dal.pojo.PostInfo;
import com.elec.dto.PostSaveDTO;
import com.elec.dto.valueObj.Result;
import com.elec.service.PostsSaveService;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.ui.Model;

import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Jinglin
 * @since 2021-10-08
 */
@Controller
@RequestMapping("/post-info")
public class PostInfoController {
    @Resource
    private PostsSaveService postsSaveService;
    @RequestMapping("/post")
    public String test2shuyuan(Model model){
        PostInfo list1 = Result.succeed(this.postsSaveService.getPostList()).getData().get(0);
        model.addAttribute("postlist1",list1);
        PostInfo list2 = Result.succeed(this.postsSaveService.getPostList()).getData().get(1);
        model.addAttribute("postlist2",list2);
        PostInfo list3 = Result.succeed(this.postsSaveService.getPostList()).getData().get(2);
        model.addAttribute("postlist3",list3);
        PostInfo list4 = Result.succeed(this.postsSaveService.getPostList()).getData().get(3);
        model.addAttribute("postlist4",list4);
        PostInfo list5 = Result.succeed(this.postsSaveService.getPostList()).getData().get(4);
        model.addAttribute("postlist5",list5);
        return "post";
    }
}
