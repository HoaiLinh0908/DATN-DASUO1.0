package com.dasuo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "buoi")
public class Buoi {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer buoi_Id;
	@ManyToOne
	@JoinColumn(name = "baiDang_Id")
	private BaiDang baiDang;
	@Column
	private String ngayTrongTuan;
	@Column
	private String buoi;

	public Integer getBuoi_Id() {
		return buoi_Id;
	}

	public void setBuoi_Id(Integer buoi_Id) {
		this.buoi_Id = buoi_Id;
	}

	public BaiDang getBaiDang() {
		return baiDang;
	}

	public void setBaiDang(BaiDang baiDang) {
		this.baiDang = baiDang;
	}

	public String getNgayTrongTuan() {
		return ngayTrongTuan;
	}

	public void setNgayTrongTuan(String ngayTrongTuan) {
		this.ngayTrongTuan = ngayTrongTuan;
	}

	public String getBuoi() {
		return buoi;
	}

	public void setBuoi(String buoi) {
		this.buoi = buoi;
	}

	public Buoi() {
		super();
	}
	
	

}
