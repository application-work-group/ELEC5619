
$(document).ready(function(){
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
        alert("predicting success");
    })
});