package com.accenture.crud.model;
/**
 * @author DanielGaleano
 */
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "book")
public class Book {
	@Column(name="id")
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "writer")
	private String writer;
	
	@Column(name = "quantity")
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
	
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", email=" + writer + ", password=" + quantity + "]";
	}
}
