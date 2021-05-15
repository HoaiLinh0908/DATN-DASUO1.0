package com.dasuo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dasuo.converter.BaiDangConverter;
import com.dasuo.dto.BaiDangDTO;
import com.dasuo.entity.BaiDang;
import com.dasuo.entity.TaiKhoan;
import com.dasuo.repository.BaiDangRepository;
import com.dasuo.service.IBaiDangService;
@Service
public class BaiDangService implements IBaiDangService{
	@Autowired
	BaiDangRepository baiDangRepository;
	@Autowired
	BaiDangConverter baiDangConverter;

	@Override
	@Transactional
	public List<BaiDangDTO> getListBaiDang(Pageable pageable) {
		List<BaiDang> baiDangs = baiDangRepository.findAll(pageable).getContent();
		List<BaiDangDTO> baiDangDTOs = new ArrayList<>();
		baiDangs.forEach(baiDang -> baiDangDTOs.add(baiDangConverter.toDTO(baiDang)));
		return baiDangDTOs;
	}
	

	@Override
	@Transactional
	public BaiDangDTO getBaiDang(Integer id) {
		BaiDang baiDang = baiDangRepository.findById(id).orElse(null);
		return baiDangConverter.toDTO(baiDang);
	}

	@Override
	public void save(BaiDangDTO baiDangDTO) {
		baiDangRepository.save(baiDangConverter.toEntity(baiDangDTO));
		
	}

	@Override
	public void delete(Integer id) {
		baiDangRepository.deleteById(id);
		
	}


	@Override
	public int getTotalPage(int limit) {
		int totalItem = (int) baiDangRepository.count();
		if(totalItem % limit != 0) {
			return (totalItem / limit) + 1;
		}
		return totalItem / limit;
	}
	
	@Override
	public List<BaiDangDTO> getListBaiDangFindByTaiKhoan(Integer id, Pageable pageable) {
		List<BaiDang> baiDangs = baiDangRepository.findByTaiKhoan(new TaiKhoan(id), pageable).getContent();
		List<BaiDangDTO> baiDangDTOs = new ArrayList<>();
		baiDangs.forEach(baiDang -> baiDangDTOs.add(baiDangConverter.toDTO(baiDang)));
		return baiDangDTOs;
	}


	@Override
	public int getTotalPageByTaiKhoan(Integer id, int limit) {
		int totalItem = baiDangRepository.countByTaiKhoan(new TaiKhoan(id));
		if(totalItem % limit != 0) {
			return (totalItem / limit) + 1;
		}
		return totalItem / limit;
	}

}
