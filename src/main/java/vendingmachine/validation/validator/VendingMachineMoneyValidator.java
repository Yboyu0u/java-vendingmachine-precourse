package vendingmachine.validation.validator;

import vendingmachine.validation.GlobalValidator;

public class VendingMachineMoneyValidator {
	private static final String MONEY_IS_BLANK_ERROR = "자판기가 보유한 금액은 빈 값일 수 없습니다.";
	private static final String MONEY_IS_NOT_NATURAL_NUMBER_ERROR = "자판기가 보유한 금액은 자연수여야 합니다.";
	private static final String MONEY_IS_NOT_DIVIDE_TEN = "자판기가 보유한 금액은 10으로 나누어 떨어져야 합니다.";

	public static void validate(String input) {
		GlobalValidator.validateInputIsBlank(input, MONEY_IS_BLANK_ERROR);
		GlobalValidator.validateInputIsNaturalNumber(input, MONEY_IS_NOT_NATURAL_NUMBER_ERROR);
		GlobalValidator.validateInputIsDivideTen(input, MONEY_IS_NOT_DIVIDE_TEN);
	}

}
