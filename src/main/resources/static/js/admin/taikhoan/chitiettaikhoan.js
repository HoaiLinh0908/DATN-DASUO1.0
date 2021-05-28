
$(document).ready(function () {
$('#btnshow').click( function () {

	$.ajax({
		url: "http://localhost:8083/api/taikhoans/" + $(this).data('id'),
		contentType: "application/json; charset=utf-8",
		async: false,
		type: "get",
		dataType: "json",
		success: function (response) {
			var htmlStr = ``;
			/*var baiDangs = response.baiDangDTOs;*/
			
				
                var taiKhoan_Id = response.taiKhoan_Id;
				var hoTen = response.hoTen;
				var email = response.email;
                var sdt = response.sdt;
				var gioiTinht;
				if(response.gioiTinh)
					gioiTinht = "Nam";
				else
					gioiTinht = "Nữ";
				var soDu = response.soDu;
				var phanQuyen = response.loai.tenLoai;
				var hocPhi = response.hocPhi;
				var moTa = response.moTa;
				var tinhThanh = response.tinhThanh.tenTinh;
				var khoa;
				if(response.enable)
					khoa = "Đã bị khóa";
				else
					khoa = "Không khóa";
				
			htmlStr += `
			<h3>Thông tin chi tiết người dùng</h3>
						

						<div class="row">

							<div class="col-sm-12">
								
								<table class="table">
									<tr>
										<td><b>ID</b></td>
										<td>${taiKhoan_Id}</td>
									</tr>
									<tr>
										<td><b>Email:</b></td>
										<td>${email}</td>

									</tr>
									<tr>
										<td><b>Giới tính:</b></td>
										<td>${gioiTinht}</td>
									</tr>
									<tr>
										<td><b>Họ tên:</b></td>
										<td>${hoTen}</td>
									</tr>
									<tr>
										<td><b>Học phí:</b></td>
										<td>${hocPhi}</td>
									</tr>
									<tr>
										<td><b>Số điện thoại:</b></td>
										<td>${sdt}</td>
									</tr>
									<tr>
										<td><b>Mô tả:</b></td>
										<td style=" word-wrap: break-word;">${moTa}</td>
									</tr>
									<tr>
										<td><b>Số dư:</b></td>
										<td>${soDu}</td>
									</tr>
									<tr>
										<td><b>Loại tài khoản:</b></td>
										<td>${phanQuyen}</td>
									</tr>
									<tr>
										<td><b>Tỉnh thành:</b></td>
										<td>${tinhThanh}</td>
									</tr>
									<tr>
										<td><b>Trạng thái:</b></td>
										<td>${khoa}</td>
									</tr>
								</table>
							</div>
						</div>
						
			`
			$("#booking-detail-body").html(htmlStr);
		},
		error: function (jqXHR, textStatus, errorThrown) {
			console.log(textStatus, errorThrown);
		}
	});
});
});
