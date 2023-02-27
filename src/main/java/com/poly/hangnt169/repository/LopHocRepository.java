package com.poly.hangnt169.repository;

import com.poly.hangnt169.entity.Lop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author hangnt169
 */
@Repository
public interface LopHocRepository extends JpaRepository<Lop, Long> {
}
