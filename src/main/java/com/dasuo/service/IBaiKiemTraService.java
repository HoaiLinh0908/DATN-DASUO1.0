package com.dasuo.service;

import java.util.List;

import com.dasuo.dto.BaiKiemTraDTO;
import com.dasuo.dto.GiaoTrinhDTO;
import com.dasuo.dto.LopDTO;

public interface IBaiKiemTraService {
	List<BaiKiemTraDTO> getListBaiKiemTra();
	BaiKiemTraDTO getBaiKiemTra(Integer id);
	public void save(BaiKiemTraDTO baiKiemTraDTO);
	public void delete(Integer id);
	List<BaiKiemTraDTO> getBaiKiemTraFindByLop(LopDTO lopDTO);

}
