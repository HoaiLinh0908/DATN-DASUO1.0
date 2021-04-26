var popularTeacherList = []
var allAccountList = []
var taiKhoanCaNhan = {}


//FUNCTION HIEN THI GIAO VIEN NOI BAT
function loadPopularTeacherList() {
	$.ajax({
		url: "http://localhost:8081/api/taikhoanuutus",
		contentType: "application/json; charset=utf-8",
		async: false,
		type: "get",
		dataType: "json",
		success: function (response) {
			var htmlStr = ``;
			// lap qua ket qua tra ve & tao html theo mong muon
			response.forEach(value => {
				popularTeacherList.push(value)
				var taiKhoanId = value.taiKhoan_Id;
				var hoTen = value.hoTen;
				htmlStr = htmlStr + `<div class="gia-su">
                           <a href="#"><img src="/img/user1.png"></a>
                           <p class="name-gia-su">${hoTen}</p>
                           <p class="address">Hà Nội | Toán, Tiếng anh</p>
                           <p class="mo-ta">Thủ khoa ĐH Duy Tân về lãnh vực toán học và Ielts 8.0 </p>
                           <button href="#" class="btn-md">Mời dạy</button>
                    </div>`;
			});
			 console.log(popularTeacherList)
			//hien thi len
			$(".inf-giasu").html(htmlStr);

		},
		error: function (jqXHR, textStatus, errorThrown) {
			console.log(textStatus, errorThrown);
		}
	});
}

loadPopularTeacherList();


//FUNCTION HIEN THI TAT CA TAI KHOAN
function loadAllAccountList() {
	$.ajax({
		url: "http://localhost:8081/api/taikhoans",
		contentType: "application/json; charset=utf-8",
		async: false,
		type: "get",
		dataType: "json",
		success: function (response) {
			var htmlStr = ``;
			// lap qua ket qua tra ve & tao html theo mong muon
			response.forEach(value => {
				allAccountList.push(value)
				var taiKhoanId = value.taiKhoan_Id;
				var hoTen = value.hoTen;
				htmlStr = htmlStr + `<div class="gia-su">
                           <a href="#"><img src="/img/user1.png"></a>
                           <p class="name-gia-su">${hoTen}</p>
                           <p class="address">Hà Nội | Toán, Tiếng anh</p>
                           <p class="mo-ta">Thủ khoa ĐH Duy Tân về lãnh vực toán học và Ielts 8.0 </p>
                           <button href="#" class="btn-md">Mời dạy</button>
                    </div>`;
			});
			 console.log(allAccountList)
			//hien thi len
			$(".inf-giasu").html(htmlStr);

		},
		error: function (jqXHR, textStatus, errorThrown) {
			console.log(textStatus, errorThrown);
		}
	});
}


//FUNCTION HIEN THI TAI KHOAN CA NHAN
function loadTaiKhoan(id) {
	$.ajax({
		url: "http://localhost:8081/api/taikhoans/" + id,
		contentType: "application/json; charset=utf-8",
		async: false,
		type: "get",
		dataType: "json",
		success: function (response) {
			var htmlStr = ``;
			
				var taiKhoanId = response.taiKhoan_Id;
				var hoTen = response.hoTen;
				htmlStr = htmlStr + `<div class="gia-su">
                           <a href="#"><img src="/img/user1.png"></a>
                           <p class="name-gia-su">${hoTen}</p>
                           <p class="address">Hà Nội | Toán, Tiếng anh</p>
                           <p class="mo-ta">Thủ khoa ĐH Duy Tân về lãnh vực toán học và Ielts 8.0 </p>
                           <button href="#" class="btn-md">Mời dạy</button>
                    </div>`;
			 console.log(popularTeacherList)
			//hien thi len
			$(".inf-giasu").html(htmlStr);

		},
		error: function (jqXHR, textStatus, errorThrown) {
			console.log(textStatus, errorThrown);
		}
	});
}

//FUNCTION THEM TAI KHOAN
$('body').on('click', '#submit', function () {

	// check validate
	$.ajax({
		url: "http://localhost:8081/api/taikhoans",
		type: "post",
		contentType: "application/json; charset=utf-8",
		async: false,
		dataType: "json",
		// du lieu truyen vao dang json 
		data: JSON.stringify({ "hoTen": $("#firstname").val(),
								"email": $("#email").val(),
								"sdt": $("#password1").val(),
								"matKhau": $("#password2").val() }),
		success: function (response) {
			$("#firstname").val("");
			$("#email").val("");
			$("#password1").val("");
			$("#password2").val("");
			console.log(response);
		},
		error: function (response) {
			console.log(response)
			let errorHtml = ``;
			Object.entries(response.responseJSON).forEach(([key, value]) => errorHtml += `<li>${value}</li>`)
			console.log(response.responseJSON)
			$('.failedToast').children('.toast-body').html(errorHtml)
			$('.failedToast').toast('show');
		}
	});
});


//FUNCTION CHINH SUA THONG TIN TAI KHOAN
function loadTaiKhoan(id) {
	$.ajax({
		url: "http://localhost:8081/api/taikhoans/" + id,
		contentType: "application/json; charset=utf-8",
		async: false,
		type: "put",
		dataType: "json",
		// du lieu truyen vao dang json 
		data: JSON.stringify({ "hinhDaiDien": $("#avatar").val(),
								"moTa": $("#mota").val(),
								"hocPhi": $("#hocphi").val(),
								"bangCap": $("#bangcap").val(),
								"ngheNghiep": $("#nghenghiep").val(),
								"sdt": $("#sdt").val()}),
		success: function (response) {
			//Re-load profile page
			window.location.href = "http://localhost:8081/account/userprofile?message=signup_success";
			//show a successful message
		},
		error: function (jqXHR, textStatus, errorThrown) {
			window.location.href = "http://localhost:8081/account/userprofile?message=signup_fail";
			//show a failed message
		}
	});
}