package com.dasuo.api.output;

import java.util.ArrayList;
import java.util.List;

import com.dasuo.dto.BaiDangDTO;

public class BaiDangOutput {
	private int page;
	private int totalItem;
	private List<BaiDangDTO> baiDangDTOs = new ArrayList<>();
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getTotalItem() {
		return totalItem;
	}
	public void setTotalItem(int totalItem) {
		this.totalItem = totalItem;
	}
	public List<BaiDangDTO> getBaiDangDTOs() {
		return baiDangDTOs;
	}
	public void setBaiDangDTOs(List<BaiDangDTO> baiDangDTOs) {
		this.baiDangDTOs = baiDangDTOs;
	}
	
	

}
