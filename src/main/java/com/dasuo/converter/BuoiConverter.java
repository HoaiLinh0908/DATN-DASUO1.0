package com.dasuo.converter;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.dasuo.dto.BuoiDTO;
import com.dasuo.entity.Buoi;

@Component
public class BuoiConverter {
	public BuoiDTO toDTO(Buoi buoi) {
		BuoiDTO buoiDTO = new BuoiDTO();
		buoiDTO.setBuoi_Id(buoi.getBuoi_Id());
		buoiDTO.setNgayTrongTuan(buoi.getNgayTrongTuan());
		return buoiDTO;
	}

	public Buoi toEntity(BuoiDTO buoiDTO) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(buoiDTO, Buoi.class);
	}
}
