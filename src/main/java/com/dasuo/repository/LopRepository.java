package com.dasuo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dasuo.entity.Lop;

public interface LopRepository extends JpaRepository<Lop, Integer>{
	
	@Query(value="SELECT count(1) FROM dasuo.lop ;"
			,nativeQuery=true)
	int countLop();
	
	@Query(value="SELECT * FROM dasuo.lop where nguoihoc_id = ?1 order by lop_id desc"
			,nativeQuery=true)
	public List<Lop> findByNguoiHoc(Integer nguoiHocID);
}
