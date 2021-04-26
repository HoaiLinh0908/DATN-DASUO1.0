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
import com.dasuo.dto.MonDTO;
import com.dasuo.service.IMonService;

@RestController
@RequestMapping("/api")
public class MonAPI {
	
	@Autowired
	IMonService monService;
	
	@GetMapping("/mon")
	public ResponseEntity<List<MonDTO>> getListMon(){
		List<MonDTO> monDTOs = monService.getListMon();
		if(monDTOs != null) {
			return new ResponseEntity<>(monDTOs,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/mon/{id}")
	public ResponseEntity<MonDTO> getMon(@PathVariable("id") Integer id){
		MonDTO monDTO = monService.getMon(id);
		if(monDTO != null) {
			return new ResponseEntity<>(monDTO,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/mon")
	public ResponseEntity<MonDTO> addMon(@RequestBody MonDTO momDTO){
		if(momDTO != null)
		{
			monService.save(momDTO);
			return new ResponseEntity<>(momDTO,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
		
	}
	
	@PutMapping("/mon/{id}")
	public ResponseEntity<MonDTO> updateMon(@RequestBody MonDTO momDTO,@PathVariable("id") Integer id){
		MonDTO _monDTO = monService.getMon(id);
		if(_monDTO!= null)
		{
			monService.save(momDTO);
			return new ResponseEntity<>(momDTO,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	@DeleteMapping("/mon/{id}")
	public ResponseEntity<HttpStatus> deleteMon(@PathVariable int id) {
		try {
			monService.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
	}

}
