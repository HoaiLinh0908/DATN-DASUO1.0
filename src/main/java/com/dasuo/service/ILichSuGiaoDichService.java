package com.dasuo.service;

import java.util.List;

import com.dasuo.dto.LichSuGiaoDichDTO;

public interface ILichSuGiaoDichService {
	List<LichSuGiaoDichDTO> getListLichSuGiaoDich();
	LichSuGiaoDichDTO getLichSuGiaoDich(Integer id);
	void save (LichSuGiaoDichDTO lichSuGiaoDichDTO);
	void delete (Integer id);

}
