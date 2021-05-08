package com.dasuo.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.dasuo.dto.BaiDangDTO;

public interface IBaiDangService {
	List<BaiDangDTO> getListBaiDang(Pageable pageable);
	BaiDangDTO getBaiDang(Integer id);
	public void save (BaiDangDTO baiDangDTO);
	public void delete(Integer id);
	public int getTotalPage(int limit);
}
