package com.dasuo.dto;

public class BuoiDTO {
private Integer buoi_Id;
	
	private BaiDangDTO baiDang;
	
	private String ngayTrongTuan;
	
	private String buoi;

	
	public BuoiDTO() {
		super();
	}


	public Integer getBuoi_Id() {
		return buoi_Id;
	}


	public void setBuoi_Id(Integer buoi_Id) {
		this.buoi_Id = buoi_Id;
	}


	public BaiDangDTO getBaiDang() {
		return baiDang;
	}


	public void setBaiDang(BaiDangDTO baiDang) {
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
	

}
