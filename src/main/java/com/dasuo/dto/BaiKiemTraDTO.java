package com.dasuo.dto;

import java.util.Date;
import java.util.List;

public class BaiKiemTraDTO {

	private Integer baiKiemTra_Id;
	
	private LopDTO lop;
	
	private String noiDung;
	
	private Date thoiGianBatDau;
	
	private Date thoiGianNop;
	
	private List<BaiLamDTO> baiLam;

	public BaiKiemTraDTO() {
		super();
	}

	public Integer getBaiKiemTra_Id() {
		return baiKiemTra_Id;
	}

	public void setBaiKiemTra_Id(Integer baiKiemTra_Id) {
		this.baiKiemTra_Id = baiKiemTra_Id;
	}

	

	public LopDTO getLop() {
		return lop;
	}

	public void setLop(LopDTO lop) {
		this.lop = lop;
	}

	public String getNoiDung() {
		return noiDung;
	}

	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}

	public Date getThoiGianBatDau() {
		return thoiGianBatDau;
	}

	public void setThoiGianBatDau(Date thoiGianBatDau) {
		this.thoiGianBatDau = thoiGianBatDau;
	}

	public Date getThoiGianNop() {
		return thoiGianNop;
	}

	public void setThoiGianNop(Date thoiGianNop) {
		this.thoiGianNop = thoiGianNop;
	}

	public List<BaiLamDTO> getBaiLam() {
		return baiLam;
	}

	public void setBaiLam(List<BaiLamDTO> baiLam) {
		this.baiLam = baiLam;
	}
	
	
	

}
