package vendingmachine.service;

import vendingmachine.domain.VendingMachine;

public class VendingMachineService {

	private VendingMachine vendingMachine;

	public VendingMachineService() {
		this.vendingMachine = new VendingMachine();
	}

	public void postMoneyVendingMachineHas(String input) {
		// TODO: validation 처리
		vendingMachine.makeCoinInCoinMap(Integer.parseInt(input));
		vendingMachine.getCoinInCoinMap();
	}

	public void  postProductInformation() {
		// TODO: validation 처리
	}

	public void postInputCost() {
		// TODO: validation 처리
	}

	public void postProductNameBePurchase() {
		// TODO: validation 처리
	}

	public void getChange() {

	}
}
