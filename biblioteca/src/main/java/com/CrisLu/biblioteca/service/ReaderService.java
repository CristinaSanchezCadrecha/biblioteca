package com.CrisLu.biblioteca.service;

import java.util.List;

import org.springframework.data.domain.Page;


import com.CrisLu.biblioteca.model.Reader;

public interface ReaderService {
	List<Reader> getAllReader();
	Reader getReaderById(int memberNumber);
	void saveReader(Reader reader);
	void deleteReaderById(int memberNumber);
	
	Page<Reader> findPaginate(int pageNum, int pageSize, String sortField, String sortDirection);


}
