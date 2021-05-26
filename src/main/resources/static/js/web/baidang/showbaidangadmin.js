
$(document).ready(function () {
$('#btnshow').click( function () {

	$.ajax({
		url: "http://localhost:8083/api/baidangs/" + $(this).data('id'),
		contentType: "application/json; charset=utf-8",
		async: false,
		type: "get",
		dataType: "json",
		success: function (response) {
			var htmlStr = ``;
			/*var baiDangs = response.baiDangDTOs;*/
			
				
                var baiDang_Id = response.baiDang_Id;
				var tomTatYeuCau = response.tomTatYeuCau;
				var moTa = response.moTa;
                var hocPhi = response.hocPhi;
				var gioiTinht;
				if(response.gioiTinh)
					gioiTinht = "Nam";
				else
					gioiTinht = "Nữ";
				var sdt = response.sdt;
				var tenMon = response.mon.tenMon;
				var chuDe = response.chuDe.tenChuDe;
				var tenTaiKhoan = response.taiKhoan.hoTen;
				var taiKhoan_Id = response.taiKhoan.taiKhoan_Id;
				var soBuoi = response.soBuoi;
				var ngayBatDau = response.ngayBatDau;
					
				
				
			htmlStr += `
			<h3>Thông tin người đăng</h3>
						<table class="table">
							<center>
							<tr>
								<td>ID</td>
								<td>${taiKhoan_Id}</td>

							</tr>
							<tr>
								<td>Họ và tên:</td>
								<td>${tenTaiKhoan}</td>
							</tr>
							</center>
						</table>

						<div class="row">

							<div class="col-sm-12">
								<h5>
									<b>Thông tin bài viết</b>
								</h5>
								<table class="table">
									<tr>
										<td><b>ID</b></td>
										<td>${baiDang_Id}</td>
									</tr>
									<tr>
										<td><b>Yêu cầu:</b></td>
										<td
											style="word-wrap: break-word;">${tomTatYeuCau}</td>

									</tr>
									<tr>
										<td><b>Học phí:</b></td>
										<td>${hocPhi}</td>
									</tr>
									<tr>
										<td><b>Mô tả:</b></td>
										<td>${moTa}</td>
									</tr>
									<tr>
										<td><b>Ngày bắt đầu:</b></td>
										<td>${ngayBatDau}</td>
									</tr>
									<tr>
										<td><b>Số điện thoại:</b></td>
										<td>${sdt}</td>
									</tr>
									<tr>
										<td><b>Số buổi:</b></td>
										<td>${soBuoi}</td>
									</tr>
									<tr>
										<td><b>Môn học:</b></td>
										<td>${tenMon}</td>
									</tr>
									<tr>
										<td><b>Chủ đề:</b></td>
										<td>${chuDe}</td>
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
