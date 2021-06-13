$(document).ready(function () {
    if(window.location.search.substring(1)==""){
        window.location.href = "http://localhost:8083/hienthilichlop";
    }else {
        var bdid = getURLParameter("id");
    $("#save-taoroom").click( function () {
       $.ajax({
           url: "http://localhost:8083/api/taoroom/" + bdid,
           type: "put",
           contentType: "application/json; charset=utf-8",
           async: false,
           dataType: "text",
           data: $("#idroom").val(),
           success: function (response) {
               alert("Đã gửi thành công!!!");
           },
           error: function (response) {
               alert("Gửi thất bại!!!");
           }
       });
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
