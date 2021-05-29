package com.dasuo.dto;

import java.util.List;
import java.util.Set;

public class TaiKhoanDTO {
	
	private Integer taiKhoan_Id;
	
	private String hoTen;
	
	private String sdt;
	
	private TinhThanhDTO tinhThanh;
	
	private String email;
	
	private String matKhau;
	
	private LoaiDTO loai;
	
	private Boolean gioiTinh;
	
	private String hinhDaiDien;
	
	private String moTa;
	
	private NgheNghiepDTO ngheNghiep;
	
	private Double hocPhi;
	
	private String bangCap;
	
	private String cmnd;
	
	private Double soDu;
	
	private Set<BaiDangDTO> baiDangs;
	
	private List<LichSuGiaoDichDTO> lichSuGiaoDichs;
	
	private List<ChatDTO> nguoiNhans;
	
	private List<ChatDTO> nguoiGuis;
	
	private List<LopDTO> nguoiDays;
	
	private List<LopDTO> nguoiHocs;
	
	private Set<MonDTO> mons;
	
	private Boolean enable;
	
	private String code;
	
	private String matKhauMoi;
	
	private String matKhauCu;
	
	
	
	
	public String getMatKhauMoi() {
		return matKhauMoi;
	}


	public void setMatKhauMoi(String matKhauMoi) {
		this.matKhauMoi = matKhauMoi;
	}


	public String getMatKhauCu() {
		return matKhauCu;
	}


	public void setMatKhauCu(String matKhauCu) {
		this.matKhauCu = matKhauCu;
	}

	private List<BaiDangDTO> baiDang;

	
	public TaiKhoanDTO() {
		super();
	}
	

	public Boolean isEnable() {
		return enable;
	}


	public void setEnable(Boolean enable) {
		this.enable = enable;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public List<BaiDangDTO> getBaiDang() {
		return baiDang;
	}


	public void setBaiDang(List<BaiDangDTO> baiDang) {
		this.baiDang = baiDang;
	}


	public Integer getTaiKhoan_Id() {
		return taiKhoan_Id;
	}

	public void setTaiKhoan_Id(Integer taiKhoan_Id) {
		this.taiKhoan_Id = taiKhoan_Id;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public TinhThanhDTO getTinhThanh() {
		return tinhThanh;
	}

	public void setTinhThanh(TinhThanhDTO tinhThanh) {
		this.tinhThanh = tinhThanh;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public LoaiDTO getLoai() {
		return loai;
	}

	public void setLoai(LoaiDTO loai) {
		this.loai = loai;
	}

	public Boolean isGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(Boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getHinhDaiDien() {
		return hinhDaiDien;
	}

	public void setHinhDaiDien(String hinhDaiDien) {
		this.hinhDaiDien = hinhDaiDien;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public NgheNghiepDTO getNgheNghiep() {
		return ngheNghiep;
	}

	public void setNgheNghiep(NgheNghiepDTO ngheNghiep) {
		this.ngheNghiep = ngheNghiep;
	}

	public Double getHocPhi() {
		return hocPhi;
	}

	public void setHocPhi(Double hocPhi) {
		this.hocPhi = hocPhi;
	}

	public String getBangCap() {
		return bangCap;
	}

	public void setBangCap(String bangCap) {
		this.bangCap = bangCap;
	}

	public String getCmnd() {
		return cmnd;
	}

	public void setCmnd(String cmnd) {
		this.cmnd = cmnd;
	}

	public Double getSoDu() {
		return soDu;
	}

	public void setSoDu(Double soDu) {
		this.soDu = soDu;
	}

	public List<LichSuGiaoDichDTO> getLichSuGiaoDichs() {
		return lichSuGiaoDichs;
	}

	public void setLichSuGiaoDichs(List<LichSuGiaoDichDTO> lichSuGiaoDichs) {
		this.lichSuGiaoDichs = lichSuGiaoDichs;
	}

	public List<ChatDTO> getNguoiNhans() {
		return nguoiNhans;
	}

	public void setNguoiNhans(List<ChatDTO> nguoiNhans) {
		this.nguoiNhans = nguoiNhans;
	}

	public List<ChatDTO> getNguoiGuis() {
		return nguoiGuis;
	}

	public void setNguoiGuis(List<ChatDTO> nguoiGuis) {
		this.nguoiGuis = nguoiGuis;
	}

	public List<LopDTO> getNguoiDays() {
		return nguoiDays;
	}

	public void setNguoiDays(List<LopDTO> nguoiDays) {
		this.nguoiDays = nguoiDays;
	}

	public List<LopDTO> getNguoiHocs() {
		return nguoiHocs;
	}

	public void setNguoiHocs(List<LopDTO> nguoiHocs) {
		this.nguoiHocs = nguoiHocs;
	}

	public Set<BaiDangDTO> getBaiDangs() {
		return baiDangs;
	}

	public void setBaiDangs(Set<BaiDangDTO> baiDangs) {
		this.baiDangs = baiDangs;
	}

	public Set<MonDTO> getMons() {
		return mons;
	}

	public void setMons(Set<MonDTO> mons) {
		this.mons = mons;
	}
	
	
}
