package com.CrisLu.biblioteca.model;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="books")
public class Book {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column
	private String name;
	@Column
	private String genre;
	@Column
	private String editorial;
	
	
	@Column
	@Nonnull
	private String year;
	@Column
	private String author;
	
	//Constructors
	public Book() {
		
	}

	public Book(long id, String name, String genre, String editorial, String year, String author) {
		super();
		this.id = id;
		this.name = name;
		this.genre = genre;
		this.editorial = editorial;
		this.year = year;
		this.author = author;
	}

	//Getters & Setters
	public long getId() {
		return id;
	}

	public void setIsbn(long id) {
		this.id = id;
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

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

}
