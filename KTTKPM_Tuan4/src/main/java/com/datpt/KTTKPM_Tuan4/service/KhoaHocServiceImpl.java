package com.datpt.KTTKPM_Tuan4.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.datpt.KTTKPM_Tuan4.entity.KhoaHoc;
import com.datpt.KTTKPM_Tuan4.repository.KhoaHocRepository;

@Service
public class KhoaHocServiceImpl implements KhoaHocService{

	@Autowired private KhoaHocRepository khoaHocRepository;
	
	@Override
	public List<KhoaHoc> getAllKhoaHoc() {
		return (List<KhoaHoc>) khoaHocRepository.findAll();
	}

	@Override
	public KhoaHoc saveKhoaHoc(KhoaHoc khoahoc) {
		return khoaHocRepository.save(khoahoc);
		
	}

	@Override
	public void deleteKhoaHoc(Long id) {
		khoaHocRepository.deleteById(id);
		
	}

	@Override
	public Optional<KhoaHoc> findKhoaHocById(Long id) {
		return khoaHocRepository.findById(id);
	}

}
