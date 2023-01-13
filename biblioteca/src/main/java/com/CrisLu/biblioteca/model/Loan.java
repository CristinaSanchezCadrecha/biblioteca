package com.CrisLu.biblioteca.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="loans")
public class Loan {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private Date start;
	@Column
	private Date end;
	
	@OneToOne
	@JoinColumn(name="book")
	private Book book;
	
	@OneToOne
	@JoinColumn(name="reader")
	private Reader reader;

}
