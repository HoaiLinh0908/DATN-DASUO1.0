package com.dasuo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dasuo.entity.BaiLam;

@Repository
public interface BaiLamRepository extends JpaRepository<BaiLam, Integer>{

}
