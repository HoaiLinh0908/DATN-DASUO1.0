package com.dasuo.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;

public class BaiKiemTraDTO {
	private Integer baiKiemTra_id;

	private Integer Id;
	
	private LopDTO lop;
	
	private String noiDung;
	
	private Date thoiGianBatDau;
	
	private Date thoiGianNop;
	
	private List<BaiLamDTO> baiLam;
	private String fileName;

	private byte[] content;
	private String tieuDe;

	public BaiKiemTraDTO() {
		super();
	}

	

	

	public Integer getBaiKiemTra_id() {
		return baiKiemTra_id;
	}





	public void setBaiKiemTra_id(Integer baiKiemTra_id) {
		this.baiKiemTra_id = baiKiemTra_id;
	}





	public Integer getId() {
		return Id;
	}





	public void setId(Integer id) {
		Id = id;
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

	public byte[] getContent() {
		return content;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}

	public String getTieuDe() {
		return tieuDe;
	}

	public void setTieuDe(String tieuDe) {
		this.tieuDe = tieuDe;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	
	

}
