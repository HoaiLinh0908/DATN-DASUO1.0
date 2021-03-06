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
import org.springframework.web.bind.annotation.PathVariable;
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
import com.dasuo.dto.LichSuGiaoDichDTO;
import com.dasuo.dto.LoaiDTO;
import com.dasuo.dto.LopDTO;
import com.dasuo.dto.NgheNghiepDTO;
import com.dasuo.dto.PhanHoiDTO;
import com.dasuo.dto.TaiKhoanDTO;
import com.dasuo.dto.TinhThanhDTO;
import com.dasuo.entity.BaiKiemTra;
import com.dasuo.entity.BaiLam;
import com.dasuo.entity.GiaoTrinh;
import com.dasuo.repository.BaiDangRepository;
import com.dasuo.repository.BaiKiemTraRepository;
import com.dasuo.repository.BaiLamRepository;
import com.dasuo.repository.GiaoTrinhRepository;
import com.dasuo.repository.LopRepository;
import com.dasuo.repository.MonRepository;
import com.dasuo.repository.TaiKhoanRepository;
import com.dasuo.service.IBaiKiemTraService;
import com.dasuo.service.IBaiLamService;
import com.dasuo.service.IGiaoTrinhService;
import com.dasuo.service.ILichSuGiaoDichService;
import com.dasuo.service.ILopService;
import com.dasuo.service.IPhanHoiService;
import com.dasuo.service.ITaiKhoanService;
import com.dasuo.service.ITinhThanhService;
import com.dasuo.utils.SecurityUtils;

@Controller
public class DasuoController {
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
	ITinhThanhService tinhThanhService;
	@Autowired
	IPhanHoiService phanHoiService;
	@Autowired
	BaiLamRepository baiLamRepository;
	@Autowired
	ILichSuGiaoDichService lichSuGiaoDichService;
	

	@RequestMapping("/")
	public String demo(Model model) {
		List<TaiKhoanDTO> _taiKhoans = taiKhoanService.getListGSNoiBat();
		_taiKhoans.forEach((taikhoan) ->{
			if (taikhoan.getTinhThanh() == null) {
				taikhoan.setTinhThanh(new TinhThanhDTO());
				taikhoan.getTinhThanh().setTenTinh("Ch??a c???p nh???t");
			}
		});
		
		model.addAttribute("taikhoan", _taiKhoans);
		return "index";
	}

	@RequestMapping("/dangnhap")
	public String Login() {
		return "web/loggin";
	}

	@RequestMapping(value = "/thoat", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		// Check user info, if there is info then delete it
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		// return to home page
		return new ModelAndView("redirect:/dangnhap");
	}

	@RequestMapping("/dangky")
	public String signUp() {
		return "web/register";
	}

	@PostMapping("/dangky")
	public String addUser(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("taikhoan") TaiKhoanDTO taiKhoanDTO, Model model) {
		String matKhau = taiKhoanDTO.getMatKhau();
		if (taiKhoanRepository.findByEmail(taiKhoanDTO.getEmail()) == null) {
			if (taiKhoanDTO.getSdt() != "" && taiKhoanDTO.getMatKhau() != "" && taiKhoanDTO.getEmail() != ""
					&& taiKhoanDTO.getHoTen() != "") {
				LoaiDTO loaiDTO = new LoaiDTO();
				loaiDTO.setLoai_Id(1);
				taiKhoanDTO.setLoai(loaiDTO);
				NgheNghiepDTO ngheNghiepDTO = new NgheNghiepDTO();
				ngheNghiepDTO.setNgheNghiep_Id(1);
				taiKhoanDTO.setNgheNghiep(ngheNghiepDTO);
				PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
				taiKhoanDTO.setMatKhau(passwordEncoder.encode(matKhau));

				taiKhoanService.save(taiKhoanDTO);
				model.addAttribute("message", "????ng k?? t??i kho???n th??nh c??ng!");
				model.addAttribute("alert", "success");
			} else {
				model.addAttribute("message", "????ng k?? t??i kho???n th???t b???i");
				model.addAttribute("alert", "error");
			}
		} else {
			model.addAttribute("message", "Email ???? t???n t???i!");
			model.addAttribute("alert", "error");
		}
		return "web/register";
	}

	@RequestMapping("/taikhoan/trangcanhan")
	public String viewProfile(Model model) {
		TaiKhoanDTO taiKhoanDTO = taiKhoanService.getTaiKhoan(SecurityUtils.getPrincipal().getEmail());
		if (taiKhoanDTO.getTinhThanh() == null) {
			taiKhoanDTO.setTinhThanh(new TinhThanhDTO());
			taiKhoanDTO.getTinhThanh().setTenTinh("Ch??a c???p nh???t");
		}
		model.addAttribute("taiKhoan", taiKhoanDTO);
		return "web/userinformation";
	}
	
	@RequestMapping("/taikhoan/trangcanhan/{id}")
	public String xemThongTin(Model model, @PathVariable("id") Integer id) {
		TaiKhoanDTO taiKhoanDTO = taiKhoanService.getTaiKhoan(id);
		if (taiKhoanDTO.getTinhThanh() == null) {
			taiKhoanDTO.setTinhThanh(new TinhThanhDTO());
			taiKhoanDTO.getTinhThanh().setTenTinh("Ch??a c???p nh???t");
		}
		model.addAttribute("taiKhoan", taiKhoanDTO);
		return "web/thongtintaikhoan";
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
	public String viewLichHoc(Model model) {
		model.addAttribute("tkid", SecurityUtils.getPrincipal().getUser_Id());
		TaiKhoanDTO taiKhoanDTO = taiKhoanService.getTaiKhoan(SecurityUtils.getPrincipal().getEmail());
		model.addAttribute("role", taiKhoanDTO.getLoai().getLoai_Id());
		return "web/hienthilichlop";
	}

	@RequestMapping("/suathongtin")
	public String viewSuaThonTin(Model model) {
		TaiKhoanDTO taiKhoanDTO = taiKhoanService.getTaiKhoan(SecurityUtils.getPrincipal().getUser_Id());
		model.addAttribute("taiKhoan", taiKhoanDTO);
		model.addAttribute("tinhThanh", tinhThanhService.getListTinhThanhs());
		return "web/suathongtin";
	}

	@PostMapping("/suathongtin")
	public String viewSuaThonTin1(HttpServletResponse response, @ModelAttribute("taikhoan") TaiKhoanDTO taiKhoanDTO,
			@RequestParam(value="tinhThanhid", required=false) Integer id, RedirectAttributes ra) {
		TaiKhoanDTO _taiKhoanDTO = taiKhoanService.getTaiKhoan(SecurityUtils.getPrincipal().getUser_Id());
		if (_taiKhoanDTO != null && id != null && id != 0&& taiKhoanDTO.isGioiTinh()!=null) {
			_taiKhoanDTO.setHoTen(taiKhoanDTO.getHoTen());
			_taiKhoanDTO.setMoTa(taiKhoanDTO.getMoTa());
			_taiKhoanDTO.setGioiTinh(taiKhoanDTO.isGioiTinh());
			TinhThanhDTO tinhThanh = tinhThanhService.getTinhThanh(id);
			if (tinhThanh != null) {
				_taiKhoanDTO.setTinhThanh(tinhThanh);
			}
			taiKhoanService.save(_taiKhoanDTO);
			ra.addFlashAttribute("message", "C???p nh???t th??nh c??ng th??ng tin t??i kho???n");

			return "redirect:/suathongtin";
		} else {
			ra.addFlashAttribute("message", "C???p nh???t th???t b???i th??ng tin t??i kho???n");

			return "redirect:/suathongtin";
		}

	}

	@RequestMapping("/taobaidang")
	public String viewTaoBaiDang(Model model) {
		model.addAttribute("tkid", SecurityUtils.getPrincipal().getUser_Id());
		return "web/taobaidang";
	}

	@RequestMapping("/timkiem")
	public String viewTimKiem() {
//		(@RequestParam(value = "ten" , required = false) String ten,
//				@RequestParam(value = "page" , required = false) Integer page,
//				@RequestParam(value = "limit" , required = false) Integer limit ,Model model
//		if(ten.length()==0)
//		{
//			model.addAttribute("mess", "Vui l??ng nh???p k???t qu??? t??m ki???m");
//			return "web/timkiem";
//		}
//		else
//		{
//			TaiKhoanOutput taiKhoanOutput = new TaiKhoanOutput();
//			Pageable pageable = PageRequest.of(page-1, limit);
//			taiKhoanOutput.setPage(page);
//			taiKhoanOutput.setTaiKhoanDTO(taiKhoanService.getTimListTaiKhoan(ten,pageable));
//			taiKhoanOutput.setTotalPage(taiKhoanService.getTotalPage(limit));
//				model.addAttribute("taikhoan", taiKhoanOutput);
//				return "web/timkiem";
//			List<TaiKhoanDTO> taiKhoanDTO = taiKhoanService.getTimListTaiKhoan(ten);
//			if(taiKhoanDTO!= null)
//			{
//				model.addAttribute("taikhoan", taiKhoanDTO);
//				return "web/timkiem";
//			}
//			else
//			{
//				model.addAttribute("mess", "kh??ng t??m th???y k???t qu??? n??o");
//				return "web/timkiem";
//			}
			
		return "web/timkiem";
		
	}

	@RequestMapping("/trang-chu")
	public String viewTrangChu(Principal principal, Model model) {
		model.addAttribute("ten", principal.getName());
		return "web/trangchu";
	}

	@RequestMapping("/check")
	public String check(Principal principal, Model model) {
		if (SecurityUtils.getPrincipal().getLoai() == null) {
			return "redirect:/dangnhap";
		} else {
			if (SecurityUtils.getPrincipal().getLoai().getLoai_Id() == 5) {
				return "redirect:/admin";
			} else {
				return "redirect:/trang-chu";
			}
		}
	}

	@RequestMapping("/upbaikt")
	public String viewUpBaiKT(@RequestParam("id") Integer id, Model model) {
		TaiKhoanDTO taiKhoanDTO = taiKhoanService.getTaiKhoan(SecurityUtils.getPrincipal().getEmail());
		model.addAttribute("role", taiKhoanDTO.getLoai().getLoai_Id());
		model.addAttribute("tkid", SecurityUtils.getPrincipal().getUser_Id());
		model.addAttribute("lopId", id);
		return "web/upbaikt";
	}

	// x??? l?? upload file b??i ki???m tra
	@PostMapping("/upbaikt")
	public String uploadfileBaiKiemTra(@RequestParam("document") MultipartFile file, RedirectAttributes ra,
			@ModelAttribute("baikiemtra") BaiKiemTraDTO baiKiemTraDTO, @RequestParam("id") Integer id,
			@RequestParam(value = "date", required=false) String date) throws IOException, java.text.ParseException {
		
		if( StringUtils.cleanPath(file.getOriginalFilename()).length() < 1)
		{
			ra.addFlashAttribute("message", "Th??m b??i ki???m tra th???t b???i");
			String b = "redirect:/upbaikt?id=" + id;
			return b;
		}
		else
		{
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			String dateInString = date.substring(0, 10);
			System.out.println(dateInString);

			Date datekiemtra = formatter.parse(dateInString);
			System.out.println(datekiemtra);
			if (!datekiemtra.after(new Date())) {
				ra.addFlashAttribute("message", "Ng??y n???p b??i ki???m tra ph???i l???n h??n h??m nay");
				String b = "redirect:/upbaikt?id=" + id;
				return b;
			} else {
				String filename = StringUtils.cleanPath(file.getOriginalFilename());
				BaiKiemTraDTO baiKiemTra = new BaiKiemTraDTO();
				baiKiemTra.setContent(file.getBytes());
				baiKiemTra.setFileName(filename);
				LopDTO lopDTO = lopService.getLop(id);
				baiKiemTra.setLop(lopDTO);
				baiKiemTra.setNoiDung(baiKiemTraDTO.getNoiDung());
				baiKiemTra.setTieuDe(baiKiemTraDTO.getTieuDe());
				baiKiemTra.setThoiGianBatDau(new Date());
				String a = date.replace('T', ' ');
				baiKiemTra.setThoiGianNop(a);
				baiKiemTraService.save(baiKiemTra);
				ra.addFlashAttribute("message", "Th??m b??i ki???m tra th??nh c??ng");
				String b = "redirect:/upbaikt?id=" + id;
				return b;
			}
		}
		

	}

	@RequestMapping("/doimatkhau")
	public String viewDoiMatKhau() {
		return "web/doimatkhau";
	}

	@PostMapping("/doimatkhau")
	public String doiMatKhau(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("taikhoan") TaiKhoanDTO taiKhoanDTO, Model model, RedirectAttributes ra) {

		Integer id = SecurityUtils.getPrincipal().getUser_Id();
		if (id != null && taiKhoanDTO.getMatKhau() != null && taiKhoanDTO.getMatKhauMoi() != null) {
			TaiKhoanDTO _taiKhoanDTO = taiKhoanService.getTaiKhoan(id);
			PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			if (passwordEncoder.matches(taiKhoanDTO.getMatKhau(), _taiKhoanDTO.getMatKhau())) {

				_taiKhoanDTO.setMatKhau(passwordEncoder.encode(taiKhoanDTO.getMatKhauMoi()));
				taiKhoanService.save(_taiKhoanDTO);
				ra.addFlashAttribute("message", "?????i m???t kh???u th??nh c??ng!");
				ra.addFlashAttribute("alert", "success");
			} else {
				ra.addFlashAttribute("message", "M???t kh???u hi???n t???i kh??ng ????ng!");
				ra.addFlashAttribute("alert", "error");
			}
		} else {
			ra.addFlashAttribute("message", "B???n ???? ?????i m???t kh???u th???t b???i!");
			ra.addFlashAttribute("alert", "error");
		}
		return "redirect:/doimatkhau";
	}

//	@RequestMapping("/taolaimatkhau")
//	public String viewQuenMatKhau() {
//		return "web/taolaimatkhau";
//	}

	/*
	 * @PostMapping("/quenmatkhau") public String QuenMatKhau(HttpServletRequest
	 * request, Model model) {
	 * 
	 * return "web/quenmatkhau"; }
	 */

	@RequestMapping("/chitietbaidang")
	public String chiTietBaiDang(Model model) {
		model.addAttribute("tkid", SecurityUtils.getPrincipal().getUser_Id());
		TaiKhoanDTO taiKhoanDTO = taiKhoanService.getTaiKhoan(SecurityUtils.getPrincipal().getEmail());
		model.addAttribute("role", taiKhoanDTO.getLoai().getLoai_Id());
		return "web/chi-tiet-bai-dang";
	}

	@RequestMapping("/dangkitrothanhgiasu")
	public String dkLamGiaSu(Model model) {
		model.addAttribute("tkid", SecurityUtils.getPrincipal().getUser_Id());
		return "web/dk-gia-su";
	}

	@RequestMapping("/giasuonline")
	public String giaSuOnline() {
		return "web/gia-su-online";
	}

	@RequestMapping("/danggiaotrinh")
	public String dangGiaoTrinh(Model model, @RequestParam("id") Integer id) {
		model.addAttribute("tkid", SecurityUtils.getPrincipal().getUser_Id());
		model.addAttribute("lopId", id);
		return "web/up-giao-trinh";
	}

	// x??? l?? upload file giao tr??nh
	@PostMapping("/danggiaotrinh")
	public String uploadfileGiaoTrinh(@RequestParam("document") MultipartFile file, RedirectAttributes ra,
			@ModelAttribute("giaotrinh") GiaoTrinhDTO giaoTrinhDTO, @RequestParam("idlop") Integer idlop)
			throws IOException {
		if(StringUtils.cleanPath(file.getOriginalFilename()).length() <1 )
		{
			ra.addFlashAttribute("message", "Th??m gi??o tr??nh th???t b???i");
			String a = "redirect:/danggiaotrinh?id=" + idlop;
			return a;
		}
		// l???y ra t??n file
		String filename = StringUtils.cleanPath(file.getOriginalFilename());

		GiaoTrinhDTO giaoTrinh = new GiaoTrinhDTO();
		giaoTrinh.setContent(file.getBytes());
		giaoTrinh.setFileName(filename);
		LopDTO lopDTO = lopService.getLop(idlop);
		giaoTrinh.setLop(lopDTO);
		giaoTrinh.setGiaoTrinh(giaoTrinhDTO.getGiaoTrinh());
		giaoTrinh.setTieuDe(giaoTrinhDTO.getTieuDe());
		giaoTrinh.setThoiGian(new Date());
		giaoTrinhService.save(giaoTrinh);
		ra.addFlashAttribute("message", "Th??m gi??o tr??nh th??nh c??ng");
		ra.addFlashAttribute("alert", "success");
		return "redirect:/danggiaotrinh?id=" + idlop;
	}

	@GetMapping("/download")
	public void downloadFile(@Param("id") Integer id, HttpServletResponse response) throws Exception {
		Optional<GiaoTrinh> resul = giaoTrinhRepository.findById(id);
		if (!resul.isPresent()) {
			throw new Exception("Kh??ng t??m th???y ID" + id);
		}
		GiaoTrinh giaoTrinhEntity = resul.get();
		response.setContentType("application/octet-stream");
		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=" + giaoTrinhEntity.getFileName();
		response.setHeader(headerKey, headerValue);
		ServletOutputStream outputStream = response.getOutputStream();
		outputStream.write(giaoTrinhEntity.getContent());
		outputStream.close();
	}

	@GetMapping("/xemgiaotrinh")
	public String xemGiaoTrinh(@RequestParam("id") Integer id, Model model) {
		LopDTO lopDTO = lopService.getLop(id);
		List<GiaoTrinhDTO> giaoTrinhDTO = giaoTrinhService.getGiaoTrinhFindByLop(lopDTO);
		TaiKhoanDTO taiKhoanDTO = taiKhoanService.getTaiKhoan(SecurityUtils.getPrincipal().getEmail());
		model.addAttribute("role", taiKhoanDTO.getLoai().getLoai_Id());
		model.addAttribute("lop", lopDTO);
		model.addAttribute("lopId", lopDTO.getLop_Id());
		model.addAttribute("listDoc", giaoTrinhDTO);
		return "web/xem-giao-trinh";
	}

	@RequestMapping("/xemthongbao")
	public String xemThongBao() {
		return "web/xem-thong-bao";
	}

	@RequestMapping("/baidangcuatoi")
	public String hienThiBaiDangCaNhan(Model model) {
		model.addAttribute("tkid", SecurityUtils.getPrincipal().getUser_Id());
		return "web/baidangcanhan";
	}

	@RequestMapping("/baikiemtra")
	public String hienThiBaiKiemTran(Model model, @RequestParam("id") Integer id) {
		LopDTO lopDTO = lopService.getLop(id);
		List<BaiKiemTraDTO> baiKiemTraDTO = baiKiemTraService.getBaiKiemTraFindByLop(lopDTO);
		model.addAttribute("lop", lopDTO);
		model.addAttribute("listDoc", baiKiemTraDTO);
		TaiKhoanDTO taiKhoanDTO = taiKhoanService.getTaiKhoan(SecurityUtils.getPrincipal().getEmail());
		model.addAttribute("role", taiKhoanDTO.getLoai().getLoai_Id());
		model.addAttribute("tkid", SecurityUtils.getPrincipal().getUser_Id());
		model.addAttribute("lopId", id);
		return "web/hienthibaikt";
	}

	@RequestMapping("/chitietbaikiemtra")
	public String hienThiBaiKiemChiTiet(Model model, @RequestParam("id") Integer id) {
		BaiKiemTraDTO baiKiemTraDTO = baiKiemTraService.getBaiKiemTra(id);
		List<BaiLamDTO> baiLamDTOs = baiLamService.getBaiLamFindByBaiKiemTra(baiKiemTraDTO);
		model.addAttribute("listLam", baiLamDTOs);
		model.addAttribute("listDoc", baiKiemTraDTO);
		return "web/chitietbaikiemtra";
	}

	@PostMapping("/chitietbaikiemtra")
	public String uploadfileBaiLam(@RequestParam("document") MultipartFile file, @RequestParam("id") Integer id,
			RedirectAttributes ra) throws IOException {
		if(StringUtils.cleanPath(file.getOriginalFilename()).length() ==0)
		{
			ra.addFlashAttribute("message", "Th??m b??i l??m th???t b???i");
			String a = "redirect:/chitietbaikiemtra?id=" + id;
			return a;
		}
		else
		{
			String filename = StringUtils.cleanPath(file.getOriginalFilename());

			BaiLamDTO baiLamDTO = new BaiLamDTO();
			baiLamDTO.setContent(file.getBytes());
			baiLamDTO.setFileName(filename);
			BaiKiemTraDTO baiKiemTraDTO = baiKiemTraService.getBaiKiemTra(id);
			baiLamDTO.setBaiKiemTra(baiKiemTraDTO);
			baiLamDTO.setThoiGian(new Date());
			baiLamService.save(baiLamDTO);
			ra.addFlashAttribute("message", "Th??m b??i l??m th??nh c??ng");
			String a = "redirect:/chitietbaikiemtra?id=" + id;
			return a;
		}

		
	}

	@GetMapping("/downloadbaikiemtra")
	public void downloadFileBaiKiemTra(@Param("id") Integer id, HttpServletResponse response) throws Exception {
		Optional<BaiKiemTra> resul = baiKiemTraRepository.findById(id);
		if (!resul.isPresent()) {
			throw new Exception("Kh??ng t??m th???y ID" + id);
		}
		BaiKiemTra baiKiemTraEntity = resul.get();
		response.setContentType("application/octet-stream");
		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=" + baiKiemTraEntity.getFileName();
		response.setHeader(headerKey, headerValue);
		ServletOutputStream outputStream = response.getOutputStream();
		outputStream.write(baiKiemTraEntity.getContent());
		outputStream.close();
	}

	@RequestMapping("/chitietlophoc")
	public String chiTietLopHoc() {
		return "web/chitietlophoc";
	}
	
	@RequestMapping("/lophoctructuyen")
	public String lopHocOnl(Model model) {
		TaiKhoanDTO taiKhoanDTO = taiKhoanService.getTaiKhoan(SecurityUtils.getPrincipal().getEmail());
		model.addAttribute("role", taiKhoanDTO.getLoai().getLoai_Id());
		return "web/loponline";
	}
	@RequestMapping("/phanhoi")
	public String phanHoi() {
		return "web/phanhoi";
	}
	@RequestMapping("/naptien")
	public String napTien() {
		return "web/naptien";
	}
	@PostMapping("/naptien")
	public String napTienPost(@ModelAttribute("taikhoan") TaiKhoanDTO taiKhoanDTO, Model model) {
		if(taiKhoanDTO.getSoDu()==0 && taiKhoanDTO.getSoDu()==null)
		{
			model.addAttribute("mess", "N???p ti???n th???t b???i!");
			return "web/naptien";
		}
		else
		{
			TaiKhoanDTO _taiKhoanDTO = taiKhoanService.getTaiKhoan(SecurityUtils.getPrincipal().getUser_Id());
			double tien = _taiKhoanDTO.getSoDu() + taiKhoanDTO.getSoDu();
			_taiKhoanDTO.setSoDu(tien);
			taiKhoanService.save(_taiKhoanDTO);
			LichSuGiaoDichDTO lsgd = new LichSuGiaoDichDTO();
			lsgd.setNoiDung("N???p ti???n");
			lsgd.setSoTien(taiKhoanDTO.getSoDu());
			lsgd.setThoiGian(new Date());
			lsgd.setTaiKhoan(_taiKhoanDTO);
			lichSuGiaoDichService.save(lsgd);
			model.addAttribute("mess", "N???p ti???n th??nh c??ng!");
			return "web/naptien";
		}
		
		
	}
	@RequestMapping("/ruttien")
	public String rutTien() {
		return "web/ruttien";
	}
	@PostMapping("/ruttien")
	public String rutTienPost(@ModelAttribute("taikhoan") TaiKhoanDTO taiKhoanDTO, Model model) {
		TaiKhoanDTO _taiKhoanDTO = taiKhoanService.getTaiKhoan(SecurityUtils.getPrincipal().getUser_Id());
		if(taiKhoanDTO.getSoDu() > _taiKhoanDTO.getSoDu())
		{
			model.addAttribute("mess", "S??? ti???n trong t??i kho???n kh??ng ?????!");
			return "web/ruttien";
		}
		else
		{
			if(taiKhoanDTO.getSoDu()==0 && taiKhoanDTO.getSoDu()==null)
			{
				model.addAttribute("mess", "R??t ti???n th???t b???i!");
				return "web/ruttien";
			}
			else
			{
				
				double tien = _taiKhoanDTO.getSoDu() - taiKhoanDTO.getSoDu();
				_taiKhoanDTO.setSoDu(tien);
				taiKhoanService.save(_taiKhoanDTO);
				LichSuGiaoDichDTO lsgd = new LichSuGiaoDichDTO();
				lsgd.setNoiDung("R??t ti???n");
				lsgd.setSoTien(taiKhoanDTO.getSoDu());
				lsgd.setThoiGian(new Date());
				lsgd.setTaiKhoan(_taiKhoanDTO);
				lichSuGiaoDichService.save(lsgd);
				model.addAttribute("mess", "R??t ti???n th??nh c??ng!");
				return "web/ruttien";
			}
		}
		
		
		
	}
	@PostMapping("/phanhoi")
	public String addphanHoi(@ModelAttribute("phanhoi") PhanHoiDTO phanHoiDTO, Model model) {
		if(phanHoiDTO.getEmail().length() != 0 && phanHoiDTO.getNoiDung().length() != 0)
		{
			phanHoiService.save(phanHoiDTO);
			model.addAttribute("mess", "G???i ph???n h???i th??nh c??ng");
			return "web/phanhoi";
		}
		else
		{
			model.addAttribute("mess", "G???i ph???n h???i th???t b???i");
			return "web/phanhoi";
		}
		
	}
	@GetMapping("/downloadbailam")
	public void downloadFileBaiLam(@Param("id") Integer id, HttpServletResponse response) throws Exception {
		Optional<BaiLam> resul = baiLamRepository.findById(id);
		if (!resul.isPresent()) {
			throw new Exception("Kh??ng t??m th???y ID" + id);
		}
		BaiLam baiKiemTraEntity = resul.get();
		response.setContentType("application/octet-stream");
		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=" + baiKiemTraEntity.getFileName();
		response.setHeader(headerKey, headerValue);
		ServletOutputStream outputStream = response.getOutputStream();
		outputStream.write(baiKiemTraEntity.getContent());
		outputStream.close();
	}
	@RequestMapping("/lichsugiaodich")
	public String lichSuGiaoDich(Model model) {
		TaiKhoanDTO taiKhoanDTO = taiKhoanService.getTaiKhoan(SecurityUtils.getPrincipal().getUser_Id());
		List<LichSuGiaoDichDTO> lichSuGiaoDichDTOs = lichSuGiaoDichService.getListLichSuGiaoDichFindByTK(taiKhoanDTO);
		model.addAttribute("lsgd", lichSuGiaoDichDTOs);
		return "web/lichsugiaodich";
	}
	
	
}
