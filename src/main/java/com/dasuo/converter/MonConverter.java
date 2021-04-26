package com.dasuo.converter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dasuo.dto.BaiDangDTO;
import com.dasuo.dto.LoaiDTO;
import com.dasuo.dto.MonDTO;
import com.dasuo.dto.NgheNghiepDTO;
import com.dasuo.dto.TaiKhoanDTO;
import com.dasuo.dto.TinhThanhDTO;
import com.dasuo.entity.Mon;
import com.dasuo.entity.TaiKhoan;

@Component
public class MonConverter {
	@Autowired
	BaiDangConverter baiDangConverter;
	
	
	public MonDTO toDTO(Mon mon) {
		MonDTO monDTO = new MonDTO();
		monDTO.setMon_Id(mon.getMon_Id());
		monDTO.setTenMon(mon.getTenMon());
		monDTO.setBaiDang(null);
		return monDTO;
	}
	
	public Mon toEntity(MonDTO monDTO) {
		ModelMapper modelMapper = new ModelMapper();
		Mon mon = modelMapper.map(monDTO, Mon.class);

		/*
		 * Mon mon = new Mon(); mon.setMon_Id(monDTO.getMonHoc_Id());
		 * mon.setTenMonHoc(monDTO.getTenMonHoc());
		 */
		
		return mon;
	}
	public Set<MonDTO> toMonDTO(List<Mon> listMon) {
		Set<MonDTO> listMonDTO = new HashSet<MonDTO>();
		listMon.forEach(mon -> {
			MonDTO monDTO = new MonDTO();
			monDTO.setMon_Id(mon.getMon_Id());
			monDTO.setTenMon(mon.getTenMon());
			monDTO.setBaiDang(null);
			listMonDTO.add(monDTO);
		});
		return listMonDTO;
	}

}
