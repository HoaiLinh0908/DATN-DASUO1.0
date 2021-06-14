package com.dasuo.api;

import java.util.Date;

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
import com.dasuo.dto.BaiDangDTO;
import com.dasuo.dto.LichSuGiaoDichDTO;
import com.dasuo.dto.LopDTO;
import com.dasuo.dto.TaiKhoanDTO;
import com.dasuo.service.IBaiDangService;
import com.dasuo.service.ILichSuGiaoDichService;
import com.dasuo.service.ILopService;
import com.dasuo.service.ITaiKhoanService;

@RestController
@RequestMapping("/api")
public class LopAPI {
	@Autowired
	ILopService lopService;
	@Autowired
	ITaiKhoanService taiKhoanService;
	@Autowired
	IBaiDangService baiDangService;
	@Autowired
	ILichSuGiaoDichService lichSuGiaoDichService;
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
	public ResponseEntity<LopOutput> getLopByNguoiHoc(@PathVariable("id") Integer id,
												@RequestParam("page") int page,@RequestParam("limit") int limit){
		LopOutput lopOutput = new LopOutput();
		Pageable pageable = PageRequest.of(page-1, limit);
		lopOutput.setPage(page);
		lopOutput.setLopDTO(lopService.getLopByNguoiHoc(id, pageable));
		lopOutput.setTotalPage(lopService.countByNguoiHoc(id, limit));
			return new ResponseEntity<>(lopOutput,HttpStatus.OK);
	}
	
	@GetMapping("/lopstheonguoiday/{id}")
	public ResponseEntity<LopOutput> getLopByNguoiDay(@PathVariable("id") Integer id,
												@RequestParam("page") int page,@RequestParam("limit") int limit){
		LopOutput lopOutput = new LopOutput();
		Pageable pageable = PageRequest.of(page-1, limit);
		lopOutput.setPage(page);
		lopOutput.setLopDTO(lopService.getLopByNguoiDay(id, pageable));
		lopOutput.setTotalPage(lopService.countByNguoiDay(id, limit));
			return new ResponseEntity<>(lopOutput,HttpStatus.OK);
	}
	
	@GetMapping("/lops/{id}")
	public ResponseEntity<LopDTO> getLop(@PathVariable("id") Integer id){
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
		TaiKhoanDTO taiKhoanDTONguoiHoc = taiKhoanService.getTaiKhoan(lopDTO.getNguoiHoc().getTaiKhoan_Id());
		TaiKhoanDTO taiKhoanDTONguoiDay = taiKhoanService.getTaiKhoan(lopDTO.getNguoiDay().getTaiKhoan_Id());
		BaiDangDTO baiDangDTO = baiDangService.getBaiDang(lopDTO.getBaiDangId());
		Double tongTien = baiDangDTO.getHocPhi() * baiDangDTO.getSoBuoi() * 3;
		if(taiKhoanDTONguoiHoc.getSoDu() < tongTien)
		{
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
		else {
			if(lopDTO != null && lopDTO.getNguoiDay() != null && lopDTO.getNguoiHoc() != null && lopDTO.getNguoiDay().getTaiKhoan_Id() != null)
			{
				Double tienNguoiHocConLai = taiKhoanDTONguoiHoc.getSoDu() - tongTien;
				taiKhoanDTONguoiDay.setSoDu(tongTien*80/100);
				LichSuGiaoDichDTO lichSuGiaoDichNguoiDay = new LichSuGiaoDichDTO();
				lichSuGiaoDichNguoiDay.setNoiDung("cộng tiền dạy");
				lichSuGiaoDichNguoiDay.setSoTien(tongTien*80/100);
				lichSuGiaoDichNguoiDay.setTaiKhoan(taiKhoanDTONguoiDay);
				lichSuGiaoDichNguoiDay.setThoiGian(new Date());
				taiKhoanService.save(taiKhoanDTONguoiDay);
				lichSuGiaoDichService.save(lichSuGiaoDichNguoiDay);
				
				taiKhoanDTONguoiHoc.setSoDu(tienNguoiHocConLai);
				LichSuGiaoDichDTO lichSuGiaoDichNguoiHoc = new LichSuGiaoDichDTO();
				lichSuGiaoDichNguoiHoc.setNoiDung("trừ tiền học");
				lichSuGiaoDichNguoiHoc.setSoTien(-tongTien);
				lichSuGiaoDichNguoiHoc.setTaiKhoan(taiKhoanDTONguoiHoc);
				lichSuGiaoDichNguoiHoc.setThoiGian(new Date());
				taiKhoanService.save(taiKhoanDTONguoiHoc);
				lichSuGiaoDichService.save(lichSuGiaoDichNguoiHoc);
				
				lopService.save(lopDTO);
				return new ResponseEntity<>(lopDTO, HttpStatus.OK);
			}
			else {
				return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
			}
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
	
	@PutMapping("/taoroom/{id}")
	public ResponseEntity<LopDTO> taoRoom(@RequestBody String roomID,@PathVariable("id") Integer id) {
		if(roomID != null && roomID != "")
		{
			return new ResponseEntity<>(lopService.taoRoom(id, roomID),HttpStatus.OK);
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
