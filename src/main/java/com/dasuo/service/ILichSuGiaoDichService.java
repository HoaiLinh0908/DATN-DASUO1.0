package com.dasuo.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.dasuo.dto.LichSuGiaoDichDTO;
import com.dasuo.dto.TaiKhoanDTO;
import com.dasuo.entity.TaiKhoan;

public interface ILichSuGiaoDichService {
	List<LichSuGiaoDichDTO> getListLichSuGiaoDich(Pageable pageable);
	List<LichSuGiaoDichDTO> getListLichSuGiaoDichFindByTK(TaiKhoanDTO taiKhoan);
	LichSuGiaoDichDTO getLichSuGiaoDich(Integer id);
	void save (LichSuGiaoDichDTO lichSuGiaoDichDTO);
	void delete (Integer id);
	public int getTotalPage(int limit);
	public int getTotalPageCountByTK(int limit, int id);

}
