// Keng Xiong

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class BestTrading {

	public static void main(String[] args) throws IOException {
		int[] data = fillArray(args[0]); // Creates array filled with contents from file

		Trade trade = BestTradeSearch(data, 0, data.length - 1); // Initial call

		System.out.println(trade.toString()); // Displays result
	}

	public static Trade BestTradeSearch(final int[] data, final int low, final int high) {
		if (low > high) {
			throw new IllegalArgumentException("Low index is greater than high index");
		} // Thrown if low index is greater than high index

		if (low == high) {
			Trade trade = new Trade(low, high, 0); // Creates new Trade class object
			return trade;
		} // Recursion stop condition

		int mid = (int) Math.floor((low + high) / 2);

		Trade leftBuy = BestTradeSearch(data, low, mid); // Trade candidate 1
		Trade rightBuy = BestTradeSearch(data, mid + 1, high); // Trade candidate 2
		Trade acrossBuy = BestTradingAcross(data, low, high); // Trade candidate 3

		if (leftBuy.getProfitTrade() >= rightBuy.getProfitTrade()
				&& leftBuy.getProfitTrade() >= acrossBuy.getProfitTrade()) {
			return leftBuy;
		} // Compares left side trade to right side and across trades

		else if (rightBuy.getProfitTrade() >= leftBuy.getProfitTrade()
				&& rightBuy.getProfitTrade() >= acrossBuy.getProfitTrade()) {
			return rightBuy;
		} // Compares right side trade to left side and across trades

		else {
			return acrossBuy;
		} // Returns if across trade is the best
	}

	public static Trade BestTradingAcross(final int[] data, final int low, final int high) {
		if (low >= high) {
			throw new IllegalArgumentException("Low index is greater than or equal to high index.");
		} // Thrown if low index is greater or equal to high index

		int mid = (int) Math.floor((low + high) / 2);

		int indexSmall = 0;
		int smallValue = data[0]; // Starting value for checking left side
		for (int i = 0; i < mid + 1; i++) {
			if (data[i] < smallValue) {
				smallValue = data[i];
				indexSmall = i;
			} // Checks for the smallest value on the left side
		} // Loop walks through the left side of the array

		int indexLarge = mid + 1;
		int largeValue = data[mid + 1]; // Starting value for checking right side
		for (int i = mid + 1; i < data.length; i++) {
			if (data[i] > largeValue) {
				largeValue = data[i];
				indexLarge = i;
			} // Checks for the largest value on the right side
		} // Loop walks through the right side of the array

		Trade tradeAcross = new Trade(indexSmall, indexLarge, largeValue - smallValue);

		return tradeAcross;
	}

	public static int[] fillArray(final String fileName) throws IOException {
		Scanner file = new Scanner(new File(fileName)); // Creates Scanner object using text file

		int size = 0;
		while (file.hasNext()) {
			file.nextLine();
			size++;
		} // Loop gathers the number of lines in the text file

		file.close();

		int[] data = new int[size]; // Creates int array to fill with contents on the file

		file = new Scanner(new File(fileName)); // Reopens file

		for (int i = 0; i < data.length; i++) {
			data[i] = Integer.parseInt(file.nextLine());
		} // Fills the array with contents from the file

		file.close();

		return data;
	} // Returns filled array to method call

}

class Trade {
	private int lowTrade;
	private int highTrade;
	private int profitTrade;

	public Trade(final int buyTrade, final int sellTrade, final int profitTrade) {
		this.lowTrade = buyTrade;
		this.highTrade = sellTrade;
		this.profitTrade = profitTrade;
	} // Creates Trade object

	public int getProfitTrade() {
		return this.profitTrade;
	} // Returns Trade object's profit

	@Override
	public String toString() {
		String bestTrade = "[" + this.lowTrade + "," + this.highTrade + ","
				+ this.profitTrade + "]";

		return bestTrade;
	} // Returns Trade object's toString method
}
