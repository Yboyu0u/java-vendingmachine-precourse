package vendingmachine.service;

import java.util.Arrays;
import java.util.stream.Collectors;

import vendingmachine.domain.VendingMachine;
import vendingmachine.message.Sign;
import vendingmachine.validation.validator.InputCostValidator;
import vendingmachine.validation.validator.InputProductsValidator;
import vendingmachine.validation.validator.InputVendingMachineMoneyValidator;

public class VendingMachineService {

	private final VendingMachine vendingMachine;

	public VendingMachineService() {
		this.vendingMachine = new VendingMachine();
	}

	public void postMoneyVendingMachineHas(String input) {
		InputVendingMachineMoneyValidator.validate(input);

		vendingMachine.makeCoin(Integer.parseInt(input));
		vendingMachine.getCoin();
	}

	public void postProductInformation(String input) {
		InputProductsValidator.validate(input);

		vendingMachine.addProducts(Arrays
			.stream(input.split(Sign.PRODUCTS_DIVISOR))
			.collect(Collectors.toList()));
	}

	public void postInputCost(String input) {
		InputCostValidator.validate(input);

		vendingMachine.saveInputCost(Integer.parseInt(input));
		vendingMachine.getInputCost();
	}

	public boolean postProductNameBePurchase(String input) {
		vendingMachine.subtractInputCostAndProductStockByProduct(input);
		vendingMachine.getInputCost();

		return vendingMachine.checkWhetherGetBalanceOrNot();
	}

	public void getChange() {
		vendingMachine.getChangeCoin();
	}
}
