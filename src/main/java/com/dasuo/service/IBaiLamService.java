package com.dasuo.service;

import java.util.List;

import com.dasuo.dto.BaiKiemTraDTO;
import com.dasuo.dto.BaiLamDTO;
import com.dasuo.dto.LopDTO;

public interface IBaiLamService {
	List<BaiLamDTO> getListBaiLam();
	BaiLamDTO getBaiLam(Integer id);
	public void save(BaiLamDTO baiLamDTO);
	public void delete(Integer id);
	List<BaiLamDTO> getBaiLamFindByBaiKiemTra(BaiKiemTraDTO baiKiemTraDTO);

}
