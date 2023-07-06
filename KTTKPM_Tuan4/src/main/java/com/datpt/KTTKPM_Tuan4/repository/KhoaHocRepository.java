package com.datpt.KTTKPM_Tuan4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.datpt.KTTKPM_Tuan4.entity.KhoaHoc;

@Repository
public interface KhoaHocRepository extends JpaRepository<KhoaHoc, Long> {

}
