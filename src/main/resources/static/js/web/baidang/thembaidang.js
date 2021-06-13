$('#dangyc-btn').click( function () {
    if(validationFields()) {
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
                                    "hocPhi": $("#price_cost").val(),
                                    "ngayBatDau": $("#day-start").val(),
                                    "gioiTinh": false,
                                    "soBuoi": 2,
                                    "enable": 1,
                                    "mon": {
                                        "mon_Id": $("#monhoclinh").val()
                                    },
                                    "chuDe": {
                                        "chuDe_Id": 1
                                    },
                                    "buois": getCheckedBuois(),
                                    "taiKhoan": {
                                        "taiKhoan_Id": $("#tkid").val()
                                    }}),
            success: function (response) {
                window.location.href = "http://localhost:8083/taobaidang?uploadMsg=success";
            },
            error: function (response) {
                window.location.href = "http://localhost:8083/taobaidang?uploadMsg=failed";
            }
        });
    }
    
});

function getCheckedBuois() {
    var checkedBuois= [];
    var value;
    var buoiCheckboxes = $(".radio-calendar");
    for(var i=0; buoiCheckboxes[i]; ++i){
          if(buoiCheckboxes[i].checked){
            value = buoiCheckboxes[i].value.split("_");
            var buoiObj = {"buoi": value[0], "ngayTrongTuan": value[1]}
            checkedBuois.push(buoiObj);
          }
    }
    return checkedBuois;
}

function validationFields() {
    $("#vali-tomtatyc").css("display", "none");
    $("#vali-sdt").css("display", "none");
    $("#vali-mota").css("display", "none");
    $("#vali-hocphi").css("display", "none");
    $("#vali-ngayhoc").css("display", "none");
    var flagg = true;

    if($("#tomtatyc").val() == "") {
        $("#vali-tomtatyc").css("display", "block");
        flagg = false;
    }
    if($("#phone_class").val() == "") {
        $("#vali-sdt").css("display", "block");
        flagg = false;
    }
    if($("#introduce-class").val() == "") {
        $("#vali-mota").css("display", "block");
        flagg = false;
    }
    if($("#price_cost").val() == "") {
        $("#vali-hocphi").css("display", "block");
        flagg = false;
    }
    if($("#day-start").val() == "") {
        $("#vali-ngayhoc").css("display", "block");
        flagg = false;
    }
    if($("#monhoclinh").val() == "") {
        $("#vali-mon").css("display", "block");
        flagg = false;
    }
    if(getCheckedBuois().length == 0) {
        $("#vali-buois").css("display", "block");
    }
    return flagg;
}
