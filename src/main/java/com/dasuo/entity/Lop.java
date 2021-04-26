package com.dasuo.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "lop")
public class Lop {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer lop_Id;
	@Column
	private String tenLop;
	@Column
	private Date ngayNhan;
	@ManyToOne
	@JoinColumn(name = "nguoihoc_id")
	private TaiKhoan nguoiHoc;
	@ManyToOne
	@JoinColumn(name = "nguoiday_id")
	private TaiKhoan nguoiDay;
	@Column
	private double tienHoc;
	@Column
	private Integer gioHoc;
	@OneToMany(mappedBy = "lop")
	private List<LichHoc> lichHoc;
	@OneToMany(mappedBy = "lop")
	private List<BaiKiemTra> baiKiemTra;
	@OneToMany(mappedBy = "lop")
	private List<GiaoTrinh> giaoTrinh;

	public Lop() {
		super();
	}
	

	public Integer getGioHoc() {
		return gioHoc;
	}


	public void setGioHoc(Integer gioHoc) {
		this.gioHoc = gioHoc;
	}


	public Integer getLop_Id() {
		return lop_Id;
	}

	public void setLop_Id(Integer lop_Id) {
		this.lop_Id = lop_Id;
	}

	public Date getNgayNhan() {
		return ngayNhan;
	}

	public void setNgayNhan(Date ngayNhan) {
		this.ngayNhan = ngayNhan;
	}

	public TaiKhoan getNguoiHoc() {
		return nguoiHoc;
	}

	public void setNguoiHoc(TaiKhoan nguoiHoc) {
		this.nguoiHoc = nguoiHoc;
	}

	public TaiKhoan getNguoiDay() {
		return nguoiDay;
	}

	public void setNguoiDay(TaiKhoan nguoiDay) {
		this.nguoiDay = nguoiDay;
	}

	public double getTienHoc() {
		return tienHoc;
	}

	public void setTienHoc(double tienHoc) {
		this.tienHoc = tienHoc;
	}

	public List<LichHoc> getLichHoc() {
		return lichHoc;
	}

	public void setLichHoc(List<LichHoc> lichHoc) {
		this.lichHoc = lichHoc;
	}

	public List<BaiKiemTra> getBaiKiemTra() {
		return baiKiemTra;
	}

	public void setBaiKiemTra(List<BaiKiemTra> baiKiemTra) {
		this.baiKiemTra = baiKiemTra;
	}

	public List<GiaoTrinh> getGiaoTrinh() {
		return giaoTrinh;
	}

	public void setGiaoTrinh(List<GiaoTrinh> giaoTrinh) {
		this.giaoTrinh = giaoTrinh;
	}


	public String getTenLop() {
		return tenLop;
	}


	public void setTenLop(String tenLop) {
		this.tenLop = tenLop;
	}
	
	
	

}
