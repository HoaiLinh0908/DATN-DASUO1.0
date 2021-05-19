package com.dasuo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dasuo.entity.GiaoTrinh;
import com.dasuo.entity.Lop;

@Repository
public interface GiaoTrinhRepository extends JpaRepository<GiaoTrinh, Integer>{
	List<GiaoTrinh> findByLop(Lop lop);

}
