package com.datpt.KTTKPM_Tuan4.service;

import java.util.List;
import java.util.Optional;

import com.datpt.KTTKPM_Tuan4.entity.KhoaHoc;

public interface KhoaHocService {

	List<KhoaHoc> getAllKhoaHoc();
	
	KhoaHoc saveKhoaHoc(KhoaHoc khoahoc);
	
	void deleteKhoaHoc(Long id);
	
	Optional<KhoaHoc> findKhoaHocById(Long id);
}
