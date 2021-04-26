package com.dasuo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dasuo.entity.TinhThanh;

@Repository
public interface TinhThanhRepository extends JpaRepository<TinhThanh, Integer>{

}
