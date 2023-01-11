package com.CrisLu.biblioteca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.CrisLu.biblioteca.model.Book;
import com.CrisLu.biblioteca.service.BookService;


@Controller
public class BookController {
	@Autowired
	private BookService bookService;
	
	@GetMapping("/")
	public String viewBooksPage(Model model) {
		return findPaginated(1, "nombreBook", "asc", model);
	}
	
	@GetMapping("/page/{pageNum}")
	public String findPaginated(@PathVariable(value="pageNum")int pageNum,@RequestParam("sortField")String sortField,@RequestParam("sortDirection")String  sortDirection, Model model ) {
		int pageSize=5;
		Page<Book> page=bookService.findPaginate(pageNum, pageSize, sortField, sortDirection);
		
		List<Book> listBooks = page.getContent();
		
		model.addAttribute("currentPage", pageNum);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDirection", sortDirection);
		model.addAttribute("reverseSortDirection", sortDirection.equals("asc")? "desc":"asc");
		model.addAttribute("listBooks", listBooks);
		
		
		return "book";
		
		
		
		
		
	}
	
	

}
