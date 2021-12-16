package vendingmachine.validation.validator;

import java.util.Arrays;
import java.util.List;

import vendingmachine.domain.product.Product;
import vendingmachine.domain.product.ProductUnit;
import vendingmachine.message.Sign;
import vendingmachine.validation.GlobalValidator;

public class InputProductValidator {
	private static final int PRODUCT_LENGTH = 3;

	private static final String IS_BLANK_ERROR = "상품명, 가격, 수량이 각각 빈 값일 수 없습니다.";
	private static final String IS_NOT_LENGTH_THREE = "상품명, 가격, 수량이 쉼표로, 구분되어 모두 입력돼야 하고 다른 품목은 입력될 수 없습니다.";
	private static final String PRICE_IS_NOT_NATURAL_NUMBER = "상품 가격은 자연수여야 합니다.";
	private static final String PRICE_IS_NOT_DIVIDE_TEN = "상품 가격은 10으로 나누어 떨어져야 합니다.";
	private static final String STOCK_IS_NOT_NATURAL_NUMBER = "상품 수량은 자연수여야 합니다.";
	private static final String IS_DISTINCT_ERROR = "상품은 중복될 수 없습니다.";
	private static final String IS_NOT_RIGHT_FORMAT = "개별 상품은 대괄호([])로 묶어 세미콜론(;)으로 구분한다.";


	public static void validate(String rowProduct, List<Product> productList) {
		String[] product = rowProduct.split(Sign.PRODUCT_DIVISOR);

		isBlank(product);
		isLengthThree(product);
		isFormat(rowProduct);
		price(product[ProductUnit.PRICE]);
		stock((product[ProductUnit.STOCK]));
		isDistinct(product[ProductUnit.NAME],productList);
	}

	private static void isBlank(String[] product) {
		Arrays
			.stream(product)
			.forEach(unit -> GlobalValidator.validateInputIsBlank(unit.replaceAll(Sign.SPACE, Sign.NULL), IS_BLANK_ERROR));
	}

	private static void isFormat(String input) {
		if(input.charAt(0) =='[' || input.charAt(input.length()-1) == ']') {
			throw new IllegalArgumentException(IS_NOT_RIGHT_FORMAT);
		}
	}

	private static void isLengthThree(String[] product) {
		if(product.length != PRODUCT_LENGTH) {
			throw new IllegalArgumentException(IS_NOT_LENGTH_THREE);
		}
	}

	private static void price(String price) {
		GlobalValidator.validateInputIsNaturalNumber(price, PRICE_IS_NOT_NATURAL_NUMBER);
		GlobalValidator.validateInputIsDivideTen(price, PRICE_IS_NOT_DIVIDE_TEN);
	}

	private static void stock(String stock) {
		GlobalValidator.validateInputIsNaturalNumber(stock,STOCK_IS_NOT_NATURAL_NUMBER);
	}

	private static void isDistinct(String name, List<Product> productList) {
		if(productList.contains(new Product(name,0,0))) {
			throw new IllegalArgumentException(IS_DISTINCT_ERROR);
		}
	}
}

