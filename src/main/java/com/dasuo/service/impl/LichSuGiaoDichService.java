package com.dasuo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.dasuo.converter.LichSuGiaoDichConverter;
import com.dasuo.converter.TaiKhoanConverter;
import com.dasuo.dto.LichSuGiaoDichDTO;
import com.dasuo.dto.TaiKhoanDTO;
import com.dasuo.entity.LichSuGiaoDich;
import com.dasuo.repository.LichSuGiaoDichRepository;
import com.dasuo.service.ILichSuGiaoDichService;

@Service
public class LichSuGiaoDichService implements ILichSuGiaoDichService{
	
	@Autowired
	LichSuGiaoDichRepository lichSuGiaoDichRepository;
	@Autowired
	LichSuGiaoDichConverter lichSuGiaoDichConverter;
	@Autowired
	TaiKhoanConverter taiKhoanConverter;
	

	@Override
	public List<LichSuGiaoDichDTO> getListLichSuGiaoDich(Pageable pageable) {
		List<LichSuGiaoDich> lichSuGiaoDichs = lichSuGiaoDichRepository.findAll(pageable).getContent();
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

	@Override
	public int getTotalPage(int limit) {
		int totalItem = (int) lichSuGiaoDichRepository.count();
		if (totalItem % limit != 0) {
			return (totalItem / limit) + 1;
		}
		return totalItem / limit;
	}

	@Override
	public List<LichSuGiaoDichDTO> getListLichSuGiaoDichFindByTK(TaiKhoanDTO taiKhoan) {
		List<LichSuGiaoDich> lichSuGiaoDichs = lichSuGiaoDichRepository.findByTaiKhoan(taiKhoanConverter.toEntity(taiKhoan));
		if(lichSuGiaoDichs!=null)
		{
			List<LichSuGiaoDichDTO> lichSuGiaoDichDTOs = new ArrayList<>();
			lichSuGiaoDichs.forEach(lichSuGiaoDich -> lichSuGiaoDichDTOs.add(lichSuGiaoDichConverter.toDTO(lichSuGiaoDich)));
			return lichSuGiaoDichDTOs;
		}
		else {
			return null;
		}
		
	}

	@Override
	public int getTotalPageCountByTK(int limit, int id) {
		int totalItem = (int) lichSuGiaoDichRepository.countByTaiKhoan(id);
		if (totalItem % limit != 0) {
			return (totalItem / limit) + 1;
		}
		return totalItem / limit;
	}

}
