//FUNCTION THEM TAI KHOAN
$('#submit-btn').click( function () {
	if($("#password1").val() != $("#password2").val()) {
		$("#cf-password-msg").show();
	}else {
		$.ajax({
			url: "http://localhost:8083/api/taikhoans",
			type: "post",
			contentType: "application/json; charset=utf-8",
			async: false,
			dataType: "json",
			// du lieu truyen vao dang json 
			data: JSON.stringify({ "hoTen": $("#firstname").val(),
									"email": $("#email").val(),
									"sdt": $("#sodienthoai").val(),
									"matKhau": $("#password1").val(),
									"tinhThanh": null,
									"loai": {
										"loai_Id": 1
									},
									"ngheNghiep": {
										"ngheNghiep_Id": 1
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
	}
});