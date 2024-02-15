package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.model.BookModel;
import com.example.demo.model.UserModel;
import com.example.demo.repository.BookRepo;
import com.example.demo.repository.UserRepo;

@Service
public class BookService {

	
	@Autowired
	
	UserRepo userRepo;
	
	@Autowired
	
	BookRepo bookRepo;
	
	
	public List<BookModel> getAllBooks()
	{
		return bookRepo.findAll();
	}
	
	public BookModel saveAl(BookModel bookmodel)
	{
		return bookRepo.save(bookmodel);
	}
	
	public void deleteone(int id)
	{
		 bookRepo.deleteById(id);
	}
	
	public BookModel getByid(int id)
	{
		return bookRepo.findById(id).orElse(null);
	}
	
	public BookModel Borrowed(@PathVariable int userid, int bookid)
	{
		BookModel book = getByid(bookid);
		UserModel user = userRepo.findById(bookid).orElse(null);
		
		 if (book != null && !book.isBorrowed() && user != null) {
			 book.setBorrowedBy(user);
	         book.setBorrowed(true);
	         return saveAl(book);
		 }
		return null;
	}
	
	  public BookModel returnBook(int bookid) {
	        BookModel book = getByid(bookid);
	        if (book != null && book.isBorrowed()) {
	            book.setBorrowedBy(null);
	            book.setBorrowed(false);
	            return saveAl(book);
	        }
	        // Handle errors (e.g., book not found, book not borrowed)
	        return null;
	    }

}