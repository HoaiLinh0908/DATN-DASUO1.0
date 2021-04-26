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

import com.dasuo.dto.NgheNghiepDTO;
import com.dasuo.service.INgheNghiepService;

@RestController
@RequestMapping("/api")
public class NgheNghiepAPI {
	
	@Autowired
	INgheNghiepService ngheNghiepService;
	@GetMapping("/nghenghieps")
	public ResponseEntity<List<NgheNghiepDTO>> getListNgheNghieps(){
		List<NgheNghiepDTO> ngheNghiepDTOs = ngheNghiepService.getListNgheNghieps();
		if(ngheNghiepDTOs != null)
		{
			return new ResponseEntity<>(ngheNghiepDTOs,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}	
	}
	@GetMapping("/nghenghieps/{id}")
	public ResponseEntity<NgheNghiepDTO> getNgheNghiep(@PathVariable("id") Integer id ){
		NgheNghiepDTO ngheNghiepDTO = ngheNghiepService.getNgheNghiep(id);
		if(ngheNghiepDTO != null)
		{
			return new ResponseEntity<>(ngheNghiepDTO,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}	
	}
	
	@PostMapping("/nghenghieps")
	public ResponseEntity<NgheNghiepDTO> saveNgheNghiep(@RequestBody NgheNghiepDTO ngheNghiepDTO ){
		if(ngheNghiepDTO != null)
		{
			ngheNghiepService.save(ngheNghiepDTO);
			return new ResponseEntity<>(ngheNghiepDTO,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
			
	}
	
	@PutMapping("/nghenghieps/{id}")
	public ResponseEntity<NgheNghiepDTO> updateNgheNghiep(@RequestBody NgheNghiepDTO ngheNghiepDTO , @PathVariable("id") Integer id){
			NgheNghiepDTO _ngheNghiepDTO = ngheNghiepService.getNgheNghiep(id);
			if(_ngheNghiepDTO!=null)
			{
				ngheNghiepService.save(ngheNghiepDTO);
				return new ResponseEntity<>(ngheNghiepDTO,HttpStatus.OK);
			}
			else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
	}
	
	@DeleteMapping("/nghenghieps/{id}")
	public ResponseEntity<HttpStatus> deleteNgheNghiep(@PathVariable("id") Integer id){
		NgheNghiepDTO _ngheNghiepDTO = ngheNghiepService.getNgheNghiep(id);
		if(_ngheNghiepDTO != null) 
		{
			return new ResponseEntity<>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
			
	}
	

}
