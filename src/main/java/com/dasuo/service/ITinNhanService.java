package com.dasuo.service;

import java.util.List;

import com.dasuo.dto.TinNhanDTO;

public interface ITinNhanService {
	List<TinNhanDTO> getListTinNhan();
	TinNhanDTO getTinNhan(Integer id);
	public void save(TinNhanDTO tinNhanDTO);
	public void delete(Integer id);

}
