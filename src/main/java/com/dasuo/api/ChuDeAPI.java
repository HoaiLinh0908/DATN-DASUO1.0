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

import com.dasuo.dto.ChuDeDTO;
import com.dasuo.service.IChuDeService;

@RestController
@RequestMapping("/api")
public class ChuDeAPI {
	@Autowired
	IChuDeService chuDeService;
	@GetMapping("/chudes")
	public ResponseEntity<List<ChuDeDTO>> getListChuDes (){
		List<ChuDeDTO> chuDeDTOs = chuDeService.getListChuDe();
		if(chuDeDTOs!=null)
		{
			return new ResponseEntity<>(chuDeDTOs,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/chudes/{id}")
	public ResponseEntity<ChuDeDTO> getChuDe(@PathVariable("id") Integer id){
		ChuDeDTO chuDeDTO = chuDeService.getChuDe(id);
		if (chuDeDTO!=null ) {
			return new ResponseEntity<>(chuDeDTO,HttpStatus.OK);
			
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/chudes")
	public ResponseEntity<ChuDeDTO> addChuDe(@RequestBody ChuDeDTO chuDeDTO) {
		if(chuDeDTO != null)
		{
			chuDeService.save(chuDeDTO);
			return new ResponseEntity<>(chuDeDTO, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	@PutMapping("/chudes/{id}")
	public ResponseEntity<ChuDeDTO> updateChuDe(@RequestBody ChuDeDTO chuDeDTO,@PathVariable("id") Integer id) {
		ChuDeDTO _chuDeDTO = chuDeService.getChuDe(id);
		if(_chuDeDTO!= null)
		{
			chuDeService.save(chuDeDTO);
			return new ResponseEntity<>(chuDeDTO,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	@DeleteMapping("/chudes/{id}")
	public ResponseEntity<HttpStatus> deleteChuDe(@PathVariable("id") Integer id){
		ChuDeDTO chuDeDTO= chuDeService.getChuDe(id);
		if (chuDeDTO!= null) {
			chuDeService.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
			
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
	}

}
