package com.dasuo.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.dasuo.dto.BaiDangDTO;

public interface IBaiDangService {
	List<BaiDangDTO> getListBaiDang(Pageable pageable);
	BaiDangDTO getBaiDang(Integer id);
	public void save (BaiDangDTO baiDangDTO);
	public void update(BaiDangDTO baiDangDTO);
	public BaiDangDTO yeuCauDay(BaiDangDTO baiDangDTO);
	public void delete(Integer id);
	public int getTotalPage(int limit);
	public int getTotalPageByTaiKhoan(Integer id, int limit);
	List<BaiDangDTO> getListBaiDangFindByTaiKhoan(Integer id, Pageable pageable);
	List<BaiDangDTO> getListBaiDangs(Pageable pageable);
}
