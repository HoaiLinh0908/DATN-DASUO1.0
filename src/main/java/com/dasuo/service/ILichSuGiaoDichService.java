package com.dasuo.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.dasuo.dto.LichSuGiaoDichDTO;

public interface ILichSuGiaoDichService {
	List<LichSuGiaoDichDTO> getListLichSuGiaoDich(Pageable pageable);
	LichSuGiaoDichDTO getLichSuGiaoDich(Integer id);
	void save (LichSuGiaoDichDTO lichSuGiaoDichDTO);
	void delete (Integer id);
	public int getTotalPage(int limit);

}
