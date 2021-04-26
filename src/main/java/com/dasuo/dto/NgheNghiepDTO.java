package com.dasuo.dto;

import java.util.List;

public class NgheNghiepDTO {
	
	private Integer ngheNghiep_Id;
	
	private String tenNgheNghiep;
	
	private List<TaiKhoanDTO> taiKhoan;

	public NgheNghiepDTO() {
		super();
	}

	public Integer getNgheNghiep_Id() {
		return ngheNghiep_Id;
	}

	public void setNgheNghiep_Id(Integer ngheNghiep_Id) {
		this.ngheNghiep_Id = ngheNghiep_Id;
	}

	public String getTenNgheNghiep() {
		return tenNgheNghiep;
	}

	public void setTenNgheNghiep(String tenNgheNghiep) {
		this.tenNgheNghiep = tenNgheNghiep;
	}

	public List<TaiKhoanDTO> getTaiKhoan() {
		return taiKhoan;
	}

	public void setTaiKhoan(List<TaiKhoanDTO> taiKhoan) {
		this.taiKhoan = taiKhoan;
	}
	

	

}
