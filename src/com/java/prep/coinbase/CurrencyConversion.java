package com.java.prep.coinbase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CurrencyConversion {

	public static void main(String[] args) {
		String from[] = { "GBP", "INR", "USD", "DNR" };
		String to[] = { "INR", "USD", "CAD", "GBP" };
		double values[] = { 2.3, 0.7, 0.4, 3.5 };
		List<CurrencyRate> currencyRates = new ArrayList<>();
		for (int i = 0; i < from.length; i++) {
			CurrencyRate currencyRate = new CurrencyRate(from[i], to[i], values[i]);
			currencyRates.add(currencyRate);
		}
		CurrencyRate queryConversion = new CurrencyRate("GBP", "CAD", 0.0);

		CurrencyConversionDao currencyConversionDao = new CurrencyConversionDao(2 * from.length);
		CurrencyConvertor convertor = new CurrencyConvertor(currencyConversionDao);
		convertor.processCurrencyConversion(currencyRates);
		currencyConversionDao.printValues("After Processing");
		double conversionRate = convertor.getCurrencyConversionRate(queryConversion);
		System.out.println(conversionRate);
	}

}

class CurrencyConvertor {

	private CurrencyConversionDao currencyConversionDao;
	private UnionFind unionFind;
	private int currencyId;

	public CurrencyConvertor(CurrencyConversionDao currencyConversionDao) {
		this.currencyConversionDao = currencyConversionDao;
		this.unionFind = new UnionFind(currencyConversionDao);
	}

	public void processCurrencyConversion(List<CurrencyRate> currencyRates) {
		for (CurrencyRate currencyRate : currencyRates) {
			if (!currencyConversionDao.getCurrencyIdMap().containsKey(currencyRate.getFromCurrency())) {
				currencyConversionDao.getCurrencyIdMap().put(currencyRate.getFromCurrency(), currencyId);
				currencyId++;
			}
			if (!currencyConversionDao.getCurrencyIdMap().containsKey(currencyRate.getToCurrency())) {
				currencyConversionDao.getCurrencyIdMap().put(currencyRate.getToCurrency(), currencyId);
				currencyId++;
			}
			currencyRate
					.setFromCurrencyId(currencyConversionDao.getCurrencyIdMap().get(currencyRate.getFromCurrency()));
			currencyRate.setToCurrencyId(currencyConversionDao.getCurrencyIdMap().get(currencyRate.getToCurrency()));
			unionFind.union(currencyRate);
		}
	}

	public double getCurrencyConversionRate(CurrencyRate currencyRate) {
		Integer fromCurrencyId = currencyConversionDao.getCurrencyIdMap().get(currencyRate.getFromCurrency());
		Integer toCurrencyId = currencyConversionDao.getCurrencyIdMap().get(currencyRate.getToCurrency());
		if (fromCurrencyId == null || toCurrencyId == null) {
			return -1.0d;
		}
		currencyRate.setFromCurrencyId(fromCurrencyId);
		currencyRate.setToCurrencyId(toCurrencyId);
		currencyConversionDao.printValues("Before Querying");
		return unionFind.getConversionRate(currencyRate);
	}

}

class UnionFind {

	private CurrencyConversionDao currencyConversionDao;

	public UnionFind(CurrencyConversionDao currencyConversionDao) {
		this.currencyConversionDao = currencyConversionDao;
	}

	public void union(CurrencyRate currencyRate) {
		int fromRelationShip = find(currencyRate.getFromCurrencyId());
		int toRelationShip = find(currencyRate.getToCurrencyId());
		if (fromRelationShip == toRelationShip) {
			return;
		}
		currencyConversionDao.getRelationShip()[fromRelationShip] = toRelationShip;
		currencyConversionDao.getConversionValues()[fromRelationShip] = (currencyConversionDao
				.getConversionValues()[currencyRate.getToCurrencyId()] * currencyRate.getConverionRate())
				/ currencyConversionDao.getConversionValues()[currencyRate.getFromCurrencyId()];
		currencyConversionDao.printValues("Values After Currency Rate : " + currencyRate);

	}

	public int find(int fromCurrency) {
		if (currencyConversionDao.getRelationShip()[fromCurrency] != fromCurrency) {
			int currentStartCurrency = currencyConversionDao.getRelationShip()[fromCurrency];
			currencyConversionDao.getRelationShip()[fromCurrency] = find(
					currencyConversionDao.getRelationShip()[fromCurrency]);
			currencyConversionDao.getConversionValues()[fromCurrency] *= currencyConversionDao
					.getConversionValues()[currentStartCurrency];

		}
		return currencyConversionDao.getRelationShip()[fromCurrency];
	}

	public double getConversionRate(CurrencyRate currencyRate) {
		int fromRelationShip = find(currencyRate.getFromCurrencyId());
		int toRelationShip = find(currencyRate.getToCurrencyId());
		if (fromRelationShip == toRelationShip) {
			return currencyConversionDao.getConversionValues()[currencyRate.getFromCurrencyId()]
					/ currencyConversionDao.getConversionValues()[currencyRate.getToCurrencyId()];
		}
		return -1.0d;
	}

}

class CurrencyConversionDao {

	private int[] relationShip;
	private double[] conversionValues;
	private Map<String, Integer> currencyIdMap;

	public CurrencyConversionDao(int size) {
		this.relationShip = new int[size];
		this.conversionValues = new double[size];
		this.currencyIdMap = new HashMap<>();
		for (int index = 0; index < size; index++) {
			this.relationShip[index] = index;
			this.conversionValues[index] = 1.0d;
		}
	}

	public int[] getRelationShip() {
		return relationShip;
	}

	public double[] getConversionValues() {
		return conversionValues;
	}

	public Map<String, Integer> getCurrencyIdMap() {
		return currencyIdMap;
	}

	public void printValues(String message) {
		System.out.println(message);
		for (double val : this.conversionValues) {
			System.out.println(val);
		}
		System.out.println("");
	}

	@Override
	public String toString() {
		return "CurrencyConversionDao [relationShip=" + Arrays.toString(relationShip) + ", conversionValues="
				+ Arrays.toString(conversionValues) + ", currencyIdMap=" + currencyIdMap + "]";
	}

}

class CurrencyRate {
	private int fromCurrencyId;
	private int toCurrencyId;
	private String fromCurrency;
	private String toCurrency;
	private double converionRate;

	public CurrencyRate(String fromCurrency, String toCurrency, double converionRate) {
		this.fromCurrency = fromCurrency;
		this.toCurrency = toCurrency;
		this.converionRate = converionRate;
	}

	public int getFromCurrencyId() {
		return fromCurrencyId;
	}

	public void setFromCurrencyId(int fromCurrencyId) {
		this.fromCurrencyId = fromCurrencyId;
	}

	public int getToCurrencyId() {
		return toCurrencyId;
	}

	public void setToCurrencyId(int toCurrencyId) {
		this.toCurrencyId = toCurrencyId;
	}

	public String getFromCurrency() {
		return fromCurrency;
	}

	public String getToCurrency() {
		return toCurrency;
	}

	public double getConverionRate() {
		return converionRate;
	}

	@Override
	public String toString() {
		return "CurrencyRate [fromCurrency=" + fromCurrency + ", toCurrency=" + toCurrency + ", converionRate="
				+ converionRate + "]";
	}

}
