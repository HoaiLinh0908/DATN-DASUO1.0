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

import com.dasuo.dto.GiaoTrinhDTO;
import com.dasuo.service.IGiaoTrinhService;

@RestController
@RequestMapping("/api")
public class GiaoTrinhAPI {
	@Autowired
	IGiaoTrinhService giaoTrinhService;
	@GetMapping("/giaotrinhs")
	public ResponseEntity<List<GiaoTrinhDTO>> getListGiaoTrinhs (){
		List<GiaoTrinhDTO> giaoTrinhDTOs = giaoTrinhService.getListGiaoTrinh();
		if(giaoTrinhDTOs!=null)
		{
			return new ResponseEntity<>(giaoTrinhDTOs,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/giaotrinhs/{id}")
	public ResponseEntity<GiaoTrinhDTO> getGiaoTrinh(@PathVariable("id") Integer id){
		GiaoTrinhDTO giaoTrinhDTO = giaoTrinhService.getGiaoTrinh(id);
		if (giaoTrinhDTO!=null) {
			return new ResponseEntity<>(giaoTrinhDTO,HttpStatus.OK);
			
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/giaotrinhs")
	public ResponseEntity<GiaoTrinhDTO> addGiaoTrinh(@RequestBody GiaoTrinhDTO giaoTrinhDTO) {
		if(giaoTrinhDTO != null && giaoTrinhDTO.getLop() !=null)
		{
			giaoTrinhService.save(giaoTrinhDTO);
			return new ResponseEntity<>(giaoTrinhDTO, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	@PutMapping("/giaotrinhs/{id}")
	public ResponseEntity<GiaoTrinhDTO> updateGiaoTrinh(@RequestBody GiaoTrinhDTO giaoTrinhDTO,@PathVariable("id") Integer id) {
		GiaoTrinhDTO _giaoTrinhDTO = giaoTrinhService.getGiaoTrinh(id);
		if(_giaoTrinhDTO!= null && giaoTrinhDTO.getLop() !=null)
		{
			giaoTrinhService.save(giaoTrinhDTO);
			return new ResponseEntity<>(giaoTrinhDTO,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	@DeleteMapping("/giaotrinhs/{id}")
	public ResponseEntity<HttpStatus> deleteGiaoTrinh(@PathVariable("id") Integer id){
		GiaoTrinhDTO giaoTrinhDTO= giaoTrinhService.getGiaoTrinh(id);
		if (giaoTrinhDTO!= null) {
			giaoTrinhService.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
			
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
	}

}
