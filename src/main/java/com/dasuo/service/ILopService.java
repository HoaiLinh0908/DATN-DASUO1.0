package com.dasuo.service;

import java.util.List;

import com.dasuo.dto.LopDTO;

public interface ILopService {
	List<LopDTO> getListLop();
	LopDTO getLop(Integer id);
	void save(LopDTO lopDTO);
	void delete(Integer id);
	

}
