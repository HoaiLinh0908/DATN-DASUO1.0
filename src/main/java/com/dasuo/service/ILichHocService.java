package com.dasuo.service;

import java.util.List;

import com.dasuo.dto.LichHocDTO;

public interface ILichHocService {
	List<LichHocDTO> getListLichHoc();
	LichHocDTO getLichHoc(Integer id);
	void save(LichHocDTO lichHocDTO);
	void delete(Integer id);
 
}
