package com.dasuo.dto;

import java.util.Date;
import java.util.List;
import java.util.Set;

public class BaiDangDTO {
	private Integer baiDang_Id;
	
	private String tomTatYeuCau;
	
	private MonDTO mon;
	
	private double hocPhi;
	
	private String sdt;
	
	private String moTa;
	
	private boolean gioiTinh;
	
	private Integer soBuoi;
	
	private Date ngayBatDau;
	
	private Integer thoiGianDayTheoThang;
	
	private ChuDeDTO chuDe;
	
	private Set<TaiKhoanDTO> taiKhoans;
	
	private List<BuoiDTO> buois ;
	private TaiKhoanDTO taiKhoan;
	
	public BaiDangDTO() {
		super();
	}
	


	public TaiKhoanDTO getTaiKhoan() {
		return taiKhoan;
	}



	public void setTaiKhoan(TaiKhoanDTO taiKhoan) {
		this.taiKhoan = taiKhoan;
	}



	public Integer getBaiDang_Id() {
		return baiDang_Id;
	}

	public void setBaiDang_Id(Integer baiDang_Id) {
		this.baiDang_Id = baiDang_Id;
	}

	public String getTomTatYeuCau() {
		return tomTatYeuCau;
	}

	public void setTomTatYeuCau(String tomTatYeuCau) {
		this.tomTatYeuCau = tomTatYeuCau;
	}

	public MonDTO getMon() {
		return mon;
	}

	public void setMon(MonDTO mon) {
		this.mon = mon;
	}

	public double getHocPhi() {
		return hocPhi;
	}

	public void setHocPhi(double hocPhi) {
		this.hocPhi = hocPhi;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public boolean isGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public Integer getSoBuoi() {
		return soBuoi;
	}

	public void setSoBuoi(Integer soBuoi) {
		this.soBuoi = soBuoi;
	}

	public Date getNgayBatDau() {
		return ngayBatDau;
	}

	public void setNgayBatDau(Date ngayBatDau) {
		this.ngayBatDau = ngayBatDau;
	}

	public Integer getThoiGianDayTheoThang() {
		return thoiGianDayTheoThang;
	}

	public void setThoiGianDayTheoThang(Integer thoiGianDayTheoThang) {
		this.thoiGianDayTheoThang = thoiGianDayTheoThang;
	}

	public ChuDeDTO getChuDe() {
		return chuDe;
	}

	public void setChuDe(ChuDeDTO chuDe) {
		this.chuDe = chuDe;
	}

	public Set<TaiKhoanDTO> getTaiKhoans() {
		return taiKhoans;
	}

	public void setTaiKhoans(Set<TaiKhoanDTO> taiKhoans) {
		this.taiKhoans = taiKhoans;
	}

	public List<BuoiDTO> getBuois() {
		return buois;
	}

	public void setBuois(List<BuoiDTO> buois) {
		this.buois = buois;
	}
	
}
