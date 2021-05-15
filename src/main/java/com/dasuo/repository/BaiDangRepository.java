package com.dasuo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dasuo.entity.BaiDang;
import com.dasuo.entity.TaiKhoan;

@Repository
public interface BaiDangRepository extends JpaRepository<BaiDang, Integer>{
	List<BaiDang> findByTaiKhoan(TaiKhoan taiKhoan);
}
