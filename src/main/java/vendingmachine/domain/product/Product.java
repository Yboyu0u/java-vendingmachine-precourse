package vendingmachine.domain.product;

public class Product implements Comparable<Product> {

	private String name;
	private int price;
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
	public int compareTo(Product o) {
		return this.price - o.price;
	}
}
