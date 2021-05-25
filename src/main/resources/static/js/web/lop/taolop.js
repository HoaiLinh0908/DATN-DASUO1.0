$(document).ready(function () {
 $("#taolop-btn").click( function () {
    $.ajax({
        url: "http://localhost:8083/api/lops",
        type: "post",
        contentType: "application/json; charset=utf-8",
        async: false,
        dataType: "json",
        // du lieu truyen vao dang json 
        data: JSON.stringify({  "baiDangId": $("#bdid").val(),
                                "ngayNhan": "2021-04-02T17:00:00.000+00:00",
                                "gioHoc": 20,
                                "nguoiHoc": {
                                    "taiKhoan_Id": $("#tkid").val()
                                },
                                "nguoiDay": {
                                    "taiKhoan_Id": 5
                                }}),
        success: function (response) {
            alert("Đã tạo lớp thành công!!!");
            $("#taolop-btn").css({"display":"none"});
        },
        error: function (response) {
            alert("Tạo lớp thất bại!!!");
            $("#taolop-btn").disabled = false;
        }
    });
 });
});
