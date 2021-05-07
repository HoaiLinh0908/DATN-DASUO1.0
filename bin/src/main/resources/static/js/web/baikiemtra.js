var allBaiKiemTraList = [];

//FUNCTION HIEN THI TAT CA BAI KIEM TRA
function loadAllBaiKiemTra() {
	$.ajax({
		url: "http://localhost:8081/api/baikiemtras",
		contentType: "application/json; charset=utf-8",
		async: false,
		type: "get",
		dataType: "json",
		success: function (response) {
			var htmlStr = ``;
			// Lap qua ket qua tra ve & tao html theo mong muon
			response.forEach(value => {
				allBaiKiemTraList.push(value)
				var baiKiemTra_Id = value.baiKiemTra_Id;
				var lop = value.lop;
				var noiDung = value.noiDung;
				var thoiGianBatDau = value.thoiGianBatDau;
				var thoiGianNop = value.thoiGianNop;
				
				htmlStr = htmlStr + `<div class="bai-dang">
                           <a href="#">${baiKiemTra_Id}</a>
                           <p>${lop}</p>
                           <p>${noiDung}</p>
                           <p>${thoiGianBatDau}</p>
                           <p>${thoiGianNop}</p>
                    </div>`;
			});
			 console.log(allBaiKiemTraList)
			//hien thi len
			$(".inf-giasu").html(htmlStr);

		},
		error: function (jqXHR, textStatus, errorThrown) {
			console.log(textStatus, errorThrown);
		}
	});
}

//FUNCTION HIEN THI BAI KIEM TRA THEO ID 
function loadBaiKiemTraByID(id) {
	$.ajax({
		url: "http://localhost:8081/api/baikiemtras/" + id,
		contentType: "application/json; charset=utf-8",
		async: false,
		type: "get",
		dataType: "json",
		success: function (response) {
			var htmlStr = ``;
			// Lap qua ket qua tra ve & tao html theo mong muon

				var baiKiemTra_Id = response.baiKiemTra_Id;
				var lop = response.lop;
				var noiDung = response.noiDung;
				var thoiGianBatDau = response.thoiGianBatDau;
				var thoiGianNop = response.thoiGianNop;
				
				htmlStr = htmlStr + `<div class="bai-dang">
                           <a href="#">${baiKiemTra_Id}</a>
                           <p>${lop}</p>
                           <p>${noiDung}</p>
                           <p>${thoiGianBatDau}</p>
                           <p>${thoiGianNop}</p>
                    </div>`;

			//hien thi len
			$(".inf-giasu").html(htmlStr);

		},
		error: function (jqXHR, textStatus, errorThrown) {
			console.log(textStatus, errorThrown);
		}
	});
}

//FUNCTION THEM BAI KIEM TRA
$('body').on('click', '#submit', function () {

	// check validate
	$.ajax({
		url: "http://localhost:8081/api/baikiemtras",
		type: "post",
		contentType: "application/json; charset=utf-8",
		async: false,
		dataType: "json",
		// du lieu truyen vao dang json 
		data: JSON.stringify({ "lop": $("#lop").val(),
								"noiDung": $("#noidung").val(),
								"thoiGianBatDau": $("#thoigianbatdau").val(),
								"thoiGianNop": $("#thoigiannop").val() }),
		success: function (response) {
			$("#lop").val("");
			$("#noidung").val("");
			$("#thoigianbatdau").val("");
			$("#thoigiannop").val("");
			console.log(response);
		},
		error: function (response) {
			console.log(response)
		}
	});
});

//FUNCTION XOA BAI KIEM TRA
$('#idTheDivBenNgoai').on('click', '#btnDelete', function (id) {
    if (confirm(`Bạn có chắc chắn muốn xóa bài kiểm tra này không?`)) {
	// check validate
	$.ajax({
		url: "http://localhost:8081/api/baikiemtras/" + id,
		type: "delete",
		contentType: "application/json; charset=utf-8",
		async: false,
		dataType: "json",
		success: function (response) {
			//Re-load profile page
			window.location.href = "http://localhost:8081/quanlybaikiemtra?message=success";
			//show a successful baidang deleting message
		},
		error: function (response) {
			window.location.href = "http://localhost:8081/quanlybaikiemtra?message=fail";
			//show a failed baidang deleting message
		}
	});
    }
});