package com.dasuo.converter;

import org.springframework.stereotype.Component;

import com.dasuo.dto.NgheNghiepDTO;
import com.dasuo.entity.NgheNghiep;

@Component
public class NgheNghiepConverter {
	public NgheNghiepDTO toDTO(NgheNghiep ngheNghiep) {
		NgheNghiepDTO ngheNghiepDTO = new NgheNghiepDTO();
		ngheNghiepDTO.setNgheNghiep_Id(ngheNghiep.getNgheNghiep_Id());
		ngheNghiepDTO.setTenNgheNghiep(ngheNghiep.getTenNgheNghiep());
		ngheNghiepDTO.setTaiKhoan(null);
		return ngheNghiepDTO;
	}
	
	public NgheNghiep toEntity (NgheNghiepDTO ngheNghiepDTO) {
		NgheNghiep ngheNghiep = new NgheNghiep();
		ngheNghiep.setNgheNghiep_Id(ngheNghiepDTO.getNgheNghiep_Id());
		ngheNghiep.setTenNgheNghiep(ngheNghiepDTO.getTenNgheNghiep());
		return ngheNghiep;
	}

}
