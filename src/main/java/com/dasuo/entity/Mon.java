package com.dasuo.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "mon")
public class Mon {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer mon_Id;
	@Column
	private String tenMon;
	@OneToMany(mappedBy = "mon")
	private List<BaiDang> baiDang;
	@ManyToMany(mappedBy = "mons")
	private Set<TaiKhoan> taiKhoans;
	

	

	public Set<TaiKhoan> getTaiKhoans() {
		return taiKhoans;
	}

	public void setTaiKhoans(Set<TaiKhoan> taiKhoans) {
		this.taiKhoans = taiKhoans;
	}

	public Integer getMon_Id() {
		return mon_Id;
	}

	public void setMon_Id(Integer mon_Id) {
		this.mon_Id = mon_Id;
	}

	public String getTenMon() {
		return tenMon;
	}

	public void setTenMon(String tenMon) {
		this.tenMon = tenMon;
	}

	public List<BaiDang> getBaiDang() {
		return baiDang;
	}

	public void setBaiDang(List<BaiDang> baiDang) {
		this.baiDang = baiDang;
	}

	public Mon() {
		super();
	}
	
	

}
