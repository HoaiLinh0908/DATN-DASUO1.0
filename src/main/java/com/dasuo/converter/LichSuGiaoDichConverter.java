package com.dasuo.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dasuo.dto.LichSuGiaoDichDTO;
import com.dasuo.dto.TaiKhoanDTO;
import com.dasuo.entity.LichSuGiaoDich;

@Component
public class LichSuGiaoDichConverter {
	
	@Autowired
	TaiKhoanConverter taiKhoanConverter;
	public LichSuGiaoDichDTO toDTO (LichSuGiaoDich lichSuGiaoDich) {
		LichSuGiaoDichDTO lichSuGiaoDichDTO = new LichSuGiaoDichDTO();
		lichSuGiaoDichDTO.setLichSuGiaoDich_Id(lichSuGiaoDich.getLichSuGiaoDich_Id());
		lichSuGiaoDichDTO.setNoiDung(lichSuGiaoDich.getNoiDung());
		lichSuGiaoDichDTO.setSoTien(lichSuGiaoDich.getSoTien());
		lichSuGiaoDichDTO.setThoiGian(lichSuGiaoDich.getThoiGian());
		TaiKhoanDTO taiKhoanDTO = taiKhoanConverter.toDTO(lichSuGiaoDich.getTaiKhoan());
		lichSuGiaoDichDTO.setTaiKhoan(taiKhoanDTO);
		return lichSuGiaoDichDTO;
		
	}
	
	public LichSuGiaoDich toEntity(LichSuGiaoDichDTO lichSuGiaoDichDTO) {
		ModelMapper modelMapper = new ModelMapper();
		LichSuGiaoDich lichSuGiaoDich = modelMapper.map(lichSuGiaoDichDTO, LichSuGiaoDich.class);
		return lichSuGiaoDich;
	}

}
