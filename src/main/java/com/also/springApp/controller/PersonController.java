package com.also.springApp.controller;


import com.also.springApp.model.Person;
import com.also.springApp.model.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Array;

@Controller
//@RequestMapping(path="/persons")
public class PersonController {

    /*@GetMapping(path="/add")
    public String add() {
        return "add";
    }*/


    @GetMapping(path="/show")
    public @ResponseBody String show() {
        return "show";
    }



    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("person", new Person());
        return "add";
    }

    @Autowired

    private PersonRepository personRepository;

    @PostMapping("/add")
    public String personSubmit(@ModelAttribute Person person, @RequestParam Integer id, @RequestParam String name) {
        Person a = new Person();
        a.setId(id);
        a.setName(name);
        personRepository.save(a);
        return "show";
    }

    //private PersonRepository personRepository;

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Person> getAllPersons() {
        return personRepository.findAll();
    }
}
