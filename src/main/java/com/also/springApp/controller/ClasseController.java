package com.also.springApp.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClasseController {

    @GetMapping("/classe")
    public String getClasse() {
        return "classe";
    }
}
