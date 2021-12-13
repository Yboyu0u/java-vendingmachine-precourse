package vendingmachine.validation.validator;

import vendingmachine.validation.GlobalValidation;

public class InputCostValidator {

	public static void validateInputCost(String  inputStr) {
		GlobalValidation.validateNull(inputStr);
		GlobalValidation.validateCostIsNaturalNumber(inputStr);
		GlobalValidation.validateDivideTen(Integer.parseInt(inputStr));
	}
}