package sCart.domain;

/**
 * This class handles product creation.
 */
final public class Product extends ProductTax{
	
	/**
	 * Unique id for this product.
	 */
	Integer uniqueId;
	
	/**
	 * Product name.
	 */
	final String name;
	
	/**
	 * Product price.
	 */
	final Double price;
	
	/**
	 * Applicable Tax on this product defaulted to 12.5.
	 */
	Double tax;

	public Product(String name, Double price) {
		this.name = name;
		this.price = price;
		this.uniqueId = this.hashCode();
		//Assign tax to this product
		this.tax = super.defaultTaxOnProduct();
	}
	
	public Integer getUniqueId() {
		return uniqueId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setTax(Double taxAmount){
		this.tax = taxAmount;
	}
	
	public Double getTax() {
		return tax;
	}
	
	public Double getPrice() {
		return price;
	}
	
	public int hashCode(){
		int prime = 37;
		int result = prime + name.hashCode()+price.intValue();
		return result;
	}
		
	public boolean equals(Object object){
		
		if(object == null) return false;
		
		if(object instanceof Product){
			
			Product product = (Product) object;
			
			if(product.getName().equals(this.getName()) && product.getPrice() == this.getPrice()){
				return true;
			}
		}
		
		return false;
	}
	
}
