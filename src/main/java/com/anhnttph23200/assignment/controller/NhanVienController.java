package com.anhnttph23200.assignment.controller;

import com.anhnttph23200.assignment.entity.NhanVien;
import com.anhnttph23200.assignment.services.ChucVuService;
import com.anhnttph23200.assignment.services.CuaHangService;
import com.anhnttph23200.assignment.services.NhanVenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@Controller
@RequestMapping("/nhan-vien/")
public class NhanVienController {

    @Autowired
    private NhanVenService nhanVenService;

    @Autowired
    private ChucVuService chucVuService;

    @Autowired
    private CuaHangService cuaHangService;

    @GetMapping("hien-thi")
    public String hienThi(@RequestParam(defaultValue = "0", name = "page") Integer number,
                          Model model
    ) {
        Pageable pageable = PageRequest.of(number, 5);
        model.addAttribute("list", this.nhanVenService.getAll(pageable));
        model.addAttribute("nv", new NhanVien());
        model.addAttribute("listCV", this.chucVuService.getAll());
        model.addAttribute("listCH", this.cuaHangService.getAll());
        return "/manager/nhan-vien/hien-thi";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") UUID id
    ) {
        this.nhanVenService.delete(id);
        return "redirect:/nhan-vien/hien-thi";
    }

    @GetMapping("detail/{id}")
    public String detail(@RequestParam(defaultValue = "0", name = "page") Integer number,
                         @PathVariable("id")UUID id,
                         Model model
    ){
        Pageable pageable = PageRequest.of(number, 5);
        NhanVien nv = this.nhanVenService.detail(id);
        model.addAttribute("list", this.nhanVenService.getAll(pageable));
        model.addAttribute("nv", nv);
        model.addAttribute("listCV", this.chucVuService.getAll());
        model.addAttribute("listCH", this.cuaHangService.getAll());
        return "/manager/nhan-vien/hien-thi";
    }

    @GetMapping("view-update/{id}")
    public String viewUpdate(@PathVariable("id")UUID id,
                             Model model
    ){
        model.addAttribute("nv", this.nhanVenService.detail(id));
        return "/manager/nhan-vien/update";
    }

    @PostMapping("update/{id}")
    public String update(@ModelAttribute("nv")NhanVien nhanVien

                         ){
        this.nhanVenService.update(nhanVien);
        return "redirect:/nhan-vien/hien-thi";
    }
}
