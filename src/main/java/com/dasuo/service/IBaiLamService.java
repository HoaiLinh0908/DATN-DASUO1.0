package com.dasuo.service;

import java.util.List;

import com.dasuo.dto.BaiLamDTO;

public interface IBaiLamService {
	List<BaiLamDTO> getListBaiLam();
	BaiLamDTO getBaiLam(Integer id);
	public void save(BaiLamDTO baiLamDTO);
	public void delete(Integer id);

}
