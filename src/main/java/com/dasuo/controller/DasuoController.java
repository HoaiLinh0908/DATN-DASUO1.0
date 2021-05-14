package com.dasuo.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dasuo.dto.LoaiDTO;
import com.dasuo.dto.NgheNghiepDTO;
import com.dasuo.dto.TaiKhoanDTO;
import com.dasuo.entity.TinhThanh;
import com.dasuo.repository.TaiKhoanRepository;
import com.dasuo.service.ITaiKhoanService;
import com.dasuo.utils.SecurityUtils;

@Controller
public class DasuoController {
	@Autowired
	ITaiKhoanService taiKhoanService;
	@Autowired
	TaiKhoanRepository taiKhoanRepository;

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
	@PostMapping("/dangky")
	public String addUser(HttpServletRequest request, HttpServletResponse response,
			  @ModelAttribute("taikhoan") TaiKhoanDTO taiKhoanDTO, Model model) {
		String matKhau = taiKhoanDTO.getMatKhau();
		if(taiKhoanRepository.findByEmail(taiKhoanDTO.getEmail()) == null) {
			if(taiKhoanDTO.getSdt()!= "" && taiKhoanDTO.getMatKhau()!= "" && taiKhoanDTO.getEmail()!= "" && taiKhoanDTO.getHoTen()!= "" )
			{
				LoaiDTO loaiDTO = new LoaiDTO();
				loaiDTO.setLoai_Id(1);
				taiKhoanDTO.setLoai(loaiDTO);
				NgheNghiepDTO ngheNghiepDTO = new NgheNghiepDTO();
				ngheNghiepDTO.setNgheNghiep_Id(1);
				taiKhoanDTO.setNgheNghiep(ngheNghiepDTO);
				PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
				taiKhoanDTO.setMatKhau(passwordEncoder.encode(matKhau));
				
				taiKhoanService.save(taiKhoanDTO);
				model.addAttribute("message", "Đăng nhập thành công!");
			}
			else
				model.addAttribute("message", "Đăng nhập thất bại");
		}
		else
			model.addAttribute("message", "Email đã tồn tại!");
		
		
		return "web/register";
	}
	
	@RequestMapping("/admin")
	public String HomeAdmin() {
		return "admin/homeadmin";
	}
	
	@RequestMapping("/taikhoan/trangcanhan")
	public String viewProfile(Principal principal) {
		TaiKhoanDTO taiKhoanDTO = taiKhoanService.getTaiKhoan(principal.getName());
		System.out.println(taiKhoanDTO.getHoTen());
		
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
	
	@RequestMapping("/trang-chu")
	public String viewTrangChu(Principal principal,Model model) {
		model.addAttribute("ten", SecurityUtils.getPrincipal().getUser_Id());
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
	@RequestMapping(value = "/thoat", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		//Check user info, if there is info then delete it
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		//return to home page
		return new ModelAndView("redirect:/trang-chu");
	}

}
