$(document).ready(function () {
    if(window.location.search.substring(1)==""){
        window.location.href = "http://localhost:8083/hienthibaidang";
    }else {
        var bdid = getURLParameter("id");
    }
    var baiDangList = [];
	    $.ajax({
		url: "http://localhost:8083/api/baidangs/" + bdid,
		contentType: "application/json; charset=utf-8",
		async: false,
		type: "get",
		dataType: "json",
		success: function (response) {
            if(!response.enable) {
                window.location.href = "http://localhost:8083/hienthibaidang";
            }else {
                var htmlStr = ``;
                var htmlTaoLopBtn = ``;
                var htmlDSYC = ``;	
				baiDangList.push(response)
                var baiDang_Id = response.baiDang_Id;
				var tomTatYeuCau = response.tomTatYeuCau;
				var moTa = response.moTa;
                var hocPhi = response.hocPhi;
                var mon = response.mon.tenMon;
                var buois = response.buois;
                var nguoiDangId = response.taiKhoan.taiKhoan_Id;
                var nguoiYeuCauDays = response.taiKhoans;
				htmlStr = htmlStr + `<div  class="row">
                <h1>
           
                <i class="fa fa-check-circle" aria-hidden="true" style="font-size: 24px;color: #03ad03;margin-right: 2px;" title="Đã xác thực thông tin"></i>
                            ${tomTatYeuCau}	
                    
                </h1>		
                <div style="display: flex;">
                    <p class="name inline" style="padding-right: 20px;">
                        <i class="fa fa-user-o"></i> <a href="/blacasa-cskh-02">Dasuo CSKH</a>
                    </p>
                    <p class="name inline">
                        Mã bài đăng: <strong>${baiDang_Id}</strong>
                    </p>
                </div>		
                
            </div>   
                <!--Kiểu lớp: Tìm GIA SƯ-->
                        <div class="row" style="padding:15px 0;border-top:1px solid #e7e7e7;height: 201px;">
                    <div class="col-md-4 col-sm-4">
                        <p class="no-padding">
                            <i class="fa fa-bookmark"></i> Trạng thái: <span style="font-weight: bold; color: #ff961e; text-transform: uppercase;">
                                Đang tìm giáo viên</span>
                        </p>
                        <p class="no-padding"><i class="fa fa-book"></i>  Môn học:&nbsp;${mon}
                        </p>
                        <p><i class="fa fa-briefcase"></i> Hình thức học: Online (Gia sư)  
                        </p>  		      
                       
                    </div>
                        
                    <div class="col-md-4 col-sm-4">
                        <p><i class="fa fa-venus-mars"></i> Tìm gia sư: 
                        Nam, Nữ				
                        </p>
                        <p><i class="fa fa-user-o"></i>
                            Số học viên : 1					
                        </p>
                        <p><i class="fa fa-book"></i>
                         Thời lượng: Tuần 2 buổi (2h/buổi)
                        </p>
                        <p>
                        <i class="fa fa-money"></i> Học phí 1 buổi: <span class="class-tutor-fee">${hocPhi}</span> 
                        </p>
                    </div>
                        
                    <div class="col-md-4 col-sm-4">
                        <div class="header-study-group-right">
                            <p>Phí nhận lớp:<span class="connection-fee"> 240,000 vnđ</span></p>
                                (<strong style="color: #FF961E">Chuyển khoản </strong> )              
                            <div class="class-actions">
                                <p height="30px">Người đăng ký:</p>
                                <div id="dsyeucau"></div>
                            </div>
                        </div>
                    </div>			
                </div>
                <div class="gblock-v2 detail-content">
                    <div class="text">
                        <h3 style="padding: 12px 0;"><i class="fa fa-quote-right" aria-hidden="true"></i> Chi tiết nội dung cần học</h3>
                        <p>${moTa}</p>
                    <br>
                    
                    </div>
                </div>
                <div class="info-step2">
                    <p  class="p-create-class-title"><i class="fa fa-calendar" aria-hidden="true"></i> Thời gian có thể học</p>
                    <div style="text-align: center; height: 200PX; margin-left: 193px;" class="schedule-detail">
                        <div class="row-calendar-check">
                            <h3>Thứ 2</h3>
                            <ul>
                                <li class="buoihoc">
                                    <label for="morning-calendar-2">Sáng</label>
                                    <input class="radio-calendar" id="sang2" type="checkbox" name="sang_2" value="sang_2">
                                </li>
                                <li class="buoihoc">
                                    <label for="afternoon-calendar-2">Chiều</label>
                                    <input class="radio-calendar" id="chieu2" type="checkbox" name="chieu_2" value="chieu_2">
                                </li>
                                <li class="buoihoc">
                                    <label for="evening-calendar-2">Tối</label>
                                    <input class="radio-calendar" id="toi2" type="checkbox" name="toi_2" value="toi_2">
                                </li>
                            </ul>
                        </div>
                        <div  class="row-calendar-check">
                            <h3>Thứ 3</h3>
                            <ul>
                                <li class="buoihoc">
                                    <label for="morning-calendar-3">Sáng</label>
                                    <input class="radio-calendar" id="sang3" type="checkbox" name="sang_3" value="sang_3">
                                </li>
                                <li class="buoihoc">
                                    <label for="afternoon-calendar-3">Chiều</label>
                                    <input class="radio-calendar" id="chieu3" type="checkbox" name="chieu_3" value="chieu_3">
                                </li>
                                <li class="buoihoc">
                                    <label for="evening-calendar-3">Tối</label>
                                    <input class="radio-calendar" id="toi3" type="checkbox" name="toi_3" value="toi_3">
                                </li>
                            </ul>
                        </div>
                        <div  class="row-calendar-check">
                            <h3>Thứ 4</h3>
                            <ul>
                                <li class="buoihoc">
                                    <label for="morning-calendar-4">Sáng</label>
                                    <input class="radio-calendar" id="sang4" type="checkbox" name="sang_4" value="sang_4">
                                </li>
                                <li class="buoihoc">
                                    <label for="afternoon-calendar-4">Chiều</label>
                                    <input class="radio-calendar" id="chieu4" type="checkbox" name="chieu_4" value="chieu_4">
                                </li>
                                <li class="buoihoc">
                                    <label for="evening-calendar-4">Tối</label>
                                    <input class="radio-calendar" id="toi4" type="checkbox" name="toi_4" value="toi_4">
                                </li>
                            </ul>
                        </div>
                        <div  class="row-calendar-check">
                            <h3>Thứ 5</h3>
                            <ul>
                                <li class="buoihoc">
                                    <label for="morning-calendar-5">Sáng</label>
                                    <input class="radio-calendar" id="sang5" type="checkbox" name="sang_5" value="sang_5">
                                </li>
                                <li class="buoihoc">
                                    <label for="afternoon-calendar-5">Chiều</label>
                                    <input class="radio-calendar" id="chieu5" type="checkbox" name="chieu_5" value="chieu_5">
                                </li>
                                <li class="buoihoc">
                                    <label for="evening-calendar-5">Tối</label>
                                    <input class="radio-calendar" id="toi5" type="checkbox" name="toi_5" value="toi_5">
                                </li>
                            </ul>
                        </div>
                        <div  class="row-calendar-check">
                            <h3>Thứ 6</h3>
                            <ul>
                                <li class="buoihoc">
                                    <label for="morning-calendar-6">Sáng</label>
                                    <input class="radio-calendar" id="sang6" type="checkbox" name="sang_6" value="sang_6">
                                </li>
                                <li class="buoihoc">
                                    <label for="afternoon-calendar-6">Chiều</label>
                                    <input class="radio-calendar" id="chieu6" type="checkbox" name="chieu_6" value="chieu_6">
                                </li>
                                <li class="buoihoc">
                                    <label for="evening-calendar-6">Tối</label>
                                    <input class="radio-calendar" id="toi6" type="checkbox" name="toi_6" value="toi_6">
                                </li>
                            </ul>
                        </div>
                        <div  class="row-calendar-check">
                            <h3>Thứ 7</h3>
                            <ul>
                                <li class="buoihoc">
                                    <label for="morning-calendar-7">Sáng</label>
                                    <input class="radio-calendar" id="sang7" type="checkbox" name="sang_7" value="sang_7">
                                </li>
                                <li class="buoihoc">
                                    <label for="afternoon-calendar-2">Chiều</label>
                                    <input class="radio-calendar" id="chieu7" type="checkbox" name="chieu_7" value="chieu_7">
                                </li>
                                <li class="buoihoc">
                                    <label for="evening-calendar-2">Tối</label>
                                    <input class="radio-calendar" id="toi7" type="checkbox" name="toi_7" value="toi_7">
                                </li>
                            </ul>
                        </div>
                        <div  class="row-calendar-check">
                            <h3>Chủ nhật</h3>
                            <ul>
                                <li class="buoihoc">
                                    <label for="morning-calendar-8">Sáng</label>
                                    <input class="radio-calendar" id="sang8" type="checkbox" name="sang_8" value="sang_8">
                                </li>
                                <li class="buoihoc">
                                    <label for="afternoon-calendar-8">Chiều</label>
                                    <input class="radio-calendar" id="chieu8" type="checkbox" name="chieu_8" value="chieu_8">
                                </li>
                                <li class="buoihoc">
                                    <label for="evening-calendar-8">Tối</label>
                                    <input class="radio-calendar" id="toi8" type="checkbox" name="toi_8" value="toi_8">
                                </li>
                            </ul>
                        </div>
                        <input type="hidden" value="${baiDang_Id}" id="bdid">
                    </div>
                    <p class="note-calender"><span style="color: #007e00">Màu xanh</span> là những buổi có thể học.</p>
                    <div class="row" style="text-align:center;padding:10px 0;" id="taolop-div">
                        
                    </div>
                </div>
                </div>`;
            $(".container").html(htmlStr);
			console.log(baiDangList)
            console.log(nguoiYeuCauDays)
			buois.forEach(value => {
                $("#" + value.buoi + value.ngayTrongTuan).parent().css("background-color", "#008000");
            });
            htmlDSYC = htmlDSYC + `<ul style="list-style-type: none;">`;
            nguoiYeuCauDays.forEach(value => {
                htmlDSYC = htmlDSYC + `<li><input id="nguoiyc" type="radio" name="dsyc" value="${value.taiKhoan_Id}"><label for="nguoiyc">&nbsp;&nbsp;${value.hoTen}</label></li>`;
            });
            htmlDSYC = htmlDSYC + `</ul>`;
            $("#dsyeucau").html(htmlDSYC);

            if($("#tkid").val() == nguoiDangId) {
                htmlTaoLopBtn = `<input type="button" id="taolop-btn" class="btn-bla-big btn-yellowblacasa"
                                    style="cursor: pointer; color:#fff;font-size: 16px;font-weight:bold;border: none; background-color: orange;padding: 16px 20px;border-radius: 5px;"
                                    value="Tạo lớp">`
                $("#taolop-div").html(htmlTaoLopBtn);

            } else {
                var flag = true;
                nguoiYeuCauDays.forEach(value => {
                    if(value.taiKhoan_Id == $("#tkid").val()) {
                        flag = false;
                    }
                });
                if(flag) {
                    htmlTaoLopBtn = `<input type="button" id="dangkyday-btn" class="btn-bla-big btn-yellowblacasa"
                                    style="cursor: pointer; color:#fff;font-size: 16px;font-weight:bold;border: none; background-color: orange;padding: 16px 20px;border-radius: 5px;"
                                    value="Đăng ký dạy">`
                } else {
                    htmlTaoLopBtn = `<input type="button" id="huyyeucau-btn" class="btn-bla-big btn-yellowblacasa"
                                    style="cursor: pointer; color:#fff;font-size: 16px;font-weight:bold;border: none; background-color: gray;padding: 16px 20px;border-radius: 5px;"
                                    value="Đã yêu cầu" disabled>`
                }
                $("#taolop-div").html(htmlTaoLopBtn);
            }
            }
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
