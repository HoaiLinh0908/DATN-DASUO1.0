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

import com.dasuo.dto.TinNhanDTO;
import com.dasuo.service.ITinNhanService;
@RestController
@RequestMapping("/api")
public class TinNhanAPI {
	@Autowired
	ITinNhanService tinNhanService;
	@GetMapping("/tinnhans")
	public ResponseEntity<List<TinNhanDTO>> getListTinNhans (){
		List<TinNhanDTO> tinNhanDTOs = tinNhanService.getListTinNhan();
		if(tinNhanDTOs!=null)
		{
			return new ResponseEntity<>(tinNhanDTOs,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/tinnhans/{id}")
	public ResponseEntity<TinNhanDTO> getTinNhan(@PathVariable("id") Integer id){
		TinNhanDTO tinNhanDTO = tinNhanService.getTinNhan(id);
		if (tinNhanDTO!=null) {
			return new ResponseEntity<>(tinNhanDTO,HttpStatus.OK);
			
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/tinnhans")
	public ResponseEntity<TinNhanDTO> addTinNhan(@RequestBody TinNhanDTO tinNhanDTO) {
		if(tinNhanDTO != null)
		{
			tinNhanService.save(tinNhanDTO);
			return new ResponseEntity<>(tinNhanDTO, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	@PutMapping("/tinnhans/{id}")
	public ResponseEntity<TinNhanDTO> updateTinNhan(@RequestBody TinNhanDTO tinNhanDTO,@PathVariable("id") Integer id) {
		TinNhanDTO _tinNhanDTO = tinNhanService.getTinNhan(id);
		if(_tinNhanDTO!= null)
		{
			tinNhanService.save(tinNhanDTO);
			return new ResponseEntity<>(tinNhanDTO,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	@DeleteMapping("/tinnhans/{id}")
	public ResponseEntity<HttpStatus> deleteTinNhan(@PathVariable("id") Integer id){
		TinNhanDTO _tinNhanDTO= tinNhanService.getTinNhan(id);
		if (_tinNhanDTO!= null) {
			tinNhanService.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
			
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
	}

}
