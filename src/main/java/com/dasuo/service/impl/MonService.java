package com.dasuo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.dasuo.converter.MonConverter;
import com.dasuo.dto.MonDTO;
import com.dasuo.entity.Mon;
import com.dasuo.repository.MonRepository;
import com.dasuo.service.IMonService;

@Controller
public class MonService implements IMonService{
	
	@Autowired
	MonRepository monRepository;
	
	@Autowired
	MonConverter monConverter;

	@Override
	public List<MonDTO> getListMon() {
		List<Mon> mons = monRepository.findAll();
		List<MonDTO> monDTOs = new ArrayList<>();
		if(mons != null) {
			mons.forEach(mon -> monDTOs.add(monConverter.toDTO(mon)));
		}
		return monDTOs;
	}

	@Override
	public MonDTO getMon(int id) {
		Mon mon = monRepository.findById(id).orElse(null);
		if (mon!= null) {
			MonDTO monDTO = monConverter.toDTO(mon);
			return monDTO;
		}
		else return null;
		
	}

	@Override
	public void save(MonDTO monDTO) {
		Mon  mon = monConverter.toEntity(monDTO);
		monRepository.save(mon);
		
	}

	@Override
	public void delete(Integer id) {
		monRepository.deleteById(id);
		
	}

}
