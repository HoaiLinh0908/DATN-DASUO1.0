package com.dasuo.service;

import java.util.List;

import com.dasuo.dto.LoaiDTO;

public interface ILoaiService {
	List<LoaiDTO> listLoai();
	LoaiDTO loai(Integer id);

}
