package vendingmachine.exception.validator;

import vendingmachine.exception.GlobalValidator;

public class InputVendingMachineMoneyValidator {
	private static final String IS_BLANK_ERROR = "자판기가 보유한 금액은 빈 값일 수 없습니다.";
	private static final String IS_NOT_NATURAL_NUMBER_ERROR = "자판기가 보유한 금액은 자연수여야 합니다.";
	private static final String IS_NOT_DIVIDE_TEN = "자판기가 보유한 금액은 10으로 나누어 떨어져야 합니다.";

	public static void validate(String input) {
		GlobalValidator.validateInputIsBlank(input, IS_BLANK_ERROR);
		GlobalValidator.validateInputIsNaturalNumber(input, IS_NOT_NATURAL_NUMBER_ERROR);
		GlobalValidator.validateInputIsDivideTen(input, IS_NOT_DIVIDE_TEN);
	}
}
