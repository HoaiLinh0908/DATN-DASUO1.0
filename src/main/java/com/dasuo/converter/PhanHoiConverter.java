package com.dasuo.converter;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.dasuo.dto.PhanHoiDTO;
import com.dasuo.entity.PhanHoi;

@Component
public class PhanHoiConverter {
	public PhanHoiDTO toDTO(PhanHoi phanHoi) {
		PhanHoiDTO phanHoiDTO = new PhanHoiDTO();
		phanHoiDTO.setPhanHoi_Id(phanHoi.getPhanHoi_Id());
		phanHoiDTO.setEmail(phanHoi.getEmail());
		phanHoiDTO.setNoiDung(phanHoi.getNoiDung());
		return phanHoiDTO;
	}
	public PhanHoi toEntity (PhanHoiDTO phanHoiDTO) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(phanHoiDTO, PhanHoi.class);
	}

}
