package com.dasuo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dasuo.converter.PhanHoiConverter;
import com.dasuo.dto.PhanHoiDTO;
import com.dasuo.entity.PhanHoi;
import com.dasuo.repository.PhanHoiRepository;
import com.dasuo.service.IPhanHoiService;

@Service
public class PhanHoiService implements IPhanHoiService{
	@Autowired
	PhanHoiConverter phanHoiConverter;
	@Autowired
	PhanHoiRepository phanHoiRepository;

	@Override
	public List<PhanHoiDTO> getAllPhanHoi() {
		List<PhanHoi> phanHois = phanHoiRepository.findAll();
		List<PhanHoiDTO> phanHoiDTOs = new ArrayList<>();
		if(phanHois!= null)
		{
			phanHois.forEach(phanHoi -> phanHoiDTOs.add(phanHoiConverter.toDTO(phanHoi)));
			return phanHoiDTOs;
		}
		else {
			return null;
		}
		
	}

	@Override
	public PhanHoiDTO getPhanHoi(Integer id) {
		PhanHoi phanHoi = phanHoiRepository.findById(id).orElse(null);
		// @formatter:on
		if(phanHoi !=null)
		{
			return phanHoiConverter.toDTO(phanHoi);
		}
		else {
			return null;
		}
	}

	@Override
	public void save(PhanHoiDTO phanHoiDTO) {
		phanHoiRepository.save(phanHoiConverter.toEntity(phanHoiDTO));
		
	}

	@Override
	public void delete(Integer id) {
		if(id != 0 && id!= null)
		{
			phanHoiRepository.deleteById(id);
		}
		
	}

}
