
$(document).ready(function(){
    sessionStorage.setItem("isLogIn","true");
    sessionStorage.setItem("userName",1020094254486841);
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
        if(sessionStorage.getItem("isLogIn")=="true"){
            var getGameId = $('.none_gameid').text();
            var GameId = parseInt(getGameId);
            var sendData = {
                paidScore: 100,
                userName: "qqq",
                userId: 1020094254486841,
                gameId: 1018080618093594,
                comment: "200",
                victoryOrDefeat: "VICTORY",
            }
            $.ajax({
                url:'http://localhost:8080/game/gameSession/saveUserOperation',
                data: JSON.stringify(sendData),
                type: 'POST',
                dataType: "json",
                contentType: 'application/json;charset=UTF-8',
                crossDomain: true,
                success : function(data){
                    alert("success");
                },
                fail : function(){
                    alert("fail");
                },
                error : function(){
                    alert("error");
                }
            });
        }else{
            alert("please login first");
        }

    })
});