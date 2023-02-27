package com.poly.hangnt169.controller;

import com.poly.hangnt169.entity.Lop;
import com.poly.hangnt169.repository.LopHocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author hangnt169
 */
@Controller
@RequestMapping("/lop-hoc/")
public class LopHocController {

    @Autowired
    private LopHocRepository lopHocRepository;

    /**
     * Hiển thị toàn bộ dữ liệu lên table
     *
     * @param model
     * @return view cần hiển thị
     */
    @GetMapping("hien-thi")
    public String hienThiDanhSachLopHoc(Model model) {
        List<Lop> lops = lopHocRepository.findAll();
        model.addAttribute("lops", lops);
        return "lop-hoc";
    }

    @GetMapping("view-add")
    public String viewAddLopHoc() {
        return "view-add-lop-hoc";
    }

    @GetMapping("view-update/{id}")
    public String viewUpdateLopHoc(@PathVariable("id") String id, Model model) {
        Lop lop = lopHocRepository.findById(Long.valueOf(id)).get();
        model.addAttribute("lopHoc", lop);
        return "view-update-lop-hoc";
    }

    /**
     * Detail của 1 lớp học
     *
     * @param id:   ID của lớp học muốn xem chi tiết
     * @param model
     * @return view cần hiển thị
     */
    @GetMapping("detail/{id}")
    public String detailLopHoc(@PathVariable("id") String id, Model model) {
        Lop lop = lopHocRepository.findById(Long.valueOf(id)).get();
        model.addAttribute("lopHoc", lop);
        return "detail-lop-hoc";
    }

    /**
     * Xoá của 1 lớp học
     *
     * @param id:   ID của lớp học muốn xem chi xoá
     * @param model
     * @return view cần hiển thị
     */
    @GetMapping("delete/{id}")
    public String deleteLopHoc(@PathVariable("id") Long id, Model model) {
        Lop lop = lopHocRepository.findById(id).get();
        lopHocRepository.delete(lop);
        List<Lop> lops = lopHocRepository.findAll();
        model.addAttribute("lops", lops);
        return "lop-hoc";
    }

    /**
     * Thêm mới 1 lớp học
     *
     * @param model
     * @param tenLop:    Tên lớp muốn thêm
     * @param maLop:     Mã lớp
     * @param soLuongSV: Số lượng
     * @return view cần hiển thị
     */
    @PostMapping("add")
    public String addLopHoc(Model model, @RequestParam("tenLop") String tenLop, @RequestParam("maLop") String maLop,
                            @RequestParam("soLuongSinhVien") String soLuongSV) {
        // Nếu thoả mãn đk => Add
        if (!maLop.isEmpty() && !tenLop.isEmpty() && !soLuongSV.isEmpty()) {
            Lop lop = Lop.builder()
                    .maLop(maLop)
                    .tenLop(tenLop)
                    .soLuongSV(Integer.valueOf(soLuongSV))
                    .build();
            lopHocRepository.save(lop);
            return "redirect:/lop-hoc/hien-thi";
        } else {
            // Kiểm tra mã lớp trống
            if (maLop.isEmpty()) {
                model.addAttribute("maEmpty", "Mã không được trống");
            }
            // Kiểm tra tên lớp trống
            if (tenLop.isEmpty()) {
                model.addAttribute("tenEmpty", "Tên không được trống");
            }
            // Kiểm tra số lượng SV trống
            if (soLuongSV.isEmpty()) {
                model.addAttribute("soLuongSVEmpty", "Số lượng SV không được trống");
            }
            return "view-add-lop-hoc";
        }
    }

    /**
     * Update thông tin lớp học
     *
     * @param id:        Đối tượng cần update
     * @param model
     * @param tenLop:    Tên lớp muốn thêm
     * @param maLop:     Mã lớp
     * @param soLuongSV: Số lượng
     * @return view cần hiển thị
     */
    @PostMapping("update/{id}")
    public String updateLopHoc(@PathVariable("id") String id, Model model, @RequestParam("tenLop") String tenLop, @RequestParam("maLop") String maLop,
                               @RequestParam("soLuongSinhVien") String soLuongSV) {
        // Nếu thoả mãn đk => Add
        if (!maLop.isEmpty() && !tenLop.isEmpty() && !soLuongSV.isEmpty()) {
            Lop lop = new Lop(Long.valueOf(id), maLop, tenLop, Integer.valueOf(soLuongSV));
            lopHocRepository.save(lop);
            return "redirect:/lop-hoc/hien-thi";
        } else {
            // Kiểm tra mã lớp trống
            if (maLop.isEmpty()) {
                model.addAttribute("maEmpty", "Mã không được trống");
            }
            // Kiểm tra tên lớp trống
            if (tenLop.isEmpty()) {
                model.addAttribute("tenEmpty", "Tên không được trống");
            }
            // Kiểm tra số lượng SV trống
            if (soLuongSV.isEmpty()) {
                model.addAttribute("soLuongSVEmpty", "Số lượng SV không được trống");
            }
            return "view-update-lop-hoc";
        }
    }
}
