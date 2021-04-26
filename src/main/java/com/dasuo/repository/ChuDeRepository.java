package com.dasuo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dasuo.entity.ChuDe;

@Repository
public interface ChuDeRepository extends JpaRepository<ChuDe, Integer>{

}
