package com.CrisLu.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CrisLu.biblioteca.model.Book;

public interface BookRepository  extends JpaRepository<Book, Integer>{

}
