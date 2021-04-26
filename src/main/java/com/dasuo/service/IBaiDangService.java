package com.dasuo.service;

import java.util.List;

import com.dasuo.dto.BaiDangDTO;

public interface IBaiDangService {
	List<BaiDangDTO> getListBaiDang();
	BaiDangDTO getBaiDang(Integer id);
	public void save (BaiDangDTO baiDangDTO);
	public void delete(Integer id);

}
