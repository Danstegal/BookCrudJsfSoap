package com.accenture.crud.persistence;
/**
 * @author DanielGaleano
 */
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

import javax.faces.context.FacesContext;

import com.accenture.crud.model.*;
public class BookPersistence {

	private List<Book> books;
	
	public static Statement stmtObj;
	public static Connection connObj;
	public static ResultSet resultSetObj;
	public static ResultSet resultGetObj;
	public static PreparedStatement pstmt;
	
	
	// Método para crear las conexiones
	public Connection getConnection() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String db_url ="jdbc:mariadb://localhost:3306/book",
					db_userName="root",
					db_password="1234";
			connObj = DriverManager.getConnection(db_url,db_userName,db_password);
		}catch(Exception sqlException) {
			sqlException.printStackTrace();
		}return connObj;
	}
	
	public BookPersistence() {
		super();
		books = new ArrayList<Book>();
		this.books= this.fillBooks();
	}
	
	public void addBook(Book book) {
		this.books.add(book);
	}
	
	//Cargar datos
	public List<Book> fillBooks() {
		List<Book> bookList = new ArrayList<Book>();
		String sql = "select * from book";
		try{
			stmtObj = getConnection().createStatement();
			resultSetObj = stmtObj.executeQuery(sql);
			while (resultSetObj.next()) {
				Book book = new Book();
				book.setId(resultSetObj.getInt("id"));
				book.setName(resultSetObj.getString("name"));
				book.setWriter(resultSetObj.getString("writer"));
				book.setQuantity(resultSetObj.getInt("quantity"));
				bookList.add(book);
				
			}
			System.out.println("Total "+ bookList.size());
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return bookList;
	}
	
	public Book findById(int id) {
		Book book = new Book();
		String sql = "select * from book where id = ?";
		try{
			pstmt = getConnection().prepareStatement(sql);
			pstmt.setInt(1, id);
			resultSetObj = pstmt.executeQuery();
			while (resultSetObj.next()) {
				book.setId(resultSetObj.getInt("id"));
				book.setName(resultSetObj.getString("name"));
				book.setWriter(resultSetObj.getString("writer"));
				book.setQuantity(resultSetObj.getInt("quantity"));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}		
		return book;
	}
	
	public int saveBook(Book book) {
		int saveResult=0;
		try {
			pstmt = getConnection().prepareStatement("insert into book(name,writer,quantity) values (?,?,?)");
			pstmt.setString(1, book.getName());
			pstmt.setString(2, book.getWriter());
			pstmt.setInt(3, book.getQuantity());
			saveResult =pstmt.executeUpdate();
			connObj.close();
		}catch (Exception sqlException) {
			sqlException.printStackTrace();
		}
		return saveResult;
	}
	
	public String editBookRecordInDB(int bookId) {
		Book book = null;
		System.out.println("editBookRecordInDB() : Book Id: " + bookId);
		Map<String,Object> sessionMapObj = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();

		try {
			stmtObj = getConnection().createStatement();    
			resultSetObj = stmtObj.executeQuery("select * from book where id = "+bookId);    
			if(resultSetObj != null) {
				resultSetObj.next();
				book = new Book(); 
				book.setId(resultSetObj.getInt("id"));
				book.setName(resultSetObj.getString("Name"));
				book.setWriter(resultSetObj.getString("writer"));
				book.setQuantity(resultSetObj.getInt("quantity"));
			}
			sessionMapObj.put("bookRecord", book);
			connObj.close();
		} catch(Exception sqlException) {
			sqlException.printStackTrace();
		}
		return "/editBook.xhtml?faces-redirect=true";
	}

	public String updateBookDetailsInDB(Book updateBookObj) {
		try {
			pstmt = getConnection().prepareStatement("update book set name=?, writer=?, quantity=? where id=?");    
			pstmt.setString(1,updateBookObj.getName());  
			pstmt.setString(2,updateBookObj.getWriter());  
			pstmt.setInt(3,updateBookObj.getQuantity());  
			pstmt.setInt(4,updateBookObj.getId());  
			pstmt.executeUpdate();
			connObj.close();			
		} catch(Exception sqlException) {
			sqlException.printStackTrace();
		}
		return "/bookList.xhtml?faces-redirect=true";
	}

	public String deleteBookRecordInDB(int bookId){
		System.out.println("deleteBookRecordInDB() : Book Id: " + bookId);
		try {
			pstmt = getConnection().prepareStatement("delete from book where id = "+bookId);  
			pstmt.executeUpdate();  
			connObj.close();
		} catch(Exception sqlException){
			sqlException.printStackTrace();
		}
		return "/bookList.xhtml?faces-redirect=true";
	}

	
	public List<Book> getBook(){
		return books;
	}
}
