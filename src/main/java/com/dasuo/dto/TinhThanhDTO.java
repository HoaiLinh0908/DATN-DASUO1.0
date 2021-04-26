package com.dasuo.dto;

import java.util.List;

public class TinhThanhDTO {
private Integer tinh_Id;
	
	private String tenTinh;
	
	private List<TaiKhoanDTO> taikhoan;

	public TinhThanhDTO() {
		super();
	}

	public Integer getTinh_Id() {
		return tinh_Id;
	}

	public void setTinh_Id(Integer tinh_Id) {
		this.tinh_Id = tinh_Id;
	}

	public String getTenTinh() {
		return tenTinh;
	}

	public void setTenTinh(String tenTinh) {
		this.tenTinh = tenTinh;
	}

	public List<TaiKhoanDTO> getTaikhoan() {
		return taikhoan;
	}

	public void setTaikhoan(List<TaiKhoanDTO> taikhoan) {
		this.taikhoan = taikhoan;
	}
	
	

}
