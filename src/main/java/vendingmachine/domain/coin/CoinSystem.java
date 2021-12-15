package vendingmachine.domain.coin;

import java.util.Map;
import java.util.TreeMap;

import vendingmachine.message.dto.ResponseMessage;
import vendingmachine.utils.RandomCoinUtil;

public class CoinSystem {
	private Map<Integer, Integer> coinMap;

	public CoinSystem() {
		this.coinMap = new TreeMap<>();
	}

	public void makeCoinInCoinMap(int money) {
		int randomCoin = RandomCoinUtil.generateRandomCoin();

		while(money > 0) {
			money = subtractMoney(money,randomCoin);
		}
	}

	private int subtractMoney(int money, int randomCoin) {
		if(money >= randomCoin) {
			coinMap.put(randomCoin,coinMap.get(randomCoin)+1);
			money -= randomCoin;
		}

		return money;
	}

	public void getCoinInCoinMap() {
		ResponseMessage.printCoinInMap(coinMap);
	}
}
