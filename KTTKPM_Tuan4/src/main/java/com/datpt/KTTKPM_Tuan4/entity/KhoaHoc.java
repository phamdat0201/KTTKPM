package com.datpt.KTTKPM_Tuan4.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "khoahoc")
@Data
public class KhoaHoc {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private Long maKhoaHoc;
	
	@Column(columnDefinition = "varchar(50)")
	private String tenKhoaHoc;
	
	@Column(columnDefinition = "varchar(50)")
	private String tenGV;
	
	private String status;
	private Double giaGoc;
	private Double giaHienTai;
	private String hinhAnh;
}
