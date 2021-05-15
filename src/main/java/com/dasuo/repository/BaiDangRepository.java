package com.dasuo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dasuo.entity.BaiDang;
import com.dasuo.entity.TaiKhoan;

@Repository
public interface BaiDangRepository extends JpaRepository<BaiDang, Integer>{
	Page<BaiDang> findByTaiKhoan(TaiKhoan taiKhoan, Pageable pageable);
	int countByTaiKhoan(TaiKhoan taiKhoan);
}
