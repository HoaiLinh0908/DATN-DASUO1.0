package com.dasuo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dasuo.converter.ChatConverter;
import com.dasuo.converter.TinNhanConverter;
import com.dasuo.dto.ChatDTO;
import com.dasuo.dto.TinNhanDTO;
import com.dasuo.entity.Chat;
import com.dasuo.entity.TinNhan;
import com.dasuo.repository.ChatRepository;
import com.dasuo.repository.TinNhanRepository;
import com.dasuo.service.ITinNhanService;

@Service
public class TinNhanService implements ITinNhanService{
	
	@Autowired
	TinNhanRepository tinNhanRepository;
	@Autowired
	TinNhanConverter tinNhanConverter;
	@Autowired
	ChatRepository chatRepository;
	@Autowired
	ChatConverter chatConverter;

	@Override
	public List<TinNhanDTO> getListTinNhan() {
		List<TinNhan> tinNhans = tinNhanRepository.findAll();
		List<TinNhanDTO> tinNhanDTOs = new ArrayList<>();
		tinNhans.forEach(tinNhan -> tinNhanDTOs.add(tinNhanConverter.toDTO(tinNhan)));
		return tinNhanDTOs;
	}

	@Override
	public TinNhanDTO getTinNhan(Integer id) {
		TinNhan tinNhan = tinNhanRepository.findById(id).orElse(null);
		return tinNhanConverter.toDTO(tinNhan);
	}

	@Override
	public void save(TinNhanDTO tinNhanDTO) {
		if(tinNhanDTO.getChat()!=null)
		{
			tinNhanRepository.save(tinNhanConverter.toEntity(tinNhanDTO));
		}
		
		
	}

	@Override
	public void delete(Integer id) {
		tinNhanRepository.deleteById(id);
		
	}

	@Override
	public List<TinNhanDTO> getListTinNhanFindByGN(ChatDTO chatDTO) {
		ChatDTO _chatDTO = chatConverter.toDTOID(chatRepository.findChatByGN(chatDTO.getNguoiGui().getTaiKhoan_Id(), chatDTO.getNguoiNhan().getTaiKhoan_Id()));
		Chat entity = chatConverter.toEntity(_chatDTO);
		List<TinNhan> tinNhans = tinNhanRepository.findByChat(entity);
		List<TinNhanDTO> tinNhanDTOs = new ArrayList<>();
		tinNhans.forEach(tinNhan -> tinNhanDTOs.add(tinNhanConverter.toDTO(tinNhan)));
		return tinNhanDTOs;
	}

}
