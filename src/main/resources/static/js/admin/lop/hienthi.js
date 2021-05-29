$(document).ready(function () {
    if(window.location.search.substring(1)==""){
        var currentPage = 1;
    }else {
        var currentPage = getURLParameter("page");
    }
    var lopList = []
	    $.ajax({
		url: "http://localhost:8083/api/lops?page=" + currentPage + "&limit=5",
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
            var lops = response.lopDTO;
			// lap qua ket qua tra ve & tao html theo mong muon
			lops.forEach(value => {
				lopList.push(value)
                var lop_Id = value.lop_Id;
				var tenLop = value.tenLop;
				var ngayNhan = value.ngayNhan;
                var nguoiHoc = value.nguoiHoc.hoTen;
				var nguoiDay = value.nguoiDay.hoTen;
				var tienHoc = value.tienHoc;
				var gioHoc = value.gioHoc;
				
				
				
				
				htmlStr = htmlStr + `<tr role="row" class="odd">
										<td class="sorting_1">${lop_Id}</td>
										<td>${tenLop}</td>
										<td>${ngayNhan}</td>
										<td>${nguoiHoc}</td>
										<td>${nguoiDay}</td>
										<td>${tienHoc}</td>
										<td>${gioHoc}</td>
										<td><button id="btnshow" data-id=${lop_Id} type="button" class="btn btn-info" data-toggle="modal" data-target="#updateAirplaneModal"><i class="fas fa-eye"></i></button>&nbsp
										
                							<a href="/admin/xoalophoc?id=${lop_Id} " class="btn btn-danger"><i class="fas fa-trash-alt"></i></a></td>
									</tr>`;

			});
			 console.log(lopList)
			$("#bang").html(htmlStr);
            htmlPgn = htmlPgn + `<a href="#">&laquo;</a>`;
            for(index; index <= totalPage; index++) {
                if(index == page) {
                    htmlPgn = htmlPgn + `<a class="active">${index}</a>`;
                }else {
                    htmlPgn = htmlPgn + `<a href="/admin/quanlylophoc?page=${index}">${index}</a>`;
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