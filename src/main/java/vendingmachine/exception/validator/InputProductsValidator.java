package vendingmachine.exception.validator;

import vendingmachine.exception.GlobalValidator;

public class InputProductsValidator {
	private static final String IS_BLANK_ERROR = "상품들은 빈 값일 수 없습니다.";

	public static void validate(String input) {
		GlobalValidator.validateInputIsBlank(input, IS_BLANK_ERROR);
	}
}
