package sCart.Interface;

import sCart.domain.Product;

/**
 * This interface provides functionality for handling product store.
 */
public interface IProduct {
	
	/**
	 * This method add product to product catalog/store.
	 * 
	 * @param product
	 * @return returns unique of product i.e hashcode
	 */
	Integer addProduct(Product product);
	
	/**
	 * This method removes product from product catalog/store.
	 * 
	 * @param uUid
	 * @return
	 */
	Product removeProduct(Integer uUid);
	
	/**
	 * This method will return the product based on unique Id.
	 * 
	 * @param uUid
	 * @return
	 */
	Product getProduct(Integer uUid);
	
	/**
	 * This method tells how many product are available in product catalog.
	 * 
	 * @return 
	 */
	int getTotalProductInCatalog();
	
}
