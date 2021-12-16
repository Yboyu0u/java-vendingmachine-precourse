package vendingmachine.validation.validator;

import vendingmachine.validation.GlobalValidator;

public class InputProductNameValidator {
	private static final String IS_BLANK_ERROR = "구입할 상품명은 빈 값일 수 없습니다.";

	public static void validateIsBlank(String input) {
		GlobalValidator.validateInputIsBlank(input,IS_BLANK_ERROR);
	}
}
