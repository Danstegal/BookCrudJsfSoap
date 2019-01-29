package com.accenture.crud.controller;
/**
 * @author DanielGaleano
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.crud.model.Book;
import com.accenture.crud.service.BookService;

@RestController
@CrossOrigin(origins="*")
//@RequestMapping(value="/book")
public class BookController {
	@Autowired
	public BookService bookService;
	
	@RequestMapping(value="/Book", method= RequestMethod.GET)
	public ResponseEntity<List<Book>> getBooks(){
		List<Book> getBooks = bookService.getBooks();
		if(getBooks.isEmpty()) {
			return new ResponseEntity<List<Book>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Book>>(getBooks,HttpStatus.OK);
	}
	
}
