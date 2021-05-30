package com.dasuo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dasuo.api.output.LichSuGiaoDichOutput;
import com.dasuo.dto.LichSuGiaoDichDTO;
import com.dasuo.service.ILichSuGiaoDichService;


@RestController
@RequestMapping("/api")
public class LichSuGiaoDichAPI {
	@Autowired
	ILichSuGiaoDichService lichSuGiaoDichService;
	
	@GetMapping("/lichsugiaodichs")
	public ResponseEntity<LichSuGiaoDichOutput> getListLichSuGiaoDich(@RequestParam("page") int page,@RequestParam("limit") int limit){
		LichSuGiaoDichOutput lichSuGiaoDichOutput = new LichSuGiaoDichOutput();
		Pageable pageable = PageRequest.of(page-1, limit);
		lichSuGiaoDichOutput.setPage(page);
		lichSuGiaoDichOutput.setLichSuGiaoDichs(lichSuGiaoDichService.getListLichSuGiaoDich(pageable));
		lichSuGiaoDichOutput.setTotalPage(lichSuGiaoDichService.getTotalPage(limit));
			return new ResponseEntity<>(lichSuGiaoDichOutput,HttpStatus.OK);
		
	}
	@GetMapping("/lichsugiaodichs/{id}")
	public ResponseEntity<LichSuGiaoDichDTO> getLichSuGiaoDich(@PathVariable("id") Integer id){
		LichSuGiaoDichDTO lichSuGiaoDich = lichSuGiaoDichService.getLichSuGiaoDich(id);
		if(lichSuGiaoDich!=null)
		{
			return new ResponseEntity<>(lichSuGiaoDich,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/lichsugiaodichs")
	public ResponseEntity<LichSuGiaoDichDTO> addLichSuGiaoDich(@RequestBody LichSuGiaoDichDTO lichSuGiaoDichDTO){
		if(lichSuGiaoDichDTO != null && lichSuGiaoDichDTO.getTaiKhoan() != null)
		{
			lichSuGiaoDichService.save(lichSuGiaoDichDTO);
			return new ResponseEntity<>(lichSuGiaoDichDTO,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	@PutMapping("/lichsugiaodichs/{id}")
	public ResponseEntity<LichSuGiaoDichDTO> updateLichSuGiaoDich(@RequestBody LichSuGiaoDichDTO lichSuGiaoDichDTO,@PathVariable("id") Integer id){
		LichSuGiaoDichDTO _lichSuGiaoDichDTO = lichSuGiaoDichService.getLichSuGiaoDich(id);
		if(_lichSuGiaoDichDTO != null && lichSuGiaoDichDTO.getTaiKhoan() != null)
		{
			lichSuGiaoDichService.save(lichSuGiaoDichDTO);
			return new ResponseEntity<>(lichSuGiaoDichDTO,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	@DeleteMapping("/lichsugiaodichs/{id}")
	public ResponseEntity<HttpStatus> deleteLichSuGiaoDich(@PathVariable("id") Integer id){
		LichSuGiaoDichDTO _lichSuGiaoDichDTO = lichSuGiaoDichService.getLichSuGiaoDich(id);
		if(_lichSuGiaoDichDTO != null)
		{
			lichSuGiaoDichService.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
	}

}
