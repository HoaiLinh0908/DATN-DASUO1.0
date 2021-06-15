$(document).ready(function () {
    if(window.location.search.substring(1)==""){
        var currentPage = 1;
    }else {
        var currentPage = getURLParameter("page");
    }
    var baiDangList = []
	    $.ajax({
		url: "http://localhost:8083/api/baidangs?page=" + currentPage + "&limit=5",
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
            var baiDangs = response.baiDangDTOs;
			// lap qua ket qua tra ve & tao html theo mong muon
			baiDangs.forEach(value => {
				baiDangList.push(value)
                var baiDang_Id = value.baiDang_Id;
				var tomTatYeuCau = value.tomTatYeuCau;
				var moTa = value.moTa;
                var hocPhi = value.hocPhi.toLocaleString();
				var gioiTinht;
				if(value.gioiTinh)
					gioiTinht = "Nam";
				else
					gioiTinht = "Nữ";
				var sdt = value.sdt;
				var tenMon = value.mon.tenMon;
				var thoiGian = value.ngayBatDau;
				
				
				
				htmlStr = htmlStr + `<tr role="row" class="odd">
										<td class="sorting_1">${baiDang_Id}</td>
										<td>${tomTatYeuCau}</td>
										<td>${tenMon}</td>
										<td>${gioiTinht}</td>
										<td>${sdt}</td>
										<td>${thoiGian}</td>
										<td><button id="btnshow" data-id=${baiDang_Id} type="button" class="btn btn-info" data-toggle="modal" data-target="#updateAirplaneModal"><i class="fas fa-eye"></i></button>&nbsp
										<a href="/admin/xoabaidang?id=${baiDang_Id} " class="btn btn-danger"><i class="fas fa-trash-alt"></i></a>
                
									</tr>`;
/*				htmlStr = htmlStr + `<div style="float: left;width: 100%; height: 110px;" class="bai-dang">
                <div style="display: flex; width: 100%;" class="hien-thi-bai-dang">
                    <div style="width: 15%;text-align: center;" class="cskh">
                        <div class="img-cskh">
                            <h2 style="color: #333;margin-left: -2px; font-size: 30px;" class="text-logo">Dasuo
                            </h2>
                        </div>
                        <div class="mo-ta-cskh">
                            <p class="creator-name">
                                <a href="#">Dasuo CSKH </a>
                            </p>
                        </div>
                    </div>
                    <div style="margin-left: 30px;" class="mota-baidang">
                        <div class="mota-soluoc">
                            <a style="text-decoration: none;" href="#">

                                <h2><i style="padding-right: 6px; color: chartreuse;"
                                        class="fas fa-check"></i>${tomTatYeuCau}</h2>
                            </a>

                            <div class="para-mota">
                                <p>${moTa}</p>
                            </div>
                        </div>
                    </div>
                    <div class="hocphidenghi">
                        <div class="tienhoc">
                            <p style="margin-left: 38px;color: #ff961e;font-weight: 700;">${hocPhi} vnđ/tháng</p>
                        </div>
                    </div>

                    <div style="margin-left: 20px; text-align: center;" class="phinhanlop">
                        <div style=" text-align: center; line-height: 5px;" class="phinhanlop-ctiet">
                            <p>
                                <span ma>Phí:</span>
                                360.000
                                <span>vnđ</span>
                            </p>
                            <span style="font-size: 14px;font-style: italic;">(Chỉ thu khi nhận lớp)</span>
                        </div>
                        <div style="margin-top: 20px; " class="xemchitiet-btn">
                            <a style="text-decoration: none;border-radius: 3px;color: #fff;padding: 8px 30px; background-color: #ff961e;"
                                href="/chitietbaidang?id=${baiDang_Id}" class="xemchitiet">
                                Xem chi tiết
                            </a>
                        </div>
                    </div>
                </div>
            </div>`;*/
			});
			 console.log(baiDangList)
			$("#noidung").html(htmlStr);
            htmlPgn = htmlPgn + `<a href="#">&laquo;</a>`;
            for(index; index <= totalPage; index++) {
                if(index == page) {
                    htmlPgn = htmlPgn + `<a class="active">${index}</a>`;
                }else {
                    htmlPgn = htmlPgn + `<a href="/admin/quanlybaidang?page=${index}">${index}</a>`;
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




// show form





//xóa

