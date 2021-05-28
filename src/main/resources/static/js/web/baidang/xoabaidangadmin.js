$(document).ready(function () {
	$('#btnDelete').click( function () {
	// console.log($(this).data('id'));
	if (confirm(`Bạn có muốn khóa bài đăng = ${$(this).data('id')}?`)) {
		let tr = $(this).closest('tr');
		$.ajax({
			method: "PUT",
			url: "http://localhost:8083/api/enablebaidangs/" + $(this).data('id'),
			contentType: "application/json",
			async: false,
			success: function (resp) {
				tr.remove();
				console.log("Hellllll");
			},
			error: function (jqXHR, textStatus, errorThrown) {
				$('.failedToast').children('.toast-body').html('Unsuccessful')
				$('.failedToast').toast('show');
				console.log(textStatus, errorThrown);
			}
		});
	} else { }
	});
});
