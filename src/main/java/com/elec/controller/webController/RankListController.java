package com.elec.controller.webController;

import com.elec.dal.pojo.UserInfo;
import com.elec.service.RankListService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/rank/list")
public class RankListController {
    @Resource
    private RankListService rankListService;
    //实时用户积分排名
    @PostMapping("/getRankList")
    public List<UserInfo> getRankList(){
        return this.rankListService.getUserInfoList();
    }
    //
    //
    //
}
