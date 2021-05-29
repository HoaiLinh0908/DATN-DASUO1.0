package com.dasuo.controller;

import java.io.IOException;
import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dasuo.dto.BaiKiemTraDTO;
import com.dasuo.dto.BaiLamDTO;
import com.dasuo.dto.GiaoTrinhDTO;
import com.dasuo.dto.LoaiDTO;
import com.dasuo.dto.LopDTO;
import com.dasuo.dto.MonDTO;
import com.dasuo.dto.NgheNghiepDTO;
import com.dasuo.dto.TaiKhoanDTO;
import com.dasuo.dto.TinhThanhDTO;
import com.dasuo.entity.BaiKiemTra;
import com.dasuo.entity.GiaoTrinh;
import com.dasuo.repository.BaiDangRepository;
import com.dasuo.repository.BaiKiemTraRepository;
import com.dasuo.repository.GiaoTrinhRepository;
import com.dasuo.repository.LopRepository;
import com.dasuo.repository.MonRepository;
import com.dasuo.repository.TaiKhoanRepository;
import com.dasuo.service.IBaiKiemTraService;
import com.dasuo.service.IBaiLamService;
import com.dasuo.service.IGiaoTrinhService;
import com.dasuo.service.ILopService;
import com.dasuo.service.IMonService;
import com.dasuo.service.ITaiKhoanService;


@Controller
public class DasuoAdminController {
	
		@Autowired
		ITaiKhoanService taiKhoanService;
		@Autowired
		TaiKhoanRepository taiKhoanRepository;
		@Autowired
		IBaiKiemTraService baiKiemTraService;
		@Autowired
		ILopService lopService;
		@Autowired
		IGiaoTrinhService giaoTrinhService;
		@Autowired
		GiaoTrinhRepository giaoTrinhRepository;

		@Autowired
		BaiKiemTraRepository baiKiemTraRepository;
		@Autowired
		IBaiLamService baiLamService;
		@Autowired
		BaiDangRepository baiDangRepository;
		@Autowired
		LopRepository lopRepository;
		@Autowired
		MonRepository monRepository;
		@Autowired
		IMonService monService;

		

		

		
		@RequestMapping("/admin")
		public String HomeAdmin(Model model) {
			// hiển thị tổng số bài đăng, tài khoản, lớp, môn
			int soBaiDang = (int) baiDangRepository.count();
			int soTaiKhoan = taiKhoanRepository.countTaiKhoan();
			int soLop = lopRepository.countLop();
			int soMon = monRepository.countMon();
			model.addAttribute("soBaiDang", soBaiDang);
			model.addAttribute("soTaiKhoan", soTaiKhoan);
			model.addAttribute("soLop", soLop);
			model.addAttribute("soMon", soMon);
			return "admin/homeadmin";
		}

		
		@RequestMapping("/admin/quanlytaikhoan")
		public String QLTaiKhoanAdmin() {
			return "admin/qltaikhoan";
		}
		@RequestMapping("/admin/khoataikhoan")
		public String QLTaiKhoanAdmin1(@RequestParam("id") Integer id) {
			TaiKhoanDTO _taiKhoanDTO = taiKhoanService.getTaiKhoan(id);
			if(_taiKhoanDTO != null)
			{
				
				_taiKhoanDTO.setEnable(true);	
				taiKhoanService.save(_taiKhoanDTO);
			}
			return "redirect:/admin/quanlytaikhoan";
		}
		@RequestMapping("/admin/xoalophoc")
		public String XoaLopHocAdmin(@RequestParam("id") Integer id) {
			LopDTO lop = lopService.getLop(id);
			if(lop!= null)
				lopService.delete(id);
			return "redirect:/admin/quanlylophoc";
		}
		@RequestMapping("/admin/quanlybaidang")
		public String QLBaiDangAdmin() {
			return "admin/qlbaidang";
		}
		@RequestMapping("/admin/quanlygiaodich")
		public String QLGiaoDichAdmin() {
			return "admin/qlgiaodich";
		}
		@RequestMapping("/admin/quanlymonhoc")
		public String QLMonHocAdmin(Model model) {
			List<MonDTO> mons = monService.getListMon();
			model.addAttribute("mon", mons);
			return "admin/qlmonhoc";
		}
		@RequestMapping("/admin/quanlylophoc")
		public String QLLopHocAdmin() {
			return "admin/qllophoc";
		}
		@RequestMapping("/admin/quanlymonhoc/suamonhoc")
		public String SuaLopHocAdmin(@RequestParam("id") Integer id, Model model) {
			MonDTO mon = monService.getMon(id);
			if(mon!= null)
				model.addAttribute("mon", mon);
			return "admin/themmonhoc";
		}
		@PostMapping("/admin/quanlymonhoc/suamonhoc")
		public String SuaLopHocAdmin1(@RequestParam("id") Integer id,@ModelAttribute("monHocDTO") MonDTO monHocDTO) {
			MonDTO mon = monService.getMon(id);
			if(mon!= null)
			{
				mon.setTenMon(monHocDTO.getTenMon());
				monService.save(mon);
			}
			return "redirect:/admin/quanlymonhoc";
		}
		
		@RequestMapping("/admin/quanlymonhoc/xoamonhoc")
		public String XoaMonHocAdmin(@RequestParam("id") Integer id) {
			MonDTO mon = monService.getMon(id);
			if(mon!= null)
				monService.delete(id);
			return "redirect:/admin/quanlymonhoc";
		}
	}


