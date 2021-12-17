package vendingmachine.view;

import vendingmachine.message.Message;

public class InputView {

	public static void printEnterMoneyInVendingMachine() {
		System.out.println(Message.ENTER_MONEY_VENDING_MACHINE_HAS);
	}

	public static void printEnterProducts() {
		System.out.println();
		System.out.println(Message.ENTER_PRODUCT_INFORMATION);
	}

	public static void printEnterInputCost() {
		System.out.println();
		System.out.print(Message.PRINT_INPUT_COST);
	}

	public static void printEnterBePurchaseProduct() {
		System.out.println(Message.ENTER_PRODUCT_NAME_BE_PURCHASE);
	}
}
