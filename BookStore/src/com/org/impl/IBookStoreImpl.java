package com.org.impl;

import java.util.List;

import com.org.bookStore.IBookStore;
import com.org.domain.Books;
import com.org.repository.BooksStorage;

public class IBookStoreImpl implements IBookStore{
	
	BooksStorage booksStorage;
	
	public IBookStoreImpl(BooksStorage booksStorage) {
		// TODO Auto-generated constructor stub
		this.booksStorage = booksStorage;
	}

	@Override
	public boolean addBookToCatalog(Books book) {
		// TODO Auto-generated method stub
		return booksStorage.addBookToStore(book)==book;
	}

	@Override
	public List<Books> searchBooks(String name) {
		// TODO Auto-generated method stub
		return booksStorage.searchBooksFromStore(name);
	}

	@Override
	public List<Books> getMostSoldBooks(String searchCriteria) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getTotalNumberOfBooks() {
		// TODO Auto-generated method stub
		return booksStorage.totalNumberOfBooksInStore();
	}

}
