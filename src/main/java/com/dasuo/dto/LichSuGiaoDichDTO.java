package com.dasuo.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class LichSuGiaoDichDTO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer lichSuGiaoDich_Id;
	@ManyToOne
	@JoinColumn(name = "taiKhoan_Id")
	private TaiKhoanDTO taiKhoan;
	@Column
	private Date thoiGian;
	@Column
	private String noiDung;
	@Column
	private double soTien;

	public LichSuGiaoDichDTO() {
		super();
	}

	public Integer getLichSuGiaoDich_Id() {
		return lichSuGiaoDich_Id;
	}

	public void setLichSuGiaoDich_Id(Integer lichSuGiaoDich_Id) {
		this.lichSuGiaoDich_Id = lichSuGiaoDich_Id;
	}

	
	public TaiKhoanDTO getTaiKhoan() {
		return taiKhoan;
	}

	public void setTaiKhoan(TaiKhoanDTO taiKhoan) {
		this.taiKhoan = taiKhoan;
	}

	public Date getThoiGian() {
		return thoiGian;
	}

	public void setThoiGian(Date thoiGian) {
		this.thoiGian = thoiGian;
	}

	public String getNoiDung() {
		return noiDung;
	}

	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}

	public double getSoTien() {
		return soTien;
	}

	public void setSoTien(double soTien) {
		this.soTien = soTien;
	}

	
}
