package vendingmachine.domain.coin;

import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

import vendingmachine.utils.RandomCoinUtil;
import vendingmachine.view.OutputView;

public class CoinSystem {
	private final Map<Coin, Integer> coinMap;
	private Map<Coin, Integer> changeMap;
	private int change;

	public CoinSystem() {
		this.coinMap = new TreeMap<>();
		for (Coin coin : Coin.values()) {
			coinMap.put(Coin.mapToCoin(coin.getAmount()), 0);
		}
	}

	public void insertCoinInCoinMap(int money) {
		while (money > 0) {
			money = subtractMoney(money, RandomCoinUtil.generateRandomCoin());
		}
	}

	private int subtractMoney(int money, int randomCoin) {
		if (money >= randomCoin) {
			coinMap.put(Coin.mapToCoin(randomCoin), coinMap.get(Coin.mapToCoin(randomCoin)) + 1);
			money -= randomCoin;
		}

		return money;
	}

	public void getCoinInCoinMap() {
		OutputView.printCoinVendingMachineHold(coinMap);
	}

	public void getCalculatedChangeCoin(int inputCost) {
		OutputView.printChange(calculateChangeCoin(inputCost));
	}

	private Map<Coin, Integer> calculateChangeCoin(int inputCost) {
		change = Math.min(inputCost, getSumOfCoin());
		changeMap = new TreeMap<>();
		coinMap.keySet().forEach(key -> addChangeMapToCoin(key, coinMap.get(key)));

		return changeMap;
	}

	private int getSumOfCoin() {
		return coinMap.keySet().stream()
			.mapToInt(key -> key.getAmount() * coinMap.get(key))
			.sum();
	}

	private void addChangeMapToCoin(Coin coin, int value) {
		for (int i = 0; i < value; i++) {
			if (change < coin.getAmount() || change == 0) {
				return;
			}

			if (change >= coin.getAmount()) {
				changeMap.put(coin, changeMap.getOrDefault(coin, 0) + 1);
				coinMap.put(coin, coinMap.get(coin) - 1);
				change -= coin.getAmount();
			}
		}
	}
}