$('#dangyc-btn').click( function () {
    $.ajax({
        url: "http://localhost:8083/api/baidangs",
        type: "post",
        contentType: "application/json; charset=utf-8",
        async: false,
        dataType: "json",
        // du lieu truyen vao dang json 
        data: JSON.stringify({ "tomTatYeuCau": $("#tomtatyc").val(),
                                "sdt": $("#phone_class").val(),
                                "moTa": $("#introduce-class").val(),
                                "hocPhi": 200000,
                                "gioiTinh": false,
                                "soBuoi": 2,
                                "mon": {
                                    "mon_Id": $("#monhoclinh").val()
                                },
                                "chuDe": {
                                    "chuDe_Id": 1
                                },
                                "taiKhoan": {
                                    "taiKhoan_Id": $("p#tkid").val()
                                }}),
        success: function (response) {
            $("#tomtatyc").val("");
            $("#phone_class").val("");
            $("#introduce-class").val("");
            $("#price_cost").val("");
            $("#monhoclinh").val("");
            console.log(response);
            $('.success-alert-linh').show();
            $('.error-alert-linh').hide();
        },
        error: function (response) {
            console.log(response)
            // $("#tomtatyc").val("");
            // $("#phone_class").val("");
            // $("#introduce-class").val("");
            // $("#price_cost").val("");
            // $("#monhoclinh").val("");
            $('.error-alert-linh').show();
            $('.success-alert-linh').hide();
        }
    });
});