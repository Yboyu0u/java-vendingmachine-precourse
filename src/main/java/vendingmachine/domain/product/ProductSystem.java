package vendingmachine.domain.product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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

	public int findPriceAndSubtractStockByProductName(String productName) {
		Product product =  findProductByProductName(productName);
		product.subtractStock();
		return product.getPrice();
	}

	public Product findProductByProductName(String productName) {
		return productList.stream()
			.filter(product -> product.getName().equals(productName))
			.collect(Collectors.toList())
			.get(0);
	}

	public boolean isNotValidInputCost(int inputCost) {
		Collections.sort(productList);
		if(productList.get(0).getPrice() > inputCost) {
			return true;
		}

		return false;
	}

	public boolean isOutOfStock() {
		if(productList.stream().filter(product -> product.getStock() > 0).count() == 0) {
			return true;
		}

		return false;
	}
}
