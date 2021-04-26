package com.dasuo.service;

import java.util.List;

import com.dasuo.dto.ChatDTO;

public interface IChatService {
	List<ChatDTO> getListChat();
	ChatDTO getChat(Integer id);
	public void save(ChatDTO chatDTO);
	public void delete(Integer id);

}
