package com.anhnttph23200.assignment.controller;

import com.anhnttph23200.assignment.entity.MauSac;
import com.anhnttph23200.assignment.entity.SanPham;
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
@RequestMapping("/san-pham/")
public class SanPhamController {

    @Autowired
    private SanPhamService sanPhamService;

    @GetMapping("hien-thi")
    public String hienThi(@RequestParam(defaultValue = "0", name = "page") Integer number,
                          Model model
    ) {
        Pageable pageable = PageRequest.of(number, 5);
        model.addAttribute("list", this.sanPhamService.page(pageable));
        model.addAttribute("sp", new SanPham());
        return "/manager/san-pham/hien-thi";
    }

    @PostMapping("add")
    public String add(@RequestParam(defaultValue = "0", name = "page") Integer number,
                      @Valid
                      @ModelAttribute("sp") SanPham ms,
                      BindingResult bindingResult,
                      Model model
    ) {
        if (bindingResult.hasErrors()){
            Pageable pageable = PageRequest.of(number, 5);
            model.addAttribute("list", this.sanPhamService.page(pageable));

            return "/manager/san-pham/hien-thi";
        }
        this.sanPhamService.add(ms);
        return "redirect:/san-pham/hien-thi";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable(("id")) UUID uuid
    ) {
        this.sanPhamService.delete(uuid);
        return "redirect:/san-pham/hien-thi";
    }

    @GetMapping("detail/{id}")
    public String detail(@RequestParam(defaultValue = "0", name = "page") Integer number,
                         @PathVariable("id") UUID id,
                         Model model
    ) {
        Pageable pageable = PageRequest.of(number, 5);
        SanPham list = this.sanPhamService.detail(id);
        model.addAttribute("list", this.sanPhamService.page(pageable));
        model.addAttribute("sp", list);
        return "/manager/san-pham/hien-thi";
    }

    @GetMapping("view-update/{id}")
    public String viewUpdate(@PathVariable("id") UUID id,
                             Model model
    ) {
        model.addAttribute("sp", this.sanPhamService.detail(id));
        return "/manager/san-pham/update";
    }

    @PostMapping("update/{id}")
    public String update(@ModelAttribute("sp") SanPham sanPham
    ) {
        this.sanPhamService.update(sanPham);
        return "redirect:/san-pham/hien-thi";
    }
}
