package sCart.repository

import sCart.domain.Product
import spock.lang.Specification

/**
 * This class test the product catalog
 */
class ProductCatalogTest extends Specification{

	ProductCatalog productCatalog

	def setup(){
		productCatalog = new ProductCatalog()
	}

	def "test add Product"() {
		given:
		Product product = new Product("Dove Soap", 39.99);
		
		when:
		productCatalog.addProduct(product)
		
		then:
		productCatalog.getProduct(product.getUniqueId()) == product
		
	}	
	
	def "test remove product"() {
		given:
		Product product = new Product("Dove Soap", 39.99);
		
		when:
		productCatalog.removeProduct(product.getUniqueId())
		
		then:
		productCatalog.getProduct(product.getUniqueId()) == null
		
	}
	
	def "test get product"() {
		given:
		Product product = new Product("Dove Soap", 39.99);
		
		when:
		productCatalog.addProduct(product)
		Product result = productCatalog.getProduct(product.getUniqueId())
		
		then:
		result == product
		
	}
	
}
