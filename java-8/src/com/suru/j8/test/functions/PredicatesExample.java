package com.suru.j8.test.functions;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

class ITrade {
	private String name;
	private double price;
	private boolean canclled;

	public ITrade(String name, double price, boolean canclled) {
		this.name = name;
		this.price = price;
		this.canclled = canclled;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public boolean isCanclled() {
		return canclled;
	}

	@Override
	public String toString() {
		return "[" + name + "]";
	}
}

class ITradeUtils {
	public List<ITrade> createTrades() {
		List<ITrade> iTrades = new ArrayList<>();
		iTrades.add(new ITrade("GOOG", 25000, true));
		iTrades.add(new ITrade("FB", 2000, false));
		iTrades.add(new ITrade("AMZN", 12000, false));
		iTrades.add(new ITrade("APPL", 16000, true));
		iTrades.add(new ITrade("BDPS", 33880, false));
		return iTrades;
	}
}

public class PredicatesExample {

	public static void main(String[] args) {
		new PredicatesExample().testThisExample();
	}

	private void testThisExample() {
		Predicate<ITrade> bigTrade = iTrade -> iTrade.getPrice() > 15000;
		Predicate<ITrade> canclledTrade = iTrade -> iTrade.isCanclled();
		Predicate<ITrade> googleTrade = iTrade -> iTrade.getName().equals("GOOG");
		Predicate<ITrade> bigTradeAndCanclledTrade = bigTrade.and(canclledTrade);
		List<ITrade> trades = new ITradeUtils().createTrades();
		for (ITrade trade : trades) {
			System.out.println(trade);
			System.out.println("big trade: " + bigTrade.test(trade));
			System.out.println("canclled trade: " + canclledTrade.test(trade));
			System.out.println("google trade: " + googleTrade.test(trade));
			System.out.println("big and canclled trade: " + bigTradeAndCanclledTrade.test(trade));
			System.out.println("----------------");
		}
	}
}
