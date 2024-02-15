package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Table //is a corresponding table that matches that entity in the database
@Entity // for specifies class is an entity and is mapped to a database table. 

public class BookModel {
	
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long id;
	  
	  private String title;
	  
	  private String author;
	  
	  private boolean borrowed;
	  
	  @ManyToOne
	  @JoinColumn(name = "user_id")
	  private UserModel borrowedBy;

	public UserModel getBorrowedBy() {
		return borrowedBy;
	}

	public void setBorrowedBy(UserModel borrowedBy) {
		this.borrowedBy = borrowedBy;
	}

	public BookModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BookModel(Long id, String title, String author, boolean borrowed) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.borrowed = borrowed;
		
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public boolean isBorrowed() {
		return borrowed;
	}

	public void setBorrowed(boolean borrowed) {
		this.borrowed = borrowed;
	}

	@Override
	public String toString() {
		return "BookModel [id=" + id + ", title=" + title + ", author=" + author + ", borrowed=" + borrowed + "]";
	}
	  
	  

}
