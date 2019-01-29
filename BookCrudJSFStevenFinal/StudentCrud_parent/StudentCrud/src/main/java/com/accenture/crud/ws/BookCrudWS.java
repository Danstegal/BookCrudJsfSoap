package com.accenture.crud.ws;
/**
 * @author DanielGaleano
 */
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.accenture.crud.model.Book;
import com.accenture.crud.persistence.BookPersistence;

@WebService
public class BookCrudWS {
	
	public BookPersistence persistence = new BookPersistence();
	
	
	//Mostrar toda la lista de estudiantes
	@WebMethod
	public List<Book>allBook(){
		return persistence.fillBooks();
	}
	
	@WebMethod
	//Mostrar solo un estudiante
	public Book findById(@WebParam(name="id")int id) {
		return persistence.findById(id);
		
	}
	
	@WebMethod
	public String create(@WebParam(name ="book")Book book) {
		int saveResult = (int) persistence.saveBook(book);
		String navigationResult="";
		if(saveResult !=0) {
			navigationResult="Book was created succesfully";
		}else {
			navigationResult="Book wasn´t created";
		} return navigationResult;
	}
	
	@WebMethod
	public String update(@WebParam(name="book")Book book) {
		Book bookOld=persistence.findById(book.getId());
		String message="";
		if(bookOld != null) {
			persistence.updateBookDetailsInDB(book);
			message="Book was updated";
		}else {
			message = "Book doesn´t exist";
		}
		return message;
	}
	
	@WebMethod
	public String delete(@WebParam(name="book")Book book) {
		Book bookOld=persistence.findById(book.getId());
		String message="";
		if(bookOld != null) {
			persistence.deleteBookRecordInDB(book.getId());
			message="Book was deleted";
		}else {
			message = "Book doesn´t exist";
		}
		return message;
	}

}
