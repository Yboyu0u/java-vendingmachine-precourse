package vendingmachine.utils;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.domain.coin.Coin;

public class RandomCoinUtil {

	public static int generateRandomCoin() {
		return Randoms.pickNumberInList(Coin.getCoinList());
	}
}
