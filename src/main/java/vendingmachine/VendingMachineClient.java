package vendingmachine;

import vendingmachine.controller.VendingMachineController;

public class VendingMachineClient {

	private final VendingMachineController vendingMachineController;

	public VendingMachineClient() {
		this.vendingMachineController = new VendingMachineController();
	}

	public void start() {
		vendingMachineController.postMoneyVendingMachineHas();
		vendingMachineController.postProductInformation();
		vendingMachineController.postInputCost();
		vendingMachineController.postProductNameBePurchase();
		vendingMachineController.getChange();
	}
}
