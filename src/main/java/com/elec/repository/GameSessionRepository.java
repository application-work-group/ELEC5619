package com.elec.repository;

import com.elec.dal.pojo.GameSession;
import com.elec.dal.pojo.OperationRecord;
import com.elec.dto.valueObj.basketball.BasketDetail;
import com.elec.dto.valueObj.football.FootballDetail;

import java.util.List;

public interface GameSessionRepository {
    /**
     * 根据id获取比赛详情信息
     * @param gameId
     * @return
     */
    GameSession getDetailById (Long gameId);

    /**
     * 保存比赛信息
     * @param details
     * @return
     */
    boolean saveFootballGameDetail(List<FootballDetail> details);
    boolean saveBasketballGameDetail(List<BasketDetail> details);

    /**
     * updateResult
     * @param gameSessions
     * @return
     */
    boolean updateFootballGameDetail(List<GameSession> gameSessions);

    /**
     * getGameList
     * @return
     */
    List<GameSession> getPostList();

    /**
     * save the bet record
     * @param operationRecord
     * @return
     */
    boolean saveUserOperation (OperationRecord operationRecord);

    /**
     * update
     * @param gameSession
     * @return
     */
    boolean updateGameDetail(List<GameSession> gameSession);
}
