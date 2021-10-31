
$(document).ready(function(){
    if(sessionStorage.getItem("isLogin")!="true"){
        sessionStorage.setItem("isLogin","false");
    }
    $(".empty").text(sessionStorage.getItem("isLogin"));
    $(".team_a_button").click(function(){
        $(".item1").text($(this).find("i").text());
        $(".item2").text($(this).find("b").text());
        $(".window_head span").text($(this).parent().prev().find(".title_name").text());
        if($(".vs").text()==""){
            $(".predict_window").show();
        }else {
            alert("the prediction is over");
        }
    });
    $(".team_b_button").click(function(){
        $(".item1").text($(this).find("i").text());
        $(".item2").text($(this).find("b").text());
        $(".window_head span").text($(this).parent().prev().find(".title_name").text());
        if($(".vs").text()==""){
            $(".predict_window").show();
        }else {
            alert("the prediction is over");
        }
    });
    $(".window_button_1").click(function(){
        $(".predict_window").hide();
    });
    $("#predict_number").bind('input propertychange',function(){
        var prize = $(this).val()*$(".item2").text();
        $(".item3_win").text("you can win : "+prize);
    });
    $(".window_button_2").click(function(){
        if(sessionStorage.getItem("isLogin")=="true"){
            var getGameId = $('.none_gameid').text();
            var GameId = parseInt(getGameId);
            var sendData = {
                paidScore: 100,
                userName: sessionStorage.getItem("userName"),
                userId: sessionStorage.getItem("userId"),
                gameId: GameId,
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