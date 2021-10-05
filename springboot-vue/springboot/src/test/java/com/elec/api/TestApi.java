package com.elec.api;

import com.elec.controller.ApiTestController;
import com.elec.devTest.BaseTest;
import org.junit.Test;
import org.springframework.http.HttpHeaders;

import javax.annotation.Resource;

public class TestApi extends BaseTest {
    @Resource
    public ApiTestController apiTestController;
    @Test
    public void testCovidApi(){
        String uri = "https://worldometer-covid-19.p.rapidapi.com/GetCovidStats?countrycode=us";
        HttpHeaders headers = new HttpHeaders();
        headers.add("x-rapidapi-host","worldometer-covid-19.p.rapidapi.com");
        headers.add("x-rapidapi-key","77bb1ccd20mshed85a95ffefdbebp187d43jsn4773d71cca23");
        HttpRequestA.getResult(headers,uri);
    }
    @Test
    public void testLocationApi(){
        String uri = "https://ip-geo-location.p.rapidapi.com/ip/check?format=json";
        HttpHeaders headers = new HttpHeaders();
        headers.add("x-rapidapi-host","ip-geo-location.p.rapidapi.com");
        headers.add("x-rapidapi-key","77bb1ccd20mshed85a95ffefdbebp187d43jsn4773d71cca23");
        HttpRequestA.getResult(headers,uri);
    }
    @Test
    public void testBasketballApi(){
        String uri = "https://api-basketball.p.rapidapi.com/games?date=2021-04-14";
        HttpHeaders headers = new HttpHeaders();
        headers.add("x-rapidapi-host","api-basketball.p.rapidapi.com");
        headers.add("x-rapidapi-key","77bb1ccd20mshed85a95ffefdbebp187d43jsn4773d71cca23");
        HttpRequestA.getResult(headers,uri);
    }
}
