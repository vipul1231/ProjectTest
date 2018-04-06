package sCart.repository

import sCart.domain.Product
import spock.lang.Specification

/**
 * This class test Cart Store.
 */
class CartStoreTest extends Specification{

	CartStore cartStore
	
	def setup(){
		cartStore = new CartStore()
	}
	
	def "Test Add the product"(){
		given:
		Product product = new Product("Dove Soap", 39.99);
		
		when:
		cartStore.addProductToCart(product)
		
		then:
		cartStore.getAllProductInCart().size() == 1
		
	}
	
	def "Test remove product"(){
		given:
		Product product = new Product("Dove Soap", 39.99);
		
		when:
		cartStore.addProductToCart(product)
		cartStore.removeProductFromCart(product, false)
		
		then:
		cartStore.getAllProductInCart().size() == 0
	}
	
	def "Test getAllProductFromCart" () {
		given:
		Product product = new Product("Dove Soap", 39.99);
		List<Product> list = null
		
		when:
		cartStore.addProductToCart(product)
		list = cartStore.getAllProductInCart()
		
		then:
		list.size() == 1
	}
	
	def "Test remove all products" () {
		given:
		Product product = new Product("Dove Soap", 39.99);
		List<Product> list = null
		
		when:
		cartStore.addProductToCart(product)
		cartStore.removeProductFromCart(null, true)
		list = cartStore.getAllProductInCart()
		
		then:
		list.size() == 0
	}
	
	
	
}
