package com.also.springApp.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/persons")
public class DemoController {

    @GetMapping(path="/add")
    public String add() {
        return "add";
    }


    @GetMapping(path="/show")
    public @ResponseBody String show() {
        return "show";
    }
}
