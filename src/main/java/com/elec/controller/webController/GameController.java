package com.elec.controller.webController;

import com.elec.dto.valueObj.Result;
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
    public Result<?> queryGameDetail(@RequestParam(value = "gameId") Long gameId){
        return Result.succeed(this.gameSessionHandleService.getDetail(gameId));
    }
    //保存用户操作（下注）
    @PostMapping("/saveUserOperation")
    public Result<?> saveUserOperation(){
        return Result.succeed();
    }
    //更新用户操作
    @PostMapping("/updateUserOperation")
    public Result<?> updateUserOperation(){
        return Result.succeed();
    }
    //获取比赛列表
    @PostMapping("/getGameList")
    public Result<?> getGameList(){
        return Result.succeed(this.gameSessionHandleService.getGameList());
    }
    //
}
