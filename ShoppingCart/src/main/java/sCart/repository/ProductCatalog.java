package sCart.repository;

import java.util.HashMap;
import java.util.Map;

import sCart.domain.Product;

/**
 * This class contains all products which are created.
 */
public class ProductCatalog {
	
	/**
	 * Product map where key is hashcode followed by value.
	 */
	Map<Integer, Product> products = new HashMap<>();

	/**
	 * Add product.
	 * 
	 * @param product
	 * @return
	 */
	public Integer addProduct(Product product){
		products.put(product.getUniqueId(), product);
		return product.getUniqueId();
	}

	/**
	 * Remove product
	 * 
	 * @param uUid
	 * @return
	 */
	public Product removeProduct(Integer uUid){
		return products.remove(uUid);
		
	}
	
	/**
	 * Returns the product for the provided Id.
	 * 
	 * @param uUid
	 * @return
	 */
	public Product getProduct(Integer uUid){
		return products.get(uUid);
	}
	
	/**
	 * Returns total no of products added.
	 * 
	 * @return
	 */
	public int totalNoOfProducts(){
		return products.size();
	}
	
}
