
$(document).ready(function(){
    $(".release_button").click(function(){
        var getTitle = $("#title_area").val();
        var getContent = $("#reply_textarea").val();
        var sendData = {
            userName: 'qqq',
            gameType: 'FOOTBALL',
            title: getTitle,
            content: getContent,
            comment: 'let me out',
        }
        $.ajax({
            url:'http://localhost:8080/save/post/savePost',
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
    });
})
