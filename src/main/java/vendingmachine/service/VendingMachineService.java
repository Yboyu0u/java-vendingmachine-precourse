package vendingmachine.service;

import java.util.Arrays;
import java.util.stream.Collectors;

import vendingmachine.domain.VendingMachine;
import vendingmachine.message.Sign;

public class VendingMachineService {

	private VendingMachine vendingMachine;

	public VendingMachineService() {
		this.vendingMachine = new VendingMachine();
	}

	public void postMoneyVendingMachineHas(String input) {
		// TODO: validation 처리
		vendingMachine.makeCoin(Integer.parseInt(input));
		vendingMachine.getCoin();
	}

	public void postProductInformation(String input) {
		// TODO: validation 처리
		vendingMachine.addProducts(Arrays
			.stream(input
				.replaceAll("\\[","")
				.replaceAll("\\]","")
				.split(Sign.PRODUCTS_DIVISOR))
			.collect(Collectors.toList()));

	}

	public void postInputCost(String input) {
		// TODO: validation 처리
		vendingMachine.saveInputCost(Integer.parseInt(input));
		vendingMachine.getInputCost();
	}

	public boolean postProductNameBePurchase(String input) {
		// TODO: validation 처리
		vendingMachine.subtractInputCostAndProductStockByProduct(input);
		vendingMachine.getInputCost();

		return vendingMachine.checkWhetherGetBalanceOrNot();
	}

	public void getChange() {
		vendingMachine.getChangeCoin();
	}
}
