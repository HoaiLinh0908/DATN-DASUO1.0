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
import com.dasuo.entity.BaiDang;
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
		baiDangOutput.setTotalPage(baiDangService.getTotalPage(limit));
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
		if(baiDangDTO.getChuDe() != null && baiDangDTO.getMon() != null)
		{
//			TaiKhoanDTO taiKhoanDTO = new TaiKhoanDTO();
//			taiKhoanDTO.setTaiKhoan_Id(SecurityUtils.getPrincipal().getUser_Id());
//			baiDangDTO.setTaiKhoan(taiKhoanDTO);
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
		if(_baiDangDTO!= null)
		{
			if(baiDangDTO.getChuDe() == null)
				baiDangDTO.setChuDe(_baiDangDTO.getChuDe());
			if(baiDangDTO.getMon() == null)
				baiDangDTO.setMon(_baiDangDTO.getMon());
			if(baiDangDTO.getTaiKhoan() == null)
				baiDangDTO.setTaiKhoan(_baiDangDTO.getTaiKhoan());
			if(baiDangDTO.getBaiDang_Id()==null)
				baiDangDTO.setBaiDang_Id(_baiDangDTO.getBaiDang_Id());
			if(baiDangDTO.getTomTatYeuCau()==null)
				baiDangDTO.setTomTatYeuCau(_baiDangDTO.getTomTatYeuCau());
			if(baiDangDTO.getHocPhi()==null)
				baiDangDTO.setHocPhi(_baiDangDTO.getHocPhi());
			if(baiDangDTO.getSdt()==null)
				baiDangDTO.setSdt(_baiDangDTO.getSdt());
			if(baiDangDTO.getMoTa()==null)
				baiDangDTO.setMoTa(_baiDangDTO.getMoTa());
			if(baiDangDTO.isGioiTinh()== null)
				baiDangDTO.setGioiTinh(_baiDangDTO.isGioiTinh());
			if(baiDangDTO.getSoBuoi()==null)
				baiDangDTO.setSoBuoi(_baiDangDTO.getSoBuoi());
			if(baiDangDTO.getNgayBatDau()==null)
				baiDangDTO.setNgayBatDau(_baiDangDTO.getNgayBatDau());
			if(baiDangDTO.getThoiGianDayTheoThang()==null)
				baiDangDTO.setThoiGianDayTheoThang(_baiDangDTO.getThoiGianDayTheoThang());
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
	
	@GetMapping("/baidangfindbytaikhoan/{id}")
	public ResponseEntity<List<BaiDangDTO>> getBaiDangFindByTaiKhoan(@PathVariable("id") Integer id){
		List<BaiDangDTO> baiDangDTO = baiDangService.getListBaiDangFindByTaiKhoan(id);
		if (baiDangDTO!=null) {
			return new ResponseEntity<>(baiDangDTO,HttpStatus.OK);
			
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
