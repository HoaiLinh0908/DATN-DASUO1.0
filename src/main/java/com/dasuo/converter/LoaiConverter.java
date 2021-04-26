package com.dasuo.converter;

import org.springframework.stereotype.Component;

import com.dasuo.dto.LoaiDTO;
import com.dasuo.entity.Loai;

@Component
public class LoaiConverter {
	public LoaiDTO toDTO(Loai loai) {
		LoaiDTO loaiDTO = new LoaiDTO();
		loaiDTO.setLoai_Id(loai.getLoai_Id());
		loaiDTO.setTenLoai(loai.getTenLoai());
		loaiDTO.setTaiKhoan(null);
		return loaiDTO;
	}

}
