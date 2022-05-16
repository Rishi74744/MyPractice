package com.java.prep.coinbase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MaximizeFee {

	public static void main(String[] args) {
		double fee[] = { 75, 15, 80, 40, 25, 95, 50 };
		int blockSize[] = { 15, 3, 16, 8, 3, 16, 6 };
		Transaction[] transactions = new Transaction[fee.length];
		for (int i = 0; i < fee.length; i++) {
			transactions[i] = new Transaction(i, fee[i], blockSize[i]);
		}
		MaximizeFee mf = new MaximizeFee();
		System.out.println(mf.getMaximumProfitTransactions(45, transactions));
	}

	public List<Transaction> getMaximumProfitTransactions(int blockSize, Transaction[] transactions) {
		List<Transaction> maximumProfitTransactions = new ArrayList<>();
		if (!isInputValid(transactions)) {
			return maximumProfitTransactions;
		}
		for (Transaction transaction : transactions) {
			transaction.setProfitRatio(transaction.getFee() / transaction.getBlockSize());
		}
		Arrays.sort(transactions, new Comparator<Transaction>() {

			@Override
			public int compare(Transaction o1, Transaction o2) {
				return o2.getProfitRatio().compareTo(o1.getProfitRatio());
			}
		});
		Arrays.stream(transactions).forEach(System.out::print);
		System.out.println();
		int blockSizeAcquired = 0;
		double profitAcquired = 0;
		for (Transaction transaction : transactions) {
			maximumProfitTransactions.add(transaction);
			int previousBlockSize = blockSizeAcquired;
			blockSizeAcquired += transaction.getBlockSize();
			if (blockSizeAcquired > blockSize) {
				profitAcquired += (((double) (blockSize - previousBlockSize) / (double) transaction.getBlockSize())
						* transaction.getFee());
				break;
			} else if (blockSizeAcquired == blockSize) {
				profitAcquired += transaction.getFee();
				break;
			} else {
				profitAcquired += transaction.getFee();
			}
		}
		System.out.println(profitAcquired);
		return maximumProfitTransactions;
	}

	private boolean isInputValid(Transaction[] transactions) {
		return transactions.length > 0;
	}

}

class Transaction {

	private int id;
	private double fee;
	private int blockSize;
	private Double profitRatio;

	public Transaction(int id, double fee, int blockSize) {
		super();
		this.id = id;
		this.fee = fee;
		this.blockSize = blockSize;
	}

	public int getId() {
		return id;
	}

	public double getFee() {
		return fee;
	}

	public int getBlockSize() {
		return blockSize;
	}

	public void setProfitRatio(Double profitRatio) {
		this.profitRatio = profitRatio;
	}

	public Double getProfitRatio() {
		return profitRatio;
	}

	@Override
	public String toString() {
		return "Transaction [id=" + id + ", fee=" + fee + ", blockSize=" + blockSize + ", profitRatio=" + profitRatio
				+ "]";
	}

}