package com.anhnttph23200.assignment.controller;

import com.anhnttph23200.assignment.entity.MauSac;
import com.anhnttph23200.assignment.services.MauSacService;
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
@RequestMapping("/mau-sac/")
public class MauSacController {

    @Autowired
    MauSacService mauSacService;

    @GetMapping("hien-thi")
    public String view(@RequestParam(defaultValue = "0", name = "page") Integer number,
                       Model model
    ) {
        Pageable pageable = PageRequest.of(number, 5);
        model.addAttribute("mauSac", this.mauSacService.getAll(pageable));
        model.addAttribute("ms", new MauSac());
        return "/manager/mau-sac/hien-thi";
    }

    @PostMapping("add")
    public String add(@RequestParam(defaultValue = "0", name = "page") Integer number,
                      @Valid
                      @ModelAttribute("ms") MauSac mauSac,
                      BindingResult bindingResult,
                      Model model
    ) {
        if (bindingResult.hasErrors()) {
            Pageable pageable = PageRequest.of(number, 5);
            model.addAttribute("mauSac", this.mauSacService.getAll(pageable));
            return "/manager/mau-sac/hien-thi";
        }
        this.mauSacService.add(mauSac);
        return "redirect:/mau-sac/hien-thi";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") UUID id) {
        this.mauSacService.delete(id);
        return "redirect:/mau-sac/hien-thi";
    }

    @GetMapping("detail/{id}")
    public String detail(@RequestParam(defaultValue = "0", name = "page") Integer number,
            @PathVariable("id") UUID id,
                         Model model
    ) {
        Pageable pageable = PageRequest.of(number, 5);
        MauSac list = this.mauSacService.detail(id);
        model.addAttribute("mauSac", this.mauSacService.getAll(pageable));
        model.addAttribute("ms", list);
        return "/manager/mau-sac/hien-thi";
    }

    @GetMapping("view-update/{id}")
    public String viewUpdate(@PathVariable("id") UUID id,
                             Model model
    ) {
        model.addAttribute("ms", new MauSac());
        model.addAttribute("ms", this.mauSacService.detail(id));

        return "/manager/mau-sac/update";
    }

    @PostMapping("update/{id}")
    public String update(@ModelAttribute("ms") MauSac ms
    ) {
        this.mauSacService.update(ms);
        return "redirect:/mau-sac/hien-thi";
    }
}
