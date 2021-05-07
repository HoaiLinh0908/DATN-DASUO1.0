$(document).ready(function () {
    var popularTeacherList = []
	$.ajax({
		url: "http://localhost:8081/api/taikhoanuutus",
		contentType: "application/json; charset=utf-8",
		async: false,
		type: "get",
		dataType: "json",
		success: function (response) {
			var htmlStr = ``;
			// lap qua ket qua tra ve & tao html theo mong muon
			response.forEach(value => {
				popularTeacherList.push(value)
				var taiKhoanId = value.taiKhoan_Id;
				var hoTen = value.hoTen;
				htmlStr = htmlStr + `<div class="gia-su">
                           <a href="#"><img src="/img/user1.png"></a>
                           <p class="name-gia-su">${hoTen}</p>
                           <p class="address">Hà Nội | Toán, Tiếng anh</p>
                           <p class="mo-ta">Thủ khoa ĐH Duy Tân về lãnh vực toán học và Ielts 8.0 </p>
                           <button href="#" class="btn-md">Mời dạy</button>
                    </div>`;
			});
			 console.log(popularTeacherList)
			//hien thi len
            htmlStr = htmlStr + `<a href="#" class="see-more"> Xem thêm </a>`;
			$(".inf-giasu").html(htmlStr);

		},
		error: function (jqXHR, textStatus, errorThrown) {
			console.log(textStatus, errorThrown);
		}
	});
});