$(document).ready(function(){
    var leftMenu = `<ul id="accordion">
                    <li><a style="color: #ff961e;" href="/trang-chu"><i class="fas fa-home icon-menu"></i> Trang chủ</a></li>
                    <li><a href="#"><i class="fas fa-comments icon-menu"></i> Tin nhắn</a></li>
                    <li><a href="#"><i class="fas fa-bell icon-menu"></i> Thông báo</a></li>
                    <li>
                        <a href="/baidangcuatoi"><i class="fas fa-pen-square icon-menu"></i> Bài đăng của tôi</a>
                    </li>
                    <li>
                        <a href="#"> <i class="fas fa-heart icon-menu"></i>Đã lưu <i
                                class="fas fa-chevron-right show-right"></i></a>
                        <ul class="sub-menu">
                            <li><a href="#">Bài viết đã lưu</a></li>
                            <li><a href="#">Giáo viên yêu thích</a></li>
                        </ul>
                    </li>
                    <li><a href="#"> <i class="fas fa-dollar-sign icon-menu"></i> Lịch sử giao dịch</a></li>
                    <li>
                        <a href="#"><i class="fas fa-flag icon-menu"></i> Thông tin cá nhân <i
                                class="fas fa-chevron-right show-right"></i></a>
                        <ul class="sub-menu">
                            <li><a href="/taikhoan/trangcanhan">Trang cá nhân</a></li>
                            <li><a href="/suathongtin">Sửa thông tin cá nhân</a></li>
                            <li><a href="/doimatkhau">Thay đổi mật khẩu</a></li>
                        </ul>
                    </li>
                    <li>
                        <a href="/phanhoi"><i class="fa fa-envelope icon-menu"></i>Phản hồi</a>
                    </li>
                    <li>
                        <a href="/hienthilichlop"><i class="fa fa-pencil-square icon-menu"></i> Lớp</a>
                    </li>
                </ul>`
    $(".left-content").html(leftMenu);
});