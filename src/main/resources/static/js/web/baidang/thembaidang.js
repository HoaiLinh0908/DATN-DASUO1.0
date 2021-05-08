$('#submit-btn').click( function () {
    $.ajax({
        url: "http://localhost:8083/api/baidangs",
        type: "post",
        contentType: "application/json; charset=utf-8",
        async: false,
        dataType: "json",
        // du lieu truyen vao dang json 
        data: JSON.stringify({ "tomTatYeuCau": $("#tomtatyc").val(),
                                "hocPhi": $("#email").val(),
                                "sdt": $("#sodienthoai").val(),
                                "moTa": $("#password1").val(),
                                "hocPhi": $(""),
                                "gioiTinh": $(""),
                                "soBuoi": $(""),
                                "ngayBatDau": $(""),
                                "buois": null,
                                "mon": {
                                    "mon_Id": $("monhoclinh").val()
                                },
                                "chuDe": {
                                    "chuDe_Id": 1
                                },
                                "taiKhoan": {
                                    "taiKhoan_Id": 36
                                }}),
        success: function (response) {
            $("#firstname").val("");
            $("#email").val("");
            $("#sodienthoai").val("");
            $("#password1").val("");
            $("#password2").val("");
            console.log(response);
            $('.success-alert-linh').show();
            $('.error-alert-linh').hide();
            $("#cf-password-msg").hide();
        },
        error: function (response) {
            console.log(response)
            $("#password1").val("");
            $("#password2").val("");
            $('.error-alert-linh').show();
            $('.success-alert-linh').hide();
            $("#cf-password-msg").hide();
        }
    });
});