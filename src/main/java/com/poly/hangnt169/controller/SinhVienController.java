package com.poly.hangnt169.controller;

import com.poly.hangnt169.response.ApiResponse;
import com.poly.hangnt169.service.SinhVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sinh-vien/")
@CrossOrigin(origins = "*", maxAge = -1)
public class SinhVienController {

    @Autowired
    private SinhVienService sinhVienService;

    @GetMapping("hien-thi")
    public ResponseEntity<?> getAllSinhVien(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo) {
        ApiResponse apiResponse = sinhVienService.getAllSinhVien(pageNo, 5);
        ResponseEntity<ApiResponse> response = new ResponseEntity<>(apiResponse, HttpStatus.OK);
        return response;
    }


}
