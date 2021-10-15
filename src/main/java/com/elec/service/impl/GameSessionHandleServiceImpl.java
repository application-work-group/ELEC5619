package com.elec.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.elec.api.HttpRequestA;
import com.elec.dal.pojo.GameSession;
import com.elec.dal.pojo.OperationRecord;
import com.elec.dto.GameBetDTO;
import com.elec.dto.valueObj.GameDetail;
import com.elec.dto.valueObj.Result;
import com.elec.enums.GameVictoryOrDefeatEnums;
import com.elec.enums.UserOperationEnums;
import com.elec.repository.GameSessionRepository;
import com.elec.service.GameSessionHandleService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class GameSessionHandleServiceImpl implements GameSessionHandleService {
    @Resource
    private GameSessionRepository gameSessionRepository;
    @Override
    public GameSession getDetail(Long gameId) {
        GameSession gameSession = this.gameSessionRepository.getDetailById(gameId);

        return gameSession;
    }

    @Override
    public boolean saveDetail() {
        String uri = "https://odds.p.rapidapi.com/v1/odds?sport=soccer_epl&region=uk&mkt=h2h&dateFormat=iso&oddsFormat=decimal";
        HttpHeaders headers = new HttpHeaders();
        headers.add("x-rapidapi-host","odds.p.rapidapi.com");
        headers.add("x-rapidapi-key","77bb1ccd20mshed85a95ffefdbebp187d43jsn4773d71cca23");
        ResponseEntity<String> result = HttpRequestA.getResult(headers, uri);
        String s = JSONObject.toJSONString(result.getBody());

        Result<?> result1 = JSONObject.parseObject(result.getBody(),Result.class);
        if (null!=result1){
            final Object data = result1.getData();
            JSONArray array = JSONObject.parseArray(JSONObject.toJSONString(data));
            List<GameDetail> list = array.toJavaList(GameDetail.class);
            this.gameSessionRepository.saveFootballGameDetail(list);
            return true;
        }else {
            return false;
        }
    }

    @Override
    public List<GameSession> getGameList() {
        List<GameSession> list =  this.gameSessionRepository.getPostList();//这个list就是数据源
        int listNum = 20;
        int returnNum = list.size();
        //如果listNum大于数据源list，直接返回list数据源全部数据
        if(listNum < list.size()) {
            returnNum = listNum;
        }
        int randomIndex =  (int) (Math.random() * (list.size()-returnNum));
        List<GameSession> resultList= new ArrayList<>();
        for (int i = randomIndex; i < randomIndex+returnNum; i++) {
            resultList.add(list.get(i));
        }
        return resultList;
    }

    @Override
    public boolean saveUserOperation(GameBetDTO gameBetDTO) {
        GameSession gameSession = this.getDetail(gameBetDTO.getGameId());
        String oddsInformation = gameSession.getOddsInformation();
        JSONArray jsonArray = JSONObject.parseArray(oddsInformation);
        List<BigDecimal> list = jsonArray.toJavaList(BigDecimal.class);
        String gameInfo = gameSession.getGameType()+gameSession.getHome()+"vs"+gameSession.getAway();
        OperationRecord operationRecord = new OperationRecord();
        operationRecord.setPaidScores(gameBetDTO.getPaidScore());
        operationRecord.setUserId(gameBetDTO.getUserId());
        operationRecord.setUserName(gameBetDTO.getUserName());
        if (StringUtils.isNotBlank(gameBetDTO.getComment())){
            operationRecord.setComment(gameBetDTO.getComment());
        }
        if (GameVictoryOrDefeatEnums.VICTORY.name().equals(gameBetDTO.getVictoryOrDefeat())){
            BigDecimal winOdd = list.get(0);
            String oddInfo = GameVictoryOrDefeatEnums.VICTORY.name()+":"+winOdd.toString();
            operationRecord.setOddsInformation(oddInfo);
        }else if (GameVictoryOrDefeatEnums.DRAW.name().equals(gameBetDTO.getVictoryOrDefeat())){
            BigDecimal winOdd = list.get(1);
            String oddInfo = GameVictoryOrDefeatEnums.DRAW.name()+":"+winOdd.toString();
            operationRecord.setOddsInformation(oddInfo);
        }else {
            BigDecimal winOdd = list.get(1);
            String oddInfo = GameVictoryOrDefeatEnums.DEFEAT.name()+":"+winOdd.toString();
            operationRecord.setOddsInformation(oddInfo);
        }
        operationRecord.setOperationStatus(UserOperationEnums.QUIZ.name());
        operationRecord.setGameSession(gameInfo);
        return this.gameSessionRepository.saveUserOperation(operationRecord);
    }
}
