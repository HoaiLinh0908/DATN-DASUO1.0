$(document).ready(function () {
    if(window.location.search.substring(1)==""){
        window.location.href = "http://localhost:8083/hienthilichlop";
    }else {
        var bdid = getURLParameter("id");
	    $.ajax({
		url: "http://localhost:8083/api/lops/" + bdid,
		contentType: "application/json; charset=utf-8",
		async: false,
		type: "get",
		dataType: "json",
		success: function (response) {
            var htmlStr = ``;
			// lap qua ket qua tra ve & tao html theo mong muon
                var lop_Id = response.lop_Id;
				var tenLop = response.tenLop;
                var nguoiDay = response.nguoiDay.hoTen;
                var nguoiHoc = response.nguoiHoc.hoTen;
				htmlStr = htmlStr + `<div class="col-md-1">
                                    <h1>Thông tin lớp học</h1>
                                    <p class="name inline"><strong>Tên lớp:</strong> ${tenLop}</p>
                                    <p class="name inline"><strong>Người dạy:</strong> ${nguoiDay}</p>
                                    <p class="name inline"><strong>Người học:</strong> ${nguoiHoc}</p>
                                    </div>`;

			$(".bai-dang").html(htmlStr);
		},
		error: function (jqXHR, textStatus, errorThrown) {
			console.log(textStatus, errorThrown);
		}
	});
    }  
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