package com.dasuo.service;

import java.util.List;

import com.dasuo.dto.MonDTO;

public interface IMonService {
	List<MonDTO> getListMon();
	MonDTO getMon(int id);
	public void save (MonDTO monDTO);
	public void delete(Integer id);

}
