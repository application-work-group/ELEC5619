package com.elec.service;

import com.elec.dal.pojo.GameSession;

import java.util.List;

public interface GameSessionHandleService {
    /**
     * 获取比赛详情信息
     * @param gameId
     * @return
     */
    GameSession getDetail(Long gameId);

    /**
     * save
     * @return
     */
    boolean saveDetail();

    /**
     * get game list
     * @return
     */
    List<GameSession> getGameList();
}
