package com.elec.repository;

import com.elec.dal.pojo.GameSession;

public interface GameSessionRepository {
    /**
     * 根据id获取比赛详情信息
     * @param gameId
     * @return
     */
    GameSession getDetailById (Long gameId);
}
