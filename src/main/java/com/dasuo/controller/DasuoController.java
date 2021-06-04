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
import javax.websocket.server.PathParam;

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

	@RequestMapping("/index")
	public String demo() {
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
				model.addAttribute("message", "Đăng ký tài khoản thành công!");
				model.addAttribute("alert", "success");
			} else {
				model.addAttribute("message", "Đăng ký tài khoản thất bại");
				model.addAttribute("alert", "error");
			}
		} else {
			model.addAttribute("message", "Email đã tồn tại!");
			model.addAttribute("alert", "error");
		}
		return "web/register";
	}

	@RequestMapping("/taikhoan/trangcanhan")
	public String viewProfile(Model model) {
		TaiKhoanDTO taiKhoanDTO = taiKhoanService.getTaiKhoan(SecurityUtils.getPrincipal().getEmail());
		if (taiKhoanDTO.getTinhThanh() == null) {
			taiKhoanDTO.setTinhThanh(new TinhThanhDTO());
			taiKhoanDTO.getTinhThanh().setTenTinh("Chưa cập nhật");
		}
		model.addAttribute("taiKhoan", taiKhoanDTO);
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
			@RequestParam("tinhThanhid") Integer id, RedirectAttributes ra) {
		TaiKhoanDTO _taiKhoanDTO = taiKhoanService.getTaiKhoan(SecurityUtils.getPrincipal().getUser_Id());
		if (_taiKhoanDTO != null) {
			_taiKhoanDTO.setHoTen(taiKhoanDTO.getHoTen());
			_taiKhoanDTO.setMoTa(taiKhoanDTO.getMoTa());
			_taiKhoanDTO.setGioiTinh(taiKhoanDTO.isGioiTinh());
			TinhThanhDTO tinhThanh = tinhThanhService.getTinhThanh(id);
			if (tinhThanh != null) {
				_taiKhoanDTO.setTinhThanh(tinhThanh);
			}
			taiKhoanService.save(_taiKhoanDTO);
			ra.addFlashAttribute("message", "Cập nhật thành công thông tin tài khoản");

			return "redirect:/suathongtin";
		} else {
			ra.addFlashAttribute("message", "Cập nhật thất bại thông tin tài khoản");

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
		return "web/timkiem";
	}

	@RequestMapping("/trang-chu")
	public String viewTrangChu(Principal principal, Model model) {
		model.addAttribute("ten", principal.getName());
		return "web/trangchu";
	}

	@RequestMapping("/upbaikt")
	public String viewUpBaiKT() {
		return "web/upbaikt";
	}

	// xử lý upload file bài kiểm tra
	@PostMapping("/upbaikt")
	public String uploadfileBaiKiemTra(@RequestParam("document") MultipartFile file, RedirectAttributes ra,
			@ModelAttribute("baikiemtra") BaiKiemTraDTO baiKiemTraDTO, @RequestParam("id") Integer id,
			@RequestParam("date") String date) throws IOException, java.text.ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateInString = date.substring(0, 10);
		System.out.println(dateInString);

		Date datekiemtra = formatter.parse(dateInString);
		System.out.println(datekiemtra);
		if (!datekiemtra.after(new Date())) {
			ra.addFlashAttribute("message", "Ngày nộp bài kiểm tra phải lớn hơn hôm nay");
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
			ra.addFlashAttribute("message", "Thêm bài kiểm tra thành công");
			String b = "redirect:/upbaikt?id=" + id;
			return b;
		}
		// System.out.println(formatter.format(date));

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
				ra.addFlashAttribute("message", "Bạn đã đổi mật khẩu thành công");
			} else {
				ra.addFlashAttribute("message", "Bạn đã đổi mật khẩu thất bại");
				ra.addFlashAttribute("alert", "error");
			}
		} else {
			ra.addFlashAttribute("message", "Bạn đã đổi mật khẩu thất bại");
			ra.addFlashAttribute("alert", "error");
		}
		return "redirect:/doimatkhau";
	}

	@RequestMapping("/quenmatkhau")
	public String viewQuenMatKhau() {
		return "forgot_password_form";
	}

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

	// xử lý upload file giao trình
	@PostMapping("/danggiaotrinh")
	public String uploadfileGiaoTrinh(@RequestParam("document") MultipartFile file, RedirectAttributes ra,
			@ModelAttribute("giaotrinh") GiaoTrinhDTO giaoTrinhDTO, @RequestParam("idlop") Integer idlop)
			throws IOException {
		// lấy ra tên file
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
		ra.addFlashAttribute("message", "Thêm giáo trình thành công");
		return "redirect:/danggiaotrinh?id=" + idlop;
	}

	@GetMapping("/download")
	public void downloadFile(@Param("id") Integer id, HttpServletResponse response) throws Exception {
		Optional<GiaoTrinh> resul = giaoTrinhRepository.findById(id);
		if (!resul.isPresent()) {
			throw new Exception("Không tìm thấy ID" + id);
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

		model.addAttribute("lop", lopDTO);
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

		String filename = StringUtils.cleanPath(file.getOriginalFilename());

		BaiLamDTO baiLamDTO = new BaiLamDTO();
		baiLamDTO.setContent(file.getBytes());
		baiLamDTO.setFileName(filename);
		BaiKiemTraDTO baiKiemTraDTO = baiKiemTraService.getBaiKiemTra(id);
		baiLamDTO.setBaiKiemTra(baiKiemTraDTO);
		baiLamDTO.setThoiGian(new Date());
		baiLamService.save(baiLamDTO);
		ra.addFlashAttribute("message", "Thêm bài làm thành công");
		String a = "redirect:/chitietbaikiemtra?id=" + id;
		return a;
	}

	@GetMapping("/downloadbaikiemtra")
	public void downloadFileBaiKiemTra(@Param("id") Integer id, HttpServletResponse response) throws Exception {
		Optional<BaiKiemTra> resul = baiKiemTraRepository.findById(id);
		if (!resul.isPresent()) {
			throw new Exception("Không tìm thấy ID" + id);
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
}
