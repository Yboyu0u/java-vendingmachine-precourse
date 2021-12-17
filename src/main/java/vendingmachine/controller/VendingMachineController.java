package vendingmachine.controller;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.validation.dto.ResponseError;
import vendingmachine.view.InputView;
import vendingmachine.service.VendingMachineService;

public class VendingMachineController {

	private VendingMachineService vendingMachineService;

	public VendingMachineController() {
		this.vendingMachineService = new VendingMachineService();
	}

	public void postMoneyVendingMachineHas() {
		try {
			InputView.printEnterMoneyInVendingMachine();
			vendingMachineService.postMoneyVendingMachineHas(Console.readLine());
		} catch (IllegalArgumentException e) {
			ResponseError.of(e.getMessage());
			postMoneyVendingMachineHas();
		}
	}

	public void postProductInformation() {
		try {
			InputView.printEnterProducts();
			vendingMachineService.postProductInformation(Console.readLine());
		} catch (IllegalArgumentException e) {
			ResponseError.of(e.getMessage());
			postProductInformation();
		}
	}

	public void postInputCost() {
		try {
			InputView.printEnterInputCost();
			vendingMachineService.postInputCost(Console.readLine());
		} catch (IllegalArgumentException e) {
			ResponseError.of(e.getMessage());
			postInputCost();
		}
	}

	public void postProductNameBePurchase() {
		try {
			boolean start = true;
			while (start) {
				InputView.printEnterBePurchaseProduct();
				start = vendingMachineService.postProductNameBePurchase(Console.readLine());
			}
		} catch (IllegalArgumentException e) {
			ResponseError.of(e.getMessage());
			postProductNameBePurchase();
		}

	}

	public void getChange() {
		vendingMachineService.getChange();
	}
}
