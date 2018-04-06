package sCart.Impl;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.List;

import sCart.Interface.ICart;
import sCart.domain.Product;
import sCart.repository.CartStore;

/**
 * This class provides implementation for cart interface
 */
public class CartImpl implements ICart{
	
	/**
	 * Cart store where added product in cart is handled.
	 */
	CartStore cartStore;
	
	/**
	 * Flag if tax can be ignored.
	 */
	boolean ignoreTax;
	
	/**
	 * #### Override methods from interface ####
	 */

	@Override
	public void addProductToCart(Product product) {
		cartStore.addProductToCart(product);
	}

	@Override
	public Double[] calculatePriceOfCart() {
		List<Product> list = cartStore.getAllProductInCart();
		Double[] totalPriceWithTax = new Double[2];
		Double totalPrice = 0.00;
		Double totalTx = 0.00;
		for(Product product : list){
//			totalPrice += product.getPrice();
//			if(!ignoreTax){
//				double tax = product.getPrice()*(product.getTax()/100);
//				totalTx += tax;
//				totalPrice += tax;
//			}
			
			Integer quantity = cartStore.quantityOfProduct(product);
			totalPrice += product.getPrice()*quantity;
			if(!ignoreTax){
				double tax = product.getPrice()*(product.getTax()/100);
				totalTx += tax*quantity;
				//totalPrice += totalTx;
			}
		}
		
		if(!ignoreTax){
			totalPrice += totalTx;
		}
		DecimalFormat f = new DecimalFormat("##.00");
		f.setRoundingMode(RoundingMode.CEILING);
		totalPriceWithTax[0] = Double.parseDouble(f.format(totalPrice));
		totalPriceWithTax[1] = Double.parseDouble(f.format(totalTx));
		return totalPriceWithTax;
	}

	@Override
	public List<Product> getAllProduct() {
		return cartStore.getAllProductInCart();
	}

	@Override
	public boolean removeProductFromCart(Product product, boolean removeAll) {
		return cartStore.removeProductFromCart(product, removeAll);
	}
	
	//Getters and setters
	
	public void setIgnoreTax(boolean ignoreTax) {
		this.ignoreTax = ignoreTax;
	}
	
	//Constructors
	public CartImpl(CartStore cartStore) {
		this.cartStore = cartStore;
	}

	@Override
	public Integer getQuantityOfProduct(Product product) {
		return cartStore.quantityOfProduct(product);
	}
}
