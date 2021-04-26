package com.dasuo.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dasuo.dto.GiaoTrinhDTO;
import com.dasuo.dto.LopDTO;
import com.dasuo.entity.GiaoTrinh;

@Component
public class GiaoTrinhConverter {
	
	@Autowired
	LopConverter lopConverter;
	public GiaoTrinhDTO toDTO (GiaoTrinh giaoTrinh) {
		GiaoTrinhDTO giaoTrinhDTO = new GiaoTrinhDTO();
		giaoTrinhDTO.setGiaoTrinh_Id(giaoTrinh.getGiaoTrinh_Id());
		giaoTrinhDTO.setGiaoTrinh(giaoTrinh.getGiaoTrinh());
		giaoTrinhDTO.setThoiGian(giaoTrinh.getThoiGian());
		LopDTO lopDTO = lopConverter.toDTO(giaoTrinh.getLop());
		giaoTrinhDTO.setLop(lopDTO);
		return giaoTrinhDTO;
	}
	
	public GiaoTrinh toEntity (GiaoTrinhDTO giaoTrinhDTO) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(giaoTrinhDTO, GiaoTrinh.class);
	}

}
