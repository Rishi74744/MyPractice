package com.java.prep.coinbase;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class PrecedenceKnapsack {

	public static void main(String[] args) {
		double fee[] = { 75, 15, 80, 40, 25, 95, 50 };
		int blockSize[] = { 15, 3, 16, 8, 3, 16, 6 };
		KnapsackTransaction[] transactions = new KnapsackTransaction[fee.length];
		for (int i = 0; i < fee.length; i++) {
			transactions[i] = new KnapsackTransaction(i, fee[i], blockSize[i], null);
		}
		transactions[0].setParentTransaction(transactions[2]);
		transactions[2].setParentTransaction(transactions[4]);
		transactions[1].setParentTransaction(transactions[5]);

		PrecedenceKnapsack mf = new PrecedenceKnapsack();
		System.out.println(mf.getMaximumProfitTransactionsHeapWithPrecedence(45, transactions));
//		System.out.println(mf.getMaximumProfitTransactionsHeap(45, transactions));
	}

	public List<KnapsackTransaction> getMaximumProfitTransactionsHeap(int blockSize,
			KnapsackTransaction[] transactions) {
		PriorityQueue<KnapsackTransaction> maxHeap = new PriorityQueue<>(new Comparator<KnapsackTransaction>() {
			@Override
			public int compare(KnapsackTransaction o1, KnapsackTransaction o2) {
				return o2.getProfitRatio().compareTo(o1.getProfitRatio());
			}
		});
		List<KnapsackTransaction> maximumProfitTransactions = new ArrayList<>();
		if (!isInputValid(transactions)) {
			return maximumProfitTransactions;
		}
		for (KnapsackTransaction transaction : transactions) {
			transaction.setProfitRatio(transaction.getFee() / transaction.getBlockSize());
			maxHeap.add(transaction);
		}

		int blockSizeAcquired = 0;
		double profitAcquired = 0;

		System.out.println(maxHeap);

		while (!maxHeap.isEmpty()) {
			KnapsackTransaction transaction = maxHeap.poll();
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

	public List<KnapsackTransaction> getMaximumProfitTransactionsHeapWithPrecedence(int blockSize,
			KnapsackTransaction[] transactions) {
		PriorityQueue<KnapsackTransaction> maxHeap = new PriorityQueue<>(new Comparator<KnapsackTransaction>() {
			@Override
			public int compare(KnapsackTransaction o1, KnapsackTransaction o2) {
				return o2.getProfitRatio().compareTo(o1.getProfitRatio());
			}
		});
		List<KnapsackTransaction> maximumProfitTransactions = new ArrayList<>();
		if (!isInputValid(transactions)) {
			return maximumProfitTransactions;
		}

		for (KnapsackTransaction transaction : transactions) {
			transaction.setProfitRatio(transaction.getFee() / transaction.getBlockSize());
		}

		Map<KnapsackTransaction, Integer> prerequisites = new HashMap<>();
		Map<Integer, List<KnapsackTransaction>> adjList = prepareAdjList(blockSize, transactions, prerequisites);

		for (Map.Entry<KnapsackTransaction, Integer> m : prerequisites.entrySet()) {
			if (m.getValue() == 0) {
				maxHeap.offer(m.getKey());
			}
		}

		int blockSizeAcquired = 0;
		double profitAcquired = 0;

		System.out.println("Max Heap Created : " + maxHeap);

		while (!maxHeap.isEmpty()) {
			for (int index = maxHeap.size(); index > 0; index--) {
				KnapsackTransaction src = maxHeap.poll();
				if (adjList.containsKey(src.getId()) && !adjList.get(src.getId()).isEmpty()) {
					for (KnapsackTransaction dest : adjList.get(src.getId())) {
						if (prerequisites.get(dest) != 0) {
							prerequisites.put(dest, prerequisites.get(dest) - 1);
						}
						if (prerequisites.get(dest) == 0) {
							maximumProfitTransactions.add(dest);
							int previousBlockSize = blockSizeAcquired;
							blockSizeAcquired += dest.getBlockSize();
							if (blockSizeAcquired > blockSize) {
								profitAcquired += (((double) (blockSize - previousBlockSize)
										/ (double) dest.getBlockSize()) * dest.getFee());
								break;
							} else if (blockSizeAcquired == blockSize) {
								profitAcquired += dest.getFee();
								break;
							} else {
								profitAcquired += dest.getFee();
							}
							maxHeap.offer(dest);
						}
					}
				} else {
					maximumProfitTransactions.add(src);
					int previousBlockSize = blockSizeAcquired;
					blockSizeAcquired += src.getBlockSize();
					if (blockSizeAcquired > blockSize) {
						profitAcquired += (((double) (blockSize - previousBlockSize) / (double) src.getBlockSize())
								* src.getFee());
						break;
					} else if (blockSizeAcquired == blockSize) {
						profitAcquired += src.getFee();
						break;
					} else {
						profitAcquired += src.getFee();
					}
				}
			}
		}
		return maximumProfitTransactions;
	}

	public Map<Integer, List<KnapsackTransaction>> prepareAdjList(int n, KnapsackTransaction[] transactions,
			Map<KnapsackTransaction, Integer> prerequisites) {
		Map<Integer, List<KnapsackTransaction>> adjList = new HashMap<>();
		for (KnapsackTransaction transaction : transactions) {
			if (transaction.getParentTransaction() != null) {
				List<KnapsackTransaction> dependentTransactions = adjList
						.getOrDefault(transaction.getParentTransaction().getId(), new ArrayList<>());
				dependentTransactions.add(transaction);
				adjList.put(transaction.getParentTransaction().getId(), dependentTransactions);
			}
			adjList.put(transaction.getId(), adjList.getOrDefault(transaction.getId(), new ArrayList<>()));
			prerequisites.put(transaction, preparePrerequisites(transaction));
		}
		return adjList;

	}

	public int preparePrerequisites(KnapsackTransaction knapsackTransaction) {
		if (knapsackTransaction.getParentTransaction() == null) {
			return 0;
		}
		return 1 + preparePrerequisites(knapsackTransaction.getParentTransaction());
	}

	private boolean isInputValid(KnapsackTransaction[] transactions) {
		return transactions.length > 0;
	}

}

class KnapsackTransaction {

	private int id;
	private double fee;
	private int blockSize;
	private Double profitRatio;
	private KnapsackTransaction parentTransaction;

	public KnapsackTransaction(int id, double fee, int blockSize, KnapsackTransaction parentTransaction) {
		super();
		this.id = id;
		this.fee = fee;
		this.blockSize = blockSize;
		this.parentTransaction = parentTransaction;
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

	public void setParentTransaction(KnapsackTransaction parentTransaction) {
		this.parentTransaction = parentTransaction;
	}

	public KnapsackTransaction getParentTransaction() {
		return parentTransaction;
	}

	@Override
	public String toString() {
		return "KnapsackTransaction [id=" + id + ", fee=" + fee + ", blockSize=" + blockSize + ", profitRatio="
				+ profitRatio + ", parentTransaction=" + (parentTransaction != null) + "]";
	}

}

/**
 * 
 * [Transaction [id=4, fee=25.0, blockSize=3], Transaction [id=6, fee=50.0,
 * blockSize=6], Transaction [id=5, fee=95.0, blockSize=16], Transaction [id=1,
 * fee=15.0, blockSize=3], Transaction [id=3, fee=40.0, blockSize=8],
 * Transaction [id=2, fee=80.0, blockSize=16]] [Transaction [id=0, fee=75.0,
 * blockSize=15], Transaction [id=1, fee=15.0, blockSize=3], Transaction [id=2,
 * fee=80.0, blockSize=16], Transaction [id=3, fee=40.0, blockSize=8],
 * Transaction [id=5, fee=95.0, blockSize=16]]
 */
