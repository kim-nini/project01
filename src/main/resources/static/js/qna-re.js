function sendQnaRe() {

    $.ajax({
        url: "",
        method: "GET",
        success: function(data) {
            // 요청이 성공했을 때
            $("#result").html("ID: " + data.id + "<br>Title: " + data.title);
        },
        error: function() {
            console.error("실패");
        }
    });
}



























