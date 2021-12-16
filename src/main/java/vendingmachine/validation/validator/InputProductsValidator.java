package vendingmachine.validation.validator;

import vendingmachine.validation.GlobalValidator;

public class InputProductsValidator {
	private static final String IS_BLANK_ERROR = "상품들은 빈 값일 수 없습니다.";
	private static final String IS_NOT_RIGHT_FORMAT = "개별 상품은 대괄호([])로 묶어 세미콜론(;)으로 구분한다.";

	public static void validate(String input) {
		GlobalValidator.validateInputIsBlank(input, IS_BLANK_ERROR);
		//TODO: 형식 관련 error

	}

	private static void validateProductsFormat(String input) {

	}



}
