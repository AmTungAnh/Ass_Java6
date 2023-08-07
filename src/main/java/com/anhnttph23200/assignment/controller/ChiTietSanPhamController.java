package com.anhnttph23200.assignment.controller;

import com.anhnttph23200.assignment.entity.ChiTietSanPham;
import com.anhnttph23200.assignment.services.ChiTietSanPhamService;
import com.anhnttph23200.assignment.services.DongSanPhamService;
import com.anhnttph23200.assignment.services.MauSacService;
import com.anhnttph23200.assignment.services.NhaSanXuatService;
import com.anhnttph23200.assignment.services.SanPhamService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@Controller
@RequestMapping("/chi-tiet-san-pham/")
public class ChiTietSanPhamController {

    @Autowired
    private ChiTietSanPhamService chiTietSanPhamService;

    @Autowired
    private MauSacService mauSacService;

    @Autowired
    private NhaSanXuatService nhaSanXuatService;

    @Autowired
    private SanPhamService sanPhamService;

    @Autowired
    private DongSanPhamService dongSanPhamService;

    @GetMapping("hien-thi")
    public String hienThi(@RequestParam(defaultValue = "0", name = "page") Integer number,
                          Model model
    ) {
        Pageable pageable = PageRequest.of(number, 5);
        model.addAttribute("list", this.chiTietSanPhamService.page(pageable));
        model.addAttribute("ctsp", new ChiTietSanPham());
        model.addAttribute("listMs", this.mauSacService.getAll());
        model.addAttribute("listNsx", this.nhaSanXuatService.getAll());
        model.addAttribute("listSp", this.sanPhamService.getAll());
        model.addAttribute("listDongSP", this.dongSanPhamService.getAll());
        return "/manager/chi-tiet-san-pham/hien-thi";
    }

    @PostMapping("add")
    public String add(@RequestParam(defaultValue = "0", name = "page") Integer number,
                      @Valid
                      @ModelAttribute("ctsp") ChiTietSanPham chiTietSanPham,
                      BindingResult bindingResult,
                      Model model
    ) {
        if (bindingResult.hasErrors()) {
            Pageable pageable = PageRequest.of(number, 5);
            model.addAttribute("list", this.chiTietSanPhamService.page(pageable));
            model.addAttribute("listMs", this.mauSacService.getAll());
            model.addAttribute("listNsx", this.nhaSanXuatService.getAll());
            model.addAttribute("listSp", this.sanPhamService.getAll());
            model.addAttribute("listDongSP", this.dongSanPhamService.getAll());
            return "/manager/chi-tiet-san-pham/hien-thi";
        }
        this.chiTietSanPhamService.add(chiTietSanPham);
        return "redirect:/chi-tiet-san-pham/hien-thi";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") UUID id
    ) {
        this.chiTietSanPhamService.delete(id);
        return "redirect:/chi-tiet-san-pham/hien-thi";
    }

    @GetMapping("detail/{id}")
    public String detail(@RequestParam(defaultValue = "0", name = "page") Integer number,
                         @PathVariable("id") UUID id,
                         Model model
    ) {
        Pageable pageable = PageRequest.of(number, 5);
        ChiTietSanPham chiTietSanPham = this.chiTietSanPhamService.detail(id);
        model.addAttribute("list", this.chiTietSanPhamService.page(pageable));
        model.addAttribute("ctsp", chiTietSanPham);
        model.addAttribute("listMs", this.mauSacService.getAll());
        model.addAttribute("listNsx", this.nhaSanXuatService.getAll());
        model.addAttribute("listSp", this.sanPhamService.getAll());
        model.addAttribute("listDongSP", this.dongSanPhamService.getAll());
        return "/manager/chi-tiet-san-pham/hien-thi";
    }

    @GetMapping("view-update/{id}")
    public String viewUpdate(@PathVariable("id") UUID id,
                             Model model
    ) {
        model.addAttribute("ctsp", this.chiTietSanPhamService.detail(id));
        model.addAttribute("listMs", this.mauSacService.getAll());
        model.addAttribute("listNsx", this.nhaSanXuatService.getAll());
        model.addAttribute("listSp", this.sanPhamService.getAll());
        model.addAttribute("listDongSP", this.dongSanPhamService.getAll());
        return "/manager/chi-tiet-san-pham/update";
    }

    @PostMapping("update/{id}")
    public String update(@ModelAttribute("ctsp") ChiTietSanPham chiTietSanPham
    ){
        this.chiTietSanPhamService.update(chiTietSanPham);
        return "redirect:/chi-tiet-san-pham/hien-thi";
    }
}
