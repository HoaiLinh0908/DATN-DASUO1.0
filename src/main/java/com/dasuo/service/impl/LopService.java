package com.dasuo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dasuo.converter.LopConverter;
import com.dasuo.dto.LopDTO;
import com.dasuo.entity.Lop;
import com.dasuo.repository.LopRepository;
import com.dasuo.service.ILopService;

@Service
public class LopService implements ILopService{
	@Autowired
	LopRepository lopRepository;
	@Autowired
	LopConverter lopConverter;

	@Override
	@Transactional
	public List<LopDTO> getListLop() {
		List<Lop> lops = lopRepository.findAll();
		List<LopDTO> lopDTOs = new ArrayList<>();
		lops.forEach(lop -> lopDTOs.add(lopConverter.toDTO(lop)));
		return lopDTOs;
	}

	@Override
	@Transactional
	public LopDTO getLop(Integer id) {
		if(id != 0 )
		{
			Lop lop = lopRepository.findById(id).orElse(null);
			return lopConverter.toDTO(lop);
		}
		else {
			return null;
		}
		
	}

	@Override
	public void save(LopDTO lopDTO) {
		if(lopDTO.getNguoiDay()!=null && lopDTO.getNguoiHoc()!= null)
		{
			lopRepository.save(lopConverter.toEntity(lopDTO));
		}
		
		
	}

	@Override
	public void delete(Integer id) {
		lopRepository.deleteById(id);
		
	}
	

}
