package com.dasuo.dto;

import javax.persistence.Column;

public class PhanHoiDTO {
	private Integer phanHoi_Id;
	
	private String email;
	
	private String noiDung;

	public PhanHoiDTO() {
		super();
	}

	public Integer getPhanHoi_Id() {
		return phanHoi_Id;
	}

	public void setPhanHoi_Id(Integer phanHoi_Id) {
		this.phanHoi_Id = phanHoi_Id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNoiDung() {
		return noiDung;
	}

	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}
	
	

}
