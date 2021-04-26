package com.dasuo.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dasuo.dto.BaiKiemTraDTO;
import com.dasuo.dto.LopDTO;
import com.dasuo.entity.BaiKiemTra;

@Component
public class BaiKiemTraConverter {
	@Autowired 
	LopConverter lopConverter;
	public BaiKiemTraDTO toDTO (BaiKiemTra baiKiemTra) {
		BaiKiemTraDTO baiKiemTraDTO = new BaiKiemTraDTO();
		baiKiemTraDTO.setBaiKiemTra_Id(baiKiemTra.getBaiKiemTra_Id());
		baiKiemTraDTO.setNoiDung(baiKiemTra.getNoiDung());
		baiKiemTraDTO.setThoiGianBatDau(baiKiemTra.getThoiGianBatDau());
		baiKiemTraDTO.setThoiGianNop(baiKiemTra.getThoiGianNop());
		baiKiemTraDTO.setBaiLam(null);
		LopDTO lopDTO = lopConverter.toDTO(baiKiemTra.getLop());
		baiKiemTraDTO.setLop(lopDTO);
		return baiKiemTraDTO;
	}
	
	public BaiKiemTra totEntity (BaiKiemTraDTO baiKiemTraDTO) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(baiKiemTraDTO, BaiKiemTra.class);
	}

}
