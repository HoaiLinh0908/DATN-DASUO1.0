package com.dasuo.converter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dasuo.dto.LoaiDTO;
import com.dasuo.dto.MonDTO;
import com.dasuo.dto.NgheNghiepDTO;
import com.dasuo.dto.TaiKhoanDTO;
import com.dasuo.dto.TinhThanhDTO;
import com.dasuo.entity.TaiKhoan;
import com.dasuo.repository.TaiKhoanRepository;
import com.dasuo.service.ILoaiService;
import com.dasuo.service.IMonService;
import com.dasuo.service.INgheNghiepService;
import com.dasuo.service.ITinhThanhService;
import com.google.common.collect.Lists;


@Component
public class TaiKhoanConverter {
	@Autowired
	LoaiConverter loaiConverter;
	@Autowired
	NgheNghiepConverter ngheNghiepConverter;
	@Autowired
	TinhThanhConverter tinhThanhConverter;
	@Autowired
	BaiDangConverter baiDangConverter;
	@Autowired
	MonConverter monConverter;
	@Autowired
	ILoaiService loaiService;
	@Autowired
	ITinhThanhService tinhThanhService;
	@Autowired
	INgheNghiepService ngheNghiepService;
	@Autowired
	TaiKhoanRepository taiKhoanRepository;
	@Autowired
	IMonService monService;
	
	
	public TaiKhoanDTO toDTO (TaiKhoan taiKhoan) {
		TaiKhoanDTO taiKhoanDTO = new TaiKhoanDTO();
		taiKhoanDTO.setTaiKhoan_Id(taiKhoan.getTaiKhoan_Id());
		taiKhoanDTO.setMatKhau(taiKhoan.getMatKhau());
		taiKhoanDTO.setBangCap(taiKhoan.getBangCap());
		taiKhoanDTO.setCmnd(taiKhoan.getCmnd());
		taiKhoanDTO.setEmail(taiKhoan.getEmail());
		taiKhoanDTO.setGioiTinh(taiKhoan.isGioiTinh());
		taiKhoanDTO.setHinhDaiDien(taiKhoan.getHinhDaiDien());
		taiKhoanDTO.setHocPhi(taiKhoan.getHocPhi());
		taiKhoanDTO.setHoTen(taiKhoan.getHoTen());
		LoaiDTO loaiDTO = loaiConverter.toDTO(taiKhoan.getLoai());
		taiKhoanDTO.setLoai(loaiDTO);
		taiKhoanDTO.setSdt(taiKhoan.getSdt());
		TinhThanhDTO tinhthanh;
		if(taiKhoan.getTinhThanh() != null) {
			tinhthanh = tinhThanhConverter.toDTO(taiKhoan.getTinhThanh());
		}else {
			tinhthanh = null;
		}
		taiKhoanDTO.setTinhThanh(tinhthanh);
		taiKhoanDTO.setSoDu(taiKhoan.getSoDu());
		taiKhoanDTO.setMoTa(taiKhoan.getMoTa());
		taiKhoanDTO.setBaiDangs(baiDangConverter.toBaiDangDTOAsSet(Lists.newArrayList(taiKhoan.getBaiDangs())));
		taiKhoanDTO.setMons(monConverter.toMonDTO(Lists.newArrayList(taiKhoan.getMons())));
		NgheNghiepDTO nghenghiep = ngheNghiepConverter.toDTO(taiKhoan.getNgheNghiep());
		taiKhoanDTO.setNgheNghiep(nghenghiep);
		taiKhoanDTO.setEnable(taiKhoan.isEnable());
		taiKhoanDTO.setCode(taiKhoan.getCode());
		taiKhoanDTO.setBaiDang(Lists.newArrayList(baiDangConverter.toBaiDangDTO(taiKhoan.getBaiDang())));
		return taiKhoanDTO;
	}
	
	public TaiKhoan  toEntity (TaiKhoanDTO taiKhoanDTO) {
		ModelMapper modelMapper = new ModelMapper();
		TaiKhoan taiKhoan = modelMapper.map(taiKhoanDTO, TaiKhoan.class);
		return taiKhoan;
	}
	
	public Set<TaiKhoanDTO> toTaiKhoanDTO(List<TaiKhoan> listTaiKhoan) {
		Set<TaiKhoanDTO> listTaiKhoanDTO = new HashSet<TaiKhoanDTO>();
		listTaiKhoan.forEach(taiKhoan -> {
			TaiKhoanDTO taiKhoanDTO = new TaiKhoanDTO();
			taiKhoanDTO.setTaiKhoan_Id(taiKhoan.getTaiKhoan_Id());
			taiKhoanDTO.setBangCap(taiKhoan.getBangCap());
			taiKhoanDTO.setCmnd(taiKhoan.getCmnd());
			taiKhoanDTO.setEmail(taiKhoan.getEmail());
			taiKhoanDTO.setGioiTinh(taiKhoan.isGioiTinh());
			taiKhoanDTO.setHinhDaiDien(taiKhoan.getHinhDaiDien());
			taiKhoanDTO.setHocPhi(taiKhoan.getHocPhi());
			taiKhoanDTO.setHoTen(taiKhoan.getHoTen());
			LoaiDTO loaiDTO = loaiConverter.toDTO(taiKhoan.getLoai());
			taiKhoanDTO.setLoai(loaiDTO);
			taiKhoanDTO.setSdt(taiKhoan.getSdt());
			TinhThanhDTO tinhthanh;
			if(taiKhoan.getTinhThanh() != null) {
				tinhthanh = tinhThanhConverter.toDTO(taiKhoan.getTinhThanh());
			}else {
				tinhthanh = null;
			}
			taiKhoanDTO.setTinhThanh(tinhthanh);
			taiKhoanDTO.setSoDu(taiKhoan.getSoDu());
			taiKhoanDTO.setMoTa(taiKhoan.getMoTa());
			NgheNghiepDTO nghenghiep = ngheNghiepConverter.toDTO(taiKhoan.getNgheNghiep());
			taiKhoanDTO.setNgheNghiep(nghenghiep);
			listTaiKhoanDTO.add(taiKhoanDTO);
		});
		return listTaiKhoanDTO;
	}
	
	public TaiKhoanDTO toDTO (Object[] obj) {
		TaiKhoanDTO taiKhoanDTO = new TaiKhoanDTO();
		taiKhoanDTO.setTaiKhoan_Id(Integer.valueOf(String.valueOf(obj[0])));
		taiKhoanDTO.setBangCap(String.valueOf(obj[1]));
		taiKhoanDTO.setCmnd(String.valueOf(obj[2]));
		taiKhoanDTO.setEmail(String.valueOf(obj[3]));
		taiKhoanDTO.setGioiTinh(Boolean.valueOf(String.valueOf(obj[4])));
		taiKhoanDTO.setHinhDaiDien(String.valueOf(obj[5]));
		taiKhoanDTO.setHoTen(String.valueOf(obj[6]));
		taiKhoanDTO.setHocPhi(Double.valueOf(String.valueOf(obj[7])));
		taiKhoanDTO.setMoTa(String.valueOf(obj[9]));
		taiKhoanDTO.setSdt(String.valueOf(obj[10]));
		taiKhoanDTO.setSoDu(Double.valueOf(String.valueOf(obj[11])));
		LoaiDTO loaiDTO = loaiService.loai(Integer.valueOf(String.valueOf(obj[12])));
		taiKhoanDTO.setLoai(loaiDTO);
		NgheNghiepDTO nghenghiep = ngheNghiepService.getNgheNghiep(Integer.valueOf(String.valueOf(obj[13])));
		taiKhoanDTO.setNgheNghiep(nghenghiep);
		if(obj[14] != null) {
			TinhThanhDTO tinhthanh = tinhThanhService.getTinhThanh(Integer.valueOf(String.valueOf(obj[14])));
			taiKhoanDTO.setTinhThanh(tinhthanh);
		}
		
		taiKhoanDTO.setBaiDangs(null);
		List<Object[]> objs = taiKhoanRepository.taiKhoan_Mon(Integer.valueOf(String.valueOf(obj[0])));
		Set<MonDTO> mon =new HashSet<>();
		objs.forEach(taiKhoan-> mon.add(monService.getMon(Integer.valueOf(String.valueOf(taiKhoan[1])))));
		taiKhoanDTO.setMons((mon));
		
		return taiKhoanDTO;
	}
	

}
