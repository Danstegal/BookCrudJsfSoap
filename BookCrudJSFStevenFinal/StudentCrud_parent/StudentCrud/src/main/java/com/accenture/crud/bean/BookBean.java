package com.accenture.crud.bean;
/**
 * @author DanielGaleano
 */
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.accenture.crud.model.Book;
import com.accenture.crud.persistence.BookPersistence;

@ManagedBean(name = "bookBean")
@RequestScoped
public class BookBean {
	
	private List<Book> books;
	private BookPersistence persistence;
	public String message = "hello world";
	private Book book = new Book();
	
	public BookPersistence getPersistence() {
		return persistence;
	}
	public void setPersistence(BookPersistence persistence) {
		this.persistence = persistence;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public BookBean() {
		persistence = new BookPersistence();
		books= new ArrayList<Book>();
	}
	@PostConstruct
	public void init() {
		this.findAllBooks();
	}
	
	public void findAllBooks() {
		books = persistence.fillBooks();
	}
	
	public List<Book> getBooks() {
		return books;
	}
	
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	public String saveBook() {
		String navigationResult="";
		int saveResult = persistence.saveBook(book);
		if(saveResult !=0) {
			navigationResult="bookList.xhtml?faces-redirect=true";
		}else {
			navigationResult="createBook.xhtml?faces-redirect=true";
		} 
		return navigationResult;
	}
	
	public String editBook(int bookId) {
		return persistence.editBookRecordInDB(bookId);
	}
	
	public String updateBookDetails(Book updateBookObj) {
		return persistence.updateBookDetailsInDB(updateBookObj);
	}
	
	public String deleteBook(int bookId) {
		return persistence.deleteBookRecordInDB(bookId);
	}
	


}