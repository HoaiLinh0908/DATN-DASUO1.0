package com.dasuo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dasuo.converter.BaiKiemTraConverter;
import com.dasuo.dto.BaiKiemTraDTO;
import com.dasuo.entity.BaiKiemTra;
import com.dasuo.repository.BaiKiemTraRepository;
import com.dasuo.service.IBaiKiemTraService;

@Service
public class BaiKiemTraService implements IBaiKiemTraService{
	@Autowired
	BaiKiemTraRepository baiKiemTraRepository;
	@Autowired
	BaiKiemTraConverter baiKiemTraConverter;

	@Override
	@Transactional
	public List<BaiKiemTraDTO> getListBaiKiemTra() {
		List<BaiKiemTra> baiKiemTras = baiKiemTraRepository.findAll();
		List<BaiKiemTraDTO> baiKiemTraDTOs = new ArrayList<>();
		baiKiemTras.forEach(baiKiemTra -> baiKiemTraDTOs.add(baiKiemTraConverter.toDTO(baiKiemTra)));
		return baiKiemTraDTOs;
	}

	@Override
	@Transactional
	public BaiKiemTraDTO getBaiKiemTra(Integer id) {
		BaiKiemTra baiKiemTra = baiKiemTraRepository.findById(id).orElse(null);
		return baiKiemTraConverter.toDTO(baiKiemTra);
	}

	@Override
	public void save(BaiKiemTraDTO baiKiemTraDTO) {
		baiKiemTraRepository.save(baiKiemTraConverter.totEntity(baiKiemTraDTO));
		
	}

	@Override
	public void delete(Integer id) {
		baiKiemTraRepository.deleteById(id);
		
	}

}
