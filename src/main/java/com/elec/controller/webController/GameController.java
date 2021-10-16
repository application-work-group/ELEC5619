package com.elec.controller.webController;

import com.elec.dal.pojo.GameSession;
import com.elec.service.GameSessionHandleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

@Controller
@RequestMapping("/game/gameSession")
public class GameController {
    @Resource
    private GameSessionHandleService gameSessionHandleService;
    //获取比赛信息详情
    @GetMapping("/queryGameDetail")
    public GameSession queryGameDetail(@RequestParam(value = "gameId") Long gameId){
        return this.gameSessionHandleService.getDetail(gameId);
    }
    //保存用户操作（下注）
    @PostMapping("/saveUserOperation")
    public Boolean saveUserOperation(){
        return true;
    }
    //更新用户操作
    @PostMapping("/updateUserOperation")
    public Boolean updateUserOperation(){
        return true;
    }
    //获取比赛列表
    @PostMapping("/getGameList")
    public Boolean getGameList(){
        return true;
    }
    //
}
