package com.DesignPattern.Proxy;


interface InternetAccess {
	void grantAccess();
}


class ManagerInternetAccess implements InternetAccess{

	@Override
	public void grantAccess() {
		// TODO Auto-generated method stub
		System.out.println("Managers can access the internet");
	}
}

class OutSideInternetAccess implements InternetAccess{
	
	private String designation;
	private ManagerInternetAccess managerInternetAccess;

	public OutSideInternetAccess(String designation) {
		// TODO Auto-generated constructor stub
		this.designation = designation;
	}
	
	
	@Override
	public void grantAccess() {
		// TODO Auto-generated method stub
		
		if(getManager()){
			System.out.println("You are manager. You can Access Internet.");
			managerInternetAccess = new ManagerInternetAccess();
			managerInternetAccess.grantAccess();
		}
		else {
			System.out.println("You cannot access the internet. Your designation :"+designation);
		}
	}
	
	public boolean getManager(){
		
		if(designation.equals("Manager")){
			return true; 
		}
		return false;
	}
	
}


public class ProxyDesignPattern {
	
	public static void main(String[] args){
		InternetAccess internetAccess = new ManagerInternetAccess();
		internetAccess.grantAccess();	
		InternetAccess outSideInternetAccess = new OutSideInternetAccess("Manager");
		InternetAccess outSideInternetAccess1 = new OutSideInternetAccess("Employee");
		outSideInternetAccess.grantAccess();
		outSideInternetAccess1.grantAccess();
	}
}
