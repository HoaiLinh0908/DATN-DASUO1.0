package com.dasuo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.dasuo.converter.TaiKhoanConverter;
import com.dasuo.dto.TaiKhoanDTO;
import com.dasuo.entity.TaiKhoan;
import com.dasuo.repository.TaiKhoanRepository;
import com.dasuo.service.ITaiKhoanService;

@Service
public class TaiKhoanService implements ITaiKhoanService{
	
	@Autowired
	TaiKhoanRepository taiKhoanRepository;
	
	@Autowired
	TaiKhoanConverter taiKhoanConverter;

	@Override
	public List<TaiKhoanDTO> getListTaiKhoan(Pageable pageable) {
		List<TaiKhoan> taiKhoans = taiKhoanRepository.findAll(pageable).getContent();
		List<TaiKhoanDTO> taiKhoanDTO = new ArrayList<>();
		taiKhoans.forEach(taiKhoan -> taiKhoanDTO.add(taiKhoanConverter.toDTO(taiKhoan)));
		return taiKhoanDTO;
	}

	@Override
	public TaiKhoanDTO getTaiKhoan(int id) {
		TaiKhoan taiKhoan = taiKhoanRepository.findById(id).orElse(null);
		if(taiKhoan!= null)
		{
			return taiKhoanConverter.toDTO(taiKhoan);
		}
		return null;
	}


	@Override
	public void save(TaiKhoanDTO taiKhoanDTO) {
			TaiKhoan taiKhoan = taiKhoanConverter.toEntity(taiKhoanDTO);
			taiKhoanRepository.save(taiKhoan);
		
	}

	@Override
	public void delete(Integer id) {
		taiKhoanRepository.deleteById(id);
		
	}

	@Override
	public List<TaiKhoanDTO> getListGSNoiBat() {
		List<Object[]> objs = taiKhoanRepository.taiKhoanUuTu();
		List<TaiKhoanDTO> taiKhoanDTO = new ArrayList<>();
		objs.forEach(taiKhoan -> taiKhoanDTO.add(taiKhoanConverter.toDTO(taiKhoan)));
		return taiKhoanDTO;
	}

	@Override
	public List<TaiKhoanDTO> getTimListTaiKhoan(String id) {
		List<Object[]> objs = taiKhoanRepository.timKiemGS(id);
		List<TaiKhoanDTO> taiKhoanDTO = new ArrayList<>();
		objs.forEach(taiKhoan -> taiKhoanDTO.add(taiKhoanConverter.toDTO(taiKhoan)));
		return taiKhoanDTO;
	}

	@Override
	public void doiMatKhau(int id, TaiKhoanDTO taiKhoanDTO) {
		TaiKhoan taiKhoan = taiKhoanRepository.findById(id).orElse(null);
		if(taiKhoanDTO.getMatKhauCu().equals(taiKhoan.getMatKhau()) && taiKhoanDTO.getMatKhauMoi() != null )
		{
			taiKhoan.setMatKhau(taiKhoanDTO.getMatKhauMoi());
			taiKhoanRepository.save(taiKhoan);
		}
	}

	public void updateResetPasswordToken(String token, String email) throws TaiKhoanNotFoundException {
		TaiKhoan taiKhoan = taiKhoanRepository.findByEmail(email);
		if(taiKhoan != null)
		{
			taiKhoan.setCode(token);
			taiKhoanRepository.save(taiKhoan);
			
		}
		else {
			throw new TaiKhoanNotFoundException("Could not find any customer with the email " + email);
		}
		
	}
	
	 public TaiKhoan getByResetPasswordToken(String token) {
	        return taiKhoanRepository.findByCode(token);
	    }

	public void updatePassword(String newPassword, TaiKhoan taiKhoan) {
		
			taiKhoan.setMatKhau(newPassword);
			taiKhoan.setCode(null);
			taiKhoanRepository.save(taiKhoan);
	
		
	}

	@Override
	public TaiKhoanDTO getTaiKhoan(String email) {
		
		return taiKhoanConverter.toDTO(taiKhoanRepository.findByEmail(email));
	}
	@Override
	public int getTotalPage(int limit) {
		int totalItem = (int) taiKhoanRepository.count();
		if(totalItem % limit != 0) {
			return (totalItem / limit) + 1;
		}
		return totalItem / limit;
	}

}
