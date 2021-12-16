package vendingmachine.validation;

import vendingmachine.message.Sign;

//TODO: 상수화
public class GlobalValidator {
	private static final int TEN = 10;

	public static void validateInputIsBlank(String input, String errorMessage) {
		if (input.replaceAll(Sign.SPACE, Sign.NULL).length() == 0) {
			throw new IllegalArgumentException(errorMessage);
		}
	}

	public static void validateInputIsNaturalNumber(String input, String errorMessage) {
		for (char c : input.toCharArray()) {
			isNegativeNumberOrCharacter(c, errorMessage);
		}

		if (Integer.parseInt(input) == 0) {
			throw new IllegalArgumentException(errorMessage);
		}
	}

	private static void isNegativeNumberOrCharacter(char character, String errorMessage) {
		if (!Character.isDigit(character)) {
			throw new IllegalArgumentException(errorMessage);
		}
	}

	public static void validateInputIsDivideTen(String input, String errorMessage) {
		if (Integer.parseInt(input) % TEN != 0) {
			throw new IllegalArgumentException(errorMessage);
		}
	}

}
