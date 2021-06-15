$(document).ready(function () {
    $("#btn-timkiem").click( function () {
        window.location.href = "http://localhost:8083/timkiem?key=" + $("#edit-key").val();
    });
});