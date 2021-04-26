package com.dasuo.dto;

import java.util.List;

public class LoaiDTO {
private Integer loai_Id;
	
	private String tenLoai;
	
	private List<TaiKhoanDTO> taiKhoan;

	public LoaiDTO() {
		super();
	}

	public Integer getLoai_Id() {
		return loai_Id;
	}

	public void setLoai_Id(Integer loai_Id) {
		this.loai_Id = loai_Id;
	}

	public String getTenLoai() {
		return tenLoai;
	}

	public void setTenLoai(String tenLoai) {
		this.tenLoai = tenLoai;
	}

	public List<TaiKhoanDTO> getTaiKhoan() {
		return taiKhoan;
	}

	public void setTaiKhoan(List<TaiKhoanDTO> taiKhoan) {
		this.taiKhoan = taiKhoan;
	}

	

}
