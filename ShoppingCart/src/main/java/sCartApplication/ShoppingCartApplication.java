package sCartApplication;

import java.util.List;

import sCart.Impl.CartImpl;
import sCart.Impl.ProductImpl;
import sCart.Interface.ICart;
import sCart.Interface.IProduct;
import sCart.domain.Product;
import sCart.repository.CartStore;
import sCart.repository.ProductCatalog;

/**
 * This application class will demo the 3 scenario mentioned in question. Apart from this
 * A testcase is also written for testing the scenario with name Application.groovy
 *
 */
public class ShoppingCartApplication 
{
    public static void main( String[] args )
    {
    	//Step 1
        ShoppingCartApplication shApplication = new ShoppingCartApplication(); 
        ICart cart = shApplication.createShippingCart();
        cart.setIgnoreTax(true);
        ProductCatalog productCatalog = new ProductCatalog();
        IProduct productRepo = new ProductImpl(productCatalog);
    	List<Product> productInCart = cart.getAllProduct();
    	
    	System.out.println("Scenario 1.....");
    	
    	if(productInCart.isEmpty()){
    		System.out.println("Cart is Empty...");
    	}
    	
    	System.out.println("Creating and Adding 5 new product in cart..."); 
    	
    	for(int i=0;i<5;i++){
    		Product product = shApplication.createProduct("Dove Soap", 39.99);
    		productRepo.addProduct(product);
    		cart.addProductToCart(product);
    	}
 
    	Double[] totalPriceAndTax = cart.calculatePriceOfCart(); 
    	if(!productInCart.isEmpty()){
    		System.out.println("No of product in cart: "+productInCart.size());
    	}
    	System.out.println("Total Cart Price :"+totalPriceAndTax[0] + " Total Tax: "+totalPriceAndTax[1]);
    	
    	
    	//Step 2
    	System.out.println("\n\nScenario 2.....");
    	for(int i=0;i<3;i++){
    		Product product = shApplication.createProduct("Dove Soap", 39.99);
    		productRepo.addProduct(product);
    		cart.addProductToCart(product);
    	}
    	if(!productInCart.isEmpty()){
    		System.out.println("No of product in cart: "+productInCart.size());
    	}
    	totalPriceAndTax = cart.calculatePriceOfCart(); 
    	System.out.println("Total Cart Price :"+totalPriceAndTax[0] + " Total Tax: "+totalPriceAndTax[1]);

    	//Step 3
    	cart.setIgnoreTax(false);
    	System.out.println("\n\nScenario 3....."); 
    	cart.removeProductFromCart(null,true);
    	System.out.println("No of product in cart: "+productInCart.size());
    	for(int i=0;i<2;i++){
    		Product product1 = shApplication.createProduct("Dove Soap", 39.99);
    		Product product2 = shApplication.createProduct("Axe Deo", 99.99);
    		productRepo.addProduct(product1);
    		productRepo.addProduct(product2);
    		
    		cart.addProductToCart(product1);
    		cart.addProductToCart(product2);
    	}
    	totalPriceAndTax = cart.calculatePriceOfCart(); 
    	System.out.println("Total Cart Price :"+totalPriceAndTax[0] + " Total Tax: "+totalPriceAndTax[1]);
    	
    	
    }
    
    private ICart createShippingCart(){
    	CartStore cartStore = new CartStore();
    	return new CartImpl(cartStore);
    }
    
    
    private Product createProduct(String name, Double price){
    	return new Product(name, price);
    }
}
