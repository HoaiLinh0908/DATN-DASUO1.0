package com.dasuo.api.output;

import java.util.ArrayList;
import java.util.List;

import com.dasuo.dto.BaiDangDTO;
import com.dasuo.dto.TaiKhoanDTO;

public class TaiKhoanOutput {
	private int page;
	private int totalPage;
	private List<TaiKhoanDTO> taiKhoanDTO = new ArrayList<>();
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public List<TaiKhoanDTO> getTaiKhoanDTO() {
		return taiKhoanDTO;
	}
	public void setTaiKhoanDTO(List<TaiKhoanDTO> taiKhoanDTO) {
		this.taiKhoanDTO = taiKhoanDTO;
	}
	
	

}
