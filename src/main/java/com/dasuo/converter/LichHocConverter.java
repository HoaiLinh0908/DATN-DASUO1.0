package com.dasuo.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dasuo.dto.LichHocDTO;
import com.dasuo.dto.LopDTO;
import com.dasuo.entity.LichHoc;
@Component
public class LichHocConverter {
	@Autowired
	LopConverter lopConverter;
	
	public LichHocDTO toDTO (LichHoc lichHoc) {
		LichHocDTO lichHocDTO = new LichHocDTO();
		lichHocDTO.setLichHoc_Id(lichHoc.getLichHoc_Id());
		lichHocDTO.setThoiGianBatDau(lichHoc.getThoiGianBatDau().toString());
		lichHocDTO.setThoiGianKetThuc(lichHoc.getThoiGianKetThuc().toString());
		lichHocDTO.setIdZoom(lichHoc.getIdZoom());
		lichHocDTO.setMatKhauZoom(lichHoc.getMatKhauZoom());
		lichHocDTO.setLinkZoom(lichHoc.getLinkZoom());
		LopDTO lopDTO = lopConverter.toDTO(lichHoc.getLop());
		lichHocDTO.setLop(lopDTO);
		return lichHocDTO;
	}
	
	public LichHoc toEntity (LichHocDTO lichHocDTO) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(lichHocDTO, LichHoc.class);
	}

}
