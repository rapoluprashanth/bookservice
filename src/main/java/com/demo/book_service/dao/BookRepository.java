package com.demo.book_service.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.book_service.entity.BookEntity;

public interface BookRepository extends JpaRepository<BookEntity, Long> {

}
