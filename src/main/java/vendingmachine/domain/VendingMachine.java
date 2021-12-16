package vendingmachine.domain;

import java.util.List;

import vendingmachine.domain.coin.CoinSystem;
import vendingmachine.domain.product.ProductSystem;
import vendingmachine.message.Message;
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
		coinSystem.inCoinMap(money);
	}

	public void getCoin() {
		ResponseMessage.printLineBreaker();
		ResponseMessage.of(Message.PRINT_VENDING_MACHINE_COIN);
		coinSystem.getCoinInCoinMap();
	}

	public void addProducts(List<String> products) {
		productSystem.takeProducts(products);
	}

	public void saveInputCost(int inputCost) {
		if(this.inputCost == 0) {
			this.inputCost = inputCost;
		}
	}

	public void getInputCost() {
		ResponseMessage.printInputCost(inputCost);
	}

	public void subtractInputCostAndProductStockByProduct(String productName) {
		inputCost -= productSystem.findPriceAndSubtractStockByProductName(productName);
	}

	public boolean checkWhetherGetBalanceOrNot() {
		return !productSystem.isNotValidInputCost(inputCost) && !productSystem.isOutOfStock();
	}

	public void getChangeCoin() {
		ResponseMessage.printChange();
		coinSystem.getCalculatedChangeCoin(inputCost);
	}
}
