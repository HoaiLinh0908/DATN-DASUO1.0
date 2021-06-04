package com.dasuo.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.dasuo.dto.LopDTO;

public interface ILopService {
	List<LopDTO> getListLop(Pageable pageable);
	LopDTO getLop(Integer id);
	void save(LopDTO lopDTO);
	void delete(Integer id);
	public int getTotalPage(int limit);
	public List<LopDTO> getLopByNguoiHoc(Integer nguoiHocId, Pageable pageable);
	public int countByNguoiHoc(Integer id, int limit);
	public List<LopDTO> getLopByNguoiDay(Integer nguoiDayId, Pageable pageable);
	public int countByNguoiDay(Integer id, int limit);
}
