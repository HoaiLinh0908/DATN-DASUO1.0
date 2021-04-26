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

import com.dasuo.dto.BaiKiemTraDTO;
import com.dasuo.service.IBaiKiemTraService;

@RestController
@RequestMapping("/api")
public class BaiKiemTraAPI {
	@Autowired
	IBaiKiemTraService baiKiemTraService;
	@GetMapping("/baikiemtras")
	public ResponseEntity<List<BaiKiemTraDTO>> getListBaiKiemTras (){
		List<BaiKiemTraDTO> baiKiemTraDTOs = baiKiemTraService.getListBaiKiemTra();
		if(baiKiemTraDTOs!=null)
		{
			return new ResponseEntity<>(baiKiemTraDTOs,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/baikiemtras/{id}")
	public ResponseEntity<BaiKiemTraDTO> getBaiKiemTra(@PathVariable("id") Integer id){
		BaiKiemTraDTO baiKiemTraDTO = baiKiemTraService.getBaiKiemTra(id);
		if (baiKiemTraDTO!=null) {
			return new ResponseEntity<>(baiKiemTraDTO,HttpStatus.OK);
			
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/baikiemtras")
	public ResponseEntity<BaiKiemTraDTO> addBaiKiemTra(@RequestBody BaiKiemTraDTO baiKiemTraDTO) {
		if(baiKiemTraDTO != null && baiKiemTraDTO.getLop() != null)
		{
			baiKiemTraService.save(baiKiemTraDTO);
			return new ResponseEntity<>(baiKiemTraDTO, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	@PutMapping("/baikiemtras/{id}")
	public ResponseEntity<BaiKiemTraDTO> updateBaiKiemTra(@RequestBody BaiKiemTraDTO baiKiemTraDTO,@PathVariable("id") Integer id) {
		BaiKiemTraDTO _baiKiemTraDTO = baiKiemTraService.getBaiKiemTra(id);
		if(_baiKiemTraDTO!= null && baiKiemTraDTO.getLop() != null)
		{
			baiKiemTraService.save(baiKiemTraDTO);
			return new ResponseEntity<>(baiKiemTraDTO,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	@DeleteMapping("/baikiemtras/{id}")
	public ResponseEntity<HttpStatus> deleteBaiKiemTra(@PathVariable("id") Integer id){
		BaiKiemTraDTO _baiKiemTraDTO= baiKiemTraService.getBaiKiemTra(id);
		if (_baiKiemTraDTO!= null) {
			baiKiemTraService.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
			
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
	}

}
