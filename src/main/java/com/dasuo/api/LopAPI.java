package com.dasuo.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dasuo.api.output.LopOutput;
import com.dasuo.dto.LopDTO;
import com.dasuo.service.ILopService;

@RestController
@RequestMapping("/api")
public class LopAPI {
	@Autowired
	ILopService lopService;
	@GetMapping("/lops")
	public ResponseEntity<LopOutput> getListLops (@RequestParam("page") int page,@RequestParam("limit") int limit){
		LopOutput lopOutput = new LopOutput();
		Pageable pageable = PageRequest.of(page-1, limit);
		lopOutput.setPage(page);
		lopOutput.setLopDTO(lopService.getListLop(pageable));
		lopOutput.setTotalPage(lopService.getTotalPage(limit));
			return new ResponseEntity<>(lopOutput,HttpStatus.OK);
	}
	
	@GetMapping("/lopstheonguoihoc/{id}")
	public ResponseEntity<List<LopDTO>> getLop(@PathVariable("id") Integer id){
		 List<LopDTO> lops = lopService.getLopByNguoiHoc(id);
		if (lops != null) {
			return new ResponseEntity<>(lops,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/lops/{id}")
	public ResponseEntity<LopDTO> getLopByNguoiHoc(@PathVariable("id") Integer id){
		LopDTO lopDTO = lopService.getLop(id);
		if (lopDTO!=null) {
			return new ResponseEntity<>(lopDTO,HttpStatus.OK);
			
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/lops")
	public ResponseEntity<LopDTO> addLop(@RequestBody LopDTO lopDTO) {
		if(lopDTO != null && lopDTO.getNguoiDay() != null && lopDTO.getNguoiHoc() != null)
		{
			lopService.save(lopDTO);
			return new ResponseEntity<>(lopDTO, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	@PutMapping("/lops/{id}")
	public ResponseEntity<LopDTO> updateLop(@RequestBody LopDTO lopDTO,@PathVariable("id") Integer id) {
		LopDTO _lopDTO = lopService.getLop(id);
		if(_lopDTO!= null && lopDTO.getNguoiDay() != null && lopDTO.getNguoiHoc() != null)
		{
			lopService.save(lopDTO);
			return new ResponseEntity<>(lopDTO,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	@DeleteMapping("/lops/{id}")
	public ResponseEntity<HttpStatus> deleteLop(@PathVariable("id") Integer id){
		LopDTO lopDTO= lopService.getLop(id);
		if (lopDTO!= null) {
			lopService.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
			
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
	}

}
