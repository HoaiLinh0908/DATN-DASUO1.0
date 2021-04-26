package com.dasuo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dasuo.converter.ChuDeConverter;
import com.dasuo.dto.ChuDeDTO;
import com.dasuo.entity.ChuDe;
import com.dasuo.repository.ChuDeRepository;
import com.dasuo.service.IChuDeService;

@Service
public class ChuDeService implements IChuDeService{
	
	@Autowired
	ChuDeRepository chuDeRepository;
	@Autowired
	ChuDeConverter chuDeConverter;
	

	@Override
	public List<ChuDeDTO> getListChuDe() {
		List<ChuDe> chuDes = chuDeRepository.findAll();
		List<ChuDeDTO> chuDeDTOs = new ArrayList<>();
		chuDes.forEach(chuDe -> chuDeDTOs.add(chuDeConverter.toDTO(chuDe)));
		return chuDeDTOs;
	}

	@Override
	public ChuDeDTO getChuDe(Integer id) {
		ChuDe chuDe = chuDeRepository.findById(id).orElse(null);
		ChuDeDTO chuDeDTO = chuDeConverter.toDTO(chuDe);
		return chuDeDTO;
	}

	@Override
	public void save(ChuDeDTO chuDeDTO) {
		ChuDe chuDe = chuDeConverter.toEntity(chuDeDTO);
		chuDeRepository.save(chuDe);
		
	}

	@Override
	public void delete(Integer id) {
		chuDeRepository.deleteById(id);
		
	}

}
