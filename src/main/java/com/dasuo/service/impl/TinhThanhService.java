package com.dasuo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dasuo.converter.TinhThanhConverter;
import com.dasuo.dto.TinhThanhDTO;
import com.dasuo.entity.TinhThanh;
import com.dasuo.repository.TinhThanhRepository;
import com.dasuo.service.ITinhThanhService;

@Service
public class TinhThanhService implements ITinhThanhService{
	
	@Autowired 
	TinhThanhRepository tinhThanhRepository;
	@Autowired
	TinhThanhConverter tinhThanhConverter;
	

	@Override
	public List<TinhThanhDTO> getListTinhThanhs() {
		List<TinhThanh> tinhThanhs = tinhThanhRepository.findAll();
		List<TinhThanhDTO> tinhThanhDTOs = new ArrayList<>();
		tinhThanhs.forEach(tinhThanh->tinhThanhDTOs.add(tinhThanhConverter.toDTO(tinhThanh)));
		return tinhThanhDTOs;
	}

	@Override
	public TinhThanhDTO getTinhThanh(int id) {
		TinhThanh tinhThanh = tinhThanhRepository.findById(id).orElse(null);
		return tinhThanhConverter.toDTO(tinhThanh);
	}

	@Override
	public void save(TinhThanhDTO tinhThanhDTO) {
		TinhThanh _tinhThanh = tinhThanhConverter.toEntity(tinhThanhDTO);
		tinhThanhRepository.save(_tinhThanh);
		
	}

	@Override
	public void delete(int id) {
		tinhThanhRepository.deleteById(id);
		
	}

}
