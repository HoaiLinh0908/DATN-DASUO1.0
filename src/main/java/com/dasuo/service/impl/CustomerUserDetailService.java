
package com.dasuo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.dasuo.converter.LoaiConverter;
import com.dasuo.dto.MyUser;
import com.dasuo.entity.TaiKhoan;
import com.dasuo.repository.TaiKhoanRepository;

@Service
public class CustomerUserDetailService implements UserDetailsService {

	@Autowired
	TaiKhoanRepository taiKhoanRepository;
	@Autowired
	LoaiConverter loaiConverter;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		TaiKhoan taiKhoan = taiKhoanRepository.findByEmail(username);
		if (taiKhoan == null) {
			throw new UsernameNotFoundException(username);
		} else {
			List<GrantedAuthority> graList = new ArrayList<GrantedAuthority>();
			GrantedAuthority authrity = new SimpleGrantedAuthority(taiKhoan.getLoai().getTenLoai());
			graList.add(authrity);
			MyUser myUser = new MyUser(taiKhoan.getHoTen(), taiKhoan.getMatKhau(), graList);
			myUser.setEmail(taiKhoan.getEmail());
			myUser.setUser_Id(taiKhoan.getTaiKhoan_Id());
			myUser.setHinhDaiDien(taiKhoan.getHinhDaiDien());
			myUser.setMoTa(taiKhoan.getMoTa());
			myUser.setLoai(loaiConverter.toDTO(taiKhoan.getLoai()));
			return myUser;
		}

	}

}
