package com.dasuo.service;

import java.util.List;

import com.dasuo.dto.GiaoTrinhDTO;

public interface IGiaoTrinhService {
	List<GiaoTrinhDTO> getListGiaoTrinh();
	GiaoTrinhDTO getGiaoTrinh(Integer id);
	public void save(GiaoTrinhDTO giaoTrinhDTO);
	public void delete(Integer id);

}
