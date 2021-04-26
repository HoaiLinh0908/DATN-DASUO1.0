package com.dasuo.converter;

import com.dasuo.dto.BuoiDTO;
import com.dasuo.entity.Buoi;

public class BuoiConverter {
	public BuoiDTO toDTO(Buoi buoi) {
		BuoiDTO buoiDTO = new BuoiDTO();
		buoiDTO.setBuoi_Id(buoi.getBuoi_Id());
		buoiDTO.setNgayTrongTuan(buoi.getNgayTrongTuan());
		return buoiDTO;
	}

}
