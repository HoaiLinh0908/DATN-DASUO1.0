package com.dasuo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dasuo.converter.BaiKiemTraConverter;
import com.dasuo.converter.LopConverter;
import com.dasuo.dto.BaiKiemTraDTO;
import com.dasuo.dto.GiaoTrinhDTO;
import com.dasuo.dto.LopDTO;
import com.dasuo.entity.BaiKiemTra;
import com.dasuo.entity.GiaoTrinh;
import com.dasuo.entity.Lop;
import com.dasuo.repository.BaiKiemTraRepository;
import com.dasuo.service.IBaiKiemTraService;

@Service
public class BaiKiemTraService implements IBaiKiemTraService{
	@Autowired
	BaiKiemTraRepository baiKiemTraRepository;
	@Autowired
	BaiKiemTraConverter baiKiemTraConverter;
	@Autowired
	LopConverter lopConverter;

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

	@Override
	public List<BaiKiemTraDTO> getBaiKiemTraFindByLop(LopDTO lopDTO) {
		Lop lop = lopConverter.toEntity(lopDTO);
		List<BaiKiemTra> baiKiemTras = baiKiemTraRepository.findByLop(lop);
		List<BaiKiemTraDTO> baiKiemTraDTOs = new ArrayList<>();
		baiKiemTras.forEach(baiKiemTra -> baiKiemTraDTOs.add(baiKiemTraConverter.toDTO(baiKiemTra)));
		if(baiKiemTras!= null)
		{
			return baiKiemTraDTOs;
		}
		else {
			return null;
		}
	}

}
