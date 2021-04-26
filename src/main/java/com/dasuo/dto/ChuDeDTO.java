package com.dasuo.dto;

import java.util.List;

public class ChuDeDTO {
private Integer chuDe_Id;
	
	private String tenChuDe;
	
	private List<BaiDangDTO> baiDang;

	public ChuDeDTO() {
		super();
	}

	public Integer getChuDe_Id() {
		return chuDe_Id;
	}

	public void setChuDe_Id(Integer chuDe_Id) {
		this.chuDe_Id = chuDe_Id;
	}

	public String getTenChuDe() {
		return tenChuDe;
	}

	public void setTenChuDe(String tenChuDe) {
		this.tenChuDe = tenChuDe;
	}

	public List<BaiDangDTO> getBaiDang() {
		return baiDang;
	}

	public void setBaiDang(List<BaiDangDTO> baiDang) {
		this.baiDang = baiDang;
	}

	
	

}
