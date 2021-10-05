package com.elec.dto.valueObj;

import lombok.Data;

import java.sql.Time;

@Data
public class BasketballScores {
    private Integer quarter_1;
    private Integer quarter_2;
    private Integer quarter_3;
    private Integer quarter_4;
    private Time overTime;
    private Integer total;
}
