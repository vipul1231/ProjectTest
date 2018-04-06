package com.org.app;

import java.util.Calendar;

import com.org.bookStore.IBookStore;
import com.org.domain.Books;
import com.org.impl.IBookStoreImpl;
import com.org.repository.BooksStorage;

public class App {

	public static void main(String[] args){
		
		//Create Books
		Calendar calendar = Calendar.getInstance();
		calendar.set(2012, 02, 01);
		Books books1 = new Books("CLANGUAGE","Vipul","ABC", calendar.getTime(), "Adventure", 1000, 12);
		calendar.set(2013, 03, 01);
		Books books2 = new Books("PHP","Ankita","YRF", calendar.getTime(), "Adventure", 1000, 12);
		calendar.set(2014, 04, 12);
		Books books3 = new Books("JAVASCRIPT","Mridul","ZTC", calendar.getTime(), "Adventure", 1000, 12);
		calendar.set(2013, 10, 19);
		Books books4 = new Books("PYTHON","Akanksha","YRF", calendar.getTime(), "Adventure", 1000, 12);
		calendar.set(2011, 12, 01);
		Books books5 = new Books("JAVA","Sumit","K9", calendar.getTime(), "Adventure", 1000, 12);
		
		BooksStorage booksStorage = new BooksStorage();
		IBookStore bookStore = new IBookStoreImpl(booksStorage);
		bookStore.addBookToCatalog(books1);
		bookStore.addBookToCatalog(books2);
		bookStore.addBookToCatalog(books3);
		bookStore.addBookToCatalog(books4);
		bookStore.addBookToCatalog(books5);
		
		System.out.println(bookStore.getTotalNumberOfBooks());
		
	}
}
