package com.demo.book_service.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.book_service.dao.BookRepository;
import com.demo.book_service.entity.BookEntity;

@RestController
@RequestMapping("/api")
public class BookController {
	@Autowired
	BookRepository bs;
	
	
	
	@GetMapping("/books")
	public List<BookEntity> getAll(){
		List<BookEntity> all=bs.findAll();
		return all;
	}
	@GetMapping("/book/{bid}")
	public Optional<BookEntity> getABook(@PathVariable("bid") long bookId) {
	    return bs.findById(bookId);	
	}
	
	
	@PostMapping("/add")
	public BookEntity addBook(@RequestBody BookEntity newBook) {
		BookEntity b=bs.saveAndFlush(newBook);
		return b;
	}

}
