package com.dasuo.dto;

import java.util.Date;

public class BaiLamDTO {
	private Integer Id;
	private Integer baiLam_Id;
	
	private String noiDung;
	
	private Date thoiGian;
	
	private BaiKiemTraDTO baiKiemTra;
	
	private byte[] content;
	
	private String tieuDe;
	
	private String fileName;

	public BaiLamDTO() {
		super();
	}

	

	public String getNoiDung() {
		return noiDung;
	}

	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}

	public Integer getId() {
		return Id;
	}



	public void setId(Integer id) {
		Id = id;
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



	public Integer getBaiLam_Id() {
		return baiLam_Id;
	}



	public void setBaiLam_Id(Integer baiLam_Id) {
		this.baiLam_Id = baiLam_Id;
	}
	
	
	

}
