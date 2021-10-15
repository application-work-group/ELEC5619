package com.elec.repository.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.elec.convertor.UserConvertor;
import com.elec.dal.pojo.GameSession;
import com.elec.dal.pojo.OperationRecord;
import com.elec.dal.service.IGameSessionService;
import com.elec.dal.service.IOperationRecordService;
import com.elec.dto.valueObj.GameDetail;
import com.elec.repository.GameSessionRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Repository
public class GameSessionRepositoryImpl implements GameSessionRepository {
    @Resource
    private IGameSessionService iGameSessionService;
    @Resource
    private IOperationRecordService iOperationRecordService;
    @Override
    public GameSession getDetailById(Long gameId) {
        GameSession gameSession = this.iGameSessionService.getOne(new LambdaQueryWrapper<GameSession>()
                .eq(GameSession::getGameId,gameId));
        return gameSession;
    }

    @Override
    public boolean saveFootballGameDetail(List<GameDetail> details) {
        List<GameSession> gameSessions = new ArrayList<>();
        details.forEach(detail->{
            GameSession gameSession = UserConvertor.convert2GameSession(detail);
            gameSessions.add(gameSession);
        });
        return this.iGameSessionService.saveBatch(gameSessions);
    }

    @Override
    public boolean updateFootballGameDetail(List<GameSession> gameSessions) {
        return false;
    }

    @Override
    public List<GameSession> getPostList() {
        List<GameSession> gameSessions = iGameSessionService.list(new LambdaQueryWrapper<>());
        return gameSessions;
    }

    @Override
    public boolean saveUserOperation(OperationRecord operationRecord) {
        return this.iOperationRecordService.save(operationRecord);
    }
}
