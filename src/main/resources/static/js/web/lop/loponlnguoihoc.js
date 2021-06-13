$(document).ready(function () {
    var roomID = $("#tenlop").html();
    console.log(roomID);
    var htmlStr = `<p style="margin: 20px; padding-top: 15px;">Đợi gia sư tạo phòng học rồi mới vào nha!</p>
    <div class="lophoctructuyen-top">
    <a class="btn-taoroom" href="https://stg-vid-call.glitch.me?room=` + $("#tenlop").html() + `" target="_blank">Tham gia lớp học</a>
                                    </div>`;
	$(".loponl-conten").html(htmlStr);
});