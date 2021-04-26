package com.dasuo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dasuo.converter.LoaiConverter;
import com.dasuo.dto.LoaiDTO;
import com.dasuo.entity.Loai;
import com.dasuo.repository.LoaiRepository;
import com.dasuo.service.ILoaiService;

@Service
public class LoaiService implements ILoaiService{
	@Autowired
	LoaiRepository loaiRepository;
	@Autowired
	LoaiConverter loaiConverter;

	@Override
	public List<LoaiDTO> listLoai() {
		List<Loai> listLoais = loaiRepository.findAll(); 
		List<LoaiDTO> listLoaiDTO = new ArrayList<>();
		listLoais.forEach(listLoai -> listLoaiDTO.add(loaiConverter.toDTO(listLoai)));
		return listLoaiDTO;
	}

	@Override
	public LoaiDTO loai(Integer id) {
		return loaiConverter.toDTO(loaiRepository.findById(id).orElse(null));
	}

}
