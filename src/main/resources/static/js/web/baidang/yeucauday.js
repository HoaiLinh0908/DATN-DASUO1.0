$(document).ready(function () {
$('#dangkyday-btn').click( function () {
    console.log("hell1")
    $.ajax({
        url: "http://localhost:8083/api/baidangs/yeucauday/" + $("#bdid").val(),
        type: "put",
        contentType: "application/json; charset=utf-8",
        async: false,
        dataType: "json",
        // du lieu truyen vao dang json 
        data: JSON.stringify({ "baiDang_Id": $("#bdid").val(),
                                "taiKhoans": [{
                                    "taiKhoan_Id": $("#tkid").val()
                                }]}),
        success: function (response) {
            alert("Gửi yêu cầu thành công!!!");
            window.location.href = "http://localhost:8083/chitietbaidang?id=" + $("#bdid").val();
        },
        error: function (response) {
            alert("Gửi yêu cầu thất bại!!!");
        }
    });
});
});
