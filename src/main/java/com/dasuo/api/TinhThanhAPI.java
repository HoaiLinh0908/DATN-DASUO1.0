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

import com.dasuo.dto.TinhThanhDTO;
import com.dasuo.service.ITinhThanhService;

@RestController
@RequestMapping("/api")
public class TinhThanhAPI {
	
	@Autowired
	ITinhThanhService tinhThanhService;
	
	@GetMapping("/tinhthanhs")
	public ResponseEntity<List<TinhThanhDTO>> getListTinhThanhs() {
		List<TinhThanhDTO> tinhThanhDTOs = tinhThanhService.getListTinhThanhs();
		if(tinhThanhDTOs!=null)
		{
			return new ResponseEntity<>(tinhThanhDTOs,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@GetMapping("/tinhthanhs/{id}")
	public ResponseEntity<TinhThanhDTO> getTinhThanh(@PathVariable("id") Integer id){
		TinhThanhDTO tinhThanhDTO = tinhThanhService.getTinhThanh(id);
		if(tinhThanhDTO!=null)
		{
			return new ResponseEntity<>(tinhThanhDTO,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/tinhthanhs")
	public ResponseEntity<TinhThanhDTO> addTinhThanh(@RequestBody TinhThanhDTO tinhThanhDTO) {
		if(tinhThanhDTO != null)
		{
			tinhThanhService.save(tinhThanhDTO);
			return new ResponseEntity<>(tinhThanhDTO,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@PutMapping("/tinhthanhs/{id}")
	public ResponseEntity<TinhThanhDTO> updateTinhThanh(@RequestBody TinhThanhDTO tinhThanhDTO,@PathVariable("id") Integer id) {
		TinhThanhDTO _tinhThanhDTO = tinhThanhService.getTinhThanh(id);
		if(_tinhThanhDTO!=null)
		{
			tinhThanhService.save(tinhThanhDTO);
			return new ResponseEntity<>(tinhThanhDTO,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/tinhthanhs/{id}")
	public ResponseEntity<HttpStatus> deleteTinhThanh (@PathVariable("id") Integer id)
	{
		TinhThanhDTO _tinhThanhDTO = tinhThanhService.getTinhThanh(id);
		if(_tinhThanhDTO!=null)
		{
			tinhThanhService.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
	}

}
