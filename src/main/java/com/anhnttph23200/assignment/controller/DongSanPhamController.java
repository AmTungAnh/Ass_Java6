package com.anhnttph23200.assignment.controller;

import com.anhnttph23200.assignment.entity.DongSanPham;
import com.anhnttph23200.assignment.services.DongSanPhamService;
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
@RequestMapping("/dong-san-pham/")
public class DongSanPhamController {

    @Autowired
    private DongSanPhamService dongSanPhamService;

    @GetMapping("hien-thi")
    public String hienThi(@RequestParam(defaultValue = "0", name = "page") Integer number,
                          Model model
    ) {
        Pageable pageable = PageRequest.of(number, 5);
        model.addAttribute("list", this.dongSanPhamService.page(pageable));
        model.addAttribute("dsp", new DongSanPham());
        return "/manager/dong-san-pham/hien-thi";
    }

    @PostMapping("add")
    public String add(@RequestParam(defaultValue = "0", name = "page") Integer number,
                      @Valid
                      @ModelAttribute("dsp") DongSanPham dongSanPham,
                      BindingResult bindingResult,
                      Model model
    ) {
        if (bindingResult.hasErrors()){
            Pageable pageable = PageRequest.of(number, 5);
            model.addAttribute("list", this.dongSanPhamService.page(pageable));
            return "/manager/dong-san-pham/hien-thi";
        }
        this.dongSanPhamService.add(dongSanPham);
        return "redirect:/dong-san-pham/hien-thi";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") UUID id
    ) {
        this.dongSanPhamService.delete(id);
        return "redirect:/dong-san-pham/hien-thi";
    }

    @GetMapping("detail/{id}")
    public String detail(@RequestParam(defaultValue = "0", name = "page") Integer number,
                         @PathVariable("id") UUID id,
                         Model model
    ) {
        Pageable pageable = PageRequest.of(number, 5);
        DongSanPham list = this.dongSanPhamService.detail(id);
        model.addAttribute("list", this.dongSanPhamService.page(pageable));
        model.addAttribute("dsp", list);
        return "/manager/dong-san-pham/hien-thi";
    }

    @GetMapping("view-update/{id}")
    public String viewUpdate(@PathVariable("id") UUID id,
                             Model model
    ) {
        model.addAttribute("dsp", new DongSanPham());
        model.addAttribute("list", this.dongSanPhamService.detail(id));
        return "/manager/dong-san-pham/hien-thi";
    }

    @PostMapping("update/{id}")
    public String update(@ModelAttribute("dsp") DongSanPham dongSanPham
    ) {
        this.dongSanPhamService.update(dongSanPham);
        return "redirect:/dong-san-pham/hien-thi";
    }
}
