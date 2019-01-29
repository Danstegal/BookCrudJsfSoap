package com.accenture.crud.dao;
/**
 * @author DanielGaleano
 */
import java.util.List;

import com.accenture.crud.model.Book;

public interface BookDAO {
	public void createBook(Book book);
	public Book getBookById(int id);
	public List<Book> getBooks();
	public void updateBook(Book book);
	public void deleteBook(int id);
}
