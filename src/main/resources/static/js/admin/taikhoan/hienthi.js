$(document).ready(function () {
    if(window.location.search.substring(1)==""){
        var currentPage = 1;
    }else {
        var currentPage = getURLParameter("page");
    }
    var taiKhoanList = []
	    $.ajax({
		url: "http://localhost:8083/api/taikhoans?page=" + currentPage + "&limit=5",
		contentType: "application/json; charset=utf-8",
		async: false,
		type: "get",
		dataType: "json",
		success: function (response) {
			var htmlStr = ``;
            var htmlPgn = ``;
            var index = 1;
            var page = response.page;
            var totalPage = response.totalPage;
            var taiKhoans = response.taiKhoanDTO;
			// lap qua ket qua tra ve & tao html theo mong muon
			taiKhoans.forEach(value => {
				taiKhoanList.push(value)
                var taiKhoan_Id = value.taiKhoan_Id;
				var hoTen = value.hoTen;
				var email = value.email;
                var sdt = value.sdt;
				var gioiTinht;
				if(value.gioiTinh)
					gioiTinht = "Nam";
				else
					gioiTinht = "Nữ";
				var soDu = value.soDu.toLocaleString();
				var phanQuyen = value.loai.tenLoai;
				var khoa;
				if(value.enable)
					khoa = "Đã bị khóa";
				else
					khoa = "Không khóa";
				
				
				
				
				htmlStr = htmlStr + `<tr role="row" class="odd">
										<td class="sorting_1">${taiKhoan_Id}</td>
										
										<td>${hoTen}</td>
										<td>${email}</td>
										<td>${sdt}</td>
										<td>${gioiTinht}</td>
										<td>${soDu} VND</td>
										<td>${phanQuyen}</td>
										<td>${khoa}</td>
										<td><button id="btnshow" data-id=${taiKhoan_Id} type="button" class="btn btn-info" data-toggle="modal" data-target="#updateAirplaneModal"><i class="fas fa-eye"></i></button>&nbsp
										
                							<a href="/admin/khoataikhoan?id=${taiKhoan_Id} " class="btn btn-danger"><i class="fas fa-lock"></i></a></td>
									</tr>`;

			});
			 console.log(taiKhoanList)
			$("#noidung").html(htmlStr);
            htmlPgn = htmlPgn + `<a href="#">&laquo;</a>`;
            for(index; index <= totalPage; index++) {
                if(index == page) {
                    htmlPgn = htmlPgn + `<a class="active">${index}</a>`;
                }else {
                    htmlPgn = htmlPgn + `<a href="/admin/quanlytaikhoan?page=${index}">${index}</a>`;
                }
            }
            htmlPgn = htmlPgn + `<a href="#">&raquo;</a>`;
            $(".pagination").html(htmlPgn);
		},
		error: function (jqXHR, textStatus, errorThrown) {
			console.log(textStatus, errorThrown);
		}
	});    
});

function getURLParameter(sParam)
{
    var sPageURL = window.location.search.substring(1);
    var sURLVariables = sPageURL.split('&');
    for (var i = 0; i < sURLVariables.length; i++) 
    {
        var sParameterName = sURLVariables[i].split('=');
        if (sParameterName[0] == sParam) 
        {
            return sParameterName[1];
        }
    }
}