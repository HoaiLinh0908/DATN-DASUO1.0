package com.dasuo.service;

import java.util.List;

import com.dasuo.dto.GiaoTrinhDTO;
import com.dasuo.dto.LopDTO;
import com.dasuo.entity.Lop;

public interface IGiaoTrinhService {
	List<GiaoTrinhDTO> getListGiaoTrinh();
	GiaoTrinhDTO getGiaoTrinh(Integer id);
	public void save(GiaoTrinhDTO giaoTrinhDTO);
	public void delete(Integer id);
	List<GiaoTrinhDTO> getGiaoTrinhFindByLop(LopDTO lopDTO);

}
