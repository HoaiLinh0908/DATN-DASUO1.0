package com.dasuo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dasuo.converter.LopConverter;
import com.dasuo.dto.BaiDangDTO;
import com.dasuo.dto.LichHocDTO;
import com.dasuo.dto.LopDTO;
import com.dasuo.entity.BaiDang;
import com.dasuo.entity.Lop;
import com.dasuo.repository.BaiDangRepository;
import com.dasuo.repository.LopRepository;
import com.dasuo.repository.TaiKhoanRepository;
import com.dasuo.service.ILopService;

@Service
public class LopService implements ILopService{
	@Autowired
	LopRepository lopRepository;
	@Autowired
	LopConverter lopConverter;
	
	@Autowired
	BaiDangRepository baiDangRepository;
	@Autowired
	BaiDangService baiDangService;
	
	@Autowired
	TaiKhoanService taiKhoanService;
	@Autowired
	TaiKhoanRepository taiKhoanRepository;
	
	@Autowired
	LichHocService lichHocService;

	@Override
	@Transactional
	public List<LopDTO> getListLop(Pageable pageable) {
		List<Lop> lops = lopRepository.findAll(pageable).getContent();
		List<LopDTO> lopDTOs = new ArrayList<>();
		lops.forEach(lop -> lopDTOs.add(lopConverter.toDTO(lop)));
		return lopDTOs;
	}

	@Override
	@Transactional
	public LopDTO getLop(Integer id) {
		if(id != 0 )
		{
			Lop lop = lopRepository.findById(id).orElse(null);
			return lopConverter.toDTO(lop);
		}
		else {
			return null;
		}
	}

	@Override
	public void save(LopDTO lopDTO) {
		BaiDangDTO baiDangDTO = baiDangService.getBaiDang(lopDTO.getBaiDangId());
		lopDTO.setTenLop("Lop" + lopDTO.getNguoiDay().getTaiKhoan_Id() + "-" + lopDTO.getNguoiHoc().getTaiKhoan_Id());
		lopDTO.setTienHoc(baiDangDTO.getHocPhi());
		Lop lop = lopRepository.save(lopConverter.toEntity(lopDTO));
		
		//Tao lich hoc
		int soBuoi = baiDangDTO.getBuois().size();
		LichHocDTO lich;
		LopDTO lopDTO2 = new LopDTO();
		for(int i=1; i<=soBuoi*4; i++) {
			lich = new LichHocDTO();
			lich.setThoiGianBatDau("2021-04-03 00:00:00");
			lich.setThoiGianKetThuc("2021-04-03 02:00:00");
			lopDTO2.setLop_Id(lop.getLop_Id());
			lich.setLop(lopDTO2);
			lich.setIdZoom(1);
			lich.setLinkZoom("link");
			lich.setMatKhauZoom(33333);
			lichHocService.save(lich);
		}
		BaiDang bd = baiDangRepository.findById(baiDangDTO.getBaiDang_Id()).orElse(null);
		bd.setEnable(false);
		baiDangRepository.save(bd);
	}

	@Override
	public void delete(Integer id) {
		lopRepository.deleteById(id);
		
	}
	@Override
	public int getTotalPage(int limit) {
		int totalItem = (int) lopRepository.count();
		if(totalItem % limit != 0) {
			return (totalItem / limit) + 1;
		}
		return totalItem / limit;
	}

	@Override
	public List<LopDTO> getLopByNguoiHoc(Integer nguoiHocId) {
		if(nguoiHocId != 0 )
		{
			List<Lop> lops = lopRepository.findByNguoiHoc(nguoiHocId);
			List<LopDTO> lopDTOs = lops.stream().map(l -> lopConverter.toDTO(l)).collect(Collectors.toList());
			return lopDTOs;
		}
		else {
			return null;
		}
	}
}
