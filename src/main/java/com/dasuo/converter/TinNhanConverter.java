package com.dasuo.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dasuo.dto.ChatDTO;
import com.dasuo.dto.TinNhanDTO;
import com.dasuo.entity.TinNhan;

@Component
public class TinNhanConverter {
	@Autowired
	ChatConverter chatConverter;
	public TinNhanDTO toDTO(TinNhan tinNhan) {
		TinNhanDTO tinNhanDTO = new TinNhanDTO();
		tinNhanDTO.setTinNhan_Id(tinNhan.getTinNhan_Id());
		tinNhanDTO.setNoiDung(tinNhan.getNoiDung());
		tinNhanDTO.setThoiGian(tinNhan.getThoiGian());
		ChatDTO chatDTO = chatConverter.toDTO(tinNhan.getChat());
		tinNhanDTO.setChat(chatDTO);
		return tinNhanDTO;
		
	}
	
	public TinNhan toEntity (TinNhanDTO tinNhanDTO) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(tinNhanDTO, TinNhan.class);
	}

}
