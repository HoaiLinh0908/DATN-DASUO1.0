$(document).ready(function () {
    if(window.location.search.substring(1)==""){
        var currentPage = 1;
    }else {
        var currentPage = getURLParameter("page");
    }
    var lsgdList = []
	    $.ajax({
		url: "http://localhost:8083/api/lichsugiaodichs?page=" + currentPage + "&limit=5",
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
            var lichSuGiaoDichs = response.lichSuGiaoDichs;
			// lap qua ket qua tra ve & tao html theo mong muon
			lichSuGiaoDichs.forEach(value => {
				lsgdList.push(value)
                var lichSuGiaoDich_Id = value.lichSuGiaoDich_Id;
				var taiKhoan = value.taiKhoan.taiKhoan_Id;
				var thoiGian = value.thoiGian;
                var noiDung = value.noiDung;
				var soTien = value.soTien;
				
				
				
				
				
				htmlStr = htmlStr + `<tr role="row" class="odd">
										<td class="sorting_1">${lichSuGiaoDich_Id}</td>
										<td>${taiKhoan}</td>
										<td>${thoiGian}</td>
										<td>${noiDung}</td>
										<td>${soTien}</td>
										
									</tr>`;

			});
			 console.log(lsgdList)
			$("#hienthi").html(htmlStr);
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