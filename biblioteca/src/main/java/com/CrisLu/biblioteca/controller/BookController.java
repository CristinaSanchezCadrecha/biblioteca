package com.CrisLu.biblioteca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.CrisLu.biblioteca.model.Book;
import com.CrisLu.biblioteca.service.BookService;



@Controller
public class BookController {
	@Autowired
	private BookService bookService;
	
	@GetMapping("/book")
	public String viewBooksPage(Model model) {
		return findPaginated(1, "name", "asc", model);
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
		@PostMapping("/save")
		public String saveBook(@ModelAttribute("book") Book book) {
			bookService.saveBook(book);
			return "redirect:/book";
		}
		
		@GetMapping("/delete/{id}")
		public String deleteBook(@PathVariable(value="id") Integer id) {
			this.bookService.deleteBookById(id);
			return "redirect:/book";
		}
		
		@GetMapping("/update/{id}")
		public String showFormUpdateBook(@PathVariable(value="id") Integer id, Model model) {
			Book book = bookService.getBookById(id);
			model.addAttribute("book", book);
			return "update_book";
		}
		
		@GetMapping("/add")
		public String showFormNewBook(Model model) {
			Book book = new Book();
			model.addAttribute("book", book);
			return "new_book";
		}
		
		
		
	
	
	

}
