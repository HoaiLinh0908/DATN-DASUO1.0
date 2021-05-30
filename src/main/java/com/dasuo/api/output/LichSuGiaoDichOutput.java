package com.dasuo.api.output;

import java.util.ArrayList;
import java.util.List;

import com.dasuo.dto.LichSuGiaoDichDTO;

public class LichSuGiaoDichOutput {
	private int page;
	private int totalPage;
	private List<LichSuGiaoDichDTO> lichSuGiaoDichs = new ArrayList<>();
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
	public List<LichSuGiaoDichDTO> getLichSuGiaoDichs() {
		return lichSuGiaoDichs;
	}
	public void setLichSuGiaoDichs(List<LichSuGiaoDichDTO> lichSuGiaoDichs) {
		this.lichSuGiaoDichs = lichSuGiaoDichs;
	}
	

}
