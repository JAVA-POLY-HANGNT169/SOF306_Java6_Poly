package com.poly.hangnt169.service.impl;

import com.poly.hangnt169.entity.SinhVien;
import com.poly.hangnt169.repository.SinhVienRepository;
import com.poly.hangnt169.response.ApiResponse;
import com.poly.hangnt169.response.SinhVienResponse;
import com.poly.hangnt169.service.SinhVienService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SinhVienServiceImpl implements SinhVienService {

    @Autowired
    private SinhVienRepository sinhVienRepository;

    @Override
    public ApiResponse getAllSinhVien(Integer pageNo, Integer size) {
        ApiResponse response = new ApiResponse();
        Pageable pageable = PageRequest.of(pageNo, size);
        Page<SinhVien> pages = sinhVienRepository.hienThiDanhSachSinhVien(pageable);
        List<SinhVienResponse> listResponse = new ArrayList<>();
        response.setTotalElement(pages.getTotalElements());
        pages.getContent().forEach(a -> listResponse.add(convertToSinhVienResponse(a)));
        response.setData(listResponse);
        return response;
    }

    @Override
    public void addSinhVien(SinhVien sv) {
    }

    @Transactional
    @Modifying
    @Override
    public void suaSinhVien(Long id, SinhVien sv) {
//        sinhVienRepository.updateSinhVien();
    }

    @Override
    public void deleteSinhVien(Long id) {
        sinhVienRepository.deleteById(id);
    }

    private SinhVienResponse convertToSinhVienResponse(SinhVien sv) {
        SinhVienResponse response = new SinhVienResponse();
        response.setId(sv.getId());
        response.setMaSV(sv.getMaSV());
        response.setTenSV(sv.getTen());
        response.setEmail(sv.getEmail());
        response.setGioiTinh(sv.isGioiTinh());
        response.setTenLop(sv.getLop().getTenLop());
        response.setTenChuyenNganh(sv.getChuyenNganh().getTenChuyenNganh());
        return response;
    }

}
