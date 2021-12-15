package vendingmachine.domain.product;

import java.util.ArrayList;
import java.util.List;

import vendingmachine.message.Sign;

public class ProductSystem {

	private static final int NAME = 0;
	private static final int PRICE = 1;
	private static final int STOCK = 2;

	private List<Product> productList;

	public ProductSystem() {
		this.productList = new ArrayList<>();
	}

	public void takeProducts(List<String> products) {
		products.stream()
			.forEach(rowProduct -> addProductInProductList(rowProduct));
	}

	private void addProductInProductList(String rowProduct) {
		String[] product = rowProduct.split(Sign.PRODUCT_DIVISOR);
		productList.add(new Product(product[NAME], Integer.parseInt(product[PRICE]), Integer.parseInt(product[STOCK])));
	}

}
