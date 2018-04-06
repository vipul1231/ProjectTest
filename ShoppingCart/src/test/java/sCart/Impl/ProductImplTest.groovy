package sCart.Impl

import sCart.domain.Product
import sCart.repository.ProductCatalog
import spock.lang.Specification

/**
 * This class test product implmentation
 */
class ProductImplTest extends Specification{
	
	ProductImpl productImpl;
	
	ProductCatalog productCatalog = Mock()
	
	def setup(){
		productImpl = new ProductImpl(productCatalog)
	}
	
	
	def "Test Add product" (){
		given:
		Product product = new Product("Dove Soap",39.99)
		
		when:
		productImpl.addProduct(product)
		
		then:
		1 * productCatalog.addProduct(product)
	}
	
	
	def "Test Remove Product"() {
		given:
		Product product = new Product("Dove Soap",39.99)
		
		when:
		productImpl.removeProduct(product.getUniqueId())
		
		then:
		1 * productCatalog.removeProduct(product.getUniqueId())
	}

	def "Test get Product"() {
		given:
		Product product = new Product("Dove Soap",39.99)
		
		when:
		productImpl.getProduct(product.getUniqueId())
		
		then:
		1 * productCatalog.getProduct(product.getUniqueId())
	}
	
}
