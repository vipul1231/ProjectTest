package com.DesignPattern.Revision;

import javax.naming.OperationNotSupportedException;

interface Bank{
	int getAccount() throws Exception;
}

interface Loans {
	int homeLoan() throws Exception;
	int carLoan() throws Exception;
}

class Savings implements Bank{

	@Override
	public int getAccount() throws Exception {
		// TODO Auto-generated method stub
		return 1;
	}

}

class Current implements Bank{

	@Override
	public int getAccount() throws Exception {
		// TODO Auto-generated method stub
		return 2;
	}

}

class HomeLoan implements Loans {

	@Override
	public int homeLoan() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int carLoan() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}

/*
 * ####### This is Abstract Factory Example.
 */

interface absFactory{
	Bank getAccountType(String type) throws Exception;
	Loans getLoanType(String type) throws Exception;
}

class BankFactory implements absFactory {

	@Override
	public Bank getAccountType(String type) {
		// TODO Auto-generated method stub
		if(type.equals("Savings")){
			return new Savings();
		}
		else {
			return new Current();
		}
	}

	@Override
	public Loans getLoanType(String type) throws Exception {
		// TODO Auto-generated method stub
		throw new OperationNotSupportedException("Cannot get Loan. Use Loan Factory.");
	}
}


/**
 * ######### This is factory class. 
 */
class Factory {
	
	public Bank getAccount(String type){
		
		if(type.equals("Savings")){
			return new Savings();
		}
		else {
			return new Current();
		}
	}
}
