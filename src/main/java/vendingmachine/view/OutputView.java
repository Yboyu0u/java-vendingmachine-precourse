package vendingmachine.view;

import java.util.Map;

import vendingmachine.domain.coin.Coin;
import vendingmachine.message.Message;
import vendingmachine.message.Sign;

public class OutputView {

	public static void printCoinVendingMachineHold(Map<Coin, Integer> coinMap) {
		System.out.println();
		System.out.println(Message.PRINT_VENDING_MACHINE_COIN);
		printCoinInMap(coinMap);
	}

	private static void printCoinInMap(Map<Coin, Integer> coinMap) {
		coinMap.keySet()
			.forEach(key -> System.out.println(makeCoinAndAMountFormat(key, coinMap.get(key))));
	}

	private static String makeCoinAndAMountFormat(Coin coin, int amount) {
		return coin.getAmount() + Message.MONEY_UNIT + Sign.COIN_AMOUNT_DIVISOR + amount + Message.AMOUNT_UNIT;
	}

	public static void printInputCost(int inputCost) {
		System.out.println();
		System.out.print(Message.PRINT_INPUT_COST);
		System.out.println(inputCost + Message.MONEY_UNIT);
	}

	public static void printChange(Map<Coin, Integer> coinMap) {
		System.out.println(Message.PRINT_CHANGE);
		printCoinInMap(coinMap);
	}

}
