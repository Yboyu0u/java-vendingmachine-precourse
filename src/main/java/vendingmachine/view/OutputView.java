package vendingmachine.view;

import java.util.Map;

import vendingmachine.message.Message;
import vendingmachine.message.Sign;

public class OutputView {

	public static void printCoinVendingMachineHold(Map<Integer, Integer> coinMap) {
		System.out.println();
		System.out.println(Message.ENTER_MONEY_VENDING_MACHINE_HAS);
		printCoinInMap(coinMap);
	}

	public static void printCoinInMap(Map<Integer, Integer> coinMap) {
		coinMap.keySet()
			.forEach(key -> System.out.println(makeCoinAndAMountFormat(key, coinMap.get(key))));
	}

	private static String makeCoinAndAMountFormat(int coin, int amount) {
		return coin + Message.MONEY_UNIT + Sign.COIN_AMOUNT_DIVISOR + amount + Message.AMOUNT_UNIT;
	}

	public static void printInputCost(int inputCost) {
		System.out.println();
		System.out.println(Message.PRINT_INPUT_COST + inputCost + Message.MONEY_UNIT);
	}

	public static void printChange(Map<Integer, Integer> coinMap) {
		System.out.println(Message.PRINT_CHANGE);
		printCoinInMap(coinMap);
	}

}
