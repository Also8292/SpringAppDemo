package com.also.springApp.controller;

import com.also.springApp.model.Student;
import com.also.springApp.model.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author also
 *
 */

@Controller
@RequestMapping(path="/student")
public class HomeController {

	/*@GetMapping("/")
	public String home() {
		return "home";
	}

	@GetMapping("/about")
	public String about() {
		return "about";
	}*/

	@Autowired

	private StudentRepository studentRepository;

	@GetMapping(path="/add")
	public @ResponseBody String addNewStudent (@RequestParam String name, @RequestParam String email) {
		Student a = new Student();
		a.setName(name);
		a.setEmail(email);
		studentRepository.save(a);

		return "Saved";
	}

	@GetMapping(path="/all")
	public @ResponseBody Iterable<Student> getAllStudents() {
		return studentRepository.findAll();
	}

}
