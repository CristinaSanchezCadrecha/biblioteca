package com.CrisLu.biblioteca.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.CrisLu.biblioteca.model.Reader;
import com.CrisLu.biblioteca.repository.ReaderRepository;



@Service
public class ReaderServiceImpl implements ReaderService{

	@Autowired
	private ReaderRepository readerRepository;
	
	@Override
	public List<Reader> getAllReader() {
		
		return this.readerRepository.findAll();
	}

	@Override
	public Reader getReaderById(int memberNumber) {
		Optional<Reader> optionalReader = this.readerRepository.findById(memberNumber);
		Reader reader = null;
		if(optionalReader.isPresent()) {
			reader = optionalReader.get();
		}else {
			throw new RuntimeException("El lector con id: " + memberNumber + "no se encuentra");
		}
		return reader;
	}

	@Override
	public void saveReader(Reader reader) {
		this.readerRepository.save(reader);
		
	}

	@Override
	public void deleteReaderById(int memberNumber) {
		this.readerRepository.deleteById(memberNumber);
		
	}

	@Override
	public Page<Reader> findPaginate(int pageNum, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name())?
				Sort.by(sortField).ascending(): Sort.by(sortField).descending();
		Pageable pageable = PageRequest.of(pageNum -1, pageSize, sort);
		return this.readerRepository.findAll(pageable);
	}

}




