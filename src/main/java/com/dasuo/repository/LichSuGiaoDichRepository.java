package com.dasuo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dasuo.entity.LichSuGiaoDich;
import com.dasuo.entity.TaiKhoan;

public interface LichSuGiaoDichRepository extends JpaRepository<LichSuGiaoDich, Integer>{
	List<LichSuGiaoDich> findByTaiKhoan(TaiKhoan taiKhoan);
	

}
