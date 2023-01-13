package com.CrisLu.biblioteca.model;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="books")
public class Book {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column
	private String name;
	
	@Column
	private Genre genre;
	@Column
	private String editorial;
	
	
	@Column
	@Nonnull
	private String year;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="author")
	private Author author;
	
	//Constructors
	public Book() {
		
	}

	public Book(Integer id, String name, Genre genre, String editorial, String year, Author author) {
		super();
		this.id = id;
		this.name = name;
		this.genre = genre;
		this.editorial = editorial;
		this.year = year;
		this.author = author;
	}

	//Getters & Setters
	public int getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
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

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

}
