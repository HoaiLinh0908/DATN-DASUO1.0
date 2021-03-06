package com.dasuo.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dasuo.dto.ChatDTO;
import com.dasuo.dto.TaiKhoanDTO;
import com.dasuo.entity.Chat;
import com.dasuo.service.IChatService;
import com.dasuo.service.ITaiKhoanService;

@Component
public class ChatConverter {
	@Autowired
	TaiKhoanConverter taiKhoanConverter;
	@Autowired
	ITaiKhoanService taiKhoanService;
	public ChatDTO toDTO (Chat chat) {
		ChatDTO chatDTO = new ChatDTO();
		chatDTO.setChat_Id(chat.getChat_Id());
		TaiKhoanDTO nguoiGui = taiKhoanConverter.toDTO(chat.getNguoiGui());
		chatDTO.setNguoiGui(nguoiGui);
		TaiKhoanDTO nguoiNhan = taiKhoanConverter.toDTO(chat.getNguoiNhan());
		chatDTO.setNguoiNhan(nguoiNhan);
		return chatDTO;
	}
	
	
	public Chat toEntity(ChatDTO chatDTO) {
		ModelMapper modelMapper =new  ModelMapper();
		return modelMapper.map(chatDTO, Chat.class);
	}
	public ChatDTO toDTOID (Chat chat) {
		ChatDTO chatDTO = new ChatDTO();
		chatDTO.setChat_Id(chat.getChat_Id());
		return chatDTO;
	}
	

}
