package com.poly.hangnt169.service;


import com.poly.hangnt169.entity.SinhVien;
import com.poly.hangnt169.response.ApiResponse;

public interface SinhVienService {
    ApiResponse getAllSinhVien(Integer pageNo, Integer size);

    void addSinhVien(SinhVien sv);

    void suaSinhVien(Long id, SinhVien sv);

    void deleteSinhVien(Long id);
}
