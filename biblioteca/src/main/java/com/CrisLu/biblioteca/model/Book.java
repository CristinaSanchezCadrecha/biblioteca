package com.CrisLu.biblioteca.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="books")
public class Book {
	
	@Id
	private int isbn;
	
	@Column
	private String name;
	@Column
	private String genre;
	@Column
	private String editorial;
	@Column
	private int year;
	@Column
	private String author;
	
	
	public Book() {
		
		
	}


	public Book(int isbn, String name, String genre, String editorial, int year, String author) {
		super();
		this.isbn = isbn;
		this.name = name;
		this.genre = genre;
		this.editorial = editorial;
		this.year = year;
		this.author = author;
	}


	public int getIsbn() {
		return isbn;
	}


	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getGenre() {
		return genre;
	}


	public void setGenre(String genre) {
		this.genre = genre;
	}


	public String getEditorial() {
		return editorial;
	}


	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}


	public int getYear() {
		return year;
	}


	public void setYear(int year) {
		this.year = year;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}
	
	
	
	

}
