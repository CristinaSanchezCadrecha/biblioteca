package com.CrisLu.biblioteca.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.CrisLu.biblioteca.model.Reader;
import com.CrisLu.biblioteca.service.ReaderService;





@Controller
public class ReaderController {
	@Autowired
	private ReaderService readerService;
	
	@GetMapping("/reader")
	public String viewReadersPage(Model model) {
		return findPaginated(1, "name", "asc", model);
	}
	
	@GetMapping("/pageReader/{pageNum}")
	public String findPaginated(@PathVariable(value="pageNum")int pageNum,@RequestParam("sortField")String sortField,@RequestParam("sortDirection")String  sortDirection, Model model ) {
		int pageSize=5;
		Page<Reader> page=readerService.findPaginate(pageNum, pageSize, sortField, sortDirection);
		
		List<Reader> listReaders = page.getContent();
		
		model.addAttribute("currentPage", pageNum);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDirection", sortDirection);
		model.addAttribute("reverseSortDirection", sortDirection.equals("asc")? "desc":"asc");
		model.addAttribute("listReaders", listReaders);
		
		
		return "reader";
	}
		@PostMapping("/saveReader")
		public String saveReader(@ModelAttribute("reader") Reader reader) {
			readerService.saveReader(reader);
			return "redirect:/reader";
		}
		
		@GetMapping("/deleteReader/{memberNumber}")
		public String deleteReader(@PathVariable(value="memberNumber") int memberNumber) {
			this.readerService.deleteReaderById(memberNumber);
			return "redirect:/reader";
		}
		
		@GetMapping("/updateReader/{memberNumber}")
		public String showFormUpdateReader(@PathVariable(value="memberNumber") int memberNumber, Model model) {
			Reader reader = readerService.getReaderById(memberNumber);
			model.addAttribute("reader", reader);
			return "update_reader";
		}
		
		@GetMapping("/addReader")
		public String showFormNewReader(Model model) {
			
			Reader reader = new Reader();
			model.addAttribute("reader", reader);
			return "new_reader";
		}

}
