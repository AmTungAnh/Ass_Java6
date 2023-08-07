package com.anhnttph23200.assignment.controller;

import com.anhnttph23200.assignment.entity.ChucVu;
import com.anhnttph23200.assignment.services.ChucVuService;
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
@RequestMapping("/chuc-vu/")
public class ChucVuController {
    
    @Autowired
    private ChucVuService chucVuService;

    @GetMapping("hien-thi")
    public String view(@RequestParam(defaultValue = "0", name = "page") Integer number,
                       Model model
    ) {
        Pageable pageable = PageRequest.of(number, 5);
        model.addAttribute("list", this.chucVuService.getAll(pageable));
        model.addAttribute("ms", new ChucVu());
        return "/manager/chuc-vu/hien-thi";
    }

    @PostMapping("add")
    public String add(@RequestParam(defaultValue = "0", name = "page") Integer number,
                      @Valid
                      @ModelAttribute("ms") ChucVu ChucVu,
                      BindingResult bindingResult,
                      Model model
    ) {
        if (bindingResult.hasErrors()) {
            Pageable pageable = PageRequest.of(number, 5);
            model.addAttribute("ChucVu", this.chucVuService.getAll(pageable));
            return "/manager/chuc-vu/hien-thi";
        }
        this.chucVuService.add(ChucVu);
        return "redirect:/chuc-vu/hien-thi";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") UUID id) {
        this.chucVuService.delete(id);
        return "redirect:/chuc-vu/hien-thi";
    }

    @GetMapping("detail/{id}")
    public String detail(@RequestParam(defaultValue = "0", name = "page") Integer number,
                         @PathVariable("id") UUID id,
                         Model model
    ) {
        Pageable pageable = PageRequest.of(number, 5);
        ChucVu list = this.chucVuService.detail(id);
        model.addAttribute("list", this.chucVuService.getAll(pageable));
        model.addAttribute("ms", list);
        return "/manager/chuc-vu/hien-thi";
    }

    @GetMapping("view-update/{id}")
    public String viewUpdate(@PathVariable("id") UUID id,
                             Model model
    ) {
        model.addAttribute("ms", this.chucVuService.detail(id));

        return "/manager/chuc-vu/update";
    }

    @PostMapping("update/{id}")
    public String update(@ModelAttribute("ms") ChucVu cv) {
        this.chucVuService.update(cv);
        return "redirect:/chuc-vu/hien-thi";
    }
}
