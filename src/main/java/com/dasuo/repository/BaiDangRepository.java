package com.dasuo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dasuo.entity.BaiDang;

@Repository
public interface BaiDangRepository extends JpaRepository<BaiDang, Integer>{

}
