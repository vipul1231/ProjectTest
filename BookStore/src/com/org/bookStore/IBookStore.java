package com.org.bookStore;

import java.util.List;

import com.org.domain.Books;

public interface IBookStore {

	boolean addBookToCatalog(Books book);

	List<Books> searchBooks(String name);
	
	List<Books> getMostSoldBooks(String searchCriteria);
	
	int getTotalNumberOfBooks();
}
