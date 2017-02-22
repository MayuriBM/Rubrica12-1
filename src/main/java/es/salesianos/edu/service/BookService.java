package es.salesianos.edu.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import es.salesianos.edu.model.Author;
import es.salesianos.edu.model.Book;

public class BookService {
	private static final Logger logger = LogManager.getLogger(BookService.class.getName());

	public boolean insert(Book book) {
		logger.debug("simulando insercion");
		return true;
	}

	public List BookService(Book book) {
		List list = new ArrayList();
		if (book.getTittle() != null) {
			Book book1 = new Book();
			book1.setTittle("tittle");
			book1.setIsbn("isbn");
			book1.setAuthor("author");
			
			list.add(book1);
		
		}
		
		
		
		return list;
		
		
		}

	
}
