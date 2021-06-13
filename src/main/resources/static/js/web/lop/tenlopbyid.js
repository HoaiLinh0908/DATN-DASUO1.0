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
				var tenLop = response.tenLop;
				htmlStr = `${tenLop}`;
			$("#tenlop").html(htmlStr);
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