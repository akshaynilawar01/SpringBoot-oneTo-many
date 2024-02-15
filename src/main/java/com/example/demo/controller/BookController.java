package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.BookModel;
import com.example.demo.service.BookService;

@RestController
public class BookController {
	
	@Autowired
	
	BookService bookService;
	
	@GetMapping("/getallbook")
	public List<BookModel> getAbook()
	{
		return bookService.getAllBooks();
	}
	
	@GetMapping("/getallbook/getone/{id}")
	public BookModel getonee(@PathVariable int id)
	{
		return bookService.getByid(id);
	}
	
	@DeleteMapping("/deleteone/{id}")
	public void deletingone(@PathVariable int id)
	{
	    bookService.deleteone(id);
	}
	
	@PostMapping("/addingbook")
	public BookModel addingBook(@RequestBody BookModel bookmodel)
	{
		return bookService.saveAl(bookmodel);
	}

    @PostMapping("/{bookId}/borrow/{userId}")
    public ResponseEntity<BookModel> borrowBook(@PathVariable int bookId, @PathVariable int userId) {
        BookModel borrowedBook = bookService.Borrowed(bookId, userId);
        if (borrowedBook != null) {
            return ResponseEntity.ok(borrowedBook);
        } else {
            return ResponseEntity.badRequest().build(); // or a more descriptive error response
        }
    }

    @PostMapping("/{bookId}/return")
    public ResponseEntity<BookModel> returnBook(@PathVariable int bookId) {
        BookModel returnedBook = bookService.returnBook(bookId);
        if (returnedBook != null) {
            return ResponseEntity.ok(returnedBook);
        } else {
            return ResponseEntity.badRequest().build(); // or a more descriptive error response
        }
    }

}
