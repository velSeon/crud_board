package com.curd.crud_board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Maincontroller {
    @GetMapping("/")
    public String root() {
        return "forward:/articles";
    }
}
