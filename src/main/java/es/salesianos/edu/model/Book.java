package es.salesianos.edu.model;

import java.io.Serializable;

public class Book implements Serializable{
	

	private String Tittle;
	private String Isbn;
	private String  Author;
	
	
	


	public String getTittle() {
		return Tittle;
	}
	public void setTittle(String tittle) {
		Tittle = tittle;
	}
	
	public String getIsbn() {
		return Isbn;
	}
	public void setIsbn(String isbn) {
		Isbn = isbn;
	}
	public String getAuthor() {
		return Author;
	}
	public void setAuthor(String author) {
		Author = author;
	}

	

}