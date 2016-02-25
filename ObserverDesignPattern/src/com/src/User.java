package com.src;

public class User implements Observer{
	
	private String article;
	
	private Subject blog;

	@Override
	public void update() {
		// TODO Auto-generated method stub
		System.out.println("State change reported by Subject");
		article = (String) blog.getUpdate();
	}

	@Override
	public void setSubject(Subject subject) {
		// TODO Auto-generated method stub
		this.blog = subject;
		article = "New Article";
		
	}

	public String getArticle() {
		return article;
	}
}
