package sCart.Impl;

import sCart.Interface.IProduct;
import sCart.domain.Product;
import sCart.repository.ProductCatalog;

public class ProductImpl implements IProduct{
	
	ProductCatalog productCatalog;
	
	public ProductImpl(ProductCatalog catalog) {
		this.productCatalog = catalog;
	}

	public Integer addProduct(Product product) {
		return productCatalog.addProduct(product);
	}

	public Product removeProduct(Integer uUid) {
		return productCatalog.removeProduct(uUid);
	}

	public Product getProduct(Integer uUid) {
		return productCatalog.getProduct(uUid);
	}

	@Override
	public int getTotalProductInCatalog() {
		return productCatalog.totalNoOfProducts();
	}
}
