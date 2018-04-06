package com.DesignPattern.Iterator;

interface Iterator<T>{
	T next();
	boolean hasNext();
}


interface Container<T>{
	Iterator<T> getIterator();
}


class CollectionOfNames implements Container<String> {

	String[] names = {"Ashwani Rajput", "Soono Jaiswal","Rishi Kumar","Rahul Mehta","Hemant Mishra"};
	
	@Override
	public Iterator<String> getIterator() {
		// TODO Auto-generated method stub
		return new CollectionOfNamesIterator();
	}
	
	class CollectionOfNamesIterator implements Iterator<String>{

		int i = 0;
		
		@Override
		public String next() {
			// TODO Auto-generated method stub
			return names[i++];
			
		}

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			if(i != names.length){
				return true;
			}
			return false;
		}
		
	}
	
}


public class IteratorPatternImpl {

	
	
	public static void main(String[] args){
		CollectionOfNames collectionOfNames = new CollectionOfNames();
		Iterator<String> iter =  collectionOfNames.getIterator();
		
		while(iter.hasNext()){
			System.out.println(iter.next());
		}
	}
}
