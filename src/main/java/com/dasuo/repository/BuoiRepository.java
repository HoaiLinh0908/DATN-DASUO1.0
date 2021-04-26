package com.dasuo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dasuo.entity.Buoi;
@Repository
public interface BuoiRepository extends JpaRepository<Buoi, Integer>{

}
