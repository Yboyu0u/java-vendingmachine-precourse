package vendingmachine.domain.product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import vendingmachine.message.Sign;
import vendingmachine.validation.validator.InputProductNameValidator;
import vendingmachine.validation.validator.InputProductValidator;

public class ProductSystem {

	private final List<Product> productList;

	public ProductSystem() {
		this.productList = new ArrayList<>();
	}

	public void takeProducts(List<String> products) {
		products.forEach(this::addProductInProductList);
	}

	private void addProductInProductList(String rowProduct) {
		InputProductValidator.validate(rowProduct, productList);

		String[] product = rowProduct
			.replaceAll("\\[", Sign.NULL)
			.replaceAll("\\]", Sign.NULL)
			.split(Sign.PRODUCT_DIVISOR);

		productList.add(new Product(product[ProductUnit.NAME], Integer.parseInt(product[ProductUnit.PRICE]),
			Integer.parseInt(product[ProductUnit.STOCK])));
	}

	public int findPriceAndSubtractStockByProductName(String productName) {
		InputProductNameValidator.validate(productName, productList);

		Product product = findProductByProductName(productName);
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
		return productList.get(0).getPrice() > inputCost;
	}

	public boolean isOutOfStock() {
		return productList.stream().noneMatch(product -> product.getStock() > 0);
	}
}
