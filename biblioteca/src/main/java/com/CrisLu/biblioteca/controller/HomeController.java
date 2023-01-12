package com.CrisLu.biblioteca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	
	@GetMapping("/pageHome")
	public String viewHomePage() {
		return "redirect:/";
	}
	@GetMapping("/pageBook")
	public String viewBookPage() {
		return "redirect:/book";
	}
	
	@GetMapping("/pageReader")
	public String viewReaderPage() {
		return "redirect:/reader";
	}

}
