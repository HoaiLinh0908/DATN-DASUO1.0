package com.dasuo.service;

import java.util.List;

import com.dasuo.dto.NgheNghiepDTO;

public interface INgheNghiepService {
	List<NgheNghiepDTO> getListNgheNghieps();
	NgheNghiepDTO getNgheNghiep(int id);
	void save (NgheNghiepDTO ngheNghiepDTO);
	void delete(int id);
	

}
