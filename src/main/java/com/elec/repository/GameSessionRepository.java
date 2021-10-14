package com.elec.repository;

import com.elec.dal.pojo.GameSession;
import com.elec.dto.valueObj.GameDetail;

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
    boolean saveFootballGameDetail(List<GameDetail> details);

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
}
