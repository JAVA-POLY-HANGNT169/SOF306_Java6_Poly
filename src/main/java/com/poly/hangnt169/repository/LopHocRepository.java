package com.poly.hangnt169.repository;

import com.poly.hangnt169.entity.Lop;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author hangnt169
 */
@Repository
public interface LopHocRepository extends JpaRepository<Lop,Long> {

    @Transactional
    @Modifying
    @Query("UPDATE Lop l SET l.tenLop = ?1 , l.soLuongSV=?2 , l.maLop=?3 WHERE l.id =?4")
    void updateLopHoc(String tenLop, Integer soLuong, String maLop, Long id);
}
