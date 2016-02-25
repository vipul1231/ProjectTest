package com.src;

public class ObserverDesignPattern {
	
	public static void main(String[] args)
	{
		Blog blog = new Blog();
		
		User usr1 = new User();
		User usr2 = new User();
		
		blog.registerObserver(usr1);
		blog.registerObserver(usr2);
		
		usr1.setSubject(blog);
		usr2.setSubject(blog);
		
		System.out.println(usr1.getArticle());
		
		blog.postNewArticle();
		System.out.println(usr1.getArticle());
	}

}
