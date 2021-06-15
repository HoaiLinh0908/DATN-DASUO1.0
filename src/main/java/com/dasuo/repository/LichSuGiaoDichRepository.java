package com.dasuo.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dasuo.entity.LichSuGiaoDich;
import com.dasuo.entity.TaiKhoan;

public interface LichSuGiaoDichRepository extends JpaRepository<LichSuGiaoDich, Integer>{
	List<LichSuGiaoDich> findByTaiKhoan(TaiKhoan taiKhoan);
	@Query(value="SELECT count(1) FROM dasuo.lichsugiaodich where tai_khoan_id=?1;"
			,nativeQuery=true)
	int countByTaiKhoan(Integer id);
	
	List<LichSuGiaoDich> findByTaiKhoan(TaiKhoan taiKhoan,Pageable pageable);
	

}
