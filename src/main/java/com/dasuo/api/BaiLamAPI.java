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

import com.dasuo.dto.BaiLamDTO;
import com.dasuo.service.IBaiLamService;

@RestController
@RequestMapping("/api")
public class BaiLamAPI {
	@Autowired
	IBaiLamService baiLamService;
	@GetMapping("/bailams")
	public ResponseEntity<List<BaiLamDTO>> getListBaiLams (){
		List<BaiLamDTO> baiLamDTOs = baiLamService.getListBaiLam();
		if(baiLamDTOs!=null)
		{
			return new ResponseEntity<>(baiLamDTOs,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/bailams/{id}")
	public ResponseEntity<BaiLamDTO> getBaiLam(@PathVariable("id") Integer id){
		BaiLamDTO baiLamDTO = baiLamService.getBaiLam(id);
		if (baiLamDTO!=null) {
			return new ResponseEntity<>(baiLamDTO,HttpStatus.OK);
			
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/bailams")
	public ResponseEntity<BaiLamDTO> addBaiLam(@RequestBody BaiLamDTO baiLamDTO) {
		if(baiLamDTO != null && baiLamDTO.getBaiKiemTra() != null)
		{
			baiLamService.save(baiLamDTO);
			return new ResponseEntity<>(baiLamDTO, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	@PutMapping("/bailams/{id}")
	public ResponseEntity<BaiLamDTO> updateBaiLam(@RequestBody BaiLamDTO baiLamDTO,@PathVariable("id") Integer id) {
		BaiLamDTO _baiLamDTO = baiLamService.getBaiLam(id);
		if(_baiLamDTO!= null && baiLamDTO.getBaiKiemTra() != null)
		{
			baiLamService.save(baiLamDTO);
			return new ResponseEntity<>(baiLamDTO,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	@DeleteMapping("/bailams/{id}")
	public ResponseEntity<HttpStatus> deleteBaiLam(@PathVariable("id") Integer id){
		BaiLamDTO baiLamDTO= baiLamService.getBaiLam(id);
		if (baiLamDTO!= null) {
			baiLamService.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
			
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
	}

}
