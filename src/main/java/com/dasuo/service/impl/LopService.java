package com.dasuo.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
		lopDTO.setTenLop("Lop" + baiDangDTO.getMon().getTenMon() + lopDTO.getNguoiDay().getTaiKhoan_Id() + "-" + lopDTO.getNguoiHoc().getTaiKhoan_Id());
		lopDTO.setTienHoc(baiDangDTO.getHocPhi());
		SimpleDateFormat dtf = new SimpleDateFormat("yyyy-MM-dd");  
		Date dateNgayNhan = new Date(); 
		lopDTO.setNgayNhan(dtf.format(dateNgayNhan));
		Lop lop = lopRepository.save(lopConverter.toEntity(lopDTO));
		
		//Tao lich hoc
		Calendar c1 = Calendar.getInstance();
		Date date = baiDangDTO.getNgayBatDau();
		c1.setTime(date);
		
		int soBuoi = baiDangDTO.getBuois().size();
		LichHocDTO lich;
		LopDTO lopDTO2 = new LopDTO();
		for(int i=1; i<=soBuoi*4; i++) {
//			for(int j=1; j<=soBuoi; j++) {
//				
//			}
			lich = new LichHocDTO();
			if(i==1) {
				lich.setThoiGianBatDau(dtf.format(c1.getTime()));
				lich.setThoiGianKetThuc("2021-04-03 02:00:00");
			}
			c1.add(Calendar.DATE, 7);
			lich.setThoiGianBatDau(dtf.format(c1.getTime()));
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
	public List<LopDTO> getLopByNguoiHoc(Integer nguoiHocId, Pageable pageable) {
		if(nguoiHocId != 0 )
		{
			List<Lop> lops = lopRepository.findByNguoiHoc(nguoiHocId, pageable);
			List<LopDTO> lopDTOs = lops.stream().map(l -> lopConverter.toDTO(l)).collect(Collectors.toList());
			return lopDTOs;
		}
		else {
			return null;
		}
	}

	@Override
	public int countByNguoiHoc(Integer id, int limit) {
		int totalItem = lopRepository.countByNguoiHoc(id);
		if (totalItem % limit != 0) {
			return (totalItem / limit) + 1;
		}
		return totalItem / limit;
	}

	@Override
	public List<LopDTO> getLopByNguoiDay(Integer nguoiDayId, Pageable pageable) {
		if(nguoiDayId != 0 )
		{
			List<Lop> lops = lopRepository.findByNguoiDay(nguoiDayId, pageable);
			List<LopDTO> lopDTOs = lops.stream().map(l -> lopConverter.toDTO(l)).collect(Collectors.toList());
			return lopDTOs;
		}
		else {
			return null;
		}
	}

	@Override
	public int countByNguoiDay(Integer id, int limit) {
		int totalItem = lopRepository.countByNguoiDay(id);
		if (totalItem % limit != 0) {
			return (totalItem / limit) + 1;
		}
		return totalItem / limit;
	}

	@Override
	public LopDTO taoRoom(Integer id, String roomID) {
		Lop lop = lopRepository.findById(id).orElse(null);
		lop.setTenLop(roomID);
		return lopConverter.toDTO(lopRepository.save(lop));
	}
}
