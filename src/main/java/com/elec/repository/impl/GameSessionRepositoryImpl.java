package com.elec.repository.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.elec.dal.pojo.GameSession;
import com.elec.dal.service.IGameSessionService;
import com.elec.repository.GameSessionRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class GameSessionRepositoryImpl implements GameSessionRepository {
    @Resource
    private IGameSessionService iGameSessionService;
    @Override
    public GameSession getDetailById(Long gameId) {
        GameSession gameSession = this.iGameSessionService.getOne(new LambdaQueryWrapper<GameSession>()
                .eq(GameSession::getGameId,gameId));
        return gameSession;
    }
}
