package vendingmachine.domain;

import java.util.List;

import vendingmachine.domain.coin.CoinSystem;
import vendingmachine.domain.product.ProductSystem;

public class VendingMachine {

	private CoinSystem coinSystem;
	private ProductSystem productSystem;

	public VendingMachine() {
		this.coinSystem = new CoinSystem();
		this.productSystem = new ProductSystem();
	}

	public void makeCoin(int money) {
		coinSystem.makeCoinInCoinMap(money);
	}

	public void getCoin() {
		coinSystem.getCoinInCoinMap();
	}

	public void addProducts(List<String> products) {
		productSystem.takeProducts(products);
	}

}
