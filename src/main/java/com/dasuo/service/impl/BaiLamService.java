package com.dasuo.service.impl;

import java.util.ArrayList;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dasuo.converter.BaiKiemTraConverter;
import com.dasuo.converter.BaiLamConverter;
import com.dasuo.dto.BaiKiemTraDTO;
import com.dasuo.dto.BaiLamDTO;
import com.dasuo.entity.BaiKiemTra;
import com.dasuo.entity.BaiLam;
import com.dasuo.entity.Lop;
import com.dasuo.repository.BaiLamRepository;
import com.dasuo.service.IBaiLamService;
@Service
public class BaiLamService implements IBaiLamService{
	
	@Autowired
	BaiLamRepository baiLamRepository;
	@Autowired
	BaiLamConverter baiLamConverter;
	@Autowired
	BaiKiemTraConverter baiKiemTraConverter;

	@Override
	@Transactional
	public List<BaiLamDTO> getListBaiLam() {
		List<BaiLam> baiLams = baiLamRepository.findAll();
		List<BaiLamDTO> baiLamDTOs = new ArrayList<>();
		baiLams.forEach(baiLam -> baiLamDTOs.add(baiLamConverter.toDTO(baiLam)));
		return baiLamDTOs;
	}

	@Override
	@Transactional
	public BaiLamDTO getBaiLam(Integer id) {
		BaiLam baiLam = baiLamRepository.findById(id).orElse(null);
		if(baiLam != null)
		{
			return baiLamConverter.toDTO(baiLam);
		}
		else {
			return null;
		}
		
	}

	@Override
	public void save(BaiLamDTO baiLamDTO) {
		baiLamRepository.save(baiLamConverter.toEntity(baiLamDTO));
		
	}

	@Override
	public void delete(Integer id) {
		baiLamRepository.deleteById(id);
		
	}

	@Override
	public List<BaiLamDTO> getBaiLamFindByBaiKiemTra(BaiKiemTraDTO baiKiemTraDTO) {
		BaiKiemTra baiKiemTra = baiKiemTraConverter.totEntity(baiKiemTraDTO);
		
		List<BaiLam> baiLams = baiLamRepository.findByBaiKiemTra(baiKiemTra);
		List<BaiLamDTO> baiLamDTOs = new ArrayList<>();
		baiLams.forEach(baiLam -> baiLamDTOs.add(baiLamConverter.toDTO(baiLam)));
		if(baiLams!= null)
		{
			return baiLamDTOs;
		}
		else {
			return null;
		}
	}
	

}
