package com.dasuo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dasuo.entity.Mon;

@Repository
public interface MonRepository extends JpaRepository<Mon, Integer>{
	@Query(value="SELECT count(1) FROM dasuo.mon ;"
			,nativeQuery=true)
	int countMon();

}
