package vendingmachine.validation.validator;

import java.util.Arrays;

import vendingmachine.domain.product.ProductUnit;
import vendingmachine.validation.GlobalValidator;

public class InputProductValidator {

	private static final String IS_BLANK_ERROR = "상품명, 가격, 수량이 각각 빈 값일 수 없습니다.";
	private static final String IS_NOT_LENGTH_THREE = "상품명, 가격, 수량이 모두 입력되야 하고 다른 품목은 입력될 수 없습니다.";
	private static final String PRICE_IS_NOT_NATURAL_NUMBER = "상품 가격은 자연수여야 합니다.";
	private static final String PRICE_IS_NOT_DIVIDE_TEN = "상품 가격은 10으로 나누어 떨어져야 합니다.";
	private static final String STOCK_IS_NOT_NATURAL_NUMBER = "상품 수량은 자연수여야 합니다.";


	public static void validateProduct(String[] product) {
		isLengthThree(product);
		isBlank(product);
		Price(product[ProductUnit.PRICE]);
		stock((product[ProductUnit.STOCK]));

	}

	private static void isBlank(String[] product) {
		Arrays
			.stream(product)
			.forEach(unit -> GlobalValidator.validateInputIsBlank(unit.replaceAll(" ", ""), IS_BLANK_ERROR));
	}

	private static void isLengthThree(String[] product) {
		if(product.length != 3) {
			throw new IllegalArgumentException(IS_NOT_LENGTH_THREE);
		}
	}

	private static void Price(String price) {
		GlobalValidator.validateInputIsNaturalNumber(price, PRICE_IS_NOT_NATURAL_NUMBER);
		GlobalValidator.validateInputIsDivideTen(price, PRICE_IS_NOT_DIVIDE_TEN);
	}

	private static void stock(String stock) {
		GlobalValidator.validateInputIsNaturalNumber(stock,STOCK_IS_NOT_NATURAL_NUMBER);
	}
}

