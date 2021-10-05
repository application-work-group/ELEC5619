package com.elec.dto;

import com.elec.dto.valueObj.*;
import lombok.Data;

import java.util.Date;
import java.util.List;
@Data
public class BasketballApiDTO {
    private List<ApiResponse> response;
    @Data
    public static class ApiResponse{
        private Integer id;
        private Date date;
        private Date time;
        private Long timeStamp;
        private String timeZone;
        private String stage;
        private String week;
        private GameStatus status;
        private GameLeague league;
        private GameCountry country;
        private GameScores scores;
        private GameTeams teams;
    }
}
