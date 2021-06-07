package com.dasuo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dasuo.dto.LopDTO;
import com.dasuo.dto.MonDTO;
import com.dasuo.dto.TaiKhoanDTO;
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
		@RequestMapping("/admin/quanlymonhoc/themmonhoc")
		public String ThemMonHocAdmin() {
			
			return "admin/suamonhoc";
		}
		@PostMapping("/admin/quanlymonhoc/themmonhoc")
		public String ThemMonHocAdmin1(@ModelAttribute("monHocDTO") MonDTO monHocDTO) {
			
				if(monHocDTO.getTenMon()!= null)
					monService.save(monHocDTO);
			
			return "redirect:/admin/quanlymonhoc";
		}
	}


