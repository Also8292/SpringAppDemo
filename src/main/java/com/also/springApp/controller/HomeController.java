package com.also.springApp.controller;

import com.also.springApp.model.Student;
import com.also.springApp.model.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @author also
 *
 */

@Controller
//@RequestMapping(path="/student")
public class HomeController {

	/*@GetMapping("/")
	public String home() {
		return "home";
	}

	@GetMapping("/about")
	public String about() {
		return "about";
	}*/

	//@Autowired

	//private StudentRepository studentRepository;

	@GetMapping(path="/")
	public String home () {
		return "home";
	}


	//@GetMapping(path="/all")
	//public @ResponseBody Iterable<Student> getAllStudents() {
		//return studentRepository.findAll();
	//}

}
