package com.dasuo.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "chude")
public class ChuDe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer chuDe_Id;
	@Column
	private String tenChuDe;
	@OneToMany(mappedBy = "chuDe")
	private List<BaiDang> baiDangs;

	public ChuDe() {
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

	public List<BaiDang> getBaiDangs() {
		return baiDangs;
	}

	public void setBaiDangs(List<BaiDang> baiDangs) {
		this.baiDangs = baiDangs;
	}

	
	

}
