package com.dasuo.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dasuo.converter.BaiDangConverter;
import com.dasuo.converter.BuoiConverter;
import com.dasuo.converter.TaiKhoanConverter;
import com.dasuo.dto.BaiDangDTO;
import com.dasuo.dto.TaiKhoanDTO;
import com.dasuo.entity.BaiDang;
import com.dasuo.entity.Buoi;
import com.dasuo.entity.TaiKhoan;
import com.dasuo.repository.BaiDangRepository;
import com.dasuo.repository.BuoiRepository;
import com.dasuo.repository.TaiKhoanRepository;
import com.dasuo.service.IBaiDangService;

@Service
public class BaiDangService implements IBaiDangService {
	@Autowired
	BaiDangRepository baiDangRepository;
	@Autowired
	BaiDangConverter baiDangConverter;
	@Autowired
	BuoiRepository buoiRepository;
	@Autowired
	BuoiConverter buoiConverter;
	
	@Autowired
	TaiKhoanRepository taiKhoanRepository;
	@Autowired
	TaiKhoanConverter taiKhoanConverter;

	@Override
	@Transactional
	public List<BaiDangDTO> getListBaiDang(Pageable pageable) {
		List<BaiDang> baiDangs = baiDangRepository.getBaiDangs(pageable);

		List<BaiDangDTO> baiDangDTOs = baiDangConverter.toBaiDangDTO(baiDangs);
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
		BaiDang baidang = baiDangRepository.save(baiDangConverter.toEntity(baiDangDTO));
		List<Buoi> buois = baidang.getBuois();
		buois.forEach((buoi) -> {
			buoi.setBaiDang(baidang);
			buoiRepository.save(buoi);
		});
	}
	
	@Override
	public void update(BaiDangDTO baiDangDTO) {
		baiDangRepository.save(baiDangConverter.toEntity(baiDangDTO));
	}
	
	@Override
	public BaiDangDTO yeuCauDay(BaiDangDTO baiDangDTO) {
		TaiKhoanDTO nguoiYeuCauDay = (TaiKhoanDTO) baiDangDTO.getTaiKhoans().toArray()[0];
		TaiKhoan nguoiYCDEntity = taiKhoanRepository.findById(nguoiYeuCauDay.getTaiKhoan_Id()).orElse(null);
		BaiDang baiDang = baiDangRepository.findById(baiDangDTO.getBaiDang_Id()).orElse(null);
		Set<BaiDang> baiDangs;
		if(baiDang.getTaiKhoans() == null) {
			baiDangs = new HashSet<>();
		} else {
			baiDangs = nguoiYCDEntity.getBaiDangs();
		}
		baiDangs.add(baiDang);
		nguoiYCDEntity.setBaiDangs(baiDangs);
		taiKhoanConverter.toDTO(taiKhoanRepository.save(nguoiYCDEntity));
		BaiDang baiDangReturn = baiDangRepository.findById(baiDangDTO.getBaiDang_Id()).orElse(null);
		return baiDangConverter.toDTO(baiDangReturn);
	}

	@Override
	public void delete(Integer id) {
		baiDangRepository.deleteById(id);
	}

	@Override
	public int getTotalPage(int limit) {
		int totalItem = (int) baiDangRepository.countByEnable();
		if (totalItem % limit != 0) {
			return (totalItem / limit) + 1;
		}
		return totalItem / limit;
	}

	@Override
	public List<BaiDangDTO> getListBaiDangFindByTaiKhoan(Integer id, Pageable pageable) {
		List<BaiDang> baiDangs = baiDangRepository.findByTaiKhoan(id, pageable).getContent();
		List<BaiDangDTO> baiDangDTOs = new ArrayList<>();
		baiDangs.forEach(baiDang -> baiDangDTOs.add(baiDangConverter.toDTO(baiDang)));
		return baiDangDTOs;
	}

	@Override
	public int getTotalPageByTaiKhoan(Integer id, int limit) {
		int totalItem = baiDangRepository.countByTaiKhoan(id);
		if (totalItem % limit != 0) {
			return (totalItem / limit) + 1;
		}
		return totalItem / limit;
	}

	@Override
	public List<BaiDangDTO> getListBaiDangs(Pageable pageable) {
		List<BaiDang> baiDangs = baiDangRepository.findAll(pageable).getContent();

		List<BaiDangDTO> baiDangDTOs = new ArrayList<>();
		baiDangs.forEach(baiDang -> baiDangDTOs.add(baiDangConverter.toDTO(baiDang)));
		return baiDangDTOs;
	}
}
