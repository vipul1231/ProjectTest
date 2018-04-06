package com.test;

import java.util.Map.Entry;

public class CustomHashMap<K, V> {
	
	private int DEFAULT_BUCKET_COUNT = 10;
	
	private Node<K, V>[] buckets = null;
	
	/**
	 * 
	 * 
	 * @author vtiwari
	 *
	 * @param <K>
	 * @param <V>
	 */
	static class Node<K,V> implements Entry<K, V>{
		
		final int hash;
		final K key;
		V value;
		Node<K,V> next;

		public Node(K key, V value, Node<K,V> next) {
			// TODO Auto-generated constructor stub
			this.hash = key.hashCode();
			this.key = key;
			this.value = value;
			this.next = next;
		}
		

		@Override
		public K getKey() {
			// TODO Auto-generated method stub
			return key;
		}

		@Override
		public V getValue() {
			// TODO Auto-generated method stub
			return value;
		}

		@Override
		public V setValue(V value) {
			// TODO Auto-generated method stub
			V oldValue = value;
			this.value = value;
			return oldValue;
		}
		
		public Node<K, V> getNext() {
			return next;
		}


		public void setNext(Node<K, V> next) {
			this.next = next;
		}
		
	}
	
	
	public CustomHashMap(){
		buckets = new Node[DEFAULT_BUCKET_COUNT];
	}
	
	public CustomHashMap(int capacity){
		buckets = new Node[capacity];
	}
	
	private int findBucketIndex(K key){
		return key.hashCode() % buckets.length;
	}
	
	private void checkNullKey(K key){
		if(key==null){
			throw new IllegalArgumentException();
		}
	}
	
	private V get(K key){
		
		int index = findBucketIndex(key);
		Node<K,V> entry = buckets[index];
		
		while(entry!=null && !key.equals(entry.getKey())){
			entry = entry.getNext();
		}
		
		return entry!=null ? entry.getValue() : null;
	}
	
	private boolean put(K key, V value){
		//Find bucket
		checkNullKey(key);
		int index  = findBucketIndex(key);
		Node<K,V> node = buckets[index];
		
		if(null != node){
			while(node.getNext()!=null){
				node = node.getNext();
			}
			
			Node<K,V> newNode = new Node<K, V>(key, value, null);
			node.setNext(newNode);
			return true;
		}
		else {
			buckets[index] = new Node<K, V>(key, value, null);
			return true;
		}
	}
	
	
	public static void main(String[] args){
		CustomHashMap<Integer, String> customHashMap = new CustomHashMap<>();
		customHashMap.put(1, "Vipul");
		customHashMap.put(2, "Deepan");
		
		System.out.println(customHashMap.get(1));
		System.out.println(customHashMap.get(2));
	}
}
