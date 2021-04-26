package com.dasuo.dto;

import java.util.Date;

public class GiaoTrinhDTO {
private Integer giaoTrinh_Id;
	
	private LopDTO lop;
	
	private String giaoTrinh;
	
	private Date thoiGian;

	public GiaoTrinhDTO() {
		super();
	}
	

	public Date getThoiGian() {
		return thoiGian;
	}


	public void setThoiGian(Date thoiGian) {
		this.thoiGian = thoiGian;
	}


	public Integer getGiaoTrinh_Id() {
		return giaoTrinh_Id;
	}

	public void setGiaoTrinh_Id(Integer giaoTrinh_Id) {
		this.giaoTrinh_Id = giaoTrinh_Id;
	}

	public LopDTO getLop() {
		return lop;
	}

	public void setLop(LopDTO lop) {
		this.lop = lop;
	}

	public String getGiaoTrinh() {
		return giaoTrinh;
	}

	public void setGiaoTrinh(String giaoTrinh) {
		this.giaoTrinh = giaoTrinh;
	}

	
}
