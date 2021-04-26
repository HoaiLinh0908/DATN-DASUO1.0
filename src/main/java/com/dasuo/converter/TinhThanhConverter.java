package com.dasuo.converter;

import org.springframework.stereotype.Component;

import com.dasuo.dto.TinhThanhDTO;
import com.dasuo.entity.TinhThanh;

@Component
public class TinhThanhConverter {
	public TinhThanhDTO toDTO (TinhThanh tinhThanh) {
		TinhThanhDTO tinhThanhDTO = new TinhThanhDTO();
		tinhThanhDTO.setTinh_Id(tinhThanh.getTinh_Id());
		tinhThanhDTO.setTenTinh(tinhThanh.getTenTinh());
		tinhThanhDTO.setTaikhoan(null);
		return tinhThanhDTO;
	}
	
	public TinhThanh toEntity (TinhThanhDTO tinhThanhDTO) {
		TinhThanh tinhThanh = new TinhThanh();
		tinhThanh.setTinh_Id(tinhThanhDTO.getTinh_Id());
		tinhThanh.setTenTinh(tinhThanhDTO.getTenTinh());
		return tinhThanh;
	}

}
