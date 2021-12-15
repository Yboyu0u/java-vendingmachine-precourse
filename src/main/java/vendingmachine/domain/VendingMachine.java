package vendingmachine.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import vendingmachine.message.dto.ResponseMessage;
import vendingmachine.utils.RandomCoinUtil;

public class VendingMachine {

	private Map<Integer, Integer> coinMap;
	private List<Product> productList;

	public VendingMachine() {
		this.coinMap = new TreeMap(Collections.reverseOrder());
		this.productList = new ArrayList<>();

		for(Coin coin : Coin.values()) {
			coinMap.put(coin.getAmount(),0);
		}
	}

	// 들어온 금액에 맞게 코인 생성
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
