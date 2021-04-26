package com.dasuo.converter;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.dasuo.dto.ChuDeDTO;
import com.dasuo.entity.ChuDe;

@Component
public class ChuDeConverter {
	public ChuDeDTO toDTO (ChuDe chuDe) {
		ChuDeDTO chuDeDTO = new ChuDeDTO();
		chuDeDTO.setChuDe_Id(chuDe.getChuDe_Id());
		chuDeDTO.setTenChuDe(chuDe.getTenChuDe());
		return chuDeDTO;
	}
	
	public ChuDe toEntity (ChuDeDTO chuDeDTO) {
		ModelMapper modelMapper = new ModelMapper();
		ChuDe chuDe = modelMapper.map(chuDeDTO, ChuDe.class);
		return chuDe;
		
	}

}
