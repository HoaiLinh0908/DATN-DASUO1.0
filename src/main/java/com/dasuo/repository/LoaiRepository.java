package com.dasuo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dasuo.entity.Loai;
@Repository
public interface LoaiRepository extends JpaRepository<Loai, Integer>{

}
