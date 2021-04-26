package com.dasuo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dasuo.converter.LichSuGiaoDichConverter;
import com.dasuo.dto.LichSuGiaoDichDTO;
import com.dasuo.entity.LichSuGiaoDich;
import com.dasuo.repository.LichSuGiaoDichRepository;
import com.dasuo.service.ILichSuGiaoDichService;

@Service
public class LichSuGiaoDichService implements ILichSuGiaoDichService{
	
	@Autowired
	LichSuGiaoDichRepository lichSuGiaoDichRepository;
	@Autowired
	LichSuGiaoDichConverter lichSuGiaoDichConverter;
	

	@Override
	public List<LichSuGiaoDichDTO> getListLichSuGiaoDich() {
		List<LichSuGiaoDich> lichSuGiaoDichs = lichSuGiaoDichRepository.findAll();
		List<LichSuGiaoDichDTO> lichSuGiaoDichDTOs = new ArrayList<>();
		lichSuGiaoDichs.forEach(lichSuGiaoDich -> lichSuGiaoDichDTOs.add(lichSuGiaoDichConverter.toDTO(lichSuGiaoDich)));
		return lichSuGiaoDichDTOs;
	}

	@Override
	public LichSuGiaoDichDTO getLichSuGiaoDich(Integer id) {
		LichSuGiaoDich lichSuGiaoDich = lichSuGiaoDichRepository.findById(id).orElse(null);
		return lichSuGiaoDichConverter.toDTO(lichSuGiaoDich);
	}

	@Override
	public void save(LichSuGiaoDichDTO lichSuGiaoDichDTO) {
		if(lichSuGiaoDichDTO.getTaiKhoan()!= null)
		{
			lichSuGiaoDichRepository.save(lichSuGiaoDichConverter.toEntity(lichSuGiaoDichDTO));
		}
		
		
	}

	@Override
	public void delete(Integer id) {
		lichSuGiaoDichRepository.deleteById(id);
		
	}

}
