package vendingmachine.validation.validator;

import vendingmachine.validation.GlobalValidator;

public class InputCostValidator {
	private static final String IS_BLANK_ERROR = "투입 금액은 빈 값일 수 없습니다.";
	private static final String IS_NOT_NATURAL_NUMBER_ERROR = "투입 금액은 자연수여야 합니다.";
	private static final String IS_NOT_DIVIDE_TEN = "투입 금액은 10으로 나누어 떨어져야 합니다.";

	public static void validate(String input) {
		GlobalValidator.validateInputIsBlank(input,IS_BLANK_ERROR);
		GlobalValidator.validateInputIsNaturalNumber(input,IS_NOT_NATURAL_NUMBER_ERROR);
		GlobalValidator.validateInputIsDivideTen(input,IS_NOT_DIVIDE_TEN);
	}
}
