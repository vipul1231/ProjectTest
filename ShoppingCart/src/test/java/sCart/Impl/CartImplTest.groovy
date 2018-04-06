package sCart.Impl

import sCart.Impl.CartImpl
import sCart.Interface.ICart
import sCart.domain.Product
import sCart.repository.CartStore
import spock.lang.Specification

/**
 * This class test Cart implementation
 *
 */
class CartImplTest extends Specification{
	
	CartStore cartStore  = Mock()
	CartImpl cart= null
	
	def setup(){
		cart = new CartImpl(cartStore)
		cart.setIgnoreTax(true)
	}
	
	def "Test EmptyCart" (){
		
		when:
		cart.getAllProduct() 
		
		then:
		1 * cartStore.getAllProductInCart() >> []
	}
	
	def "test Add product to cart"(){
		given:
		Product product = new Product("Dove Soap",39.99)
		
		when:
		cart.addProductToCart(product)
		
		then:
		1 * cartStore.addProductToCart(product)
	}
	
	def "test Get cart value after adding product"() {
		given:
		Product product = new Product("Dove Soap",39.99)
		
		when:
		cart.addProductToCart(product)
		cart.getAllProduct()
		
		
		then:
		1 * cartStore.addProductToCart(product)
		1 * cartStore.getAllProductInCart() >> [product];
	}
	
	def "test Removing a product from cart"(){
		given:
		Product product = new Product("Dove Soap",39.99)
		Product product1 = new Product("Dummy Soap",39.99)
		
		when:
		cart.addProductToCart(product)
		cart.getAllProduct()
		cart.removeProductFromCart(product, false)
		cart.removeProductFromCart(product1, false)
		
		
		then:
		1 * cartStore.addProductToCart(product)
		1 * cartStore.getAllProductInCart() >> [product];
		1 * cartStore.removeProductFromCart(product, false) >> true
		1 * cartStore.removeProductFromCart(product1, false) >> false 
	}
	
	def "test Calculate price of cart"(){
		given:
		Product product = new Product("Dove Soap",39.99)
		
		when:
		cart.addProductToCart(product)
		Double[] price = cart.calculatePriceOfCart()
		
		then:
		1 * cartStore.addProductToCart(product)
		1 * cartStore.getAllProductInCart() >> [product] 
		1 * cartStore.quantityOfProduct(_) >> 1
		price[0] == product.getPrice()
	}
	
}
