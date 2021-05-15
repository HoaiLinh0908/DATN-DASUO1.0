package com.dasuo.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.swing.text.StyledEditorKit.BoldAction;

@Entity
@Table(name = "taikhoan")
public class TaiKhoan {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer taiKhoan_Id;
	@Column
	private String hoTen;
	@Column
	private String sdt;
	@ManyToOne
	@JoinColumn(name = "tinhThanh_id")
	private TinhThanh tinhThanh;
	@Column
	private String email;
	@Column
	private String matKhau;
	@ManyToOne
	@JoinColumn(name = "loai_id")
	private Loai loai;
	@Column
	private Boolean gioiTinh;
	@Column
	private String hinhDaiDien;
	@Column
	private String moTa;
	@ManyToOne
	@JoinColumn(name = "ngheNghiep_Id")
	private NgheNghiep ngheNghiep;
	@Column
	private double hocPhi;
	@Column
	private String bangCap;
	@Column
	private String cmnd;
	@Column
	private double soDu;
	@ManyToMany()
	@JoinTable(
			name="taikhoan_baidang"
			, joinColumns={
				@JoinColumn(name="TaiKhoan_Id", referencedColumnName="taiKhoan_Id")
				}
			, inverseJoinColumns={
				@JoinColumn(name="BaiDang_Id", referencedColumnName="baidang_Id")})
	private Set<BaiDang> baiDangs;
	@OneToMany(mappedBy = "taiKhoan")
	private List<LichSuGiaoDich> lichSuGiaoDichs;
	@OneToMany(mappedBy = "nguoiNhan")
	private List<Chat> nguoiNhans;
	@OneToMany(mappedBy = "nguoiGui")
	private List<Chat> nguoiGuis;
	@OneToMany(mappedBy = "nguoiHoc")
	private List<Lop> nguoiDays;
	@OneToMany(mappedBy = "nguoiDay")
	private List<Lop> nguoiHocs;
	@ManyToMany()
	@JoinTable(
			name="taikhoan_mon"
			, joinColumns={
				@JoinColumn(name="TaiKhoan_Id", referencedColumnName="taiKhoan_Id")
				}
			, inverseJoinColumns={
				@JoinColumn(name="Mon_Id", referencedColumnName="mon_Id")})
	private Set<Mon> mons;
	@Column
	private boolean enable;
	@Column
	private String code;
	
	@OneToMany(mappedBy = "taiKhoan")
	private List<BaiDang> baiDang;

	public TaiKhoan() {
		super();
	}
	

	public TaiKhoan(Integer id) {
		this.taiKhoan_Id = id;
	}
	public boolean isEnable() {
		return enable;
	}



	public void setEnable(boolean enable) {
		this.enable = enable;
	}



	public String getCode() {
		return code;
	}



	public void setCode(String code) {
		this.code = code;
	}



	public List<BaiDang> getBaiDang() {
		return baiDang;
	}



	public void setBaiDang(List<BaiDang> baiDang) {
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


	public TinhThanh getTinhThanh() {
		return tinhThanh;
	}


	public void setTinhThanh(TinhThanh tinhThanh) {
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


	public Loai getLoai() {
		return loai;
	}


	public void setLoai(Loai loai) {
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


	public NgheNghiep getNgheNghiep() {
		return ngheNghiep;
	}


	public void setNgheNghiep(NgheNghiep ngheNghiep) {
		this.ngheNghiep = ngheNghiep;
	}


	public double getHocPhi() {
		return hocPhi;
	}


	public void setHocPhi(double hocPhi) {
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


	public double getSoDu() {
		return soDu;
	}


	public void setSoDu(double soDu) {
		this.soDu = soDu;
	}

	public List<LichSuGiaoDich> getLichSuGiaoDichs() {
		return lichSuGiaoDichs;
	}


	public void setLichSuGiaoDichs(List<LichSuGiaoDich> lichSuGiaoDichs) {
		this.lichSuGiaoDichs = lichSuGiaoDichs;
	}


	public List<Chat> getNguoiNhans() {
		return nguoiNhans;
	}


	public void setNguoiNhans(List<Chat> nguoiNhans) {
		this.nguoiNhans = nguoiNhans;
	}


	public List<Chat> getNguoiGuis() {
		return nguoiGuis;
	}


	public void setNguoiGuis(List<Chat> nguoiGuis) {
		this.nguoiGuis = nguoiGuis;
	}


	public List<Lop> getNguoiDays() {
		return nguoiDays;
	}


	public void setNguoiDays(List<Lop> nguoiDays) {
		this.nguoiDays = nguoiDays;
	}


	public List<Lop> getNguoiHocs() {
		return nguoiHocs;
	}


	public void setNguoiHocs(List<Lop> nguoiHocs) {
		this.nguoiHocs = nguoiHocs;
	}


	public Set<BaiDang> getBaiDangs() {
		return baiDangs;
	}


	public void setBaiDangs(Set<BaiDang> baiDangs) {
		this.baiDangs = baiDangs;
	}


	public Set<Mon> getMons() {
		return mons;
	}


	public void setMons(Set<Mon> mons) {
		this.mons = mons;
	}


	
	
}
