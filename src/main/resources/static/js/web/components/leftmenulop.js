$(document).ready(function(){
    if(window.location.search.substring(1)==""){
        window.location.href = "http://localhost:8083/hienthilichlop";
    }else {
        var bdid = getURLParameter("id");
        var leftMenu = `<ul id="accordion">
                    <li>
                        <a href="/trang-chu"><i class="fas fa-graduation-cap tk-icon icon-menu"></i> Trang chủ </a>
                    </li>
                    <li><a href="#"><i class="fas fa-comments icon-menu"></i> Cuộc trò chuyện</a></li>
                    <li><a href="/xemthongbao?id=${bdid}"><i class="fas fa-bell icon-menu"></i> Thông báo</a></li>
                    <li>
                        <a href="/baikiemtra?id=${bdid}"><i class="fas fa-pen-square icon-menu"></i> Kiểm tra và câu hỏi </a>
                    </li>
                    <li>
                        <a href="/xemgiaotrinh?id=${bdid}"> <i class="fa fa-book icon-menu"></i>Giáo trình </a>
                    </li>
                    <li>
                        <a style="color: #ff961e;" href="#"><i class="fas fa-flag icon-menu"></i> Lớp học online</i></a>
                    </li>
                </ul>`
        $(".left-content").html(leftMenu);
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