package vendingmachine.exception.validator;

import java.util.List;
import java.util.stream.Collectors;

import vendingmachine.domain.product.Product;
import vendingmachine.exception.GlobalValidator;

public class InputProductNameValidator {
	private static final String IS_BLANK_ERROR = "구입할 상품명은 빈 값일 수 없습니다.";
	private static final String IS_NOT_IN_LIST = "구입할 상품이 목록에 없습니다.";
	private static final String IS_OUT_OF_STOCK = "구입할 상품이 매진되었습니다.";

	public static void validate(String name, List<Product> productList) {
		GlobalValidator.validateInputIsBlank(name, IS_BLANK_ERROR);

		List<Product> StreamProducts
			= productList.stream().filter(product -> product.getName().equals(name)).collect(Collectors.toList());
		isNotInList(StreamProducts);
		isOutOfStock(StreamProducts);
	}

	private static void isNotInList(List<Product> productList) {
		if (productList.size() == 0) {
			throw new IllegalArgumentException(IS_NOT_IN_LIST);
		}
	}

	private static void isOutOfStock(List<Product> productList) {
		if (productList.get(0).getStock() == 0) {
			throw new IllegalArgumentException(IS_OUT_OF_STOCK);
		}
	}
}
