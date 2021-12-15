package vendingmachine.controller;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.message.Message;
import vendingmachine.message.dto.ResponseError;
import vendingmachine.message.dto.ResponseMessage;
import vendingmachine.service.VendingMachineService;

public class VendingMachineController {

	private VendingMachineService vendingMachineService;

	public VendingMachineController() {
		this.vendingMachineService = new VendingMachineService();
	}

	public void postMoneyVendingMachineHas() {
		try {
			ResponseMessage.of(Message.ENTER_MONEY_VENDING_MACHINE_HAS);
			vendingMachineService.postMoneyVendingMachineHas(Console.readLine());
		} catch (IllegalArgumentException e) {
			ResponseError.of(e.getMessage());
			postMoneyVendingMachineHas();
		}
	}

	public void postProductInformation() {
		try {
			ResponseMessage.of(Message.ENTER_PRODUCT_INFORMATION);
			vendingMachineService.postProductInformation(Console.readLine());
		} catch (IllegalArgumentException e) {
			ResponseError.of(e.getMessage());
		}

	}

	public void postInputCost() {

		try {
			vendingMachineService.postInputCost();
		} catch (IllegalArgumentException e) {
			ResponseError.of(e.getMessage());
		}

	}

	public void postProductNameBePurchase() {

		try {
			vendingMachineService.postProductNameBePurchase();
		} catch (IllegalArgumentException e) {
			ResponseError.of(e.getMessage());
		}

	}

	public void getChange() {
		vendingMachineService.getChange();
	}
}
