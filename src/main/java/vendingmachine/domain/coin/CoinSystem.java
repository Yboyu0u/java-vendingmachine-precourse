package vendingmachine.domain.coin;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

import vendingmachine.message.dto.ResponseMessage;
import vendingmachine.utils.RandomCoinUtil;

public class CoinSystem {
	private Map<Integer, Integer> coinMap;

	public CoinSystem() {
		this.coinMap = new TreeMap<>(Collections.reverseOrder());
		for(Coin coin: Coin.values()) {
			coinMap.put(coin.getAmount(),0);
		}
	}

	public void inCoinMap(int money) {
		while(money > 0) {
			money = subtractMoney(money,RandomCoinUtil.generateRandomCoin());
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

	// public void getCalculatedChangeCoin() {
	// 	ResponseMessage.printCoinInMap(calculateChangeCoin());
	// }

	// private Map<Integer,Integer> calculateChangeCoin() {
	//
	// }
}
