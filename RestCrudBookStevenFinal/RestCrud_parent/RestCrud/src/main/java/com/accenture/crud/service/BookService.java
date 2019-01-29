package com.accenture.crud.service;
/**
 * @author DanielGaleano
 */
import java.util.List;

import com.accenture.crud.model.Book;

public interface BookService {
	public void createBook(Book book);
	public Book getBookById(int id);
	public List<Book> getBooks();
	public void updateBooks(Book book);
	public void deleteBook(int id);

}
