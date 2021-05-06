$(document).ready(function () {
    var baiDangList = []
	$.ajax({
		url: "http://localhost:8081/api/baidangs",
		contentType: "application/json; charset=utf-8",
		async: false,
		type: "get",
		dataType: "json",
		success: function (response) {
			var htmlStr = ``;
			// lap qua ket qua tra ve & tao html theo mong muon
			response.forEach(value => {
				baiDangList.push(value)
				var tomTatYeuCau = value.tomTatYeuCau;
				var moTa = value.moTa;
                var hocPhi = value.hocPhi;
				htmlStr = htmlStr + `<div style="float: left;height: auto;" class="bai-dang">
                <div style="display: flex;" class="hien-thi-bai-dang">
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
                            <p style="margin-left: 8px;color: #ff961e;font-weight: 700;">${hocPhi} vnđ/tháng</p>
                        </div>
                    </div>

                    <div style="margin-left: 30px; text-align: center;" class="phinhanlop">
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
                                href="#" class="xemchitiet">
                                Xem chi tiết
                            </a>
                        </div>
                    </div>
                </div>
            </div>`;
			});
			 console.log(baiDangList)
			$(".baidang-container").html(htmlStr);

		},
		error: function (jqXHR, textStatus, errorThrown) {
			console.log(textStatus, errorThrown);
		}
	});
});