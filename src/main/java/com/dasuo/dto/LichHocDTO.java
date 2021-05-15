package com.dasuo.dto;

import java.util.Date;

import javax.persistence.Column;

public class LichHocDTO {
	private Integer lichHoc_Id;

	
	private Date thoiGianBatDau;
	private Date thoiGianKetThuc;
	private Integer  idZoom;
	private Integer  matKhauZoom;
	private String linkZoom;
	private LopDTO lop;
	

	public LichHocDTO() {
		super();
	}

	public Integer getLichHoc_Id() {
		return lichHoc_Id;
	}

	public void setLichHoc_Id(Integer lichHoc_Id) {
		this.lichHoc_Id = lichHoc_Id;
	}

	public Date getThoiGianBatDau() {
		return thoiGianBatDau;
	}

	public void setThoiGianBatDau(Date thoiGianBatDau) {
		this.thoiGianBatDau = thoiGianBatDau;
	}

	public Date getThoiGianKetThuc() {
		return thoiGianKetThuc;
	}

	public void setThoiGianKetThuc(Date thoiGianKetThuc) {
		this.thoiGianKetThuc = thoiGianKetThuc;
	}

	public LopDTO getLop() {
		return lop;
	}

	public void setLop(LopDTO lop) {
		this.lop = lop;
	}

	public Integer getIdZoom() {
		return idZoom;
	}

	public void setIdZoom(Integer idZoom) {
		this.idZoom = idZoom;
	}

	public Integer getMatKhauZoom() {
		return matKhauZoom;
	}

	public void setMatKhauZoom(Integer matKhauZoom) {
		this.matKhauZoom = matKhauZoom;
	}

	public String getLinkZoom() {
		return linkZoom;
	}

	public void setLinkZoom(String linkZoom) {
		this.linkZoom = linkZoom;
	}
	

	

}
