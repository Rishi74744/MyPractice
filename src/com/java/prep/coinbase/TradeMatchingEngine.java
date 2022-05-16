package com.java.prep.coinbase;

import java.util.Calendar;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.UUID;

public class TradeMatchingEngine {

	/**
	 * Complexity - O(NlogN) Space - O(N)
	 */
	public static void main(String[] args) {
		MatchingEngineDAO matchingEngineDAO = new MatchingEngineDAO();
		MatchingEngine matchingEngine = new MatchingEngine(matchingEngineDAO);
		int[][] orders = { { 10, 5, 1 }, { 15, 2, 1 }, { 15, 8, 0 }, { 30, 4, 0 }, { 15, 2, 1 } };
		for (int[] order : orders) {
			Order tradeOrder = null;
			if (order[2] == 0) {
				tradeOrder = new Order((double) order[0], order[1], OrderType.BUY,
						Calendar.getInstance().getTimeInMillis());
			} else {
				tradeOrder = new Order((double) order[0], order[1], OrderType.SELL,
						Calendar.getInstance().getTimeInMillis());
			}
			OrderResponse response = matchingEngine.matchOrder(tradeOrder);
			System.out.println(
					"====================================================================================================================================");
			System.out.println("Response From Matching Engine - " + response);
			System.out.println(
					"====================================================================================================================================");
		}
	}

}

class MatchingEngine {

	private MatchingEngineDAO matchingEngineDAO;

	public MatchingEngine(MatchingEngineDAO matchingEngineDAO) {
		this.matchingEngineDAO = matchingEngineDAO;
	}

	public OrderResponse matchOrder(Order order) {
		switch (order.getType()) {
		case SELL:
			return matchSellOrder(order);
		case BUY:
			return matchBuyOrder(order);
		default:
			return null;
		}
	}

	private boolean addBuyOrder(Order order) {
		matchingEngineDAO.getBuyOrders().add(order);
		return true;
	}

	private boolean addSellOrder(Order order) {
		matchingEngineDAO.getSellOrders().add(order);
		return true;
	}

	private OrderResponse matchBuyOrder(Order order) {
		OrderResponse orderResponse = null;
		System.out.println(
				"\n<---------------------------- Processing Order - " + order + " --------"
						+ "-------------------->");
		double buyPrice = 0.0;
		while (matchingEngineDAO.getSellOrders().size() > 0
				&& matchingEngineDAO.getSellOrders().peek().getPrice() <= order.getPrice() && order.getQuantity() > 0) {
			Order sellOrder = matchingEngineDAO.getSellOrders().peek();
			int orderQty = Math.min(order.getQuantity(), sellOrder.getQuantity());

			System.out.println("Order Price WithIn Range Of Seller Price With Minimum Value Order - " + sellOrder);

			System.out.println("Decreasing Required Quanity");

			sellOrder.setQuantity(sellOrder.getQuantity() - orderQty);
			order.setQuantity(order.getQuantity() - orderQty);

			buyPrice += (orderQty * sellOrder.getPrice());

			if (sellOrder.getQuantity() == 0) {
				System.out.println("All Quantities Sold From Min Selling Price Backlog!");
				matchingEngineDAO.getSellOrders().remove();
			}
			if (order.getQuantity() == 0) {
				System.out.println("All Quantities Bought For The Given Order!");
				order.setStatus(OrderStatus.COMPLETED);
			} else {
				System.out.println("Partial Quantities Bought For The Given Order! ");
				order.setStatus(OrderStatus.PARTIAL);
			}
		}
		if (order.getStatus() != OrderStatus.COMPLETED) {
			if (order.getStatus() != OrderStatus.PARTIAL) {
				System.out.println("Order Price Match Not Found");
				order.setStatus(OrderStatus.PENDING);
			} else {
				System.out.println(order.getQuantity() + " Still Needs To Be Bought! Adding To The Buy Backlog");
			}
			addBuyOrder(order);
		}
		orderResponse = new OrderResponse(order.getId(), buyPrice, order.getStatus());
		System.out.println("<---------------------------- Processing Done For - " + order + " With Response - "
				+ orderResponse + " ---------------------------->\n");
		return orderResponse;

	}

	private OrderResponse matchSellOrder(Order order) {
		System.out.println(
				"\n<---------------------------- Processing Order - " + order + " ---------------------------->");
		OrderResponse orderResponse = null;
		double sellPrice = 0.0;
		while (matchingEngineDAO.getBuyOrders().size() > 0
				&& matchingEngineDAO.getBuyOrders().peek().getPrice() >= order.getPrice() && order.getQuantity() > 0) {
			Order buyOrder = matchingEngineDAO.getBuyOrders().peek();
			int orderQty = Math.min(order.getQuantity(), buyOrder.getQuantity());
			System.out.println("Order Price WithIn Range Of Buyer Price With Maximum Value - " + buyOrder);

			System.out.println("Decreasing Required Quanity");

			buyOrder.setQuantity(buyOrder.getQuantity() - orderQty);
			order.setQuantity(order.getQuantity() - orderQty);
			sellPrice += (orderQty * order.getPrice());

			if (buyOrder.getQuantity() == 0) {
				System.out.println("All Quantities Bought With Max Selling Price Backlog!");
				matchingEngineDAO.getBuyOrders().remove();
			}
			if (order.getQuantity() == 0) {
				System.out.println("All Quantities Sold For The Given Order!");
				order.setStatus(OrderStatus.COMPLETED);
			} else {
				System.out.println("Partial Quantities Sold For The Given Order! ");
				order.setStatus(OrderStatus.PARTIAL);
			}
		}
		if (order.getStatus() != OrderStatus.COMPLETED) {
			if (order.getStatus() != OrderStatus.PARTIAL) {
				System.out.println("Order Price Match Not Found");
				order.setStatus(OrderStatus.PENDING);
			} else {
				System.out.println(order.getQuantity() + " Still Needs To Be Sold! Adding To The Sell Backlog");
			}
			addSellOrder(order);
		}
		orderResponse = new OrderResponse(order.getId(), sellPrice, order.getStatus());
		System.out.println("<---------------------------- Processing Done For - " + order + " With Response - "
				+ orderResponse + " ---------------------------->\n");
		return orderResponse;
	}

}

class MatchingEngineDAO {

	PriorityQueue<Order> sellOrders = new PriorityQueue<>(
			(order1, order2) -> order1.getPrice().compareTo(order2.getPrice()));
	PriorityQueue<Order> buyOrders = new PriorityQueue<>(
			(order1, order2) -> order2.getPrice().compareTo(order1.getPrice()));

	public PriorityQueue<Order> getBuyOrders() {
		return buyOrders;
	}

	public PriorityQueue<Order> getSellOrders() {
		return sellOrders;
	}

}

class Order {

	String id;
	Double price;
	int quantity;
	OrderType type;
	OrderStatus status;
	Long creationTime;

	public Order(Double price, int quantity, OrderType type, Long creationTime) {
		super();
		this.id = UUID.randomUUID().toString();
		this.price = price;
		this.quantity = quantity;
		this.type = type;
		this.creationTime = creationTime;
		this.status = OrderStatus.INITIATED;
	}

	public String getId() {
		return id;
	}

	public Double getPrice() {
		return price;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getQuantity() {
		return quantity;
	}

	public OrderType getType() {
		return type;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		return Objects.hash(creationTime, id, price, quantity, status, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(creationTime, other.creationTime) && id == other.id && Objects.equals(price, other.price)
				&& quantity == other.quantity && status == other.status && type == other.type;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", price=" + price + ", quantity=" + quantity + ", type=" + type + ", status="
				+ status + "]";
	}

}

class OrderResponse {

	private String id;
	private Double price;
	private OrderStatus status;

	public OrderResponse(String id, Double price, OrderStatus status) {
		super();
		this.id = id;
		this.price = price;
		this.status = status;
	}

	public String getId() {
		return id;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "OrderResponse [id=" + id + ", price=" + price + ", status=" + status + "]";
	}

}

enum OrderStatus {
	INITIATED, PENDING, COMPLETED, PARTIAL, FAILED, CANCELLED
}

enum OrderType {
	BUY, SELL
}