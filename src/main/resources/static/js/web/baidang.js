var allBaiDangList = [];

//FUNCTION HIEN THI BAI DANG THEO ID
function loadBaiDangById(id) {
	$.ajax({
		url: "http://localhost:8081/api/baidangs/" + id,
		contentType: "application/json; charset=utf-8",
		async: false,
		type: "get",
		dataType: "json",
		success: function (response) {
			var htmlStr = ``;
			// Lay bai dang theo ID & tao html theo mong muon

				var baiDang_Id = response.baiDang_Id;
				var tomTatYeuCau = response.tomTatYeuCau;
				var mon = response.mon;
				var hocPhi = response.hocPhi;
				var sdt = response.sdt;
				var moTa = response.moTa;
				var gioiTinh = response.gioiTinh;
				var soBuoi = response.soBuoi;
				var ngayBatDau = response.ngayBatDau;
				var thoiGianDayTheoThang = response.thoiGianDayTheoThang;
				var chuDe = value.chuDe;
				var tenNguoiDang = value.taiKhoan.getHoTen();
				htmlStr = htmlStr + `<div class="bai-dang">
                           <a href="#">${tomTatYeuCau}</a>
                           <p>${mon}</p>
                           <p>${hocPhi}</p>
                           <p>${sdt}</p>
                           <p>${moTa}</p>
                           <p>${gioiTinh}</p>
                           <p>${soBuoi}</p>
                           <p>${ngayBatDau}</p>
                           <p>${thoiGianDayTheoThang}</p>
                           <p>${chuDe}</p>
                           <p>${tenNguoiDang}</p>
                           <button href="#" class="btn-md">Xem</button>
                    </div>`;
			//hien thi len
			$(".inf-giasu").html(htmlStr);

		},
		error: function (jqXHR, textStatus, errorThrown) {
			console.log(textStatus, errorThrown);
		}
	});
}

//FUNCTION XOA BAI DANG THEO ID
$('#idTheDivBenNgoai').on('click', '#btnDelete', function(id) {
  if (confirm(`Bạn có chắc chắn muốn xóa bài đăng này không?`)) {
	$.ajax({
		url: "http://localhost:8081/api/baidangs/" + id,
		contentType: "application/json; charset=utf-8",
		async: false,
		type: "delete",
		dataType: "json",

		success: function (response) {
			//Re-load profile page
			window.location.href = "http://localhost:8081/quanlybaidang?message=signup_success";
			//show a successful baidang deleting message
		},
		error: function (jqXHR, textStatus, errorThrown) {
			window.location.href = "http://localhost:8081/quanlybaidang?message=signup_fail";
			//show a failed baidang deleting message
		}
	});
  }
});