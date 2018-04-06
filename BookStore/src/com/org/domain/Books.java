package com.org.domain;

import java.util.Date;

public class Books {
	
	String name;
	String author;
	String publisher;
	Date year;
	String category;
	int price;
	int sCount;
	
	public Books(String name, String author, String publisher, Date year, String category, int price, int sCount){
		this.name = name;
		this.author = author;
		this.publisher = publisher;
		this.year = year;
		this.category = category;
		this.price = price;
		this.sCount = sCount;
	}
	
	
	public String getName() {
		return name;
	}

	public String getAuthor() {
		return author;
	}

	public String getPublisher() {
		return publisher;
	}

	public Date getYear() {
		return year;
	}

	public String getCategory() {
		return category;
	}

	public int getPrice() {
		return price;
	}

	public int getsCount() {
		return sCount;
	}

}
