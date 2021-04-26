package com.dasuo.dto;

import java.util.Date;

public class BaiLamDTO {
private Integer baiLam_Id;
	
	private String noiDung;
	
	private Date thoiGian;
	
	private BaiKiemTraDTO baiKiemTra;

	public BaiLamDTO() {
		super();
	}

	public Integer getBaiLam_Id() {
		return baiLam_Id;
	}

	public void setBaiLam_Id(Integer baiLam_Id) {
		this.baiLam_Id = baiLam_Id;
	}

	public String getNoiDung() {
		return noiDung;
	}

	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}

	public Date getThoiGian() {
		return thoiGian;
	}

	public void setThoiGian(Date thoiGian) {
		this.thoiGian = thoiGian;
	}

	public BaiKiemTraDTO getBaiKiemTra() {
		return baiKiemTra;
	}

	public void setBaiKiemTra(BaiKiemTraDTO baiKiemTra) {
		this.baiKiemTra = baiKiemTra;
	}
	

	

}
