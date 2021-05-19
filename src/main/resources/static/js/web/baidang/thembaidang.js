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
                                "hocPhi": $("#phone_class").val(),

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
