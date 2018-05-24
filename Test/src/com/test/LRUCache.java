package com.test;

import java.util.HashMap;
import java.util.Map;

public class LRUCache<K,V> {
	
	public final int LENGTH;
	int count = 0;
	
	public LRUCache(int length) {
		this.LENGTH = length;
		cache = new HashMap<>();
	}
	
	class Node<T,U>{
		Node<T,U> previous;
		Node<T,U> next;
		T key;
		U value;
		
		Node(Node<T,U> previous,Node<T,U> next, T key, U value){
			this.previous = previous;
			this.next = next;
			this.key = key;
			this.value = value;
		}
	}
	
	Map<K, Node<K,V>> cache;
	Node<K,V> front = null;
	Node<K,V> back = null;
	
	/**
	 * 
	 * @param key
	 * @return
	 */
	public V get(K key) {
		
		return null;
	}
	
	public boolean put(K key, V value){
		
		if(cache.containsKey(key)){
			return false;
		}
	
		if(front == null && back == null){
			Node<K, V> node = new Node<K,V>(null, null, key, value);
			front = node;
			back = node;
			cache.put(key, node);
			count++;
		}
		
		else if (count!=LENGTH){
			Node<K,V> node = new Node<K, V>(null, null, key, value);	
			cache.put(key, node);
			count++;
			
		}

		return false;
	}
	
	public static void main(String[] args){
		LRUCache<Integer, Integer> lru = new LRUCache<>(5);
		lru.put(1, 7);
		lru.put(4, 8);
		lru.put(8, 15);
		lru.put(3, 14);
		lru.put(2, 19);
	}
}
