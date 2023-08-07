package com.anhnttph23200.assignment.controller;

import com.anhnttph23200.assignment.services.ChiTietSanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {

    @Autowired
    ChiTietSanPhamService chiTietSanPhamService;

    @GetMapping("/index/")
    public String view(){
        return "index";
    }

    @GetMapping("/service/")
    public String service(@RequestParam(defaultValue = "0", name = "page")Integer number,
            Model model){
        Pageable pageable = PageRequest.of(number, 8);
        model.addAttribute("list", this.chiTietSanPhamService.page(pageable));
        return "service";
    }

    @GetMapping("/about/")
    public String about(){
        return "about";
    }

    @GetMapping("/account/")
    public String account(){
        return "account";
    }
}
