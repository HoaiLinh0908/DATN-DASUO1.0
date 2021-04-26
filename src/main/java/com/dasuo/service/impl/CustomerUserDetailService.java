/*
 * package com.dasuo.service.impl;
 * 
 * import java.util.ArrayList; import java.util.List;
 * 
 * import org.omg.CORBA.UserException; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.security.core.GrantedAuthority; import
 * org.springframework.security.core.authority.SimpleGrantedAuthority; import
 * org.springframework.security.core.userdetails.User; import
 * org.springframework.security.core.userdetails.UserDetails; import
 * org.springframework.security.core.userdetails.UserDetailsService; import
 * org.springframework.security.core.userdetails.UsernameNotFoundException;
 * import org.springframework.stereotype.Service;
 * 
 * import com.dasuo.entity.TaiKhoan; import
 * com.dasuo.repository.TaiKhoanRepository;
 * 
 * @Service public class CustomerUserDetailService implements
 * UserDetailsService{
 * 
 * @Autowired TaiKhoanRepository taiKhoanRepository;
 * 
 * @Override public UserDetails loadUserByUsername(String username) throws
 * UsernameNotFoundException { TaiKhoan taiKhoan =
 * taiKhoanRepository.findByEmail(username); if (taiKhoan == null) { throw new
 * UsernameNotFoundException(username); } else { List<GrantedAuthority> graList
 * = new ArrayList<GrantedAuthority>(); GrantedAuthority authrity = new
 * SimpleGrantedAuthority(taiKhoan.getLoai().getTenLoai());
 * graList.add(authrity); UserDetails userDetail = new User(taiKhoan.getEmail(),
 * taiKhoan.getMatKhau(), graList); return userDetail; }
 * 
 * }
 * 
 * }
 */
