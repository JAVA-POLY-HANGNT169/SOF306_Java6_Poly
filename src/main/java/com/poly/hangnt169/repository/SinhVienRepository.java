package com.poly.hangnt169.repository;

import com.poly.hangnt169.entity.SinhVien;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SinhVienRepository extends JpaRepository<SinhVien, Long> {

    @Query("SELECT sv FROM SinhVien sv,Lop l, ChuyenNganh  cn WHERE sv.lop.id = l.id AND sv.chuyenNganh.id = cn.id")
    Page<SinhVien> hienThiDanhSachSinhVien(Pageable pageable);

//    @Transactional
//    @Modifying
//    @Query("UPDATE SinhVien  sv SET sv.maSV = ?1, sv.ten = ?2, sv.email = ?3, sv.gioiTinh = ?4, sv.chuyenNganhId = ?5 WHERE sv.id = ?6")
//    void updateSinhVien(String chuyenNganh, Boolean gioiTinh, String ten, Integer tuoi, Long id);

}
