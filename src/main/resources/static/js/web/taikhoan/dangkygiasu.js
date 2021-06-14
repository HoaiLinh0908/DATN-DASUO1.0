$(document).ready(function () {
    $('#dangky-giasu').click( function () {

        if(validationFields()) {
            $.ajax({
                url: "http://localhost:8083/api/taikhoans/" + $("#tkid").val(),
                type: "put",
                contentType: "application/json; charset=utf-8",
                async: false,
                dataType: "json",
                // du lieu truyen vao dang json 
                data: JSON.stringify({ "taiKhoan_Id": $("#tkid").val(),
                                        "loai": {
                                            "loai_Id": 2
                                        },
                                        "moTa": $("#mota").val(),
                                        "ngheNghiep": {
                                            "ngheNghiep_Id": 5
                                        },
                                        "bangCap": $("#bangcap").val(),
                                        "cmnd": $("#socmnd").val()
                                    }),
                success: function (response) {
                    window.location.href = "http://localhost:8083/dangkitrothanhgiasu?signupMsg=success";
                },
                error: function (response) {
                    window.location.href = "http://localhost:8083/dangkitrothanhgiasu?signupMsg=failed";
                }
            });    
        }
    });
});

function validationFields() {
    $("#vali-mota").css("display", "none");
    $("#vali-bangcap").css("display", "none");
    $("#vali-socmnd").css("display", "none");

    var flagg = true;

    if($("#mota").val() == "") {
        $("#vali-mota").css("display", "block");
        flagg = false;
    }
    if($("#bangcap").val() == "") {
        $("#vali-bangcap").css("display", "block");
        flagg = false;
    }
    if($("#socmnd").val() == "") {
        $("#vali-socmnd").css("display", "block");
        flagg = false;
    }
    return flagg;
}
