$(document).ready(function(){
    var leftMenu = `<ul id="accordion">
                    <li>
                        <a href="#"><i class="fas fa-graduation-cap tk-icon icon-menu"></i> Trang chủ </a>
                    </li>
                    <li><a href="#"><i class="fas fa-comments icon-menu"></i> Cuộc trò chuyện</a></li>
                    <li><a href="#"><i class="fas fa-bell icon-menu"></i> Thông báo</a></li>
                    <li>
                        <a href="#"><i class="fas fa-pen-square icon-menu"></i> Kiểm tra và câu hỏi </a>
                    </li>
                    <li>
                        <a href="#"> <i class="fa fa-book icon-menu"></i>Giáo trình </a>
                    </li>
                    <li>
                        <a style="color: #ff961e;" href="#"><i class="fas fa-flag icon-menu"></i> Lớp học online</i></a>
                    </li>
                </ul>`
    $(".left-content").html(leftMenu);
});