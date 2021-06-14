package com.dasuo.service;

import java.util.List;

import com.dasuo.dto.PhanHoiDTO;

public interface IPhanHoiService {
	List<PhanHoiDTO> getAllPhanHoi();
	PhanHoiDTO getPhanHoi(Integer id);
	void save(PhanHoiDTO phanHoiDTO);
	void delete(Integer id);

}
