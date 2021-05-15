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

import com.dasuo.dto.LichHocDTO;
import com.dasuo.service.ILichHocService;

@RestController
@RequestMapping("/api")
public class LichHocAPI {
	@Autowired
	ILichHocService lichHocService;
	@GetMapping("/lichhocs")
	public ResponseEntity<List<LichHocDTO>> getListLichHocs (){
		List<LichHocDTO> lichHocDTOs = lichHocService.getListLichHoc();
		if(lichHocDTOs!=null)
		{
			return new ResponseEntity<>(lichHocDTOs,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/lichhocs/{id}")
	public ResponseEntity<LichHocDTO> getLichHoc(@PathVariable("id") Integer id){
		LichHocDTO lichHocDTO = lichHocService.getLichHoc(id);
		if (lichHocDTO!=null) {
			return new ResponseEntity<>(lichHocDTO,HttpStatus.OK);
			
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/lichhocs")
	public ResponseEntity<LichHocDTO> addLichHoc(@RequestBody LichHocDTO lichHocDTO) {
		if(lichHocDTO != null && lichHocDTO.getLop() != null)
		{
			lichHocService.save(lichHocDTO);
			return new ResponseEntity<>(lichHocDTO, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	@PutMapping("/lichhocs/{id}")
	public ResponseEntity<LichHocDTO> updateLichHoc(@RequestBody LichHocDTO lichHocDTO,@PathVariable("id") Integer id) {
		LichHocDTO _lichHocDTO = lichHocService.getLichHoc(id);
		if(_lichHocDTO!= null )
		{
			if(lichHocDTO.getLop() == null)
				lichHocDTO.setLop(_lichHocDTO.getLop());
			if(lichHocDTO.getThoiGianBatDau() == null)
				lichHocDTO.setThoiGianBatDau(_lichHocDTO.getThoiGianBatDau());
			if(lichHocDTO.getThoiGianKetThuc()==null)
				lichHocDTO.setThoiGianKetThuc(_lichHocDTO.getThoiGianKetThuc());
			if(lichHocDTO.getLichHoc_Id()==null)
				lichHocDTO.setLichHoc_Id(_lichHocDTO.getLichHoc_Id());
			if(lichHocDTO.getIdZoom()==null)
				lichHocDTO.setIdZoom(_lichHocDTO.getIdZoom());
			if(lichHocDTO.getMatKhauZoom()==null)
				lichHocDTO.setMatKhauZoom(_lichHocDTO.getMatKhauZoom());
			if(lichHocDTO.getLinkZoom()==null)
				lichHocDTO.setLinkZoom(_lichHocDTO.getLinkZoom());
			lichHocService.save(lichHocDTO);
			return new ResponseEntity<>(lichHocDTO,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	@DeleteMapping("/lichhocs/{id}")
	public ResponseEntity<HttpStatus> deleteLichHoc(@PathVariable("id") Integer id){
		LichHocDTO _lichHocDTO= lichHocService.getLichHoc(id);
		if (_lichHocDTO!= null) {
			lichHocService.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
			
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
	}

}
