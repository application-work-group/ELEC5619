
$(document).ready(function(){

    sessionStorage.setItem("isLogIn",true);
    $(".empty").text(sessionStorage.getItem("isLogIn"))
    $(".team_a_button").click(function(){
        $(".item1").text($(this).find("i").text());
        $(".item2").text($(this).find("b").text());
        $(".window_head span").text($(this).parent().prev().find(".title_name").text());
        $(".predict_window").show();
    });
    $(".team_b_button").click(function(){
        $(".item1").text($(this).find("i").text());
        $(".item2").text($(this).find("b").text());
        $(".window_head span").text($(this).parent().prev().find(".title_name").text());
        $(".predict_window").show();
    });
    $(".window_button_1").click(function(){
        $(".predict_window").hide();
    });
    $("#predict_number").bind('input propertychange',function(){
        var prize = $(this).val()*$(".item2").text();
        $(".item3_win").text("you can win : "+prize);
    });
    $(".window_button_2").click(function(){
        var sendData = {
            paidScore: 123,
            userName: "qqq",
            userId: 1234455,
            gameId: 1234555,
            comment: 12444,
            victoryOrDefeat: "true",
        }
    })
});