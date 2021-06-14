package com.dasuo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dasuo.entity.PhanHoi;

@Repository
public interface PhanHoiRepository extends JpaRepository<PhanHoi, Integer> {

}
