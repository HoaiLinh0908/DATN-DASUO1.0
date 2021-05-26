$(document).ready(function () {
    var idtk = $("#tkid").val();
    var baiDangList = []
	    $.ajax({
		url: "http://localhost:8083/api/lopstheonguoihoc/" + idtk,
		contentType: "application/json; charset=utf-8",
		async: false,
		type: "get",
		dataType: "json",
		success: function (response) {
            var htmlStr = ``;
			// lap qua ket qua tra ve & tao html theo mong muon
			response.forEach(value => {
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
		},
		error: function (jqXHR, textStatus, errorThrown) {
			console.log(textStatus, errorThrown);
		}
	});    
});
