package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.BookModel;

public interface BookRepo extends JpaRepository<BookModel, Integer>{
	
	
}

