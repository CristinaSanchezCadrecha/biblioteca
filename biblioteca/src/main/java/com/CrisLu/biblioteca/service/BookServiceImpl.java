package com.CrisLu.biblioteca.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.CrisLu.biblioteca.model.Book;
import com.CrisLu.biblioteca.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService{

	@Autowired
	private BookRepository bookRepository;
	
	@Override
	public List<Book> getAllBook() {
		
		return this.bookRepository.findAll();
	}

	@Override
	public Book getBookById(Integer id) {
		Optional<Book> optionalBook = this.bookRepository.findById(id);
		Book book = null;
		if(optionalBook.isPresent()) {
			book = optionalBook.get();
		}else {
			throw new RuntimeException("el libro con id: " + id + "no se encuentra");
		}
		return book;
	}

	@Override
	public void saveBook(Book book) {
		this.bookRepository.save(book);
		
	}

	@Override
	public void deleteBookById(Integer id) {
		this.bookRepository.deleteById(id);
		
	}

	@Override
	public Page<Book> findPaginate(int pageNum, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name())?
				Sort.by(sortField).ascending(): Sort.by(sortField).descending();
		Pageable pageable = PageRequest.of(pageNum -1, pageSize, sort);
		return this.bookRepository.findAll(pageable);
	}

}
