package com.datpt.KTTKPM_Tuan4.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.datpt.KTTKPM_Tuan4.entity.KhoaHoc;
import com.datpt.KTTKPM_Tuan4.service.KhoaHocService;

@RestController
@RequestMapping("api/v1")
public class KhoaHocController {

	@Autowired
	private KhoaHocService khoaHocService;

	@GetMapping("/khoahoc")
	public List<KhoaHoc> getAllKhoaHoc() {
		return khoaHocService.getAllKhoaHoc();
	}

	@GetMapping("/khoahoc/{id}")
	public ResponseEntity<Optional<KhoaHoc>> getKhoaHoc(@PathVariable Long id) {
		Optional<KhoaHoc> khoahoc = khoaHocService.findKhoaHocById(id);
		return ResponseEntity.ok().body(khoahoc);
	}

//	@PutMapping
//	public ResponseEntity<KhoaHoc> updateKhoaHoc(@PathVariable Long id, @RequestBody KhoaHoc khoahoc){
//		Optional<KhoaHoc> khoaHocOptional = khoaHocService.findKhoaHocById(id);
//		return khoaHocOptional
//	}
	
	@PostMapping("/khoahoc")
	public KhoaHoc themKhoaHoc(@Valid @RequestBody KhoaHoc khoahoc) {
		return khoaHocService.saveKhoaHoc(khoahoc);
	}

	@DeleteMapping("/khoahoc/{id}")
	public ResponseEntity<String> xoaKhoaHoc(@PathVariable Long id) {
	    khoaHocService.deleteKhoaHoc(id);
	    return ResponseEntity.ok().body("Xóa khóa học thành công");
	}

}
