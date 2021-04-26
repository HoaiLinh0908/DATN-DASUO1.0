package com.dasuo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "lichhoc")
public class LichHoc {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer lichHoc_Id;
	@Column
	private Date thoiGianBatDau;
	@Column
	private Date thoiGianKetThuc;
	@ManyToOne
	@JoinColumn(name = "lop_id")
	private Lop lop;

	public LichHoc() {
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

	public Lop getLop() {
		return lop;
	}

	public void setLop(Lop lop) {
		this.lop = lop;
	}
	
	

}
