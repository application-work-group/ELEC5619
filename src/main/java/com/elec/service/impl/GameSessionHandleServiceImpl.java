package com.elec.service.impl;

import com.elec.dal.pojo.GameSession;
import com.elec.repository.GameSessionRepository;
import com.elec.service.GameSessionHandleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class GameSessionHandleServiceImpl implements GameSessionHandleService {
    @Resource
    private GameSessionRepository gameSessionRepository;
    @Override
    public GameSession getDetail(Long gameId) {
        GameSession gameSession = this.gameSessionRepository.getDetailById(gameId);
        return gameSession;
    }
}
