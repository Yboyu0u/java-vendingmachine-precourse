package vendingmachine.domain;

import java.util.List;

import vendingmachine.domain.coin.CoinSystem;
import vendingmachine.domain.product.ProductSystem;
import vendingmachine.message.dto.ResponseMessage;

public class VendingMachine {

	private CoinSystem coinSystem;
	private ProductSystem productSystem;
	private int inputCost;

	public VendingMachine() {
		this.coinSystem = new CoinSystem();
		this.productSystem = new ProductSystem();
		this.inputCost = 0;
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

	public void saveInputCost(int inputCost) {
		if(inputCost > 0) {
			this.inputCost = inputCost;
		}
	}

	public void getInputCost() {

	}
}
