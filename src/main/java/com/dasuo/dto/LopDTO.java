package com.dasuo.dto;

import java.util.Date;
import java.util.List;

public class LopDTO {

	private Integer lop_Id;
	private String tenLop;
	
	private String ngayNhan;
	
	private TaiKhoanDTO nguoiHoc;
	
	private TaiKhoanDTO nguoiDay;
	
	private double tienHoc;
	
	private Integer gioHoc;
	
	private List<LichHocDTO> lichHoc;
	
	private List<BaiKiemTraDTO> baiKiemTra;
	
	private List<GiaoTrinhDTO> giaoTrinh;
	
	private Integer baiDangId;

	public LopDTO() {
		super();
	}

	public Integer getLop_Id() {
		return lop_Id;
	}

	public void setLop_Id(Integer lop_Id) {
		this.lop_Id = lop_Id;
	}

	public String getNgayNhan() {
		return ngayNhan;
	}

	public void setNgayNhan(String ngayNhan) {
		this.ngayNhan = ngayNhan;
	}

	public TaiKhoanDTO getNguoiHoc() {
		return nguoiHoc;
	}

	public void setNguoiHoc(TaiKhoanDTO nguoiHoc) {
		this.nguoiHoc = nguoiHoc;
	}

	public TaiKhoanDTO getNguoiDay() {
		return nguoiDay;
	}

	public void setNguoiDay(TaiKhoanDTO nguoiDay) {
		this.nguoiDay = nguoiDay;
	}

	public double getTienHoc() {
		return tienHoc;
	}

	public void setTienHoc(double tienHoc) {
		this.tienHoc = tienHoc;
	}

	public Integer getGioHoc() {
		return gioHoc;
	}

	public void setGioHoc(Integer gioHoc) {
		this.gioHoc = gioHoc;
	}

	public List<LichHocDTO> getLichHoc() {
		return lichHoc;
	}

	public void setLichHoc(List<LichHocDTO> lichHoc) {
		this.lichHoc = lichHoc;
	}

	public List<BaiKiemTraDTO> getBaiKiemTra() {
		return baiKiemTra;
	}

	public void setBaiKiemTra(List<BaiKiemTraDTO> baiKiemTra) {
		this.baiKiemTra = baiKiemTra;
	}

	public List<GiaoTrinhDTO> getGiaoTrinh() {
		return giaoTrinh;
	}

	public void setGiaoTrinh(List<GiaoTrinhDTO> giaoTrinh) {
		this.giaoTrinh = giaoTrinh;
	}

	public String getTenLop() {
		return tenLop;
	}

	public void setTenLop(String tenLop) {
		this.tenLop = tenLop;
	}

	public Integer getBaiDangId() {
		return baiDangId;
	}

	public void setBaiDangId(Integer baiDangId) {
		this.baiDangId = baiDangId;
	}
	
	

	
}
