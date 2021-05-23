package com.dasuo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.dasuo.converter.BuoiConverter;
import com.dasuo.dto.BuoiDTO;
import com.dasuo.entity.Buoi;
import com.dasuo.repository.BuoiRepository;
import com.dasuo.service.IBuoiService;

public class BuoiService implements IBuoiService{
	@Autowired
	BuoiRepository buoiRepository;
	@Autowired
	BuoiConverter buoiConverter;

	@Override
	public List<BuoiDTO> getListBuoi() {
		List<Buoi> buois = buoiRepository.findAll();
		List<BuoiDTO> buoiDTOs = new ArrayList<>();
		buois.forEach(buoi -> buoiDTOs.add(buoiConverter.toDTO(buoi)));
		return buoiDTOs;
	}

	@Override
	public BuoiDTO getBuoi(Integer id) {
		Buoi buoi = buoiRepository.findById(id).orElse(null);
		if(buoi != null)
		{
			return buoiConverter.toDTO(buoi);
		}
		else {
			return null;
		}
		
	}

	@Override
	public void save(BuoiDTO buoiDTO) {
		buoiRepository.save(buoiConverter.toEntity(buoiDTO));
		
	}

	@Override
	public void delete(Integer id) {
		buoiRepository.deleteById(id);
		
	}

}
