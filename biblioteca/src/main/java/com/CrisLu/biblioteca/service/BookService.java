package com.CrisLu.biblioteca.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.CrisLu.biblioteca.model.Book;

public interface BookService {
	List<Book> getAllBook();
	Book getBookById(Integer id);
	void saveBook(Book book);
	void deleteBookById(Integer id);
	
	Page<Book> findPaginate(int pageNum, int pageSize, String sortField, String sortDirection);


}
