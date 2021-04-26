package com.dasuo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dasuo.converter.GiaoTrinhConverter;
import com.dasuo.dto.GiaoTrinhDTO;
import com.dasuo.entity.GiaoTrinh;
import com.dasuo.repository.GiaoTrinhRepository;
import com.dasuo.service.IGiaoTrinhService;

@Service
public class GiaoTrinhService implements IGiaoTrinhService{
	@Autowired
	GiaoTrinhRepository giaoTrinhRepository;
	@Autowired
	GiaoTrinhConverter giaoTrinhConverter;

	@Override
	@Transactional
	public List<GiaoTrinhDTO> getListGiaoTrinh() {
		List<GiaoTrinh> giaoTrinhs = giaoTrinhRepository.findAll();
		List<GiaoTrinhDTO> giaoTrinhDTOs = new ArrayList<>();
		giaoTrinhs.forEach(giaoTrinh -> giaoTrinhDTOs.add(giaoTrinhConverter.toDTO(giaoTrinh)));
		return giaoTrinhDTOs;
	}

	@Override
	@Transactional
	public GiaoTrinhDTO getGiaoTrinh(Integer id) {
		GiaoTrinh giaoTrinh = giaoTrinhRepository.findById(id).orElse(null);
		if(giaoTrinh!= null)
		{
			return giaoTrinhConverter.toDTO(giaoTrinh);
		}
		else {
			return null;
		}
		
	}

	@Override
	public void save(GiaoTrinhDTO giaoTrinhDTO) {
		if(giaoTrinhDTO.getLop()!=null)
		{
			giaoTrinhRepository.save(giaoTrinhConverter.toEntity(giaoTrinhDTO));
		}
		
		
	}

	@Override
	public void delete(Integer id) {
		giaoTrinhRepository.deleteById(id);
		
	}

}
