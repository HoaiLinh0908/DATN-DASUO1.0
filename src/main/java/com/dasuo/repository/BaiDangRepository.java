package com.dasuo.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dasuo.entity.BaiDang;
import com.dasuo.entity.TaiKhoan;

@Repository
public interface BaiDangRepository extends JpaRepository<BaiDang, Integer>{
	List<BaiDang> findByTaiKhoan(TaiKhoan taiKhoan);
	@Query(value="SELECT * FROM dasuo.baidang where enable =1 order by bai_dang_id desc"
			,nativeQuery=true)
	public List<Object[]> getBaiDangs(Pageable pageable);

	Page<BaiDang> findByTaiKhoan(TaiKhoan taiKhoan, Pageable pageable);
	int countByTaiKhoan(TaiKhoan taiKhoan);
}
