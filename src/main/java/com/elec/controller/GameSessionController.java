package com.elec.controller;


import com.elec.dal.pojo.GameSession;
import com.elec.dto.valueObj.Result;
import com.elec.service.UserSaveService;
import org.springframework.ui.Model;
import com.elec.service.GameSessionHandleService;
import org.springframework.web.bind.annotation.RequestMapping;

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
@RequestMapping("/game-session")
public class GameSessionController {
    @Resource
    private UserSaveService userSaveService;
    @Resource
    private GameSessionHandleService gameSessionHandleService;

    @RequestMapping("/test0shuyuan")
    public String test0shuyuan(Model model){
        Long score = Result.succeed(this.userSaveService.queryUserInfo("usernamelululu1wo")).getData().getCurrScores();
        GameSession gs = Result.succeed(this.gameSessionHandleService.getGameList()).getData().get(0);
        Long gameId = gs.getGameId();
        GameSession gs1 = Result.succeed(this.gameSessionHandleService.getDetail(gameId)).getData();
        model.addAttribute("gameSession",gs1);
        return "test";
    }
    @RequestMapping("/test1shuyuan")
    public String test1shuyuan(){
        return "post";
    }
}
