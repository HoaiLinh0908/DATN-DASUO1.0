package com.dasuo.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dasuo.dto.BaiKiemTraDTO;
import com.dasuo.dto.BaiLamDTO;
import com.dasuo.entity.BaiLam;

@Component
public class BaiLamConverter {
	@Autowired
	BaiKiemTraConverter baiKiemTraConverter;
	
	public BaiLamDTO toDTO (BaiLam baiLam) {
		BaiLamDTO baiLamDTO = new BaiLamDTO();
		baiLamDTO.setBaiLam_Id(baiLam.getBaiLam_Id());
		baiLamDTO.setNoiDung(baiLam.getNoiDung());
		baiLamDTO.setThoiGian(baiLam.getThoiGian());
		BaiKiemTraDTO baiKiemTraDTO = baiKiemTraConverter.toDTO(baiLam.getBaiKiemTra());
		baiLamDTO.setBaiKiemTra(baiKiemTraDTO);
		return baiLamDTO;
	}
	
	public BaiLam toEntity(BaiLamDTO baiLamDTO) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(baiLamDTO, BaiLam.class);
	}
	

}
