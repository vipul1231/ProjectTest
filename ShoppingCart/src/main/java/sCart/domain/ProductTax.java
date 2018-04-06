package sCart.domain;

/**
 * This class calculates product tax.
 */
abstract public class ProductTax {

	/**
	 * Default tax to be applied on product
	 * 
	 * @return
	 */
	double defaultTaxOnProduct(){
		return 12.5;
	}
}
