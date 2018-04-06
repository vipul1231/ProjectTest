package sCart.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import sCart.domain.Product;

/**
 * This class will keep all the products added to the cart.
 */
public class CartStore {
	
	/**
	 * List containing all the products
	 */
	Map<Product, Integer> products = new HashMap<>();
	
	/**
	 * Add product to cart.
	 * 
	 * @param product
	 */
	public void addProductToCart(Product product){
		
		Integer noOfProducts = products.get(product);
		if(noOfProducts == null){
			products.put(product, 1);
		}
		else {
			products.put(product, ++noOfProducts);
		}
	}
	
	/**
	 * Remove product from cart.
	 * 
	 * @param product
	 * @param removeAll
	 * @return
	 */
	public boolean removeProductFromCart(Product product, boolean removeAll){
		
		if(removeAll){
			products.clear();
			return true;
		}
		else {
			Integer value  = products.remove(product);
			
			if(value!=null){
				return true;
			}
			else {
				return false;
			}
		}
	}
	
	/**
	 * This will return all the product in cart.
	 * 
	 * @return
	 */
	public List<Product> getAllProductInCart(){
		List<Product> list = new ArrayList<>();
		products.keySet().stream().forEach(i -> list.add(i));;
		return list;
	}
	
	/**
	 * This method returns quantity of product added to cart.
	 * 
	 * @param product
	 * @return
	 */
	public Integer quantityOfProduct(Product product){
		return products.get(product);
	}
}
