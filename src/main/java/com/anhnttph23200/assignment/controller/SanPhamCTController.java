package com.anhnttph23200.assignment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/quan-ly/")
public class SanPhamCTController {

    @GetMapping("hien-thi")
    public String view(){
        return "/manager/san-pham/hien-thi";
    }
}
