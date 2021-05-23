package com.dasuo.dto;

import java.util.Date;

import javax.persistence.Column;

public class GiaoTrinhDTO {
	private Integer Id;
	private Integer giaoTrinh_Id;
	
	private LopDTO lop;
	
	private String giaoTrinh;
	
	private Date thoiGian;
	
	
	private byte[] content;
	
	private String tieuDe;
	
	private String fileName;

	public GiaoTrinhDTO() {
		super();
	}
	

	public Date getThoiGian() {
		return thoiGian;
	}


	public void setThoiGian(Date thoiGian) {
		this.thoiGian = thoiGian;
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

	public String getGiaoTrinh() {
		return giaoTrinh;
	}

	public void setGiaoTrinh(String giaoTrinh) {
		this.giaoTrinh = giaoTrinh;
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


	public Integer getGiaoTrinh_Id() {
		return giaoTrinh_Id;
	}


	public void setGiaoTrinh_Id(Integer giaoTrinh_Id) {
		this.giaoTrinh_Id = giaoTrinh_Id;
	}
	
	
	
}
