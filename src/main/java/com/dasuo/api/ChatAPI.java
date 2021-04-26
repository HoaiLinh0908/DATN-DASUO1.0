package com.dasuo.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dasuo.dto.ChatDTO;
import com.dasuo.service.IChatService;

@RestController
@RequestMapping("/api")
public class ChatAPI {
	@Autowired
	IChatService chatService;
	@GetMapping("/chats")
	public ResponseEntity<List<ChatDTO>> getListChats (){
		List<ChatDTO> chatDTOs = chatService.getListChat();
		if(chatDTOs!=null)
		{
			return new ResponseEntity<>(chatDTOs,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/chats/{id}")
	public ResponseEntity<ChatDTO> getChat(@PathVariable("id") Integer id){
		ChatDTO chatDTO = chatService.getChat(id);
		if (chatDTO!=null) {
			return new ResponseEntity<>(chatDTO,HttpStatus.OK);
			
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/chats")
	public ResponseEntity<ChatDTO> addChat(@RequestBody ChatDTO chatDTO) {
		if(chatDTO != null && chatDTO.getNguoiGui() != null && chatDTO.getNguoiNhan() != null)
		{
			chatService.save(chatDTO);
			return new ResponseEntity<>(chatDTO, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	@PutMapping("/chats/{id}")
	public ResponseEntity<ChatDTO> updateChat(@RequestBody ChatDTO chatDTO,@PathVariable("id") Integer id) {
		ChatDTO _chatDTO = chatService.getChat(id);
		if(_chatDTO!= null && chatDTO.getNguoiGui() != null && chatDTO.getNguoiNhan() != null)
		{
			chatService.save(chatDTO);
			return new ResponseEntity<>(chatDTO,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	@DeleteMapping("/chats/{id}")
	public ResponseEntity<HttpStatus> deleteChat(@PathVariable("id") Integer id){
		ChatDTO _chatDTO= chatService.getChat(id);
		if (_chatDTO!= null) {
			chatService.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
			
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
	}

}
