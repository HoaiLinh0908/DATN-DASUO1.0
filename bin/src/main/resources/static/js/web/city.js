//su kien nut Add thanh pho
$('body').on('click', '#submit', function () {

	//check id


	// check exists


	// check validate
	$.ajax({
		url: "http://localhost:8081/api/tinhthanhs",
		async: false,
		type: "post",
		contentType: "application/json; charset=utf-8",
		async: false,
		dataType: "json",
		// du lieu truyen vao dang json 
		data: JSON.stringify({ "tenTinh": $("#cityName").val() }),
		success: function (response) {
			$("#cityCode").val("");
			$("#cityName").val("");
			$('.successToast').toast('show');
			console.log(response);
			cityList = []
			loadCityList();
		},
		// error: function(response) {
		// 	// $('.failedToast').children('.toast-body').html('Unsuccessful')
		// 	console.log(response);
		// }
		error: function (response) {
			console.log(response)
			let errorHtml = ``;
			Object.entries(response.responseJSON).forEach(([key, value]) => errorHtml += `<li>${value}</li>`)
			console.log(response.responseJSON)
			$('.failedToast').children('.toast-body').html(errorHtml)
			$('.failedToast').toast('show');
		}
	});
});