$(document).ready(function () {
	$('#khoa').click( function () {

	$.ajax({
		url: "http://localhost:8083/api/khoataikhoan/" + $(this).data('id'),
		contentType: "application/json; charset=utf-8",
		async: false,
		type: "PUT",
		dataType: "json",
		success: function (response) {
			location.reload();
		},
		error: function (jqXHR, textStatus, errorThrown) {
			console.log(textStatus, errorThrown);
		}
	});
});
/*$('#btnDelete').click( function () {
		$.ajax({
			method: "PUT",
			url: "http://localhost:8083/api/khoataikhoan/" + $(this).data('id'),
			contentType: "application/json",
			async: false,
			success: function (resp) {
				location.reload();
				
				
			},
			error: function (jqXHR, textStatus, errorThrown) {
				$('.failedToast').children('.toast-body').html('Unsuccessful')
				$('.failedToast').toast('show');
				console.log(textStatus, errorThrown);
			}
		});
	
	});*/
});

/*$('#tbodyData').on('click', '#btnDelete', function() {
	if (confirm(`You want to delete ${$(this).data('id')} Airplane?`)) {
		// get class name cua the <tr> muon xoa   
		var rawstrClass = $(this).closest('tr').attr('class');
		var strClass = '';
		for (var i = 0; i < rawstrClass.split(" ").length; i++) {
			strClass = strClass + '.' + rawstrClass.split(" ")[i];
		}
		$.ajax({
			//  $(this).data('id') = ma san bay
			url: "/FlightTicketManagement/api/airplanes/" + $(this).data('id'),
			contentType: "application/json",
			async: false,
			type: "delete",
			success: function(response) {
				//xoa the <tr>
				$('.successToast').toast('show');
				$("tr").remove(strClass);
			},
			error: function(jqXHR, textStatus, errorThrown) {
			$('.failedToast').children('.toast-body').html('Unsuccessful')
			$('.failedToast').toast('show');
				console.log(textStatus, errorThrown);
			}
		});
	} else { }
});*/