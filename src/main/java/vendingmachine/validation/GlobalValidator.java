package vendingmachine.validation;

public class GlobalValidator {

	// 빈 값 확인
	public static void validateInputIsBlank(String input, String errorMessage) {
		if (input.replaceAll(" ", "").length() == 0) {
			throw new IllegalArgumentException(errorMessage);
		}
	}

	// 자연수가 아닌 경우
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

	// 10으로 나누어 떨어지지 않는 경우
	public static void validateInputIsDivideTen(String input, String errorMessage) {
		if (Integer.parseInt(input) % 10 != 0) {
			throw new IllegalArgumentException(errorMessage);
		}
	}

}
