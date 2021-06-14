package com.dasuo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "phanhoi")
public class PhanHoi {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer phanHoi_Id;
	@Column
	private String email;
	@Column
	private String noiDung;
	public PhanHoi() {
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
