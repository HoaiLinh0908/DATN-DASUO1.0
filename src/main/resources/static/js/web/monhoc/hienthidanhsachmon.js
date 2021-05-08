$(document).ready(function(){
    var danhSachMon = []
	$.ajax({
		url: "http://localhost:8083/api/mon",
		contentType: "application/json; charset=utf-8",
		async: false,
		type: "get",
		dataType: "json",
		success: function (response) {
			var htmlStr = ``;
			// lap qua ket qua tra ve & tao html theo mong muon
			response.forEach(value => {
				danhSachMon.push(value)
				var monId = value.mon_Id;
				var tenMon = value.tenMon;
				htmlStr = htmlStr + `<option value="${monId}">${tenMon}</option>`;
			});
			 console.log(danhSachMon)
			//hien thi len
			$(".mon-phothong").html(htmlStr);

		},
		error: function (jqXHR, textStatus, errorThrown) {
			console.log(textStatus, errorThrown);
		}
	});
});