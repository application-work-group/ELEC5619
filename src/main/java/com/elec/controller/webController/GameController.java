package com.elec.controller.webController;

import com.elec.dto.GameBetDTO;
import com.elec.dto.UpdateGameDetailDTO;
import com.elec.dto.valueObj.Result;
import com.elec.service.GameSessionHandleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
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
    public Result<?> saveUserOperation(@RequestBody GameBetDTO gameBetDTO){
        return Result.succeed(this.gameSessionHandleService.saveUserOperation(gameBetDTO));
    }
    //更新用户操作
    // TODO: 2021/10/16  
    @PostMapping("/updateUserOperation")
    public Result<?> updateUserOperation(){
        return Result.succeed();
    }
    //获取比赛列表
    @PostMapping("/getGameList")
    public Result<?> getGameList(){
        return Result.succeed(this.gameSessionHandleService.getGameList());
    }
    //更新比赛信息
    @PostMapping("/updateGameInfo")
    public Result<?> updateGameInfo(@RequestBody UpdateGameDetailDTO updateGameDetailDTO){
        return Result.succeed(this.gameSessionHandleService.updateGameDetail(updateGameDetailDTO));
    }
    //保存篮球
    @PostMapping
    public Result<?> saveBasketballDetail(){
        return Result.succeed(this.gameSessionHandleService.saveBasketballDetail());
    }
}
