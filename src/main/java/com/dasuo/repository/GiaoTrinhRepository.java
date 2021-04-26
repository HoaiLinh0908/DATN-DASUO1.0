package com.dasuo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dasuo.entity.GiaoTrinh;

@Repository
public interface GiaoTrinhRepository extends JpaRepository<GiaoTrinh, Integer>{

}
