package com.java.prep.coinbase;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 
 * You operate a marketplace for buying & selling used textbooks
 * 
 * For a given textbook eg“TheoryofCryptography” there are people who want to
 * buy this textbook and people who want to sell
 * 
 * OfferstoBUY: [$100, $100, $99, $99, $97, $90]
 * 
 * OfferstoSELL:[$109, $110, $110, $114, $115$, 119]
 * 
 * A match occurs when two people agree on a price Some new offers do not match
 * These offers should be added to the active set of offers
 * 
 * For example, Tim offers to SELL at $150 This will not match No one is willing
 * to buy at that price so we save the offer
 * 
 * OfferstoSELL:: [$109, $110, $110, $114, $115, $119, $150]
 * 
 * When matching we want to give the customer the “best price”
 * 
 * Example matches: If Jane offers to BUY at $120
 * 
 * she will match and buy a book for $109 (the lowest offer)
 * 
 * //Assuming sell is false then the price I got is for buy
 * 
 */
public class StocksMatchingEngine {

	public PriorityQueue<Integer> buy;

	public PriorityQueue<Integer> sell;

	StocksMatchingEngine() {
		buy = new PriorityQueue<>(Collections.reverseOrder());
		sell = new PriorityQueue<>();
	}

	/**
	 * 
	 * Use two heaps. Put all the buy orders in a max heap and put all the sell
	 * orders in a min heap.
	 * 
	 * Let's say we get a new BUY order for $113. We want to find the best selling
	 * price ($109), which is right at the top of the seller min heap. Take that
	 * value out and match it with the user. We are done for this case.
	 * 
	 * Now let's say we got a BUY order for $90, the value at the top of the seller
	 * min heap is $110 (we already polled the $109 from the seller heap), so no one
	 * will sell at this price. So we cannot match it at this point. IMPORTANT: We
	 * are asked to save this value if it was unmatched. So put this $90 BUY order
	 * in the buy orders max heap.
	 * 
	 * Do the same logic for SELL orders (poll max buying price from buyers max
	 * heap, save the value in the seller min heap if there was no match).
	 * 
	 * Time complexity: O(n logn) --> because we put everything in the heaps which
	 * are O(log n) per offer/poll operations. Space complexity: O(n) --> we're
	 * putting the entire input lists in the heaps
	 */
	public int findMatch(int price, boolean isSell) {
		int matchMoney = -1; // default return -1
		if (isSell) {
			sell.add(price);
		} else {
			buy.add(price);
		}
		// check match is present
		if (buy.size() > 0 && sell.size() > 0) {
			if (buy.peek() < sell.peek()) {
				matchMoney = sell.poll();
				buy.poll(); // since request for buy is satisfied.
			}
		}
		return matchMoney;
	}

	/**
	 * Let's use this input: Offers to BUY: $100$100$99$99$97$90 Offers to SELL:
	 * $109$110$110$114$115$119
	 */
	public static void main(String[] args) {
		StocksMatchingEngine s = new StocksMatchingEngine();

		System.out.println(s.findMatch(109, true));
		System.out.println(s.findMatch(110, true));
		System.out.println(s.findMatch(110, true));
		System.out.println(s.findMatch(114, true));
		System.out.println(s.findMatch(115, true));
		System.out.println(s.findMatch(119, true));

		System.out.println(s.findMatch(100, false));
		System.out.println(s.findMatch(100, false));
		System.out.println(s.findMatch(99, false));
		System.out.println(s.findMatch(99, false));
		System.out.println(s.findMatch(97, false));
		System.out.println(s.findMatch(90, false));

	}

}
