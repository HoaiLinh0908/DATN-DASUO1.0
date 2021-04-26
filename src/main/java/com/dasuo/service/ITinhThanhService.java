package com.dasuo.service;

import java.util.List;

import com.dasuo.dto.TinhThanhDTO;

public interface ITinhThanhService {
	List<TinhThanhDTO> getListTinhThanhs();
	TinhThanhDTO getTinhThanh(int id);
	void save( TinhThanhDTO tinhThanhDTO);
	void delete (int id);

}
