package com.accenture.crud.model;
/**
 * @author DanielGaleano
 */
public class Book {

	
	private int id;
	private String name;
	private String writer;
	private int quantity;
	
	public Book() {
		super();
	}

	public Book(int id, String name, String writer, int quantity) {
		super();
		this.id = id;
		this.name = name;
		this.writer = writer;
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	
}
