package com.dasuo.converter;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dasuo.dto.BaiDangDTO;
import com.dasuo.dto.ChuDeDTO;
import com.dasuo.dto.MonDTO;
import com.dasuo.dto.TaiKhoanDTO;
import com.dasuo.entity.BaiDang;
import com.dasuo.entity.TaiKhoan;
import com.dasuo.repository.TaiKhoanRepository;
import com.dasuo.service.IChuDeService;
import com.dasuo.service.IMonService;
import com.dasuo.service.ITaiKhoanService;
import com.google.common.collect.Lists;

@Component
public class BaiDangConverter {
	@Autowired
	ChuDeConverter chuDeConverter;
	@Autowired
	MonConverter monConverter;
	@Autowired
	IChuDeService chuDeService;
	@Autowired
	IMonService monService;
	@Autowired
	TaiKhoanRepository taiKhoanRepository;
	@Autowired
	ITaiKhoanService taiKhoanService;
	
	@Autowired
	TaiKhoanConverter taiKhoanConverter;
	
	public BaiDangDTO toDTO (BaiDang baiDang) {
		BaiDangDTO baiDangDTO = new BaiDangDTO();
		baiDangDTO.setBaiDang_Id(baiDang.getBaiDang_Id());
		baiDangDTO.setGioiTinh(baiDang.isGioiTinh());
		baiDangDTO.setHocPhi(baiDang.getHocPhi());
		baiDangDTO.setMoTa(baiDang.getMoTa());
		baiDangDTO.setNgayBatDau(baiDang.getNgayBatDau());
		baiDangDTO.setSdt(baiDang.getSdt());
		baiDangDTO.setSoBuoi(baiDang.getSoBuoi());
		baiDangDTO.setTomTatYeuCau(baiDang.getTomTatYeuCau());
		baiDangDTO.setThoiGianDayTheoThang(baiDang.getThoiGianDayTheoThang());
		baiDangDTO.setTaiKhoans(taiKhoanConverter.toTaiKhoanDTO(Lists.newArrayList(baiDang.getTaiKhoans())));
		ChuDeDTO chuDeDTO = chuDeConverter.toDTO(baiDang.getChuDe());
		baiDangDTO.setChuDe(chuDeDTO);
		MonDTO monDTO = monConverter.toDTO(baiDang.getMon());
		baiDangDTO.setMon(monDTO);
		TaiKhoanDTO taiKhoanDTO = taiKhoanConverter.toDTO(baiDang.getTaiKhoan());
		baiDangDTO.setTaiKhoan(taiKhoanDTO);
		return baiDangDTO;
	}
	
	public BaiDang toEntity (BaiDangDTO baiDangDTO) {
		ModelMapper modelMapper = new ModelMapper();
		BaiDang baiDang =modelMapper.map(baiDangDTO, BaiDang.class);
		Set<TaiKhoan> taiKhoans = new HashSet<TaiKhoan>();
		if (baiDangDTO.getTaiKhoans() != null && baiDangDTO.getTaiKhoans().size() > 0) {
			baiDangDTO.getTaiKhoans().forEach(taiKhoan_Id -> taiKhoans.add(taiKhoanRepository.findById(Integer.valueOf(taiKhoan_Id.getTaiKhoan_Id())).orElse(null)));
		} else {
			// if null set role default for user is ROLE_STAFF
			taiKhoans.add(null);
		}
		baiDang.setTaiKhoans(taiKhoans);
		return baiDang;
	}
	
	public Set<BaiDangDTO> toBaiDangDTO(List<BaiDang> listBaiDang) {
		Set<BaiDangDTO> listBaiDangDTO = new HashSet<BaiDangDTO>();
		listBaiDang.forEach(baiDang -> {
			BaiDangDTO baiDangDTO = new BaiDangDTO();
			baiDangDTO.setBaiDang_Id(baiDang.getBaiDang_Id());
			baiDangDTO.setGioiTinh(baiDang.isGioiTinh());
			baiDangDTO.setHocPhi(baiDang.getHocPhi());
			baiDangDTO.setMoTa(baiDang.getMoTa());
			baiDangDTO.setNgayBatDau(baiDang.getNgayBatDau());
			baiDangDTO.setSdt(baiDang.getSdt());
			baiDangDTO.setSoBuoi(baiDang.getSoBuoi());
			baiDangDTO.setTomTatYeuCau(baiDang.getTomTatYeuCau());
			baiDangDTO.setThoiGianDayTheoThang(baiDang.getThoiGianDayTheoThang());
			ChuDeDTO chuDeDTO = chuDeConverter.toDTO(baiDang.getChuDe());
			baiDangDTO.setChuDe(chuDeDTO);
			MonDTO monDTO = monConverter.toDTO(baiDang.getMon());
			baiDangDTO.setMon(monDTO);
			listBaiDangDTO.add(baiDangDTO);
		});
		return listBaiDangDTO;
	}
	
	public BaiDangDTO toDTO(Object[] obj) {
		BaiDangDTO baiDangDTO = new BaiDangDTO();
		baiDangDTO.setBaiDang_Id(Integer.valueOf(String.valueOf(obj[0])));
		baiDangDTO.setGioiTinh(Boolean.valueOf(String.valueOf(obj[1])));
		baiDangDTO.setHocPhi(Double.valueOf(String.valueOf(obj[2])));
		baiDangDTO.setMoTa(String.valueOf(obj[3]));
		baiDangDTO.setNgayBatDau((Date) obj[4]);
		baiDangDTO.setSdt(String.valueOf(obj[5]));
		baiDangDTO.setSoBuoi(Integer.valueOf(String.valueOf(obj[6])));
		baiDangDTO.setThoiGianDayTheoThang(Integer.valueOf(String.valueOf(obj[7])));
		baiDangDTO.setTomTatYeuCau(String.valueOf(obj[8]));
		ChuDeDTO chuDe = chuDeService.getChuDe(Integer.valueOf(String.valueOf(obj[9])));
		baiDangDTO.setChuDe(chuDe);
		MonDTO mon = monService.getMon(Integer.valueOf(String.valueOf(obj[10])));
		baiDangDTO.setMon(mon);
		
		return baiDangDTO;
	}


}
