package com.dasuo.dto;

import java.util.List;
import java.util.Set;

public class MonDTO {
private Integer mon_Id;
	
	private String tenMon;
	
	private List<BaiDangDTO> baiDang;
	
	private Set<TaiKhoanDTO> taiKhoans;

	public MonDTO() {
		super();
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

	public List<BaiDangDTO> getBaiDang() {
		return baiDang;
	}

	public void setBaiDang(List<BaiDangDTO> baiDang) {
		this.baiDang = baiDang;
	}

	public Set<TaiKhoanDTO> getTaiKhoans() {
		return taiKhoans;
	}

	public void setTaiKhoans(Set<TaiKhoanDTO> taiKhoans) {
		this.taiKhoans = taiKhoans;
	}
	
	

}
