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

		// 투입 금액 저장
		vendingMachine.saveInputCost(Integer.parseInt(input));
	}

	public void postProductNameBePurchase() {
		// TODO: validation 처리
	}

	public void getChange() {

	}
}
