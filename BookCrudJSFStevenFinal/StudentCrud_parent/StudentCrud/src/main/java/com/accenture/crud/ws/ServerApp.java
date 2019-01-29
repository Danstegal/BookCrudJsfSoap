package com.accenture.crud.ws;
/**
 * @author DanielGaleano
 */
import javax.xml.ws.Endpoint;

public class ServerApp {

	public static void main(String[] args) {
		
		Endpoint.publish("http://localhost:8888/BookCrudWS", new BookCrudWS());
		System.out.println("Web Service BookCrud Started..!");

	}

}