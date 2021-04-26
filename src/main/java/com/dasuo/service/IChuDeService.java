package com.dasuo.service;

import java.util.List;

import com.dasuo.dto.ChuDeDTO;

public interface IChuDeService {
	List<ChuDeDTO> getListChuDe();
	ChuDeDTO getChuDe(Integer id);
	void save (ChuDeDTO chuDeDTO);
	void delete(Integer id);
	

}
