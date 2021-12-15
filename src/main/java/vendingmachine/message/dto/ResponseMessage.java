package vendingmachine.message.dto;

import java.util.Map;

import vendingmachine.message.Message;
import vendingmachine.message.Sign;

public class ResponseMessage {

	public static void of(String message) {
		System.out.println(message);
	}

	public static void printCoinInMap(Map<Integer, Integer> coinMap) {
		coinMap.keySet()
			.forEach(key -> System.out.println(makeCoinAAndAMountFormat(key, coinMap.get(key))));
		printLineBreaker();
	}

	private static String makeCoinAAndAMountFormat(int coin, int amount) {
		return coin + Message.MONEY_UNIT + Sign.COIN_AMOUNT_DIVISOR + amount + Message.AMOUNT_UNIT;
	}

	public static void printInputCost(int inputCost) {
		printLineBreaker();
		System.out.println(Message.PRINT_INPUT_COST + inputCost + Message.MONEY_UNIT);
	}

	public static void printChange() {
		System.out.println(Message.PRINT_CHANGE);
	}

	public static void printLineBreaker() {
		System.out.print(Message.LINE_BREAKER);
	}
}
