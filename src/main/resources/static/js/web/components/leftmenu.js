$(document).ready(function(){
    var leftMenu = `<ul id="accordion">
                    <li><a style="color: #ff961e;" href="#"><i class="fas fa-home icon-menu"></i> Trang chủ</a></li>
                    <li>
                        <a href="#"><i class="fas fa-graduation-cap tk-icon icon-menu"></i> Quản lý yêu cầu <i
                                class="fas fa-chevron-right show-right"></i></a>
                        <ul class="sub-menu">
                            <li><a href="#">Tất cả lớp đã đăng</a></li>
                            <li><a href="#">Đăng yêu cầu tìm gia sư mới</a></li>
                        </ul>
                    </li>
                    <li><a href="#"><i class="fas fa-comments icon-menu"></i> Hội thoại và tin nhắn</a></li>
                    <li><a href="#"><i class="fas fa-bell icon-menu"></i> Thống báo</a></li>
                    <li>
                        <a href="#"><i class="fas fa-pen-square icon-menu"></i> Bài viết <i
                                class="fas fa-chevron-right show-right"></i></a>
                        <ul class="sub-menu">
                            <li><a href="#">Đã đăng</a></li>
                            <li><a href="#">Đang soạn</a></li>
                            <li><a href="#">Đã gửi</a></li>
                        </ul>
                    </li>
                    <li>
                        <a href="#"> <i class="fas fa-heart icon-menu"></i>Đã lưu <i
                                class="fas fa-chevron-right show-right"></i></a>
                        <ul class="sub-menu">
                            <li><a href="#">Yêu cầu tìm giáo viên</a></li>
                            <li><a href="#">Giáo viên</a></li>
                        </ul>
                    </li>
                    <li><a href="#"> <i class="fas fa-dollar-sign icon-menu"></i> Lịch sử giao dịch</a></li>
                    <li>
                        <a href="#"><i class="fas fa-flag icon-menu"></i> Thông tin cá nhân <i
                                class="fas fa-chevron-right show-right"></i></a>
                        <ul class="sub-menu">
                            <li><a href="#">Sửa thông tin cá nhân</a></li>
                            <li><a href="#">Thay đổi mật khẩu</a></li>
                        </ul>
                    </li>
                    <li>
                        <a href="/hienthilichlop"><i class="fa fa-pencil-square icon-menu"></i> Lớp <i
                                class="fas fa-chevron-right show-right"></i></a>
                        <ul class="sub-menu">
                            <li><a href="" id="classname"></a></li>
                            <li><a href="" id="classname"></a></li>
                            <li><a href="" id="classname"></a></li>
                            <li><a href="" id="classname"></a></li>
                        </ul>
                    </li>
                </ul>`
    $(".left-content").html(leftMenu);
});