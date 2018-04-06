package sCart.Interface;

import java.util.List;

import sCart.domain.Product;

/**
 * This interface handles all functionality of cart
 * 
 *
 */
public interface ICart {
	
	/**
	 * This method add product to cart.
	 * 
	 * @param product
	 */
	void addProductToCart(Product product);
	
	/**
	 * This method returns total price at index 0 and total tax at index 1.
	 * 
	 * @return
	 */
	Double[] calculatePriceOfCart();
	
	/**
	 * This method returns all the product present in cart.
	 * 
	 * @return
	 */
	List<Product> getAllProduct();
	
	
	/**
	 * This method returns quantity of product present in cart.
	 * @return
	 */
	Integer getQuantityOfProduct(Product product);
	
	/**
	 * This method removes product from cart
	 * 
	 * @param product
	 * @return
	 */
	boolean removeProductFromCart(Product product, boolean removeAll);
	
	/**
	 * This method allows the cart to ignore calculation of tax
	 * 
	 * @param tax
	 */
	void setIgnoreTax(boolean tax);
}
