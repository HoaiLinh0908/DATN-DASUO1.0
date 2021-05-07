package com.dasuo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DasuoController {
	@RequestMapping("/index")
	public String demo() {
		return "index";
	}
	@RequestMapping("/dangnhap")
	public String Login() {
		return "web/loggin";
	}
	
	@RequestMapping("/dangky")
	public String signUp() {
		return "web/register";
	}
	
	@RequestMapping("/admin")
	public String HomeAdmin() {
		return "admin/homeadmin";
	}
	
	@RequestMapping("/taikhoan/trangcanhan")
	public String viewProfile() {
		return "web/userinformation";
	}

	@RequestMapping("/trochuyen")
	public String viewChat() {
		return "web/chat";
	}

	@RequestMapping("/hienthibaidang")
	public String viewBaiDang() {
		return "web/hienthibaidang";
	}
	
	@RequestMapping("/hienthilichlop")
	public String viewLichHoc() {
		return "web/hienthilichlop";
	}
	
	@RequestMapping("/suathongtin")
	public String viewSuaThonTin() {
		return "web/suathongtin";
	}
	
	@RequestMapping("/taobaidang")
	public String viewTaoBaiDang() {
		return "web/taobaidang";
	}
	
	@RequestMapping("/timkiem")
	public String viewTimKiem() {
		return "web/timkiem";
	}
	
	@RequestMapping("/trangchu")
	public String viewTrangChu() {
		return "web/trangchu";
	}
	
	@RequestMapping("/upbaikt")
	public String viewUpBaiKT() {
		return "web/upbaikt";
	}
	
	@RequestMapping("/doimatkhau")
	public String viewDoiMatKhau() {
		return "web/doimatkhau";
	}
	
	@RequestMapping("/quenmatkhau")
	public String viewQuenMatKhau() {
		return "forgot_password_form";
	}
}
