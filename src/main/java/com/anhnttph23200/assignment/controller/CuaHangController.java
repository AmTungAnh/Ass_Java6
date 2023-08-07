package com.anhnttph23200.assignment.controller;

import com.anhnttph23200.assignment.entity.CuaHang;
import com.anhnttph23200.assignment.entity.DongSanPham;
import com.anhnttph23200.assignment.services.CuaHangService;
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
@RequestMapping("/cua-hang/")
public class CuaHangController {

    @Autowired
    private CuaHangService cuaHangService;

    @GetMapping("hien-thi")
    public String hienThi(@RequestParam(defaultValue = "0", name = "page")Integer number,
                          Model model
                          ){
        Pageable pageable = PageRequest.of(number, 5);
        model.addAttribute("list", this.cuaHangService.page(pageable));
        model.addAttribute("ch", new CuaHang());
        return "/manager/cua-hang/hien-thi";
    }

    @PostMapping("add")
    public String add(@RequestParam(defaultValue = "0", name = "page") Integer number,
                      @Valid
                      @ModelAttribute("ch") CuaHang dongSanPham,
                      BindingResult bindingResult,
                      Model model
    ) {
        if (bindingResult.hasErrors()){
            Pageable pageable = PageRequest.of(number, 5);
            model.addAttribute("list", this.cuaHangService.page(pageable));
            return "/manager/cua-hang/hien-thi";
        }
        this.cuaHangService.add(dongSanPham);
        return "redirect:/cua-hang/hien-thi";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") UUID id
    ) {
        this.cuaHangService.delete(id);
        return "redirect:/cua-hang/hien-thi";
    }

    @GetMapping("detail/{id}")
    public String detail(@RequestParam(defaultValue = "0", name = "page") Integer number,
                         @PathVariable("id") UUID id,
                         Model model
    ) {
        Pageable pageable = PageRequest.of(number, 5);
        CuaHang list = this.cuaHangService.detail(id);
        model.addAttribute("list", this.cuaHangService.page(pageable));
        model.addAttribute("ch", list);
        return "/manager/cua-hang/hien-thi";
    }

    @GetMapping("view-update/{id}")
    public String viewUpdate(@PathVariable("id") UUID id,
                             Model model
    ) {
        model.addAttribute("ch", this.cuaHangService.detail(id));
        return "/manager/cua-hang/update";
    }

    @PostMapping("update/{id}")
    public String update(@ModelAttribute("ch") CuaHang dongSanPham
    ) {
        this.cuaHangService.update(dongSanPham);
        return "redirect:/cua-hang/hien-thi";
    }
}
