package com.dasuo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dasuo.converter.ChatConverter;
import com.dasuo.dto.ChatDTO;
import com.dasuo.entity.Chat;
import com.dasuo.repository.ChatRepository;
import com.dasuo.service.IChatService;

@Service
public class ChatService implements IChatService{
	@Autowired
	ChatRepository chatRepository;
	@Autowired
	ChatConverter chatConverter;
	

	@Override
	@Transactional
	public List<ChatDTO> getListChat() {
		List<Chat> chats = chatRepository.findAll();
		List<ChatDTO> chatDTOs = new ArrayList<>();
		chats.forEach(chat-> chatDTOs.add(chatConverter.toDTO(chat)));
		return chatDTOs;
	}

	@Override
	@Transactional
	public ChatDTO getChat(Integer id) {
		Chat chat = chatRepository.findById(id).orElse(null);
		if (chat!=null)
		{
			return chatConverter.toDTO(chat);
		}
		else {
			return null;
		}
		
	}

	@Override
	public void save(ChatDTO chatDTO) {
		chatRepository.save(chatConverter.toEntity(chatDTO));
		
	}

	@Override
	public void delete(Integer id) {
		chatRepository.deleteById(id);
		
	}
	

}
