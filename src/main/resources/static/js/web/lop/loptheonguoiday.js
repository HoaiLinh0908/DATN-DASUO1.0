$(document).ready(function () {
    var idtk = $("#tkid").val();
    if(window.location.search.substring(1)==""){
        var currentPage = 1;
    }else {
        var currentPage = getURLParameter("page");
    }
    var baiDangList = []
	    $.ajax({
		url: "http://localhost:8083/api/lopstheonguoiday/" + idtk + "?page=" + currentPage + "&limit=4",
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
				baiDangList.push(value)
                var lop_Id = value.lop_Id;
				var tenLop = value.tenLop;
				htmlStr = htmlStr + `<div style="float: left;width: 100%; height: 60px; border-radius: 4px;" class="bai-dang">
                <div style="display: flex; width: 100%; height: 57px" class="hien-thi-bai-dang">
                    <div style="margin-left: 30px;margin-top: 5px; width: 75%;" class="mota-baidang">
                            <a style="text-decoration: none;" href="#">
                                <p><b>Tên lớp:</b>${tenLop}</p>
                            </a>
                    </div>

                    <div style="margin-left: 0px;width: 25%; float: right;" class="phinhanlop">
                        <div style="margin-top: 20px; text-align: center;" class="xemchitiet-btn">
                            <a style="text-decoration: none;border-radius: 3px;color: #fff;padding: 8px 30px; background-color: #ff961e;"
                                href="/chitietlophoc?id=${lop_Id}" class="xemchitiet">
                                Chi tiết lớp
                            </a>
                        </div>
                    </div>
                </div>
            </div>`;
			});
			 console.log(baiDangList)
			$(".lich-lop-cua-toi").html(htmlStr);
            htmlPgn = htmlPgn + `<a href="#">&laquo;</a>`;
            for(index; index <= totalPage; index++) {
                if(index == page) {
                    htmlPgn = htmlPgn + `<a class="active">${index}</a>`;
                }else {
                    htmlPgn = htmlPgn + `<a href="/hienthilichlop?page=${index}">${index}</a>`;
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