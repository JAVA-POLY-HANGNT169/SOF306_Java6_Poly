package com.poly.hangnt169.response;

import lombok.Getter;
import lombok.Setter;

/**
 * @author hangnt169
 */

@Getter
@Setter
public class SinhVienResponse {

    private Long id;
    private String maSV;
    private String tenSV;

    private String email;

    private Boolean gioiTinh;

    private String tenLop ;

    private String tenChuyenNganh;

}
