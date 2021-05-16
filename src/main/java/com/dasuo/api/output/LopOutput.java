package com.dasuo.api.output;

import java.util.ArrayList;
import java.util.List;

import com.dasuo.dto.LopDTO;

public class LopOutput {
	private int page;
	private int totalPage;
	private List<LopDTO> lopDTO = new ArrayList<>();
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
	public List<LopDTO> getLopDTO() {
		return lopDTO;
	}
	public void setLopDTO(List<LopDTO> lopDTO) {
		this.lopDTO = lopDTO;
	}
	

}
