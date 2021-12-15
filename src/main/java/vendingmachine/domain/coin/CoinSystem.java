package vendingmachine.domain.coin;

import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

import vendingmachine.message.dto.ResponseMessage;
import vendingmachine.utils.RandomCoinUtil;

public class CoinSystem {
	private Map<Integer, Integer> coinMap;
	private Map<Integer, Integer> changeMap;
	private int change;

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

	public void getCalculatedChangeCoin(int inputCost) {
		ResponseMessage.printCoinInMap(calculateChangeCoin(inputCost));
	}

	private Map<Integer,Integer> calculateChangeCoin(int inputCost) {
		change = Math.min(inputCost,getSumOfCoin());
		changeMap = new TreeMap<>(Comparator.reverseOrder());
		coinMap.keySet().forEach(key -> addChangeMapToCoin(key, coinMap.get(key)));

		return changeMap;
	}

	private int getSumOfCoin() {
		return coinMap.keySet().stream().map(key -> key * coinMap.get(key)).reduce(0,Integer::sum);
	}

	private void addChangeMapToCoin(int key, int value) {
		for (int i = 0; i < value; i++) {
			if (change < key || change == 0) {
				return;
			}

			if (change >= key) {
				changeMap.put(key, changeMap.getOrDefault(key, 0) + 1);
				coinMap.put(key, coinMap.get(key) - 1);
				change -= key;
			}
		}
	}
}
