package com.dasuo.api;

import java.io.IOException;
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
import org.springframework.web.multipart.MultipartFile;

import com.dasuo.api.output.BaiDangOutput;
import com.dasuo.api.output.TaiKhoanOutput;
import com.dasuo.dto.TaiKhoanDTO;
import com.dasuo.service.ITaiKhoanService;
import com.dasuo.service.impl.UploadFile;

@RestController
@RequestMapping("/api")
public class TaiKhoanAPI {
	@Autowired
	UploadFile uploadFile;
	@Autowired
	ITaiKhoanService taiKhoanService;

	@GetMapping("/taikhoans")
	public ResponseEntity<TaiKhoanOutput> getListTaiKhoan(@RequestParam("page") int page,@RequestParam("limit") int limit) {
		TaiKhoanOutput taiKhoanOutput = new TaiKhoanOutput();
		Pageable pageable = PageRequest.of(page-1, limit);
		taiKhoanOutput.setPage(page);
		taiKhoanOutput.setTaiKhoanDTO(taiKhoanService.getListTaiKhoan(pageable));
		taiKhoanOutput.setTotalPage(taiKhoanService.getTotalPage(limit));
			return new ResponseEntity<>(taiKhoanOutput,HttpStatus.OK);
	}

	@GetMapping("/timtaikhoans/{id}")
	public ResponseEntity<List<TaiKhoanDTO>> getTimListGS(@PathVariable("id") String id) {
		List<TaiKhoanDTO> _taiKhoans = taiKhoanService.getTimListTaiKhoan(id);
		if (_taiKhoans != null) {
			return new ResponseEntity<>(_taiKhoans, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/taikhoanuutus")
	public ResponseEntity<List<TaiKhoanDTO>> getListTaiKhoanUuTu() {
		List<TaiKhoanDTO> _taiKhoans = taiKhoanService.getListGSNoiBat();
		if (_taiKhoans != null) {
			return new ResponseEntity<>(_taiKhoans, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/taikhoans/{id}")
	public ResponseEntity<TaiKhoanDTO> getTaiKhoan(@PathVariable("id") Integer id) {
		TaiKhoanDTO _taiKhoan = taiKhoanService.getTaiKhoan(id);
		if (_taiKhoan != null) {
			return new ResponseEntity<>(_taiKhoan, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/taikhoans")
	public ResponseEntity<TaiKhoanDTO> addTaiKhoan(@RequestBody TaiKhoanDTO taiKhoanDTO) {
		if (taiKhoanDTO.getSdt() != "" && taiKhoanDTO.getMatKhau() != "" && taiKhoanDTO.getEmail() != ""
				&& taiKhoanDTO.getHoTen() != "" && taiKhoanDTO.getLoai() != null
				&& taiKhoanDTO.getNgheNghiep() != null) {
			taiKhoanService.save(taiKhoanDTO);
			return new ResponseEntity<>(taiKhoanDTO, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@PutMapping("/taikhoans/{id}")
	public ResponseEntity<TaiKhoanDTO> updateTaiKhoan(@RequestBody TaiKhoanDTO taiKhoanDTO,@PathVariable("id") Integer id){
		TaiKhoanDTO _taiKhoanDTO = taiKhoanService.getTaiKhoan(id);
		if(_taiKhoanDTO != null)
		{
			if(taiKhoanDTO.getLoai()==null)
			{
				taiKhoanDTO.setLoai(_taiKhoanDTO.getLoai());
			}
			if(taiKhoanDTO.getNgheNghiep()==null)
			{
				taiKhoanDTO.setNgheNghiep(_taiKhoanDTO.getNgheNghiep());
			}
			if(taiKhoanDTO.getTinhThanh()==null)
			{
				taiKhoanDTO.setTinhThanh(_taiKhoanDTO.getTinhThanh());
			}
			if(taiKhoanDTO.getHoTen()==null)
			{
				taiKhoanDTO.setHoTen(_taiKhoanDTO.getHoTen());
			}
			if(taiKhoanDTO.getSdt()==null) 
			{
				taiKhoanDTO.setSdt(_taiKhoanDTO.getSdt());
			} 
			if(taiKhoanDTO.getEmail()==null) 
			{
				taiKhoanDTO.setEmail(_taiKhoanDTO.getEmail());
			}
					
			if(taiKhoanDTO.getMatKhau()==null)
			{
				taiKhoanDTO.setMatKhau(_taiKhoanDTO.getMatKhau());
			}
			if(taiKhoanDTO.isGioiTinh()==null)
			{
				taiKhoanDTO.setGioiTinh(_taiKhoanDTO.isGioiTinh());
			}
			if(taiKhoanDTO.getHinhDaiDien()==null)
			{
				taiKhoanDTO.setHinhDaiDien(_taiKhoanDTO.getHinhDaiDien());
			}
			if(taiKhoanDTO.getMoTa()==null)
			{
				taiKhoanDTO.setMoTa(_taiKhoanDTO.getMoTa());
			}
			if(taiKhoanDTO.getHocPhi()==null)
			{
				taiKhoanDTO.setHocPhi(_taiKhoanDTO.getHocPhi());
			}
										
			if(taiKhoanDTO.getBangCap()==null)
			{
				taiKhoanDTO.setBangCap(_taiKhoanDTO.getBangCap());
			}
											
			if(taiKhoanDTO.getCmnd()==null)
			{
				taiKhoanDTO.setCmnd(_taiKhoanDTO.getCmnd());
			}
												
			if(taiKhoanDTO.getSoDu()==null)
			{
				taiKhoanDTO.setSoDu(_taiKhoanDTO.getSoDu());
			}
													
			if (taiKhoanDTO.getBaiDangs()==null) {
				taiKhoanDTO.setBaiDangs(_taiKhoanDTO.getBaiDangs());
															
			}			
													
			if(taiKhoanDTO.isEnable()==null)
			{
				taiKhoanDTO.setEnable(_taiKhoanDTO.isEnable());				
			}
				
			taiKhoanService.save(taiKhoanDTO);
			return new ResponseEntity<>(taiKhoanDTO,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
	}

	@DeleteMapping("/taikhoans/{id}")
	public ResponseEntity<HttpStatus> deleteTaiKhoan(@PathVariable("id") Integer id) {
		TaiKhoanDTO _taiKhoanDTO = taiKhoanService.getTaiKhoan(id);
		if (_taiKhoanDTO != null) {
			taiKhoanService.delete(id);
			;
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);

	}

	@PutMapping("/taikhoans/doimatkhau/{id}")
	public ResponseEntity<TaiKhoanDTO> DoiMatKhau(@RequestBody TaiKhoanDTO taiKhoanDTO,
			@PathVariable("id") Integer id) {
		if (taiKhoanDTO != null && id != null) {
			taiKhoanService.doiMatKhau(id, taiKhoanDTO);
			return new ResponseEntity<>(taiKhoanDTO, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
	}

	@PostMapping("/upload")
	public void uploadFile(@RequestParam("file") MultipartFile file) throws IllegalStateException, IOException {
		uploadFile.uploadFile(file);
	}
}
