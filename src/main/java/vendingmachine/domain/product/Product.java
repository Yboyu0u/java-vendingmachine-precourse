package vendingmachine.domain.product;

import java.util.Objects;

public class Product implements Comparable<Product> {

	private final String name;
	private final int price;
	private int stock;

	public Product(String name, int price, int stock) {
		this.name = name;
		this.price = price;
		this.stock = stock;
	}

	public void subtractStock() {
		if (stock > 0) {
			stock--;
		}
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public int getStock() {
		return stock;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Product product = (Product)o;
		return Objects.equals(name, product.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public int compareTo(Product o) {
		return this.price - o.price;
	}
}
