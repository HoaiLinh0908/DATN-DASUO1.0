$(document).ready(function () {
    if(window.location.search.substring(1)==""){
        var currentPage = 1;
    }else {
        var currentPage = getURLParameter("page");
    }
    var baiDangList = []
	    $.ajax({
		url: "http://localhost:8083/api/timtaikhoans/l?page=" + currentPage + "&limit=4",
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
            var taikhoans = response.taiKhoanDTO;
			// lap qua ket qua tra ve & tao html theo mong muon
			taikhoans.forEach(value => {
				baiDangList.push(value)
				var id = value.taiKhoan_Id;
                var ten = value.hoTen;
				if(value.tinhThanh == null)
				{
					var noio = "chưa xác định";
				}
				else
				{
					var noio = value.tinhThanh.tenTinh;
				}
				var nghenghiep = value.ngheNghiep.tenNgheNghiep;
				
				
				var moTa = value.moTa;
                
				htmlStr = htmlStr + `<div  class="gia-su">
                                   <a href="#"><img src="/img/user1.png"></a>
                                   <p  class="name-gia-su"><a href="/">${ten}</a></p>
                                   <p class="address">${noio} | ${nghenghiep}</p>
                                   <p class="mo-ta">${moTa} </p>
                                   <button href="#" class="btn-md">Mời dạy</button>
                            </div>`;
			});
			 console.log(baiDangList)
			$(".inf-giasu").html(htmlStr);
            htmlPgn = htmlPgn + `<a href="#">&laquo;</a>`;
            for(index; index <= totalPage; index++) {
                if(index == page) {
                    htmlPgn = htmlPgn + `<a class="active">${index}</a>`;
                }else {
                    htmlPgn = htmlPgn + `<a href="/timkiem?page=${index}">${index}</a>`;
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
