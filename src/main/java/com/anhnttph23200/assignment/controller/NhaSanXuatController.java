package com.anhnttph23200.assignment.controller;

import com.anhnttph23200.assignment.entity.NhaSanXuat;
import com.anhnttph23200.assignment.services.NhaSanXuatService;
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
@RequestMapping("/nha-san-xuat/")
public class NhaSanXuatController {

    @Autowired
    private NhaSanXuatService nhaSanXuatService;

    @GetMapping("hien-thi")
    public String hienThi(@RequestParam(defaultValue = "0", name = "page") Integer number,
                          Model model
    ) {
        Pageable pageable = PageRequest.of(number, 5);
        model.addAttribute("nsx", this.nhaSanXuatService.page(pageable));
        model.addAttribute("nsx1", new NhaSanXuat());
        return "/manager/nha-san-xuat/hien-thi";
    }

    @GetMapping("add")
    public String add(@RequestParam(defaultValue = "0", name = "page") Integer number,
                      @Valid
                      @ModelAttribute("nsx1") NhaSanXuat nsx,
                      BindingResult bindingResult,
                      Model model
    ) {
        if (bindingResult.hasErrors()){
            Pageable pageable = PageRequest.of(number, 5);
            model.addAttribute("nsx", this.nhaSanXuatService.page(pageable));
            return "/manager/nha-san-xuat/hien-thi";
        }
        this.nhaSanXuatService.add(nsx);
        return "redirect:/nha-san-xuat/hien-thi";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") UUID id
    ) {
        this.nhaSanXuatService.delete(id);
        return "redirect:/nha-san-xuat/hien-thi";
    }

    @GetMapping("view-update/{id}")
    public String viewUpdate(@PathVariable("id") UUID id,
                             Model model
    ) {
        model.addAttribute("nsx", this.nhaSanXuatService.detail(id));
        return "/manager/nha-san-xuat/update";
    }

    @GetMapping("detail/{id}")
    public String detail(@RequestParam(defaultValue = "0", name = "page")Integer number,
                         @PathVariable("id") UUID id,
                         Model model
                         ){
        Pageable pageable = PageRequest.of(number, 5);
        NhaSanXuat nhaSanXuat = this.nhaSanXuatService.detail(id);
        model.addAttribute("nsx", this.nhaSanXuatService.page(pageable));
        model.addAttribute("nsx1", nhaSanXuat);
        return "/manager/nha-san-xuat/hien-thi";
    }

    @GetMapping("update/{id}")
    public String update(@ModelAttribute("nsx1") NhaSanXuat nsx
    ) {
        this.nhaSanXuatService.update(nsx);
        return "redirect:/nha-san-xuat/hien-thi";
    }
}
