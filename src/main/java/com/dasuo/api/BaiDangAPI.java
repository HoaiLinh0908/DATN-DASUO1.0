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

import com.dasuo.api.output.BaiDangOutput;
import com.dasuo.dto.BaiDangDTO;
import com.dasuo.service.IBaiDangService;

@RestController
@RequestMapping("/api")
public class BaiDangAPI {
	@Autowired
	IBaiDangService baiDangService;
	@GetMapping("/baidangs")
	public ResponseEntity<BaiDangOutput> getListBaiDangs (@RequestParam("page") int page,@RequestParam("limit") int limit){
		BaiDangOutput baiDangOutput = new BaiDangOutput();
		Pageable pageable = PageRequest.of(page-1, limit);
		baiDangOutput.setPage(page);
		baiDangOutput.setBaiDangDTOs(baiDangService.getListBaiDang(pageable));
		baiDangOutput.setTotalItem(baiDangService.totalItem()/limit);
			return new ResponseEntity<>(baiDangOutput,HttpStatus.OK);
	}
	
//	@GetMapping("/baidangs")
//	public ResponseEntity<List<BaiDangDTO>> getListBaiDangs (){
//		List<BaiDangDTO> baiDangDTOs = baiDangService.getListBaiDang();
//		if(baiDangDTOs!=null)
//		{
//			return new ResponseEntity<>(baiDangDTOs,HttpStatus.OK);
//		}
//		else {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
//	}
	
	@GetMapping("/baidangs/{id}")
	public ResponseEntity<BaiDangDTO> getBaiDang(@PathVariable("id") Integer id){
		BaiDangDTO baiDangDTO = baiDangService.getBaiDang(id);
		if (baiDangDTO!=null) {
			return new ResponseEntity<>(baiDangDTO,HttpStatus.OK);
			
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/baidangs")
	public ResponseEntity<BaiDangDTO> addBaiDang(@RequestBody BaiDangDTO baiDangDTO) {
		if(baiDangDTO != null && baiDangDTO.getChuDe() != null && baiDangDTO.getMon() != null && baiDangDTO.getTaiKhoan() != null)
		{
			baiDangService.save(baiDangDTO);
			return new ResponseEntity<>(baiDangDTO, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	@PutMapping("/baidangs/{id}")
	public ResponseEntity<BaiDangDTO> updateBaiDang(@RequestBody BaiDangDTO baiDangDTO,@PathVariable("id") Integer id) {
		BaiDangDTO _baiDangDTO = baiDangService.getBaiDang(id);
		if(_baiDangDTO!= null && baiDangDTO.getChuDe() != null && baiDangDTO.getMon() != null && baiDangDTO.getTaiKhoan() != null)
		{
			baiDangService.save(baiDangDTO);
			return new ResponseEntity<>(baiDangDTO,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	@DeleteMapping("/baidangs/{id}")
	public ResponseEntity<HttpStatus> deleteBaiDang(@PathVariable("id") Integer id){
		BaiDangDTO _baiDangDTO= baiDangService.getBaiDang(id);
		if (_baiDangDTO!= null) {
			baiDangService.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
			
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
	}

}
