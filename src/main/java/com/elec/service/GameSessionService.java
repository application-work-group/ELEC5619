package com.elec.service;

import com.elec.dal.pojo.GameSession;

public interface GameSessionService {
    /**
     * 获取比赛详情信息
     * @param gameId
     * @return
     */
    GameSession getDetail(Long gameId);
}
