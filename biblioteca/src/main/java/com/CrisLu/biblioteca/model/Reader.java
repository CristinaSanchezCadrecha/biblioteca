package com.CrisLu.biblioteca.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="readers")
public class Reader {
	//Attributes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer memberNumber;
	@Column
	private String name;
	@Column
	private Integer phoneNumber;
	@Column
	private String address;
	

	//Constructors
	public Reader() {
		
	}

	public Reader(Integer memberNumber, String name, Integer phoneNumber, String address) {
		super();
		this.memberNumber = memberNumber;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}

	public Integer getMemberNumber() {
		return memberNumber;
	}

	public void setMemberNumber(Integer memberNumber) {
		this.memberNumber = memberNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Integer phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}	
	
	
	
}
