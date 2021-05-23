package com.dasuo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dasuo.entity.BaiKiemTra;
import com.dasuo.entity.BaiLam;
import com.dasuo.entity.Lop;

@Repository
public interface BaiLamRepository extends JpaRepository<BaiLam, Integer>{
	List<BaiLam> findByBaiKiemTra(BaiKiemTra baiKiemTra);
}
