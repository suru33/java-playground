package com.suru.j8.test.lambdas;

public class TradeExample {

	class Trade {
		private String tradeName;
		private int amount;

		public Trade(String tradeName, int amount) {
			this.tradeName = tradeName;
			this.amount = amount;
		}

		public boolean isBigTrade() {
			return amount > 15000;
		}

		public String getTradeName() {
			return this.tradeName;
		}
	}

	interface Tradable {
		boolean check(Trade t);
	}

	public static void main(String[] args) {
		new TradeExample().testExample();
	}

	public void testExample() {
		// big trade lambda
		Tradable bigTrade = (trade) -> trade.isBigTrade();
		System.out.println("is big: " + bigTrade.check(new Trade("Intel", 15000)));
		// IBM or not?
		Tradable ibmTrade = (trade) -> trade.getTradeName().contains("IBM");
		System.out.println("ibm trade: " + ibmTrade.check(new Trade("Apple", 15000)));

	}

}
