$(document).ready(function(){
	var header = `<div class="logo"><a style="text-decoration: none;" href="/trang-chu">
					<h2 class="text-logo">Dasuo</h2>
				  </a></div>
				  <div class="menu-top"><ul id="nav">
                     <li><a href="/taobaidang">Đăng yêu cầu</a></li>
                 	 <li><a href="/hienthibaidang">Lớp mới</a></li>
                 	 <li><a href="#">Gia sư <i class="fas fa-caret-down icon-down"></i></a>
                       <ul class="subnav">
                         <li><a href="/taobaidang">Yêu cầu tìm gia sư</a></li><li><a href="/giasuonline">Gia sư online</a></li><li><a href="/dangkitrothanhgiasu">Trở thành gia sư</a></li>
                  </ul></li></ul></div>
                  <div style="width: 35%; display: flex;line-height: 54px;" class="navbar-form">
                  <div class="search-header">
                  <input style="padding: 6.8px 4px;border-radius: 3px;" placeholder="Tìm gia sư theo môn học " class=" form-text" type="text" id="edit-key" name="key" value="" size="40" maxlength="128">
                  </div>
                  <button style="background-color: #f6f6f6;border-radius: 3px;border: none;cursor: pointer;margin-top: 12px;height: 31px;width: 42px;" title="Tìm gia sư"><i style="font-size: 20px; padding: 0 0;" class="fa fa-search"></i></button>
         	 	  </div>
         	 	  <div class="flex-row-nowrap" id="bs-example-navbar-collapse-1" style=" padding:0px; width: 30%; height: 54px;">		
					        <ul style="display: flex; height: 54px; margin-left: 60px;" class="nav navbar-nav navbar-right">
                      <li style="border-right: 1px solid #fff;" class="avatar hidden-xs flex-row-nowrap common-tooltip">
                        <a style="color: #fff;text-decoration: none; " href="/taikhoan/trangcanhan" class="active"><i style="color: #fff;font-size: 20px;margin-left: 3px;" class="fa fa-user-circle header-main-icon" aria-hidden="true"></i></a>
                      </li>        
                      <li style="line-height: 54px;width: 20%;list-style: none;margin-left: 8px;" class="dropdown notification message-info common-tooltip dropdowns"> 									
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false" data-type="view_message">
                            <i style="color: #fff;font-size: 20px;margin-left: 3px;" class="fa fa-comments header-main-icon" aria-hidden="true"></i>	<h4 style="visibility: hidden;" class="title-drop"><span>Tin nhắn</span></h4>
                            <div class="count"></div>
                        </a>
                        <div class="dropdown-menu" >
                            <h4 class="title-drop"><span>Tin nhắn</span></h4>
                            <div class="list mCustomScrollbar _mCS_2 mCS_no_scrollbar">      
                                <div class="view-empty">
                                    <p class="text-tb">Không có tin nhắn nào.</p>
                                    <div class="detail-list">
                                        
                                        <img style="border-radius: 50%;"  class="chat-avatar" src="/img/ava.jpg" alt=""> <a  href="#">    Đỗ Hoài Linh </a>
                                    </div>
                                    <div class="detail-list">
                                        
                                        <img class="chat-avatar" src="/img/ava.jpg" alt="">    <a  href="#">    Đỗ Hoài Linh </a>
                                    </div>
                                    <div class="detail-list">
                                        
                                        <img class="chat-avatar" src="/img/ava.jpg" alt="">   <a  href="#">    Đỗ Hoài Linh </a>
                                    </div>
                                    
                                </div>
                            </div>
                            <div class="text-center view-all">
                                <a href="#">Xem tất cả</a>
                            </div>
                        </div>
                    </li>
    
                    <li style="line-height: 54px;width: 20%;list-style: none;margin-left: -30px;" class="dropdown notification message-info common-tooltip tb_menu_top"> 									
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false" data-type="view_message">
                            <i style="color: #fff;font-size: 20px;margin-left: 3px;" class="fa fa-bell icon-menu" aria-hidden="true"></i>	<h4 style="visibility: hidden;" class="title-drop"><span>Thông Báo</span></h4>
                            <div class="count"></div>
                        </a>
                        <div class="dropdown-menu" >
                            <h4 class="title-drop"><span>Thông báo</span></h4>
                            <div class="list mCustomScrollbar _mCS_2 mCS_no_scrollbar">      
                                <div class="view-empty">
                                    <p class="text-tb">Không có thông báo nào.</p>
                                    <div class="detail-list">
                                        
                                        <a  href="#"><i style="font-size: 18px;padding: 0 4px;" class="fas fa-hand-point-right"></i>    Bạn có lớp mới </a>
                                    </div>
                                    <div  class="detail-list">
                                        <a  href="#"><i style="font-size: 18px;padding: 0 4px;" class="fas fa-hand-point-right"></i>    Bạn đã đăng ký lớp</a>
                                    </div>
                                </div>
                            </div>
                            <div class="text-center view-all">
                                <a href="#">Xem tất cả</a>
                            </div>
                        </div>
                    </li>
                      <li style="line-height: 54px;width: 20%;list-style: none; margin-left: -30px;" class="dropdown notification message-info common-tooltip">
                        <a href="/thoat" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false" data-type="view_message">
                          <i style="color: #fff;font-size: 20px;margin-left: 3px;" class="fas fa-sign-out-alt" aria-hidden="true"></i><h4 style="visibility: hidden;" class="title-drop"><span>Đăng xuất</span></h4>
                          <div class="count"></div>
                        </a>
                      </li>
                   </div>`;
    $("#header").html(header);
});