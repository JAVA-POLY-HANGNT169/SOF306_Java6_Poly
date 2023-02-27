package com.poly.hangnt169.controller;

import com.poly.hangnt169.entity.Lop;
import com.poly.hangnt169.repository.LopHocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author hangnt169
 */
@RestController
@RequestMapping("/api/lop-hoc/")
@CrossOrigin(origins = "*", maxAge = -1)
public class LopController {

    @Autowired
    private LopHocRepository lopHocRepository;

    @GetMapping("hien-thi")
    public List<Lop> danhSachLopHoc() {
        return lopHocRepository.findAll();
    }

    // DELETE <=> DELETE <=> DELETE
    @DeleteMapping("xoa/{id}")
    public void xoaSinhVien(@PathVariable Long id) {
        Lop lop = lopHocRepository.findById(id).get();
        lopHocRepository.delete(lop);
    }

    // ADD <=> POST <=> CREATE
    @PostMapping("add")
    public void addSinhVien(@RequestBody Lop request) {
        lopHocRepository.save(request);
    }

    // UPDATE <=> PUT <=> UPDATE
    @PutMapping("update/{id}")
    public void updateSinhVien(@PathVariable("id") Long id, @RequestBody Lop request) {
        lopHocRepository.updateLopHoc(request.getTenLop(), request.getSoLuongSV(), request.getMaLop(), id);
    }
}
