package com.accenture.crud.service;
/**
 * @author DanielGaleano
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.crud.dao.BookDAO;
import com.accenture.crud.model.Book;

@Service
@Transactional
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookDAO bookDAO;

	@Override
	public void createBook(Book book) {
		bookDAO.createBook(book);
	}

	@Override
	public Book getBookById(int id) {
		return bookDAO.getBookById(id);
	}

	@Override
	public List<Book> getBooks() {
		return bookDAO.getBooks();
	}

	@Override
	public void updateBooks(Book book) {
		bookDAO.updateBook(book);
	}

	@Override
	public void deleteBook(int id) {
		bookDAO.deleteBook(id);
	}

}
