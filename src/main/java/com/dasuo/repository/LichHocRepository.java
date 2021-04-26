package com.dasuo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dasuo.entity.LichHoc;

@Repository
public interface LichHocRepository extends JpaRepository<LichHoc, Integer>{

}
