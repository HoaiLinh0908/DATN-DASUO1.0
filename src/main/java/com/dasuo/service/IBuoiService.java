package com.dasuo.service;

import java.util.List;

import com.dasuo.dto.BaiDangDTO;
import com.dasuo.dto.BuoiDTO;

public interface IBuoiService {
	List<BuoiDTO> getListBuoi();
	BuoiDTO getBuoi(Integer id);
	public void save (BuoiDTO buoiDTO);
	public void delete(Integer id);

}
