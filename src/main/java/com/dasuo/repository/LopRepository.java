package com.dasuo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dasuo.entity.Lop;

public interface LopRepository extends JpaRepository<Lop, Integer>{
	
	@Query(value="SELECT count(1) FROM dasuo.lop ;"
			,nativeQuery=true)
	int countLop();

}
