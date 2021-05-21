package com.dasuo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dasuo.entity.BaiKiemTra;
import com.dasuo.entity.Lop;

public interface BaiKiemTraRepository extends JpaRepository<BaiKiemTra, Integer>{
	List<BaiKiemTra> findByLop(Lop lop);
}
