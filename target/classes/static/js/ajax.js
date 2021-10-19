var sendData = {
    userName: 'David',
    gameType: 'FOOTBALL',
    title: 'title123',
    content: 'let me in ',
    comment: 'let me out',
}
$(document).ready(function(){
    $(".release_button").click(function(){
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
