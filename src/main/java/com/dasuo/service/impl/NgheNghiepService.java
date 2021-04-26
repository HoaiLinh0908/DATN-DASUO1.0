package com.dasuo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dasuo.converter.NgheNghiepConverter;
import com.dasuo.dto.NgheNghiepDTO;
import com.dasuo.entity.NgheNghiep;
import com.dasuo.repository.NgheNghiepRepository;
import com.dasuo.service.INgheNghiepService;

@Service
public class NgheNghiepService implements INgheNghiepService {
	
	@Autowired
	NgheNghiepRepository ngheNghiepRepository;
	@Autowired
	NgheNghiepConverter ngheNghiepConverter;

	@Override
	public List<NgheNghiepDTO> getListNgheNghieps() {
		List<NgheNghiep> ngheNghieps = ngheNghiepRepository.findAll();
		List<NgheNghiepDTO> ngheNghiepDTOs = new ArrayList<>();
		ngheNghieps.forEach(ngheNghiep -> ngheNghiepDTOs.add(ngheNghiepConverter.toDTO(ngheNghiep)));
		
		return ngheNghiepDTOs;
	}

	@Override
	public NgheNghiepDTO getNgheNghiep(int id) {
		NgheNghiep ngheNghiep = ngheNghiepRepository.findById(id).orElse(null);
		return ngheNghiepConverter.toDTO(ngheNghiep);
	}

	@Override
	public void save(NgheNghiepDTO ngheNghiepDTO) {
		NgheNghiep _ngheNghiep = ngheNghiepConverter.toEntity(ngheNghiepDTO);
		ngheNghiepRepository.save(_ngheNghiep);
		
		
	}

	@Override
	public void delete(int id) {
		ngheNghiepRepository.deleteById(id);
	}

}
