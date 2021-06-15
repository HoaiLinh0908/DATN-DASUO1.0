
$(document).ready(function () {
$('#btnshow').click( function () {

	$.ajax({
		url: "http://localhost:8083/api/lops/" + $(this).data('id'),
		contentType: "application/json; charset=utf-8",
		async: false,
		type: "get",
		dataType: "json",
		success: function (response) {
			var htmlStr = ``;
				
				var lop_Id = response.lop_Id;
				var tenLop = response.tenLop;
				var ngayNhan = response.ngayNhan;
                var nguoiHoc = response.nguoiHoc.hoTen;
				var nguoiDay = response.nguoiDay.hoTen;
				var tienHoc = response.tienHoc.toLocaleString();
				var gioHoc = response.gioHoc;
				
                
				
			htmlStr += `
			<h3>Thông tin chi tiết lớp học</h3>
						

						<div class="row">

							<div class="col-sm-12">
								
								<table class="table">
									<tr>
										<td><b>ID</b></td>
										<td>${lop_Id}</td>
									</tr>
									<tr>
										<td><b>Tên lớp:</b></td>
										<td>${tenLop}</td>

									</tr>
									<tr>
										<td><b>Ngày nhận:</b></td>
										<td>${ngayNhan}</td>
									</tr>
									<tr>
										<td><b>Họ tên người học:</b></td>
										<td>${nguoiHoc}</td>
									</tr>
									<tr>
										<td><b>Họ tên người dạy:</b></td>
										<td>${nguoiDay}</td>
									</tr>
									<tr>
										<td><b>Tiền học:</b></td>
										<td>${tienHoc} VND</td>
									</tr>
									<tr>
										<td><b>Giờ học:</b></td>
										<td style=" word-wrap: break-word;">${gioHoc}</td>
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
