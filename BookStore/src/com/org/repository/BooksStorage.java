package com.org.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.org.domain.Books;

public class BooksStorage {
	
	Map<String, Books> map = new HashMap<>();
	
	public Books addBookToStore(Books books){
		return map.put(books.getName(), books);
	}
	
	public int totalNumberOfBooksInStore(){
		return map.size();
	}
	
	public List<Books> searchBooksFromStore(String search){
		
		return null;
	}

}
