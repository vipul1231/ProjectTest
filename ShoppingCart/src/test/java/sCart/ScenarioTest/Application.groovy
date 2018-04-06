package sCart.ScenarioTest

import sCart.Impl.CartImpl
import sCart.Impl.ProductImpl
import sCart.Interface.ICart
import sCart.Interface.IProduct
import sCart.domain.Product
import sCart.repository.CartStore
import sCart.repository.ProductCatalog
import spock.lang.Specification

/**
 * This test class test all the steps from 1 to 3 mentioned in problem statement.
 *
 */
class Application extends Specification{

	CartStore store
	ProductCatalog productCatalog
	ICart cart
	IProduct productStore
	
	
	def setup(){
		store = new CartStore();
		productCatalog = new ProductCatalog()
		
		cart = new CartImpl(store)
		cart.setIgnoreTax(true)
		productStore = new ProductImpl(productCatalog)	
	}
	
	def "Step 1 test" () {
		given:
		Product product = new Product("New Soap",39.99);
		
		when:
		List<Product> list = cart.getAllProduct()
		
		then:
		list.size() == 0
		
		when:
		for(int i=0;i<5;i++){
			cart.addProductToCart(product)
		}
		list = cart.getAllProduct()
		Double[] cartPrice = cart.calculatePriceOfCart();
		
		then:
		list.size() == 1
		cartPrice[0] == 199.96
		
		when:
		Integer quantity = cart.getQuantityOfProduct(product)
		
		then:
		quantity == 5
		
	}
	
	def "Step 2 test"(){
		given:
		Product product = new Product("New Soap",39.99);
		
		when:
		productStore.addProduct(product)
		List<Product> list = cart.getAllProduct()
		
		then:
		list.size() == 0
		
		when:
		for(int i=0;i<5;i++){
			cart.addProductToCart(product)
		}
		list = cart.getAllProduct()
		Integer quantity = cart.getQuantityOfProduct(product)
		
		then:
		list.size() == 1
		quantity == 5
		
		when:
		for(int i=0;i<3;i++){
			cart.addProductToCart(product)
		}
		list = cart.getAllProduct()
		Double[] price = cart.calculatePriceOfCart()
		quantity = cart.getQuantityOfProduct(product)
		
		then:
		list.size() == 1
		price[0] == 319.92
		quantity == 8
		productStore.getTotalProductInCatalog() == 1
	}
	
	def "Step 3 test"(){
		given:
		Product product1 = new Product("Dove Soap",39.99);
		Product product2 = new Product("Axe Deo",99.99);
		productStore.addProduct(product1)
		productStore.addProduct(product2)
		cart.setIgnoreTax(false)
		
		when:
		for(int i=0;i<2;i++){
			cart.addProductToCart(product1)
			cart.addProductToCart(product2)
		}
		List<Product> productsInCart = cart.getAllProduct()
		
		then:
		productsInCart.size() == 2
		Double[] total = cart.calculatePriceOfCart()
		total[0] == 314.96
		total[1] == 35.00
		cart.setIgnoreTax(true)
	}
}
